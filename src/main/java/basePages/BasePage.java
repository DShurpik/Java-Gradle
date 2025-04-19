package basePages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static driver.SingletoneDriver.getDriver;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage() {
        this.driver = getDriver();
    }

    @Step("Open URL: {url}")
    public void open(String url) {
        driver.get(url);
    }
}
