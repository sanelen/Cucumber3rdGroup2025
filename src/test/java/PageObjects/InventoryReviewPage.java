package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryReviewPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public InventoryReviewPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Device Summary
    @FindBy(id = "device-summary-title")
    private WebElement deviceSummary_id;

    @FindBy(id = "summary-device-type")
    private WebElement summaryDeviceType_id;

    @FindBy(id = "summary-brand")
    private WebElement summaryBrand_id;

    @FindBy(id = "summary-storage")
    private WebElement summaryStorage_id;

    @FindBy(id = "summary-color")
    private WebElement summaryColor_id;

    @FindBy(id = "summary-quantity")
    private WebElement summaryQuantity_id;

    @FindBy(id = "summary-address")
    private WebElement summaryAddress_id;


    //Shipping
    @FindBy(id = "shipping-label")
    private WebElement shippingLabel_id;

    @FindBy(id = "shipping-option-standard")
    private WebElement shippingOptionStandard_id;

    @FindBy(id = "shipping-option-express")
    private WebElement shippingOptionExpress_id;

    //Warranty
    @FindBy(id = "warranty-label")
    private WebElement warrantyLabel_id;

    @FindBy(id = "warranty-option-none")
    private WebElement warrantyNone_id;

    @FindBy(id = "warranty-option-1yr")
    private WebElement warrantyOption1y_id;

    @FindBy(id = "warranty-2yr")
    private WebElement warrantyOption2y_id;

    //Discount
    @FindBy(id = "discount-label")
    private WebElement discountLabel_id;


    @FindBy(id = "discount-code")
    private WebElement discountCode_id;


    @FindBy(id = "apply-discount-btn")
    private WebElement applyDiscount_btn;

    //Preview
    @FindBy(id = "section-title")
    private WebElement previewSectionTitle_id;

    //Pricing Breakdown
    @FindBy(id = "pricing-breakdown-title")
    private WebElement pricingBreakdownTitle_id;

    @FindBy(id = "base-price")
    private WebElement basePrice_id;

    @FindBy(id = "base-price-value")
    private WebElement basePriceValue_id;

    @FindBy(id = "breakdown-quantity-label")
    private WebElement breakdownQuantityLabel_id;

    @FindBy(id = "breakdown-quantity-value")
    private WebElement breakdownQuantityValue_id;

    @FindBy(id = "breakdown-subtotal-label")
    private WebElement breakdownSubtotalLabel_id;

    @FindBy(id = "breakdown-subtotal-value")
    private WebElement breakdownSubtotalValue_id;

    @FindBy(id = "breakdown-warranty-label")
    private WebElement breakdownWarrantyLabel_id;

    @FindBy(id = "breakdown-warranty-value")
    private WebElement breakdownWarrantyValue_id;

    @FindBy(id = "breakdown-shipping-label")
    private WebElement breakdownShippingLabel_id;

    @FindBy(id = "breakdown-shipping-value")
    private WebElement breakdownShippingValue_id;

    @FindBy(id = "breakdown-total-label")
    private WebElement breakdownTotalLabel_id;

    @FindBy(id = "breakdown-total-value")
    private WebElement breakdownTotalValue_id;

    //Back Button
    @FindBy(id = "inventory-back-btn")
    private WebElement backButton_id;

    //Add to Cart Button
    @FindBy(id = "add-to-cart-btn")
    private WebElement addToCartButton_id;

    //Confirm e Button
    @FindBy(id = "purchase-device-btn")
    private WebElement purchaseDeviceButton_id;


    public void chooseStandardShipping() {
        wait.until(ExpectedConditions.elementToBeClickable(shippingOptionStandard_id)).click();
    }

    public void chooseExpressShipping() {
        wait.until(ExpectedConditions.elementToBeClickable(shippingOptionExpress_id)).click();
    }

    public void chooseNoWarranty() {
        wait.until(ExpectedConditions.elementToBeClickable(warrantyNone_id)).click();
    }

    public void chooseWarranty1Year() {
        wait.until(ExpectedConditions.elementToBeClickable(warrantyOption1y_id)).click();
    }

    public void chooseWarranty2Years() {
        wait.until(ExpectedConditions.elementToBeClickable(warrantyOption2y_id)).click();
    }

    public void enterDiscountCode(String code) {
        wait.until(ExpectedConditions.visibilityOf(discountCode_id)).clear();
        discountCode_id.sendKeys(code);
    }

    public void clickApplyDiscount() {
        wait.until(ExpectedConditions.elementToBeClickable(applyDiscount_btn)).click();
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton_id)).click();
    }

    public void clickBackButton() {
        wait.until(ExpectedConditions.elementToBeClickable(backButton_id)).click();

    }
        public void clickConfirmPurchase() {
            wait.until(ExpectedConditions.elementToBeClickable(purchaseDeviceButton_id)).click();
        }

    /** Returns the full text of the Device Summary card (type, brand, storage, etc.) */
    public String deviceSummaryText() {
        return wait.until(ExpectedConditions.visibilityOf(deviceSummary_id)).getText();
    }


    public String DeviceTypeSummaryText() {
        return wait.until(ExpectedConditions.visibilityOf(summaryDeviceType_id)).getText();
    }
    public String BrandSummaryText() {
        return wait.until(ExpectedConditions.visibilityOf(summaryBrand_id)).getText();
    }

    public String StorageSummaryText() {
        return wait.until(ExpectedConditions.visibilityOf(summaryStorage_id)).getText();
    }
    public String ColorSummaryText() {
        return wait.until(ExpectedConditions.visibilityOf(summaryColor_id)).getText();
    }

    public String QuantitySummaryText() {
        return wait.until(ExpectedConditions.visibilityOf(summaryQuantity_id)).getText();
    }
    public String AddressSummaryText() {
        return wait.until(ExpectedConditions.visibilityOf(summaryAddress_id)).getText();
    }

    public String pricingBreakdownText() {
        return wait.until(ExpectedConditions.visibilityOf(pricingBreakdownTitle_id)).getText();
    }

    public String basePriceText() {
        return wait.until(ExpectedConditions.visibilityOf(basePrice_id)).getText();
    }

    public String basePriceValueText() {
        return wait.until(ExpectedConditions.visibilityOf(basePriceValue_id)).getText();
    }

    public String breakdownQuantityLabelText() {
        return wait.until(ExpectedConditions.visibilityOf(breakdownQuantityLabel_id)).getText();
    }
    public String breakdownQuantityValueText() {
        return wait.until(ExpectedConditions.visibilityOf(breakdownQuantityValue_id)).getText();
    }
    public String breakdownSubtotalLabelText() {
        return wait.until(ExpectedConditions.visibilityOf(breakdownSubtotalLabel_id)).getText();
    }
    public String breakdownSubtotalValueText() {
        return wait.until(ExpectedConditions.visibilityOf(breakdownSubtotalValue_id)).getText();
    }
    public String breakdownWarrantyLabelText() {
        return wait.until(ExpectedConditions.visibilityOf(breakdownWarrantyLabel_id)).getText();
    }
    public String breakdownWarrantyValueText() {
        return wait.until(ExpectedConditions.visibilityOf(breakdownWarrantyValue_id)).getText();
    }
    public String breakdownShippingLabelText() {
        return wait.until(ExpectedConditions.visibilityOf(breakdownShippingLabel_id)).getText();
    }
    public String breakdownShippingValueText() {
        return wait.until(ExpectedConditions.visibilityOf(breakdownShippingValue_id)).getText();
    }
    public String breakdownTotalLabelText() {
        return wait.until(ExpectedConditions.visibilityOf(breakdownTotalLabel_id)).getText();
    }
    public String breakdownTotalValueText() {
        return wait.until(ExpectedConditions.visibilityOf(breakdownTotalValue_id)).getText();
    }

    /** Returns the currently selected shipping value from the radios. */
    public String getSelectedShipping() {
        if (shippingOptionStandard_id.isSelected()) return "standard";
        if (shippingOptionExpress_id.isSelected()) return "express";
        return "";
    }

    /** Returns the selected warranty option. */
    public String getSelectedWarranty() {
        if (warrantyNone_id.isSelected()) return "none";
        if (warrantyOption1y_id.isSelected()) return "1y";
        if (warrantyOption2y_id.isSelected()) return "2y";
        return "";
    }

}


