import extensions.LifecycleExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(LifecycleExtension.class)
public class JustTests extends BaseTest {



    @Disabled // This test is disabled and will not run
    @DisplayName("Disabled Test") // This is a custom display name for the test
    @Tag("smoke") // This test is tagged as "slow"
    @Timeout(2000) // This test has a timeout of 2000 milliseconds
    // @RepeatedTest(5) // This test will be repeated 5 times. Can't be used with @Test
    @Test
    void firstTest() {
        System.out.println("Running first test");
        assertTrue(true, "This test should always pass");
    }

    @Tags({@Tag("smoke"), @Tag("regression")}) // This test is tagged as both "smoke" and "regression")
    @DisplayName("Second Test")
    @Test
    void secondTest() {
        System.out.println("Running second test");
        assertEquals(2, 1 + 1, "1 + 1 should equal 2");
    }

    @Test
    @DisplayName("Third Test")
    void thirdTest() {
        System.out.println("Running third test");
        assertEquals(4, 2 + 2, "1 + 1 should equal 4");
    }
}
