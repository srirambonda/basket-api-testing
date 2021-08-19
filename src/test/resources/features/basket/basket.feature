@test
Feature: Functional verification of Basket REST APIs

  Scenario Outline: create new basket names
    Given I create new basket with name <basket-name>
    Then status of response is 201
    And the response content is json
    And the basket response should have token
    Examples:
      | basket-name  |
      | "baskettesting1"     |
      | "baskettesting2"     |

  Scenario Outline: create new basket negative scenarios
    Given I create new basket with name <basket-name>
    Then status of response is <response>
    Examples:
      | basket-name  | response |
      | "baskettesting1"     | 409 |

  Scenario: update the basket with right details
    Given the following basket:
    | forward_url |
    | "https://google.com" |
    When  I update the basket for "baskettesting1"
    Then status of response is 204


  Scenario: update the basket with unknown formats
    Given the following basket:
      | forward_url |
      | "google.com" |
      | "abc" |
    When  I update the basket for "baskettesting1"
    Then status of response is 422

  Scenario: Get the basket details
    Given get the basket details of "baskettesting1"
    Then status of response is 200
    And the response content is json
    And the response should have forward_url value "https://google.com"

  Scenario Outline: delete the basket details
    Given delete the basket details for <basket-name>
    Then status of response is <response>
    Examples:
      | basket-name | response |
      | "baskettesting1"    | 204      |
      | "baskettesting2"    | 204      |
      | "abcnkkkk"  | 404      |
