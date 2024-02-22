Feature: User is able to do a search and filter the information on Sales page

  Background:
    Given I am on the Yavlena broker page
    When I select "ENG" language in the drop-down menu
    And I select "sofia" city in the search field
    And I click on Sales button

#  This scenario depends on the data in the data base, but it is automated just to exercise asynchronization
  Scenario: User is able to filter the information on Sales page - positive scenario

    And I select Property type "ThreeBedroomApartment"
    And I click on Neighborhood and select one from the list
    And I select min price "75000"
    And I select max price "300000"
    And I select min area "50"
    And I select max area "150"
    Then on the right side of the screen I can see the filtered results

#  This scenario depends on the data in the data base, but in most of the cases there will no be four room apartment for max price 20000
  Scenario: User is able to filter the information on Sales page - negative scenario

    And I select Property type "FourBedroomApartment"
    And I select max price "20000"
    Then on the right side of the screen there are no filtered results

#  This scenario depends on the data in the data base, but in most of the cases there will be apartments in the given range
  Scenario: Searched information is filtered correctly based on price

    And I select Property type "TwoBedroomApartment"
    And I select min price "10000"
    And I select max price "500000"
    Then on the right side of the screen only apartments with price within the range are displayed

  Scenario: List view page is displayed when user clicks on List button

    And I click on the List button
    Then a new page with results in list view is displayed

