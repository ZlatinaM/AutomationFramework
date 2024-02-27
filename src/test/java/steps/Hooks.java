package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.SelenuimDriver;

import java.io.File;

public class Hooks {

    @Before
    public static void setUp(){
        SelenuimDriver.setUpDriver();
    }

    @After
    public static void tearDown(){
        SelenuimDriver.tearDown();
    }

    @AfterStep
    public void takeScreenShot(Scenario scenario){
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) SelenuimDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

    }
}
