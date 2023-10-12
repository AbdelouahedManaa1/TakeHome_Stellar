package pageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage {
    private WebDriver driver;

    // Selectors for the elements on the Checkout Complete page
    private By titleSelector = By.cssSelector(".title");
    private By completeHeaderSelector = By.cssSelector(".complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText() {
        WebElement title = driver.findElement(titleSelector);
        return title != null ? title.getText() : null;
    }

    public String getCompleteHeaderText() {
        WebElement completeHeader = driver.findElement(completeHeaderSelector);
        return completeHeader.getText();
    }
}
