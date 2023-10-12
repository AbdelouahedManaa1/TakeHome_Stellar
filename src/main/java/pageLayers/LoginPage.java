package pageLayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; // Add this import

public class LoginPage {

  private WebDriver driver;

  // Define the selectors for elements on the login page
  private By usernameInputSelector = By.cssSelector("#user-name");
  private By passwordInputSelector = By.cssSelector("#password");
  private By loginButtonSelector = By.cssSelector("#login-button");
  private By h3ElementSelector = By.tagName("h3");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public void navigateToLoginPage() {
    driver.get("https://www.saucedemo.com/");
  }

  public void enterUsername(String username) {
    driver.findElement(usernameInputSelector).sendKeys(username);
  }

  public void enterPassword(String password) {
    driver.findElement(passwordInputSelector).sendKeys(password);
  }

  public void clickLoginButton() {
    driver.findElement(loginButtonSelector).click();
  }

  public void login(String username, String password) {
    driver.findElement(usernameInputSelector).sendKeys(username);

    driver.findElement(passwordInputSelector).sendKeys(password);

    driver.findElement(loginButtonSelector).click();
  }

  public String getH3ElementText() {
    WebElement h3Element = driver.findElement(h3ElementSelector);
    return h3Element != null ? h3Element.getText() : null;
  }
}
