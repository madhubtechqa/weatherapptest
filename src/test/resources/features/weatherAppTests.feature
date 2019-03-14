@weatherApp
Feature: Weather App Page Tests
  The Demo App is tested against the acceptance criteria


  @smoke
  Scenario: 5 Days Forecast
    Given the user has opened the Weather App
    When the user selects the city of "Aberdeen"
    Then a 5 day forecast is displayed

  @smoke
  Scenario: Daily Weather Forecast - Current Weather Condition
    Given the user has opened the Weather App
    And the user selects the city of "Stirling"
    And a 5 day forecast is displayed
    When the user clicks on day 1
    Then the daily forecast shows the current Weather condition

  @smoke
  Scenario: Daily Weather Forecast - Wind speed and direction
    Given the user has opened the Weather App
    And the user selects the city of "Glasgow"
    And a 5 day forecast is displayed
    When the user clicks on day 1
    Then the daily forecast shows the current wind speed
    And the daily forecast shows the current wind direction

  @regression
  Scenario: Daily Forecast - Aggregate rainfall
    Given the user has opened the Weather App
    And the user selects the city of "Glasgow"
    And a 5 day forecast is displayed
    When the user clicks on day 1
    Then the daily forecast shows the aggregate rainfall

  @regression
  Scenario: Daily Forecast - Minimum and maximum temperatures
    Given the user has opened the Weather App
    And the user selects the city of "Glasgow"
    And a 5 day forecast is displayed
    When the user clicks on day 1
    Then the daily forecast shows the minimum temperature for the day
    And the daily forecast shows the maximum temperature for the day

  @regression
  Scenario: All values should be rounded down
    Given the user has opened the Weather App
    And the user selects the city of "Stirling"
    When the user clicks on day 1
    Then values displayed are rounded down
