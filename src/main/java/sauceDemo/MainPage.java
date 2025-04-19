package sauceDemo;

import basePages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "app_logo")
    private WebElement appLogo;

    @Step("Check if main page is displayed")
    public boolean isMainPageDisplayed() {
        return appLogo.isDisplayed();
    }
}
