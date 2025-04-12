import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.TestConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnerTest {

    TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());

    @Tag("owner")
    @Test
    public void testOwner() {
        assertEquals("https://the-internet.herokuapp.com/", config.baseUrl());
        assertEquals("testName", config.userName());
        assertEquals("testPassword", config.password());
    }

    @Tag("owner")
    @Test
    public void devOwner() {
        assertEquals("https://www.saucedemo.com/v1/", config.baseUrl());
        assertEquals("devName", config.userName());
        assertEquals("devPassword", config.password());
    }

    @Tag("owner")
    @Test
    public void prodOwner() {
        assertEquals("https://chromewebstore.google.com/", config.baseUrl());
        assertEquals("produser", config.userName());
        assertEquals("prodpass", config.password());
    }
}
