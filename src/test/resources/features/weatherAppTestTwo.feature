@weatherApp
Feature: Weather App Tests

  Background:
    Given the user has opened the Weather App


  @smoke
  Scenario Outline: 3 Hourly Forecast Shown on Day <day>
    And the user selects the city of "Aberdeen"
    When the user clicks on day <day>
    Then a 3 hourly forecast is displayed

    Examples:
      | day |
      | 1   |
      | 2   |
      | 3   |
      | 4   |
      | 5   |

  @smoke
  Scenario Outline: 3 Hourly Forecast Closed on Day <day>
    And the user selects the city of "Perth"
    And the user clicks on day <day>
    When the user clicks again on day <day>
    Then a 3 hourly forecast is not shown

    Examples:
      | day |
      | 1   |
      | 2   |
      | 3   |
      | 4   |
      | 5   |

