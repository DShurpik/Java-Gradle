package api.models.responses;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;


public class HttpResponse {
    private final ValidatableResponse response;

    public HttpResponse(ValidatableResponse response) {
        this.response = response;
    }

    @Step("Check json value by path '{path}' and expected value '{expectedValue}'")
    public HttpResponse jsonValueIs(String path, String expectedValue) {
        String actualValue = this.response.extract().jsonPath().getString(path);
        Assertions.assertThat(actualValue).isEqualTo(expectedValue);
        return this;
    }

    @Step("Check json value by path '{path}' and expected value '{expectedValue}'")
    public HttpResponse jsonValueIs(String path, int expectedValue) {
        int actualValue = this.response.extract().jsonPath().getInt(path);
        Assertions.assertThat(actualValue).isEqualTo(expectedValue);
        return this;
    }

    @Step("Check json value by path '{path}' matches matcher")
    public <T> HttpResponse jsonValueMatches(String path, Matcher<T> matcher) {
        T actualValue = this.response.extract().jsonPath().get(path);
        assertThat(actualValue, matcher);
        return this;
    }
}
