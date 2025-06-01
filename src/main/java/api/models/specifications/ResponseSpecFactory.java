package api.models.specifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.notNullValue;

public class ResponseSpecFactory {

    public static io.restassured.specification.ResponseSpecification basic200WithNotNullFields(String... notNullFields) {
        ResponseSpecBuilder builder = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL);

        for (String field : notNullFields) {
            builder.expectBody(field, notNullValue());
        }

        return builder.build();
    }
}
