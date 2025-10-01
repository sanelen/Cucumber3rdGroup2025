package Utils;

import PageObjects.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    public static WebDriver driver;

    public LoginPage            loginPage;
    public SignupPage           signupPage;
    public LandingPage          landingPage;
    public DashboardPage        dashboardPage;
    public InventoryPage        inventoryPage;
    public InventoryReviewPage  inventoryReviewPage;

    static { new Config(); } // ok to keep

    // DO NOT start the browser here
    public Base() {
        // Just init pages against the (possibly already-started) driver
        if (driver != null) initPages();
    }

    private static void ensureDriverStarted() {
        if (driver == null) {
            String browser = System.getProperty("BROWSER", System.getenv("BROWSER"));
            if (browser == null || browser.isEmpty()) browser = "chrome";

            String baseUrl = System.getProperty("BASE_URL", System.getenv("BASE_URL"));
            if (baseUrl == null || baseUrl.isEmpty()) {
                baseUrl = "https://www.ndosiautomation.co.za/";
            }

            driver = BrowserFactory.startBrowser(browser, baseUrl);
        }
    }

    private void initPages() {
        loginPage           = PageFactory.initElements(driver, LoginPage.class);
        signupPage          = PageFactory.initElements(driver, SignupPage.class);
        landingPage         = PageFactory.initElements(driver, LandingPage.class);
        dashboardPage       = PageFactory.initElements(driver, DashboardPage.class);
        inventoryPage       = PageFactory.initElements(driver, InventoryPage.class);
        inventoryReviewPage = PageFactory.initElements(driver, InventoryReviewPage.class);
    }

    public static WebDriver getDriver() {
        ensureDriverStarted();
        return driver;
    }

    public void ensurePagesReady() {
        // call this once in your step @Before or first step
        ensureDriverStarted();
        initPages();
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public void login(String email, String password) {
        if (email != null) {
            email = email.trim();
        }
        if (password != null) {
            password = password.trim();
        }
        if (email == null || email.isEmpty()) {
            email = System.getProperty("APP_USERNAME", System.getenv("APP_USERNAME"));
        }
        if (password == null || password.isEmpty()) {
            password = System.getProperty("APP_PASSWORD", System.getenv("APP_PASSWORD"));
        }
        if (email == null || password == null) {
            throw new IllegalStateException("Set APP_USERNAME and APP_PASSWORD via -D or env.");
        }
        ensurePagesReady();

        String currentEmail = loginPage.getEmailText();
        if (currentEmail == null || !currentEmail.equals(email)) {
            loginPage.enterEmail(email);
        }
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    public String getLocalStorageItem(String key) {
        ensureDriverStarted();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object value = js.executeScript("return window.localStorage.getItem(arguments[0]);", key);
        return value == null ? null : value.toString();
    }

    public void removeLocalStorageItem(String key) {
        ensureDriverStarted();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.localStorage.removeItem(arguments[0]);", key);
    }

    public boolean isLoginPageVisible() {
        ensurePagesReady();
        return loginPage != null && loginPage.isLoginFormVisible();
    }
}
