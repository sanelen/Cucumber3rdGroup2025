package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "login-email")
    private WebElement emailField_id;

    @FindBy(id = "login-password")
    private WebElement passwordField_id;

    @FindBy(id = "login-submit")
    private WebElement loginButton_id;

    @FindBy(id = "signup-toggle")
    WebElement signupButton_id;

    @FindBy(id = "login-to-access-learning-materials")
    public WebElement loginToAccessLearningMaterials_id;

    @FindBy(id = "login-alert")
    private WebElement authenticationAlert_id;

    @FindBy(id = "login-form")
    private WebElement loginForm_id;



    public void clickSignupButton() {
        signupButton_id.click();
    }
     public void loginToAccessLearningMaterials_id(){
      loginToAccessLearningMaterials_id.isDisplayed();
     }

    public String getEmailText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(emailField_id)).getAttribute("value");
    }

    public void enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(emailField_id)).sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField_id.sendKeys(password);
    }

    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton_id)).click();
    }

    public String getAuthenticationAlertText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(authenticationAlert_id)).getText();
    }

    public boolean isLoginFormVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(emailField_id));
            if (loginForm_id != null) {
                wait.until(ExpectedConditions.visibilityOf(loginForm_id));
            }
            return emailField_id.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



}
