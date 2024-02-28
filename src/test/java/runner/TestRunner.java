package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features="src/test/resources/Features", glue= {"steps"}, plugin = {"html:target/cucumber-reports/cucumber-html-report.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, tags = "@test")
public class TestRunner extends AbstractTestNGCucumberTests {


    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
