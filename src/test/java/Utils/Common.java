//package Utils;

//import org.openqa.selenium.Alert;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//import Utils.Base;

//import org.openqa.selenium.WebDriver;

//public class Common extends Base {
    //WebDriver driver;
        // 1. Wait for the alert to be present
        // Use Duration.ofSeconds for the timeout
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.alertIsPresent());

        // 2. Switch to the alert
        //Alert alert = driver.switchTo().alert();

        // 3. Get the text from the alert for verification (optional)
        //String alertText = alert.getText();
        //System.out.println("Alert message: " + alertText);

        // 4. Click the "OK" button to accept the alert
        //alert.accept();

        // 5. You can now continue with the rest of your test
        //System.out.println("Alert handled successfully. Continuing with the test.");

        // Clean up
        //driver.quit();

//}