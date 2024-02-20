Feature: User is able to do a search and filter the information on Sales page

  Background:
    Given I am on the main Yavlena page
    When I click on Продажба button

  Scenario: User is able to filter the information on Sales page - positive scenario

    Given I select type "ThreeBedroomApartment"
    And I select district "Дружба 2"
    And I select min price "75000"
    And I select max price "300000"
    And I select min area "50"
    And I select max area "150"
    Then on the right side of the screen I can see the filtered results

  Scenario: User is able to filter the information on Sales page - negative scenario

    Given I select type "TwoBedroomApartment"
    And I select district "Докторски паметник"
    And I select min price "10000"
    And I select max price "20000"
    And I select min area "50"
    And I select max area "150"
    Then on the right side of the screen there are no filtered results

  Scenario: Searched information is filtered correctly based on price

    Given I select type "TwoBedroomApartment"
    And I select district "Докторски паметник"
    And I select min price "10000"
    And I select max price "500000"
    And I select min area "50"
    And I select max area "150"
    Then on the right side of the screen only apartments with price within the range are displayed

  Scenario: Filtered information can be displayed in list view on a new page

    Given I select type "FourBedroomApartment"
    And I select district "Докторски паметник"
    And I select min price "10000"
    And I select max price "500000"
    And I select min area "50"
    And I select max area "150"
    When I click on Списък button
    Then a new page containing the filtered information in a list view is displayed

