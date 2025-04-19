package basePages;

import org.junit.jupiter.api.*;

import static driver.SingletoneDriver.closeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {



    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {
        closeDriver();
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
