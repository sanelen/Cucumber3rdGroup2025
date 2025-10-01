package StepDefs;

import PageObjects.InventoryPage;
import Utils.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import StepDefs.LoginStepDefinitions;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;

import static StepDefs.LoginStepDefinitions.*;

public class InventoryStepDefinitions extends Base {


    @Given("User is on the inventory form page")
    public void userIsOnTheInventoryFormPage() {
        // Navigate to the learning materials (opens the login modal/page)
        landingPage.clickLearningMaterialsButton();

        login("","");
        Assert.assertTrue(dashboardPage.isDashboardHeadingDisplayed());
        dashboardPage.clickWebAutomationBtn();
    }

    @When("user fails to select a device type")
    public void userFailsToSelectADeviceType() {
        // No action needed, as the default state of the form is "no device selected"
    }

    @Then("the next button is disabled")
    public void theNextButtonIsDisabled() {
        Assert.assertTrue(inventoryPage.isNextButtonDisabled(), "The Next button should be disabled.");
    }

    @When("User selects a device type")
    public void userSelectsADeviceType() {
        inventoryPage.selectDevice("Phone");
    }

    @When("user fails to select a brand")
    public void userFailsToSelectABrand() {
        // No action needed after selecting a device, as the default state is "no brand selected"
    }

    @When("User selects a brand")
    public void userSelectsABrand() {
        inventoryPage.selectBrand("Apple");
    }

    @When("user fails to select storage")
    public void userFailsToSelectStorage() {
        // No action needed after selecting a brand, as the default state is "no storage selected"
    }

    @When("User selects storage")
    public void userSelectsStorage() {
        inventoryPage.selectStorage("128GB");
    }

    @When("User enters an invalid quantity 0")
    public void userEntersAnInvalidQuantity0() {
        inventoryPage.enterQuantity("0");
    }

    @Then("Quantity must be >= 1 error message is displayed")
    public void quantityMustBeEqualOrGreaterThan1ErrorMessageIsDisplayed() {
        Assert.assertTrue(inventoryPage.isErrorMessageDisplayed("Quantity must be >= 1"), "Expected error message not displayed.");
    }

    @When("User enters an invalid quantity {string}")
    public void userEntersAnInvalidQuantity(String quantity) {
        inventoryPage.enterQuantity(quantity);
    }

    @When("the user clicks the Next button")
    public void theUserClicksTheNextButton() {
        inventoryPage.clickNextButton();
    }

    @Then("the error {string} is displayed")
    public void theErrorIsDisplayed(String errorMessage) {
        Assert.assertTrue(inventoryPage.isErrorMessageDisplayed(errorMessage), "Expected error message not displayed: " + errorMessage);
    }

    @When("User enters a valid quantity {string}")
    public void userEntersAValidQuantity(String quantity) {
        inventoryPage.enterQuantity(quantity);
    }

    @When("the delivery address is left blank")
    public void theDeliveryAddressIsLeftBlank() {
        inventoryPage.enterDeliveryAddress("");
    }

    @When("User selects a valid device, brand, storage, quantity, and delivery address")
    public void userSelectsAValidDeviceBrandStorageQuantityAndDeliveryAddress() {
        inventoryPage.selectDevice("Phone");
        inventoryPage.selectBrand("Apple");
        inventoryPage.selectStorage("128GB");
        inventoryPage.enterQuantity("1");
        inventoryPage.enterDeliveryAddress("123 Main St, City, Country");
    }

    @When("User clicks on the Next button")
    public void userClicksOnTheNextButton() {
        inventoryPage.clickNextButton();
    }

    @Then("the Inventory review Step Page is displayed")
    public void theInventoryReviewStepPageIsDisplayed() {
        // To be implemented: Assert that the next page is displayed.
        // You will need to add a locator to the next page and a verification method in your Page Object.
        // For example: Assert.assertTrue(driver.getCurrentUrl().contains("review"));
    }
}
