package StepDefs; // Ensure this is the correct package where Cucumber looks

import Utils.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

@Getter
public class WebDriverManager {

    private WebDriver driver;

    public WebDriverManager() {
        this.driver = Base.getDriver();
    }

    @Before
    public void setupDriver() {
        driver = Base.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDownDriver() {
        Base.tearDown();
    }
}
