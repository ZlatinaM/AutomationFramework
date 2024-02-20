This is a simple automation framework which still under construction. It is based on Java, Selenium and Cucumber. It has been created as a Maven project for easier management of the dependencies
The Page Object design pattern is used - every page is a Java object with its locators and methods. Page factory design pattern is used for initialization of the web elments
The SeleniumDriver class is based on the Singleton design pattern
The tests are the Scenarios in the Feature files
The test are run via the Test Runner class
Two reporting tools are added to the project - Cucumber and Extent Reports
