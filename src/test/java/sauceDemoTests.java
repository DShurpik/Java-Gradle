import basePages.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import sauceDemo.LoginPage;
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
}
