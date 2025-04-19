package components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderComponents {

    private WebDriver driver;

    public HeaderComponents(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "app_logo")
    private WebElement logo;

    @FindBy(className = "shopping_cart_link")
    private WebElement cart;

    @FindBy(className = "bm-burger-button")
    private WebElement menuButton;

    @Step("Open bucket menu")
    public void openBucket() {
        cart.click();
    }

    public WebElement getCart() {
        return cart;
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getMenuButton() {
        return menuButton;
    }
}
