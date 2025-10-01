package StepDefs;

import Utils.Base;
import Utils.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;
import java.util.List;
import java.util.Map;

public class DashboardStepDefinitions extends Base {

    @Given("User is on the practice page")
    public void user_is_on_the_practice_page(){
        landingPage.clickLearningMaterialsButton();

        login("","");
        Assert.assertTrue(dashboardPage.isDashboardHeadingDisplayed());
}

    @When("I click on the Web Automation Advance button")
    public void i_click_on_the_web_automation_advance_button() {
        dashboardPage.clickWebAutomationBtn();
    }
    @Then("the Inventory Form is displayed")
    public void the_inventory_form_is_displayed() {
        Assert.assertTrue(dashboardPage.isInventoryFormDisplayed());
    }
}