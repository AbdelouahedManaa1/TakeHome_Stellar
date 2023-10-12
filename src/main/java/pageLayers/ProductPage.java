package pageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private WebDriver driver;

    // Selectors for the elements on the product page
    private By addToCartButtonsSelector = By.cssSelector(".btn.btn_primary.btn_small.btn_inventory");
    private By hamburgerMenuButtonSelector = By.cssSelector("#react-burger-menu-btn");
    private By cartIconLinkSelector = By.cssSelector(".shopping_cart_link");
    private By filterBoxSelector = By.cssSelector(".select_container");
    private By selectElementSelector = By.cssSelector(".select_container select");
    private By headerTextSelector = By.cssSelector(".app_logo");
    private By inventorySidebarLinkSelector = By.cssSelector("#inventory_sidebar_link");
    private By aboutSidebarLinkSelector = By.cssSelector("#about_sidebar_link");
    private By logoutSidebarLinkSelector = By.cssSelector("#logout_sidebar_link");
    private By resetSidebarLinkSelector = By.cssSelector("#reset_sidebar_link");
    private By cartBadgeSelector = By.cssSelector(".shopping_cart_badge");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForHeaderTextToBeAvailable() {
        WebDriverWait wait = new WebDriverWait(driver, 5); // Maximum wait time of 5 seconds
        wait.until(ExpectedConditions.presenceOfElementLocated(headerTextSelector));
    }

    public void clickHamburgerMenuButton() {
        driver.findElement(hamburgerMenuButtonSelector).click();
    }

    public void clickCartIconLink() {
        driver.findElement(cartIconLinkSelector).click();
    }

    public String getBadgeNumber() {
        WebElement completeHeader = driver.findElement(cartBadgeSelector);
        return completeHeader.getText();
    }

    public String getHeaderText() {
        waitForHeaderTextToBeAvailable(); // Wait for header text to be available
        WebElement header = driver.findElement(headerTextSelector);
        return header != null ? header.getText() : null;
    }

    public void clickAllItemsLink() {
        driver.findElement(inventorySidebarLinkSelector).click();
    }

    public void clickAboutLink() {
        driver.findElement(aboutSidebarLinkSelector).click();
    }

    public void clickLogoutLink() {
        driver.findElement(logoutSidebarLinkSelector).click();
    }

    public void clickResetAppStateLink() {
        driver.findElement(resetSidebarLinkSelector).click();
    }

    public void clickAddToCartButton(int i) {
        driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])["+i+"]")).click();
    }
}
