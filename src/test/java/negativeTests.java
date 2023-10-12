import baseTest.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageLayers.*;
import utils.ElementUtil;

@Listeners(listeners.TestNgListeners.class)
public class negativeTests extends BaseTest {

  WebDriver driver;
  LoginPage loginPage;
  ProductPage productPage;
  CartPage cartPage;
  CheckoutInfoPage checkoutInfoPage;
  CheckoutOverviewPage checkoutOverviewPage;
  CheckoutCompletePage checkoutCompletePage;

  @BeforeTest
  public void setupBrowser() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test(priority = 1)
  public void emptyFirstNameField() {
    test =
      extent.createTest(
        "Validate user is not able to proceed to checkout if a first name is missing in the form"
      );
    loginPage = new LoginPage(driver);
    productPage = new ProductPage(driver);
    cartPage = new CartPage(driver);
    checkoutInfoPage = new CheckoutInfoPage(driver);

    driver.get("https://www.saucedemo.com/");
    loginPage.login("standard_user", "secret_sauce");
    productPage.clickHamburgerMenuButton();
    productPage.clickResetAppStateLink();
    productPage.clickAddToCartButton(1);
    productPage.clickCartIconLink();

    cartPage.clickCheckoutButton();
    checkoutInfoPage.enterLastName("Mana");
    checkoutInfoPage.enterZip("75892");
    checkoutInfoPage.clickContinueButton();
    Assert.assertEquals(
      checkoutInfoPage.getH3ElementText(),
      "Error: First Name is required",
      "Text does not match the expected value."
    );
  }

  @Test(priority = 2)
  public void emptyLastNameField() {
    test =
      extent.createTest(
        "Validate user is not able to proceed to checkout if a last name is missing in the form"
      );
    loginPage = new LoginPage(driver);
    productPage = new ProductPage(driver);
    cartPage = new CartPage(driver);
    checkoutInfoPage = new CheckoutInfoPage(driver);

    driver.get("https://www.saucedemo.com/");
    loginPage.login("standard_user", "secret_sauce");
    productPage.clickHamburgerMenuButton();
    productPage.clickResetAppStateLink();
    productPage.clickAddToCartButton(1);
    productPage.clickCartIconLink();

    cartPage.clickCheckoutButton();
    checkoutInfoPage.enterFirstName("Manaa");
    checkoutInfoPage.enterZip("75892");
    checkoutInfoPage.clickContinueButton();
    Assert.assertEquals(
      checkoutInfoPage.getH3ElementText(),
      "Error: Last Name is required",
      "Text does not match the expected value."
    );
  }

  @Test(priority = 3)
  public void emptyZipcodeField() {
    test =
      extent.createTest(
        "Validate user is not able to proceed to checkout if a zipcode is missing in the form"
      );
    loginPage = new LoginPage(driver);
    productPage = new ProductPage(driver);
    cartPage = new CartPage(driver);
    checkoutInfoPage = new CheckoutInfoPage(driver);

    driver.get("https://www.saucedemo.com/");
    loginPage.login("standard_user", "secret_sauce");
    productPage.clickHamburgerMenuButton();
    productPage.clickResetAppStateLink();
    productPage.clickAddToCartButton(1);
    productPage.clickCartIconLink();

    cartPage.clickCheckoutButton();
    checkoutInfoPage.enterFirstName("Abdel");
    checkoutInfoPage.enterLastName("Mana");
    checkoutInfoPage.clickContinueButton();

    Assert.assertEquals(
      checkoutInfoPage.getH3ElementText(),
      "Error: Postal Code is required",
      "Text does not match the expected value."
    );
  }

  @Test(priority = 4)
  public void emptyPasswordLogin() {
    test =
      extent.createTest(
        "Validate user is not able to Login with empty password"
      );
    driver.get("https://www.saucedemo.com/");
    loginPage = new LoginPage(driver);
    loginPage.login("standard_user", "");

    Assert.assertEquals(
      loginPage.getH3ElementText(),
      "Epic sadface: Password is required",
      "Text does not match the expected value."
    );
  }

  @Test(priority = 5)
  public void lockedoutUserLogin() {
    test =
      extent.createTest("Validate user is not able to Login if lockedout");
    driver.get("https://www.saucedemo.com/");
    loginPage = new LoginPage(driver);
    loginPage.login("locked_out_user", "secret_sauce");

    Assert.assertEquals(
      loginPage.getH3ElementText(),
      "Epic sadface: Sorry, this user has been locked out.",
      "Text does not match the expected value."
    );
  }

  @AfterTest
  public void tearDownTest() {
    driver.close();
  }
}
