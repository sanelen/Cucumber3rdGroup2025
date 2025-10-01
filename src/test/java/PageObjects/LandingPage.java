package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LandingPage {

    WebDriver driver;
    public LandingPage(WebDriver driver) {
        this.driver = driver;
        // Initialize @FindBy annotated elements
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "nav-btn-practice")
    WebElement LearningMaterialsButton_id;

    @FindBy(id = "overview-hero")
    WebElement LearnAutomationTheRightWay_id;


    public void verifyLearnAutomationTheRightWayIsDisplayed() {
        // Wait for the alert to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(LearnAutomationTheRightWay_id)).isDisplayed();
    }

    public void clickLearningMaterialsButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(LearningMaterialsButton_id)).click();
        //LearningMaterialsButton_id.click();
    }


}
