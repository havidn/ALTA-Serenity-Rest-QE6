package starter.reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import io.restassured.module.jsv.JsonSchemaValidator;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;



public class ReqresStepDef {
    @Steps
    ReqresAPI  reqresAPI;
    // Scenario 1
    @Given("Get list user with parameter page {int}")
    public void getListUserWithParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }
    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(reqresAPI.GET_LIST_USER);
    }
    @Then("Should return {int} OK")
    public void shouldReturnOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }
    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
    }
    @And("Get list user json schema validator")
    public void getListUserJsonSchemaValidator() {
        File json = new File (ReqresAPI.JSON_VALIDATOR+"/GetListUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Scenario 2
    @Given("Get list user with parameter page {string}")
    public void getListUserWithParameterPage(String page) {
        reqresAPI.getListUsersInvalidPage(page);
    }
    @Then("Should return {int} Not found")
    public void shouldReturnNotFound(int ok) {
        SerenityRest.then().statusCode(ok);
    }

// Scenario 3
    @Given("Get Single list Resource with valid parameter {int}")
    public void getListResourceWithParameter(int id) {
        reqresAPI.getSingleResource(id);
    }
    @When("Send request get list resource")
    public void sendRequestGetListResource() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE);
    }
    @And("Response body id should be {int}")
    public void responseBodyIdShouldBeId(int id) {
        SerenityRest.then().body(ReqresResponses.DATAID,equalTo(id));
    }
    @And("Get single list Resource json schema validator")
    public void getSingleListResourceJsonSchemaValidator() {
        File json = new File (ReqresAPI.JSON_VALIDATOR+"/GetSingleListResourceJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
// Scenario 4
    @Given("Get Single list Resource with invalid parameter {string}")
    public void getSingleListResourceWithInvalidParameterId(String id) {
    reqresAPI.getSingleInvalidResource(id);
    }
// Scenario 5
    @Given("Get single user with valid id {int}")
    public void getSingleUserWithValidIdId(int id) {
    reqresAPI.getSingleUser(id);
    }
    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }
    @And("Response body should contain email {string}, first name {string}, and last name {string}")
    public void responseBodyShouldContainEmailFirstNameAndLastName(String email, String first_name, String last_name) {
        SerenityRest.then()
                .body(ReqresResponses.EMAIL,equalTo(email))
                .body(ReqresResponses.FIRST_NAME,equalTo(first_name))
                .body(ReqresResponses.LAST_NAME,equalTo(last_name));
    }
    @And("Get single user json schema validator")
    public void getSingleUserJsonSchemaValidator() {
        File json = new File (ReqresAPI.JSON_VALIDATOR+"/GetSingleUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
// Scenario 6
    @Given("Get single user with invalid id {string}")
    public void getSingleUserWithInvalidId(String id) {
    reqresAPI.getSingleUserInvalid(id);
    }
// Scenario 7
    @Given("Post create new user")
    public void postCreateNewUser() {
    File json = new File(ReqresAPI.JSON_FILE+"/PostCreateNewUser.json");
    reqresAPI.postCreateNewUser(json);
    }
    @When("Send request post create new user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER);
    }
    @Then("Should return {int} created")
    public void shouldReturnCreated(int created) {
        SerenityRest.then().statusCode(created);
    }
    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }
    @And("Post create new user json schema validator")
    public void postCreateNewUserJsonSchemaValidator() {
        File json = new File (ReqresAPI.JSON_VALIDATOR+"/PostCreateNewUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    // Scenario 8
    @Given("Post create new invalid user")
    public void postCreateNewInvalidUser() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostCreateNewInvalidUser.json");
        reqresAPI.postCreateNewUser(json);
    }
    @Then("Should return {int} Bad Request")
    public void shouldReturnBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }
    // Scenario 9
    @Given("Post register user with valid json")
    public void postRegisterUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostRegisterUser.json");
        reqresAPI.postRegisterUser(json);
    }
    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_USER);
    }
    @And("Response body should contain id {int}")
    public void responseBodyShouldContainId(int id) {
        SerenityRest.then().body(ReqresResponses.ID,equalTo(id));
    }
    @And("Post register user json schema validator")
    public void postRegisterUserJsonSchemaValidator() {
        File json = new File (ReqresAPI.JSON_VALIDATOR+"/PostRegisterUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Scenario 10
    @Given("Post register user with invalid json")
    public void postRegisterUserWithInvalidJson() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostRegisterInvalidUser.json");
        reqresAPI.postRegisterUser(json);
    }
    @And("Post register invalid user json schema validator")
    public void postRegisterInvalidUserJsonSchemaValidator() {
        File json = new File (ReqresAPI.JSON_VALIDATOR+"/PostRegisterInvalidUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    // Scenario 11
    @Given("Post login user with valid json")
    public void postLoginUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostLoginUser.json");
        reqresAPI.postLoginUser(json);
    }
    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_USER);
    }
    @And("Post login user json schema validator")
    public void postLoginUserJsonSchemaValidator() {
        File json = new File (ReqresAPI.JSON_VALIDATOR+"/PostLoginUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    // Scenario 12
    @Given("Post login user without password")
    public void postLoginUserWithoutPassword() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostLoginUserWithoutPassword.json");
        reqresAPI.postLoginUser(json);
    }
    @And("Post login invalid user json schema validator")
    public void postLoginInvalidUserJsonSchemaValidator() {
        File json = new File (ReqresAPI.JSON_VALIDATOR+"/PostLoginInvalidUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    // Scenario 13
    @Given("Post login user without email")
    public void postLoginUserWithoutEmail() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostLoginUserWithoutEmail.json");
        reqresAPI.postLoginUser(json);
    }
    // Scenario 14
    @Given("Put update with id {int}")
    public void putUpdateWithId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/PutUpdateUser.json");
        reqresAPI.putUpdateUser(id,json);
    }
    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }
    @And("Put Update user json schema validator")
    public void putUpdateUserJsonSchemaValidator() {
        File json = new File (ReqresAPI.JSON_VALIDATOR+"/PutUpdateUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    // Scenario 15
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.deleteUser(id);
    }
    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }
    @Then("Should return {int} No content")
    public void shouldReturnNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }
    // Scenario 16
    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalidIdId(String id) {
        reqresAPI.deleteUserInvalid(id);
    }

// update data

    @Given("Patch update with id {int}")
    public void patchUpdateWithId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/PatchUpdateUser.json");
        reqresAPI.patchUpdateUser(id,json);
    }
    @Given("Patch update with invalid json file to id {int}")
    public void patchUpdateWithInvalidJsonFileToId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/PatchUpdateEmptyUser.json");
        reqresAPI.patchUpdateUser(id,json);
    }

    @When("Send request patch update user")
    public void sendRequestPatchUpdateUser() {
        SerenityRest.when().patch(ReqresAPI.PATCH_UPDATE_USER);
    }

    @Given("Put update without job json file to id {int}")
    public void putUpdateWithoutJobJsonFile(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/PutUpdateUserWithoutJob.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @Given("Put update without name json file to id {int}")
    public void putUpdateWithoutNameJsonFile(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/PutUpdateUserWithoutName.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @And("Patch update user json schema validator")
    public void patchUpdateUserJsonSchemaValidator() {
        File json = new File (ReqresAPI.JSON_VALIDATOR+"/PatchUpdateUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


}
