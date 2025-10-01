package StepDefs;

import Utils.Base;
import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class RegistrationStepDefinition extends Base {

    @Given("User is on the signup page")
    public void user_is_on_the_signup_page() {
        landingPage.verifyLearnAutomationTheRightWayIsDisplayed();
        landingPage.clickLearningMaterialsButton();
        loginPage.clickSignupButton();
    }

    @When("User enters name {}")
    public void user_enters_name(String name) {
        signupPage.enterFirstName(name);
    }

    @And("User enters last name {}")
    public void user_enters_last_name(String lastName) {
        signupPage.enterLastName(lastName);
    }

    @And("User enters email {}")
    public void user_enters_email(String email) {
        signupPage.enterEmail(email);
    }

    @And("User enters new password {}")
    public void user_enters_new_password(String password) {
        signupPage.enterPassword(password);
    }

    @And("User enters confirm password {}")
    public void user_enters_confirm_password(String confirmPassword) {
        signupPage.enterConfirmPassword(confirmPassword);
    }

    @And("User clicks on the create account button")
    public void user_clicks_on_the_create_account_button() {
        signupPage.clickCreateAccount();
    }

    @Then("the successful registration pop up message is displayed")
    public void the_successful_registration_pop_up_message_with_text_is_displayed() {
        // Wait for the alert to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Get the actual message and assert it matches the expected message
//        String actualMessage = alert.getText();
//        String expectedMessage = "";
//        assertEquals(actualMessage, expectedMessage);

        // Accept the alert (click "OK")
        alert.accept();
    }

    @Then("Login to Access Learning Materials page is displayed")
    public void loginToAccessLearningMaterialsPageIsDisplayed() {
        assertTrue(loginPage.loginToAccessLearningMaterials_id.isDisplayed());
    }
}

