package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {

    WebDriver driver;

    // Use PageFactory to initialize web elements
    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "register-firstName")
    WebElement firstNameField_id;

    @FindBy(id = "register-lastName")
    WebElement lastNameField_id;

    @FindBy(id = "register-email")
    WebElement emailField_id;

    @FindBy(id = "register-password")
    WebElement passwordField_id;

    @FindBy(id = "register-confirmPassword")
    WebElement confirmPasswordField_id;

    @FindBy(id = "register-submit")
    WebElement createAccountBtn;


    public void enterFirstName(String firstName) {
        firstNameField_id.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField_id.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailField_id.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField_id.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordField_id.sendKeys(confirmPassword);
    }

    public void clickCreateAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn)).click();
    }
}



