package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ListViewPage;
import pages.MainNavigationBar;
import pages.SalesPage;
import utils.SelenuimDriver;

public class SearchingOnSalesPageStepDefinitions {

    SalesPage salesPage = new SalesPage();
    ListViewPage listViewPage;
    MainNavigationBar navigationBar = new MainNavigationBar();

    @Given("I am on the Yavlena broker page")
    public void i_am_on_the_main_yavlena_broker_page() {
        SelenuimDriver.openPage("https://www.yavlena.com/broker/");
    }

    @When("I select {string} language in the drop-down menu")
    public void i_select_language_in_the_drop_down_menu(String language) {
        navigationBar.selectLanguage(language);

    }

    @When("I select {string} city in the search field")
    public void i_select_city_in_the_search_field(String city) {
        navigationBar.selectCityForSearch(city);
    }

    @When("I click on Sales button")
    public void i_click_on_sales_button() {
        salesPage = navigationBar.navigateToSalePage();
    }

    @And("I select Property type {string}")
    public void i_select_property_type(String type) {
        salesPage.selectPropertyType();
        salesPage.selectTypeOfApartment(type);
    }

    @And("I click on Neighborhood and select one from the list")
    public void i_click_on_neighborhood_and_select_one_from_the_list() {
        salesPage.clickOnNeighborhoodTab();
        salesPage.selectNeighborhood();
    }

    @And("I select min price {string}")
    public void i_select_min_price(String minPrice) {
        salesPage.selectMinPrice(minPrice);
    }

    @And("I select max price {string}")
    public void i_select_max_price(String maxPrice) {
        salesPage.selectMaxPrice(maxPrice);
    }

    @When("I select only max price {string}")
    public void i_select_only_max_price(String maxPrice) {
        salesPage.selectOnlyMaxPrice(maxPrice);
    }

    @And("I select min area {string}")
    public void i_select_min_area(String minArea) {
        salesPage.selectMinArea(minArea);
    }

    @And("I select max area {string}")
    public void i_select_max_area(String maxArea) {
        salesPage.selectMaxArea(maxArea);
    }

    @Then("on the right side of the screen I can see the filtered results")
    public void on_the_right_side_of_the_screen_i_can_see_the_filtered_results() {
        Assert.assertTrue(salesPage.areResultsDisplayed());
    }

    @Then("on the right side of the screen there are no filtered results")
    public void on_the_right_side_of_the_screen_there_are_no_filtered_results() {
        Assert.assertEquals(salesPage.displayedResult(), "0");
    }

    @Then("on the right side of the screen only apartments with price within the range are displayed")
    public void on_the_right_side_of_the_screen_only_apartments_with_price_within_the_range_are_displayed() {
        Assert.assertTrue(salesPage.verifyInformationIsFilteredCorrectlyBasedOnPrice());
    }

    @And("I click on the List button")
    public void i_click_on_the_list_button() {
        listViewPage = salesPage.clickOnListButton();
    }

    @Then("a new page with results in list view is displayed")
    public void a_new_page_with_results_in_list_view_is_displayed() {
        Assert.assertTrue(listViewPage.verifyListPageIsDisplayed());
    }

}

