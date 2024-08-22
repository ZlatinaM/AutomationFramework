@second
Feature: Clicking on the credit calculator button a calculator of Pro Credit bank opens and
  user is able to calculate the monthly payments based on the amount and the term of the credit

  Background:
    Given I am on the Yavlena broker page
    When I click on Credit Calculator button
    Then the credit calculator of Pro Credit bank is open

  Scenario: User is able to calculate the monthly payments of his credit

    When I select the minimal credit amount
    And I select the maximum period in months
    Then I can see the credit parameters calculated

  Scenario: An external page of Pro Credit bank opens when the user clicks on the Apply button

    When I click on the Apply button
    Then I am redirected to external web page of Pro Credit bank