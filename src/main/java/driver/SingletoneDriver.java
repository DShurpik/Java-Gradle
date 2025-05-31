package driver;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.PropertyReader;

import java.time.Duration;

public class SingletoneDriver {
    private static WebDriver driver;

    private SingletoneDriver() {
    }

    @Step("Get WebDriver instance")
    public static WebDriver getDriver() {
        if (driver == null) {
            switch (PropertyReader.getRequiredProperty("browser").toLowerCase()) {
                case "chrome" -> driver = new ChromeDriver(getChromeOptions());
                case "firefox" -> driver = new FirefoxDriver(getFirefoxOptions());
                default -> throw new IllegalArgumentException("Unsupported browser: " + PropertyReader.getRequiredProperty("browser"));
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(10));
        }
        return driver;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        return options;
    }

    private static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-infobars");
        return options;
    }

    @Step("Close WebDriver instance")
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
