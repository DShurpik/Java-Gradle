package sauceDemo;

import basePages.BasePage;
import components.HeaderComponents;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    HeaderComponents headerComponents;

    public MainPage() {
        PageFactory.initElements(driver, this);
        headerComponents = new HeaderComponents(driver);
    }

    @FindBy(className = "app_logo")
    private WebElement appLogo;

    @Step("Check if main page is displayed")
    public boolean isMainPageDisplayed() {
        return appLogo.isDisplayed();
    }

    public HeaderComponents getHeaderComponents() {
        return headerComponents;
    }
}
