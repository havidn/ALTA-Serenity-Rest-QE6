package starter.weatherbit;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;


import java.io.File;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.notNullValue;

public class WeatherbitStepDef {


    @Steps
    WeatherbitResponses weatherbitResponses;
    @Given("User set lat to {float} and lon {float} and token {string}")
    public void userSetLatToAndLonAndToken(float lat,float lon, String key) {
        SerenityRest.given()
                .queryParam("lat",lat)
                .queryParam("lon",lon)
                .queryParam("key",key);
    }
    @When("User send request get Current Weather")
    public void userSendRequestGetCurrentWeather() {
        SerenityRest.when().get("http://api.weatherbit.io/v2.0/current");
    }
    @Then("Should return {int} OK")
    public void shouldReturnOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }
    @And("Response body should contain State Code {string}")
    public void responseBodyShouldContainStateCode(String city) {
        SerenityRest.then()
                .body(weatherbitResponses.STATE_CODE,hasItems(city));
    }
    @And("Get Weather  json Schema Validator")
    public void getWeatherJsonSchemaValidator() {
        File json = new File (WeatherbitAPI.JSON_VALIDATOR+"/CurrentWeatherSchemaValidator.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @Given("User set postal_code to {int} and token {string}")
    public void userSetPostal_codeToAndToken(int post, String key) {
        SerenityRest.given()
                .queryParam("postal_code",post)
                .queryParam("key",key);
    }
    @When("User send request get Daily Forecast")
    public void userSendRequestGetDailyForecast() {
        SerenityRest.when().get("http://api.weatherbit.io/v2.0/forecast/hourly");
    }
    @And("Response body should contains weather, timestamps not null")
    public void responseBodyShouldContainsWeatherTimestampsNotNull() {
        SerenityRest.then()
                .body(weatherbitResponses.TIME, notNullValue())
                .body(weatherbitResponses.WEATHER, notNullValue());
    }
    @And("Get Daily Forecast json Schema Validator")
    public void getDailyForecastJsonSchemaValidator() {
        File json = new File (WeatherbitAPI.JSON_VALIDATOR+"/DailyForecastSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
