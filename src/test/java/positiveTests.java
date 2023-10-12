import baseTest.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageLayers.*;
import utils.ElementUtil;

@Listeners(listeners.TestNgListeners.class)
public class positiveTests extends BaseTest {

  WebDriver driver;
  LoginPage loginPage;
  ProductPage productPage;
  CartPage cartPage;
  CheckoutInfoPage checkoutInfoPage;
  CheckoutOverviewPage checkoutOverviewPage;
  CheckoutCompletePage checkoutCompletePage;
  ElementUtil util;
  String projectPath;

  @BeforeTest
  public void setupBrowser() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    // driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test(priority = 1)
  public void completeCheckout() throws Exception {
    test = extent.createTest("Successful login and complete the checkout");

    loginPage = new LoginPage(driver);
    productPage = new ProductPage(driver);
    cartPage = new CartPage(driver);
    checkoutInfoPage = new CheckoutInfoPage(driver);
    checkoutOverviewPage = new CheckoutOverviewPage(driver);
    checkoutCompletePage = new CheckoutCompletePage(driver);

    driver.get("https://www.saucedemo.com/");
    loginPage.login("standard_user", "secret_sauce");

    productPage.clickAddToCartButton(1);
    productPage.clickAddToCartButton(2);
    productPage.clickAddToCartButton(3);
    productPage.clickCartIconLink();

    cartPage.clickCheckoutButton();

    checkoutInfoPage.enterFirstName("Abdel");
    checkoutInfoPage.enterLastName("Abde");
    checkoutInfoPage.enterZip("75892");
    checkoutInfoPage.clickContinueButton();

    checkoutOverviewPage.clickFinishButton();

    Assert.assertEquals(
      checkoutCompletePage.getCompleteHeaderText(),
      "Thank you for your order!",
      "Text does not match the expected value."
    );
  }

  @Test(priority = 2)
  public void addingItemsToCart() throws Exception {
    test =
      extent.createTest(
        "Verify that the cart icon updates with the correct number of items"
      );
    driver.get("https://www.saucedemo.com/");

    Random rand = new Random();
    int n = rand.nextInt(6) + 1;
    loginPage = new LoginPage(driver);
    productPage = new ProductPage(driver);

    loginPage.login("standard_user", "secret_sauce");

    productPage.clickHamburgerMenuButton();
    productPage.clickResetAppStateLink();
    productPage.clickLogoutLink();

    loginPage.login("standard_user", "secret_sauce");

    for (int i = 1; i <= n; i++) {
      productPage.clickAddToCartButton(1);
    }
    System.out.println("Number of items added is: " + n);

    Assert.assertEquals(
      productPage.getBadgeNumber(),
      String.valueOf(n),
      "Text does not match the expected value."
    );
  }

  public void filtering() {
    test = extent.createTest("3. validate sorting");
    loginPage = new LoginPage(driver);
	//didn't have time to complete this
  }

  @Test(priority = 3)
  public void cartSaving() throws IOException {
    test = extent.createTest("Validate cart save items after logout");
    loginPage = new LoginPage(driver);
    productPage = new ProductPage(driver);
    Random rand = new Random();
    int n = rand.nextInt(6) + 1;
    driver.get("https://www.saucedemo.com/");

    loginPage.login("standard_user", "secret_sauce");

    productPage.clickHamburgerMenuButton();
    productPage.clickResetAppStateLink();
    productPage.clickLogoutLink();

    loginPage.login("standard_user", "secret_sauce");

    for (int i = 1; i <= n; i++) {
      productPage.clickAddToCartButton(1);
    }
    productPage.clickHamburgerMenuButton();
    productPage.clickLogoutLink();

    loginPage.login("standard_user", "secret_sauce");

    Assert.assertEquals(
      productPage.getBadgeNumber(),
      String.valueOf(n),
      "Text does not match the expected value."
    );
  }

  @AfterTest
  public void tearDownTest() {
    driver.close();
  }
}
