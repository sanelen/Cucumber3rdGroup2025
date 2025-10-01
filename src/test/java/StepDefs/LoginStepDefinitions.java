package StepDefs;

import Utils.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.util.List;
import java.util.Map;

public class LoginStepDefinitions extends Base {

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        ensurePagesReady();
        landingPage.clickLearningMaterialsButton();
    }

    @When("I enter a valid email and password")
    public void i_enter_a_valid_email_and_password(List<Map<String, String>> dataTable) {
        String email = dataTable.get(0).get("Email");
        String password = dataTable.get(0).get("Password");
        login(email, password);
        dashboardPage.waitForPracticeHeadingVisible();
    }

    @And("I click the Login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I am successfully logged in")
    public void iAmSuccessfullyLoggedIn() {
        dashboardPage.waitForPracticeHeadingVisible();
    }

    @When("I log in with email {string} and password {string}")
    public void iLogInWithEmailAndPassword(String email, String password) {
        login(email, password);
        dashboardPage.waitForPracticeHeadingVisible();
    }

    @Then("the practice tabs are displayed")
    public void thePracticeTabsAreDisplayed() {
        dashboardPage.waitForPracticeHeadingVisible();
        if (!dashboardPage.arePracticeTabsVisible()) {
            throw new AssertionError("Practice tabs are not visible after login");
        }
    }

    @Then("the {string} value exists in local storage")
    public void theValueExistsInLocalStorage(String key) {
        String value = getLocalStorageItem(key);
        if (value == null || value.isBlank()) {
            throw new AssertionError("Expected localStorage key '" + key + "' to be present");
        }
    }

    @Then("an authentication error is shown with text {string}")
    public void anAuthenticationErrorIsShownWithText(String expected) {
        String actual = loginPage.getAuthenticationAlertText();
        if (!actual.contains(expected)) {
            throw new AssertionError("Expected error message to contain '" + expected + "' but was '" + actual + "'");
        }
    }

    @Given("I am logged in with email {string} and password {string}")
    public void iAmLoggedInWithEmailAndPassword(String email, String password) {
        i_am_on_the_login_page();
        iLogInWithEmailAndPassword(email, password);
    }

    @When("I open a new browser tab and return")
    public void iOpenANewBrowserTabAndReturn() {
        WebDriver driver = getDriver();
        String originalHandle = driver.getWindowHandle();
        String currentUrl = driver.getCurrentUrl();
        driver.switchTo().newWindow(WindowType.TAB).get(currentUrl);
        driver.close();
        driver.switchTo().window(originalHandle);
        driver.navigate().refresh();
    }

    @Then("Verify that i am on the login page")
    public void iAmOnTheLoginPage() {
        if (!isLoginPageVisible()) {
            throw new AssertionError("Expected to be on the login page but it is not visible");
        }
    }

    @Then("the {string} value is absent from local storage")
    public void theValueIsAbsentFromLocalStorage(String key) {
        String value = getLocalStorageItem(key);
        if (value != null && !value.isBlank()) {
            throw new AssertionError("Expected localStorage key '" + key + "' to be removed but found value");
        }
    }

    @When("I click the Logout button")
    public void iClickTheLogoutButton() {
        dashboardPage.clickLogoutButton();
    }
}
