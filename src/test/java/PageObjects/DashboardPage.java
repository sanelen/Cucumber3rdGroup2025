package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "practice-heading")
    WebElement practiceHeaderHeading_id;

    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logoutBtn_xpath;

    @FindBy(id = "tab-btn-web")
    WebElement webAutomationAdvanceBtn_id;

    @FindBy(css = "button[id^='tab-btn-']")
    List<WebElement> practiceTabs_buttons;

    @FindBy(className = "inventory-title")
    WebElement inventoryTitle_className;

    // Wait helper: wait until the practice heading is visible (default timeout 10s)
    public void waitForPracticeHeadingVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(practiceHeaderHeading_id));
    }

    public boolean isDashboardHeadingDisplayed() {
        // Ensure the element is visible before returning its displayed state
        try {
            waitForPracticeHeadingVisible();
        } catch (Exception e) {
            return false;
        }
        return practiceHeaderHeading_id.isDisplayed();
    }

    public String getDashboardHeadingText() {
        return practiceHeaderHeading_id.getText();
    }

    public void clickLogoutButton() {
        logoutBtn_xpath.click();
    }

    public void clickWebAutomationBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(webAutomationAdvanceBtn_id)).click();
    }

    public boolean isInventoryFormDisplayed() {
        return inventoryTitle_className.isDisplayed();
    }

    public boolean arePracticeTabsVisible() {
        waitForPracticeHeadingVisible();
        if (practiceTabs_buttons == null || practiceTabs_buttons.isEmpty()) {
            return webAutomationAdvanceBtn_id.isDisplayed();
        }
        return practiceTabs_buttons.stream().allMatch(WebElement::isDisplayed);
    }

}
