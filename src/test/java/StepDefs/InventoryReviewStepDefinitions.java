package StepDefs;

import PageObjects.InventoryReviewPage;
import Utils.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class InventoryReviewStepDefinitions extends Base {

    public InventoryReviewStepDefinitions(WebDriver driver) {
        this.inventoryReviewPage =new InventoryReviewPage(driver);
        landingPage.clickLearningMaterialsButton();


        // Use the reusable login helper in Base to perform the login actions
        login(System.getProperty("APP_USERNAME"), System.getProperty("APP_PASSWORD"));
        Assert.assertTrue(dashboardPage.isDashboardHeadingDisplayed());
        dashboardPage.clickWebAutomationBtn();
        loginPage.clickLoginButton();
        dashboardPage.isInventoryFormDisplayed();
    }

    // --- Given Steps ---

    // Note: The Gherkin "Given I am on the Inventory Review page" usually relies on a
    // separate step or hook to navigate, which isn't defined here, but we include the step definition.
    @Given("I am on the Inventory Review page")
    public void iAmOnTheInventoryReviewPage() {

        System.out.println("Navigated to the Inventory Review page (assumed).");
    }


    @Given("I have selected {string} warranty")
    public void iHaveSelectedWarranty(String warrantyOption) {
        switch (warrantyOption.toLowerCase()) {
            case "none":
                inventoryReviewPage.chooseNoWarranty();
                break;
            case "1 year":
            case "1y":
                inventoryReviewPage.chooseWarranty1Year();
                break;
            case "2 years":
            case "2y":
                inventoryReviewPage.chooseWarranty2Years();
                break;
            default:
                inventoryReviewPage.chooseNoWarranty();
        }
        // Verification is optional here but good practice
        Assert.assertEquals(warrantyOption.toLowerCase().replace(" years", "y").replace(" year", "y"),
                inventoryReviewPage.getSelectedWarranty(),
                "The expected warranty option was not selected.");
    }


    // --- When/And Action Steps ---

    @When("I choose the {string} shipping option on the Inventory Review page")
    public void iChooseTheShippingOptionOnTheInventoryReviewPage(String shippingOption) {
        switch (shippingOption.toLowerCase()) {
            case "standard":
                inventoryReviewPage.chooseStandardShipping();
                break;
            case "express":
                inventoryReviewPage.chooseExpressShipping();
                break;
            default:
                throw new IllegalArgumentException("Invalid shipping option: " + shippingOption);
        }
    }

    @When("I enter the discount code {string}")
    public void iEnterTheDiscountCode(String discountCode) {
        inventoryReviewPage.enterDiscountCode(discountCode);
    }

    @And("I click the Apply Discount button")
    public void iClickTheApplyDiscountButton() {
        inventoryReviewPage.clickApplyDiscount();
    }

    @And("I click the Add to Cart button")
    public void iClickTheAddToCartButton() {
        inventoryReviewPage.clickAddToCart();
    }

    // --- Then Verification Steps ---

    @Then("the Device Summary should show the device type as {string}")
    public void theDeviceSummaryShouldShowTheDeviceTypeAs(String expectedDeviceType) {
        String actualDeviceType = inventoryReviewPage.DeviceTypeSummaryText();
        // Asserts that the element's text contains the expected value, allowing for labels/formatting.
        Assert.assertTrue(actualDeviceType.contains(expectedDeviceType),
                "Device Type mismatch. Expected to contain: " + expectedDeviceType + ", but found: " + actualDeviceType);
    }

    @And("the Device Summary should show the brand as {string}")
    public void theDeviceSummaryShouldShowTheBrandAs(String expectedBrand) {
        String actualBrand = inventoryReviewPage.BrandSummaryText();
        Assert.assertTrue(actualBrand.contains(expectedBrand),
                "Brand mismatch. Expected to contain: " + expectedBrand + ", but found: " + actualBrand);
    }

    @And("the Device Summary should show the storage as {string}")
    public void theDeviceSummaryShouldShowTheStorageAs(String expectedStorage) {
        String actualStorage = inventoryReviewPage.StorageSummaryText();
        Assert.assertTrue(actualStorage.contains(expectedStorage),
                "Storage mismatch. Expected to contain: " + expectedStorage + ", but found: " + actualStorage);
    }

    @And("the Device Summary should show the quantity as {string}")
    public void theDeviceSummaryShouldShowTheQuantityAs(String expectedQuantity) {
        String actualQuantity = inventoryReviewPage.QuantitySummaryText();
        Assert.assertTrue(actualQuantity.contains(expectedQuantity),
                "Quantity mismatch. Expected to contain: " + expectedQuantity + ", but found: " + actualQuantity);
    }

    @And("the selected shipping option should be {string}")
    public void theSelectedShippingOptionShouldBe(String expectedShipping) {
        String actualShipping = inventoryReviewPage.getSelectedShipping();
        // Compares the lowercased expected value to the value returned by the PO method.
        Assert.assertEquals(expectedShipping.toLowerCase(), actualShipping,
                "Incorrect selected shipping option.");
    }

    @And("the Shipping cost in the Pricing Breakdown is {string}")
    public void theShippingCostInThePricingBreakdownIs(String expectedValue) {
        String actualValue = inventoryReviewPage.breakdownShippingValueText();
        // Assert that the text exactly matches the expected price (e.g., "$5.00" or "R5.00").
        Assert.assertEquals(expectedValue, actualValue, "Shipping cost value does not match.");
    }

    @Then("the Total value in the Pricing Breakdown is {string}")
    public void theTotalValueInThePricingBreakdownIs(String expectedValue) {
        String actualValue = inventoryReviewPage.breakdownTotalValueText();
        Assert.assertEquals(expectedValue, actualValue, "Total value does not match the expected value after discount.");
    }
}