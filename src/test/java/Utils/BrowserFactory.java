package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public static WebDriver driver;

    public static WebDriver startBrowser(String browserChoice, String url){
        System.out.println("DEBUG: BrowserFactory.startBrowser called with browserChoice='" + browserChoice + "', url='" + url + "'");
        switch (browserChoice.toLowerCase()){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new EdgeDriver();
                break;
        }
        System.out.println("DEBUG: BrowserFactory.created driver instance: " + driver.getClass().getName());
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }
}
