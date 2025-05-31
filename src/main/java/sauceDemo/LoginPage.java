package sauceDemo;

import basePages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @Step("Enter username: {0}")
    public void enterUserName(String userName) {
        userNameField.sendKeys(userName);
    }

    @Step("Enter password: {0}")
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    @Step("Click on login button")
    public void clickLoginButton() {
        loginButton.click();
    }
}
