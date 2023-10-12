package pageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private WebDriver driver;

    // Selectors for the elements on the Your Cart page
    private By titleSelector = By.cssSelector(".title");
    private By cartItemSelector = By.cssSelector(".cart_item");
    private By removeButtonSelector = By.cssSelector(".btn.btn_secondary.btn_small.cart_button");
    private By checkoutButtonSelector = By.cssSelector("#checkout");
    private By continueShoppingButtonSelector = By.cssSelector("#continue-shopping");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickRemoveButton() {
        driver.findElement(removeButtonSelector).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButtonSelector).click();
    }

    public void clickContinueShoppingButton() {
        driver.findElement(continueShoppingButtonSelector).click();
    }
}
