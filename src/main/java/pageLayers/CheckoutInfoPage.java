package pageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutInfoPage {
    private WebDriver driver;

    // Selectors for the elements on the Checkout page
    private By titleSelector = By.cssSelector(".title");
    private By firstNameInputSelector = By.cssSelector("#first-name");
    private By lastNameInputSelector = By.cssSelector("#last-name");
    private By zipInputSelector = By.cssSelector("#postal-code");
    private By continueButtonSelector = By.cssSelector("#continue");
    private By cancelButtonSelector = By.cssSelector("#cancel");
    private By h3ElementSelector = By.tagName("h3");

    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText() {
        WebElement title = driver.findElement(titleSelector);
        return title != null ? title.getText() : null;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInputSelector).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInputSelector).sendKeys(lastName);
    }

    public void enterZip(String zip) {
        driver.findElement(zipInputSelector).sendKeys(zip);
    }

    public void clickContinueButton() {
        driver.findElement(continueButtonSelector).click();
    }

    public void clickCancelButton() {
        driver.findElement(cancelButtonSelector).click();
    }

    public String getH3ElementText() {
        WebElement h3Element = driver.findElement(h3ElementSelector);
        return h3Element != null ? h3Element.getText() : null;
    }
}
