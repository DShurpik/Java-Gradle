import basePages.BaseTest;
import dto.User;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import sauceDemo.LoginPage;
import sauceDemo.LoginPageChain;
import sauceDemo.MainPage;
import utils.PropertyReader;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class sauceDemoTests extends BaseTest {

    @DisplayName("Login Test")
    @Severity(SeverityLevel.TRIVIAL)
    @Owner("John Doe")
    @TmsLink("https://example.com/testcase/1")
    @Tag("smoke")
    @Test
    public void firstTest() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        loginPage.open(PropertyReader.getRequiredProperty("baseUrl"));
        loginPage.enterUserName(PropertyReader.getRequiredProperty("userName"));
        loginPage.enterPassword(PropertyReader.getRequiredProperty("password"));
        loginPage.clickLoginButton();

        assertTrue(mainPage.isMainPageDisplayed(), "Main page is not displayed");
    }

    @DisplayName("Login Test with builder")
    @Severity(SeverityLevel.NORMAL)
    @Owner("John Doe")
    @TmsLink("https://example.com/testcase/2")
    @Tag("smoke")
    @Test
    public void secondTest() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();

        User user = new User.UserBuilder()
                .setUsername(PropertyReader.getRequiredProperty("userName"))
                .setPassword(PropertyReader.getRequiredProperty("password"))
                .build();
        loginPage.open(PropertyReader.getRequiredProperty("baseUrl"));
        loginPage.fillLoginForm(user);

        assertTrue(mainPage.isMainPageDisplayed(), "Main page is not displayed");
    }

    @DisplayName("Login Test with chain")
    @Severity(SeverityLevel.NORMAL)
    @Owner("John Doe")
    @TmsLink("https://example.com/testcase/3")
    @Tag("smoke")
    @Test
    public void thirdTest() {
        LoginPageChain loginPage = new LoginPageChain();
        MainPage mainPage = new MainPage();

        loginPage
                .openUrl(PropertyReader.getRequiredProperty("baseUrl"))
                .enterUserName(PropertyReader.getRequiredProperty("userName"))
                .enterPassword(PropertyReader.getRequiredProperty("password"))
                .clickLoginButton();

        assertTrue(mainPage.isMainPageDisplayed(), "Main page is not displayed");
    }
}
