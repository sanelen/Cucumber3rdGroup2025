package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InventoryPage {

    WebDriver driver;
    WebDriverWait wait;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.errorMessages = errorMessages;
        PageFactory.initElements(driver, this);
    }
    // ===== Page elements (using @FindBy) =====
    @FindBy(id = "deviceType")
    private WebElement deviceDropdown;

    @FindBy(id = "brand")
    private WebElement brandDropdown;

    @FindBy(id = "storage-128GB")
    private WebElement storageOptions128GB;

    @FindBy(id = "storage-256GB")
    private WebElement storageOptions256GB;

    @FindBy(id = "color")
    private WebElement colorDropdown;

    @FindBy(id = "quantity")
    private WebElement quantityInput;

    @FindBy(id = "address")
    private WebElement deliveryAddressInput;

    @FindBy(id = "inventory-next-btn")
    private WebElement nextButton;

    @FindBy(className = "error-summary")
    private WebElement errorSummary;

    @FindBy(className = "error-message")
    private List<WebElement> errorMessages;

    @FindBy(id = "inventory-form")
    private WebElement expandFormButton;

    // ===== Actions =====

    public void selectStorage(String capacity) {
        String normalized = normalizeCapacity(capacity);
        WebElement target = null;
        switch (normalized) {
            case "128GB":
                target = storageOptions128GB;
                break;
            case "256GB":
                target = storageOptions256GB;
                break;
            default:
                throw new IllegalArgumentException("Unsupported storage capacity: " + capacity);
        }

        wait.until(ExpectedConditions.elementToBeClickable(target));
        if (!target.isSelected()) {
            target.click();
        }
    }

    private String normalizeCapacity(String raw) {
        if (raw == null) return "";
        String s = raw.trim().toUpperCase().replaceAll("\\s+", "");
        if (!s.endsWith("GB")) s += "GB";
        return s;
    }


    public void expandForm() {
        wait.until(ExpectedConditions.elementToBeClickable(expandFormButton)).click();
    }

    public void selectDevice(String deviceType) {
        wait.until(ExpectedConditions.visibilityOf(deviceDropdown));
        new Select(deviceDropdown).selectByVisibleText(deviceType);
    }

    public void selectBrand(String brand) {
        wait.until(ExpectedConditions.visibilityOf(brandDropdown));
        new Select(brandDropdown).selectByVisibleText(brand);
    }

    public void selectColor(String color) {
        wait.until(ExpectedConditions.visibilityOf(colorDropdown));
        new Select(colorDropdown).selectByVisibleText(color);
    }

    public void enterQuantity(String quantity) {
        wait.until(ExpectedConditions.visibilityOf(quantityInput));
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }

    public void enterDeliveryAddress(String address) {
        wait.until(ExpectedConditions.visibilityOf(deliveryAddressInput));
        deliveryAddressInput.clear();
        deliveryAddressInput.sendKeys(address);
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    // ===== Validations =====

    public boolean isNextButtonDisabled() {
        return !nextButton.isEnabled();
    }

    public boolean isErrorMessageDisplayed(String errorMessage) {
        wait.until(d -> !d.findElements(By.className("error-message")).isEmpty());
        for (WebElement message : errorMessages) {
            if (message.getText().trim().equals(errorMessage)) {
                return true;
            }
        }
        return false;
    }

    public boolean isErrorSummaryDisplayed() {
        try {
            return errorSummary.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}