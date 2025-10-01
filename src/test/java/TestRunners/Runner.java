package TestRunners;

// import io.cucumber.testng.AbstractTestNGCucumberTests;
// import io.cucumber.testng.CucumberOptions;


// @CucumberOptions(
//         features = "src/test/resources/Features",
//         glue = {"StepDefs"},
//         // Ensure we include all relevant feature tags; correct tag expression
//         tags = "@Signup or @Login or @Dashboard",
//         monochrome = true,
//         plugin = {"pretty",
//                 "html:target.cucumber-reports.html",
//                 "json:target.cucumber.json",
//                 "junit:target.cucumber-results.xml"}

// )
// public class Runner extends AbstractTestNGCucumberTests {
// }

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@SelectClasspathResource("Features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "StepDefs")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-report.html")
public class Runner {}

//mvn test -Dcucumber.features=classpath:Features/Signup.feature
