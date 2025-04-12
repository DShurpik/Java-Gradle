import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PropertyReader;

public class PropertyTests {

    WebDriver driver;
    PropertyReader propertyReader = new PropertyReader();

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Tag("env")
    @Test
    void openPage() {
        driver.get(propertyReader.getRequiredProperty("baseUrl"));
        driver.quit();
    }
}
