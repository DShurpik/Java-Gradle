package utils;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:${test}.properties",
        "classpath:${dev}.properties"
})

public interface TestConfig extends Config {
    @Key("baseUrl")
    String baseUrl();

    @Key("userName")
    String userName();

    @Key("password")
    String password();
}
