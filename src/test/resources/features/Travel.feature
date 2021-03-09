@Flightbooking
Feature: Flight booking

  Background:
  User navigates to Travel page
    Given I am on  Travel page

  @Test1
  Scenario: Verify login fails with incorrect credentials
    Then change the place name
    And I click on Find ticket
    And click on detail and do the assert
    And click on Select go
    And click on detials on filling page and assert values
    And user fills the details and confirm order
    And Assert details in payment page