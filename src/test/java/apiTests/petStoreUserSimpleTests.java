package apiTests;

import api.models.requests.UserModel;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.apiConstants.BASE_URL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class petStoreUserSimpleTests {

    UserModel user = new UserModel(1223, "John Doe", "John", "Doe",
            "jd@mail.com", "pass", "123123", 0);

    @Tag("api")
    @Order(1)
    @Test
    public void createUserTest() {
        given()
                .baseUri(BASE_URL)
                .accept("application/json")
                .contentType(ContentType.JSON)
                .body(user)
                .log().all()
                .when()
                .post("/v2/user")
                .then()
                .statusCode(200)
                .log().all()
                .body("code", equalTo(200),
                        "type", equalTo("unknown"),
                        "message", equalTo(user.getId() + ""));

    }

    @Tag("api")
    @Order(2)
    @Test
    public void getUserTest() {
        UserModel userModel = given()
                .baseUri(BASE_URL)
                .accept("application/json")
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get("/v2/user/" + user.getUsername())
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .as(UserModel.class);
        // Assertions
        assertEquals(userModel.getId(), user.getId());
    }

    @Tag("api")
    @Order(3)
    @Test
    public void logIn() {
        given().baseUri(BASE_URL)
                .accept("application/json")
                .queryParam("username", user.getUsername())
                .queryParam("password", user.getPassword())
                .log().all()
                .when()
                .get("/v2/user/login")
                .then()
                .statusCode(200)
                .log().all()
                .body("code", equalTo(200),
                        "type", equalTo("unknown"),
                        "message", Matchers.startsWith("logged in user session:"));
    }

    @Tag("api")
    @Order(4)
    @Test
    public void logOut() {
        given().baseUri(BASE_URL)
                .log().all()
                .when()
                .get("/v2/user/logout")
                .then()
                .statusCode(200)
                .log().all()
                .body("code", equalTo(200),
                        "type", equalTo("unknown"),
                        "message", equalTo("ok"));
    }

    @Tag("api")
    @Order(5)
    @Test
    public void updateUserTest() {
        UserModel updatedUser = new UserModel();
        updatedUser.setId(3321);
        updatedUser.setUsername("JohnDoe");
        updatedUser.setFirstName("Doe");
        updatedUser.setLastName("John");

        given()
                .baseUri(BASE_URL)
                .accept("application/json")
                .contentType(ContentType.JSON)
                .body(updatedUser)
                .log().all()
                .when()
                .put("/v2/user/" + user.getUsername())
                .then()
                .statusCode(200)
                .log().all()
                .body("code", equalTo(200),
                        "type", equalTo("unknown"),
                        "message", equalTo(updatedUser.getId() + ""));
    }

    @Tag("api")
    @Order(6)
    @Test
    public void deleteUserTest() {
        given()
                .baseUri(BASE_URL)
                .accept("application/json")
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .delete("/v2/user/" + user.getUsername())
                .then()
                .statusCode(200)
                .log().all()
                .body("code", equalTo(200),
                        "type", equalTo("unknown"),
                        "message", equalTo(user.getUsername()));
    }
}
