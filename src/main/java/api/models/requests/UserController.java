package api.models.requests;

import api.models.specifications.RequestSpecFactory;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserController {

    @Step("Add a new user")
    public Response addUser(UserModel user) {
        return given(RequestSpecFactory.withContentType(ContentType.JSON))
                .body(user)
                .post("/v2/user")
                .andReturn();
    }

    @Step("Get user by username")
    public Response getUserByUsername(String username) {
        return given(RequestSpecFactory.baseSpec())
                .get("/v2/user/" + username)
                .andReturn();
    }

    @Step("Log in user")
    public Response loginUser(Map<String, String> params) {
        return given(RequestSpecFactory.withQueryParams(params))
                .get("/v2/user/login")
                .andReturn();
    }

    @Step("Log out user")
    public Response logoutUser() {
        return given(RequestSpecFactory.baseSpec())
                .get("/v2/user/logout")
                .andReturn();
    }

    @Step("Update user")
    public Response updateUser(UserModel user, String username) {
        return given(RequestSpecFactory.withContentType(ContentType.JSON))
                .body(user)
                .put("/v2/user/" + username)
                .andReturn();
    }

    @Step("Delete user")
    public Response deleteUser(String username) {
        return given(RequestSpecFactory.baseSpec())
                .delete("/v2/user/" + username)
                .andReturn();
    }
}
