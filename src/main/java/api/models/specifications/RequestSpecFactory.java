package api.models.specifications;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static api.apiConstants.BASE_URL;

public class RequestSpecFactory {
    public static RequestSpecification baseSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setAccept("*/*")
                .addFilter(new AllureRestAssured())
                .log(LogDetail.ALL)
                .build();

    }

    public static RequestSpecification withContentType(ContentType contentType) {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setAccept("*/*")
                .setContentType(contentType)
                .addFilter(new AllureRestAssured())
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification withQueryParams(Map<String, String> params) {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setAccept("*/*")
                .addQueryParams(params)
                .addFilter(new AllureRestAssured())
                .log(LogDetail.ALL)
                .build();
    }
}
