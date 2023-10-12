package pageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {
    private WebDriver driver;

    // Selectors for the elements on the Checkout Overview page
    private By cartItemSelector = By.cssSelector(".cart_item");
    private By priceTotalSelector = By.cssSelector(".summary_subtotal_label");
    private By finishButtonSelector = By.cssSelector("#finish");
    private By cancelButtonSelector = By.cssSelector("#cancel");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPriceTotalText() {
        WebElement priceTotal = driver.findElement(priceTotalSelector);
        return priceTotal != null ? priceTotal.getText() : null;
    }

    public void clickFinishButton() {
        driver.findElement(finishButtonSelector).click();
    }

    public void clickCancelButton() {
        driver.findElement(cancelButtonSelector).click();
    }
}
