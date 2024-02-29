package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SelenuimDriver {

    private static SelenuimDriver selenuimDriver;

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    private SelenuimDriver() {

        ChromeOptions opt = new ChromeOptions();

        opt.addArguments("incognito");

        Map<String, Object> prefs = new HashMap<>();
        Map<String, Object> profile = new HashMap<>();
        Map<String, Object> contentSettings = new HashMap<>();

        contentSettings.put("geolocation", 1);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        opt.setExperimentalOption("prefs", prefs);

        driver.set(new ChromeDriver(opt));
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    public static void openPage(String url) {
        driver.get().navigate().to(url);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setUpDriver() {
        if (selenuimDriver == null) {
            selenuimDriver = new SelenuimDriver();
        }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.get().close();
            driver.get().quit();
        }
        selenuimDriver = null;
    }

}
