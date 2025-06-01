package apiTests;

import api.models.requests.UserController;
import api.models.requests.UserModel;
import api.models.responses.HttpResponse;
import api.models.specifications.ResponseSpecFactory;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class petStoreUserSpecTests {

    UserModel user = new UserModel(1223, "John Doe", "John", "Doe",
            "jd@mail.com", "pass", "123123", 0);


    @Tag("api")
    @Order(1)
    @Test
    public void createUserTest() {
        UserController controller = new UserController();
        ValidatableResponse response = controller
                .addUser(user)
                .then()
                .spec(ResponseSpecFactory.basic200WithNotNullFields("code", "type", "message"));

        new HttpResponse(response)
                .jsonValueIs("code", "200")
                .jsonValueIs("type", "unknown")
                .jsonValueIs("message", String.valueOf(user.getId()));
    }

    @Tag("api")
    @Order(2)
    @Test
    public void getUserTest() {
        UserController controller = new UserController();
        ValidatableResponse response = controller
                .getUserByUsername(user.getUsername())
                .then()
                .spec(ResponseSpecFactory.basic200WithNotNullFields("id", "username", "firstName", "lastName", "email", "password", "phone", "userStatus"));

        new HttpResponse(response)
                .jsonValueIs("id", user.getId())
                .jsonValueIs("username", user.getUsername())
                .jsonValueIs("firstName", user.getFirstName())
                .jsonValueIs("lastName", user.getLastName())
                .jsonValueIs("email", user.getEmail())
                .jsonValueIs("password", user.getPassword())
                .jsonValueIs("phone", user.getPhone())
                .jsonValueIs("userStatus", user.getUserStatus());
    }

    @Tag("api")
    @Order(3)
    @Test
    public void logIn() {
        Map<String, String> params = Map.of(
                "username", user.getUsername(),
                "password", user.getPassword());

        UserController controller = new UserController();
        ValidatableResponse response = controller
                .loginUser(params)
                .then()
                .spec(ResponseSpecFactory.basic200WithNotNullFields("code", "type", "message"));

        new HttpResponse(response)
                .jsonValueIs("code", "200")
                .jsonValueIs("type", "unknown")
                .jsonValueMatches("message", Matchers.startsWith("logged in user session:"));
    }

    @Tag("api")
    @Order(4)
    @Test
    public void logOut() {
        UserController controller = new UserController();
        ValidatableResponse response = controller
                .logoutUser()
                .then()
                .spec(ResponseSpecFactory.basic200WithNotNullFields("code", "type", "message"));

        new HttpResponse(response)
                .jsonValueIs("code", "200")
                .jsonValueIs("type", "unknown")
                .jsonValueIs("message", "ok");
    }

    @Tag("api")
    @Order(5)
    @Test
    public void updateUserTest() {
        UserModel updatedUser = new UserModel(3321, "John Doe", "Jack", "Flynn",
                "jf@mail.com", "pass", "123123", 0);

        ValidatableResponse response = new UserController().updateUser(updatedUser, user.getUsername())
                .then()
                .spec(ResponseSpecFactory.basic200WithNotNullFields("code", "type", "message"));

        new HttpResponse(response)
                .jsonValueIs("code", "200")
                .jsonValueIs("type", "unknown")
                .jsonValueIs("message", String.valueOf(updatedUser.getId()));
    }

    @Tag("api")
    @Order(6)
    @Test
    public void deleteUserTest() {
        ValidatableResponse response = new UserController().deleteUser(user.getUsername())
                .then()
                .spec(ResponseSpecFactory.basic200WithNotNullFields("code", "type", "message"));

        new HttpResponse(response)
                .jsonValueIs("code", "200")
                .jsonValueIs("type", "unknown")
                .jsonValueIs("message", user.getUsername());
    }
}
