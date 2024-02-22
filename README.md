This is a simple automation framework which is still under construction. It is based on Java, Selenium and Cucumber. It has been created as a Maven project for easier management of the dependencies.
The Page Object design pattern is used - every page is a Java object with its locators and methods. Page factory design pattern is used for initialization of the web elments.
The SeleniumDriver class is based on the Singleton design pattern.
The tests are the Scenarios in the Feature files.
The test are run via the Test Runner class.
Two reporting tools are added to the project - Cucumber and Extent Reports

***************************************************************************

Additional notes:
* Tests are run via the Chrome Browser, but later this could be improved by adding additional browsers.

* If the tests are run in incognito mode, there is a pop-up that appears asking about your colation. I tried to disable this kind of pop-ups, but the method that I found for this kind of scenarios is not working for me, so I will continue work on that. These pop-ups do not afect the correct execution of the test.

* SearchingOnSalesPage.feature file contains scenarios which have been chosen for automation due to the challanges that these kind of scenarios have, mainly related to synchronization. In a real project the tests related to filtering should rely on stable database data, otherwise there might be a lot of failures.

* The test are addaptable to all languages that the web site provides (BGN, ENG and RUS). If there is a need the tests to be run for the English localization, the parameter shoud be changed in the step which is in the background: When I select "ENG" language in the drop-down menu. The deafult district used for the test should be Sofia. If the language is BGN or RUS, "софия" should be given as a parameter to the following step in the background: And I select "софия" city in the search field. If the selected language is ENG, the parameter should be "sofia".

* The scenarios in the CreditCalculatorTests.feature file have been chosen not because their automation value, but because in that page there are elements like sliders and iframes which can be quite challanging and I would like exersice.





