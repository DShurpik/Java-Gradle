package sauceDemo;

import basePages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageChain extends BasePage {

    public LoginPageChain() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @Step("Enter username: {0}")
    public LoginPageChain enterUserName(String userName) {
        userNameField.sendKeys(userName);
        return this;
    }

    @Step("Open URL: {0}")
    public LoginPageChain openUrl(String url) {
        driver.get(url);
        return this;
    }

    @Step("Enter password: {0}")
    public LoginPageChain enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Click on login button")
    public LoginPageChain clickLoginButton() {
        loginButton.click();
        return this;
    }
}
