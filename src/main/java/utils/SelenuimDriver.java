package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelenuimDriver {

    private static SelenuimDriver selenuimDriver;

    private static WebDriver driver;

    private SelenuimDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    }

    public static void openPage(String url){
        driver.get(url);
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void setUpDriver(){
        if (selenuimDriver == null){
            selenuimDriver = new SelenuimDriver();
        }
    }

    public static void tearDown(){
        if (driver != null){
            driver.close();
            driver.quit();
        }
        selenuimDriver = null;
    }

    public static void waitUntilElementIsClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(locator));

    }




}
