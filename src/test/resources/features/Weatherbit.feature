Feature: Weatherbit API Automation
  Scenario: Get Current Weather Data
    Given User set lat to 40.730610 and lon -73.935242 and token "86eb0c93f440431fb6a43f23ee90fc28"
    When User send request get Current Weather
    Then Should return 200 OK
    And Response body should contain State Code "NY"
    And Get Weather  json Schema Validator

  Scenario: Get Daily Forecast Data
    Given User set postal_code to 28546 and token "86eb0c93f440431fb6a43f23ee90fc28"
    When User send request get Daily Forecast
    Then Should return 200 OK
    And Response body should contains weather, timestamps not null
    And Get Daily Forecast json Schema Validator