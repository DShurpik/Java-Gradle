import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

    @BeforeEach
    public void setUp() {
        // Code to set up the test environment, such as initializing WebDriver
        System.out.println("Setting up the test environment...");
    }

    @AfterEach
    public void tearDown() {
        // Code to clean up after each test, such as closing the browser
        System.out.println("Cleaning up after the test...");
    }

    @BeforeAll
    public void init() {
        // Code to run once before all tests, such as starting a server
        System.out.println("Initializing the test environment...");
    }

    @AfterAll
    public void cleanUp() {
        // Code to run once after all tests, such as shutting down the server
        System.out.println("Cleaning up the test environment...");
    }
}
