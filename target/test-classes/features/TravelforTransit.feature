@Flightbooking2
Feature: Flight booking

  Background:
  User navigates to Travel page
    Given User is on  Travel page

  @Test1
  Scenario: Verify login fails with incorrect credentials
    Then change the date
    And I click on Find tickets
    And click on detail on flight list page and do the assert
    And click on Select_go
    And click on detials in filling page and assert values
    And after filling the details do confirm order
    And Assert details in payment page for transit