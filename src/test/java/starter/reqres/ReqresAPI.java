package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static String URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/JSON/jsonfile";
    public static final String JSON_VALIDATOR = DIR+"/src/test/resources/JSON/jsonschemavalidator";
    public static String GET_LIST_USER = URL+"/api/users?page={page}";
    public static String POST_CREATE_NEW_USER = URL+ "/api/users";
    public static String PUT_UPDATE_USER = URL+ "/api/users/{id}";
    public static String DELETE_USER = URL+ "/api/users/{id}";
    public static String GET_SINGLE_USER = URL+"/api/users/{id}";
    public static String POST_REGISTER_USER = URL+"/api/register";
    public static String POST_LOGIN_USER = URL+"/api/login";
    public static String GET_SINGLE_RESOURCE = URL+"/api/unknown/{id}";
    public static String PATCH_UPDATE_USER = URL+"/api/users/{id}";




    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given().pathParam("page",page);
    }
    @Step("Get list users invalid page")
    public void getListUsersInvalidPage(String page){
        SerenityRest.given().pathParam("page",page);
    }
    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Get single user invalid")
    public void getSingleUserInvalid(String id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Get Single Resource")
    public void getSingleResource(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Get Single Invalid Resource ")
    public void getSingleInvalidResource(String id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step ("Post create new user")
    public void postCreateNewUser(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }
    @Step ("Post register user")
    public void postRegisterUser(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }
    @Step ("Post login user")
    public void postLoginUser(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update user")
    public void putUpdateUser(int id,File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("delete user invalid")
    public void deleteUserInvalid(String id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Patch Update User")
    public void patchUpdateUser(int id,File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
