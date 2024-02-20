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

    @Given("I am on the main Yavlena page")
    public void i_am_on_the_main_yavlena_page() {
        SelenuimDriver.openPage("https://www.yavlena.com/broker/");
    }

    @When("I click on Продажба button")
    public void i_click_on_продажба_button() {
        MainNavigationBar navigationBar = new MainNavigationBar();
        salesPage = navigationBar.navigateToSalePage();
    }

    @Given("I select type {string}")
    public void i_select_type(String type) {
        salesPage.selectPropertyType();
        salesPage.selectTypeOfApartment(type);
    }

    @And("I select district {string}")
    public void i_select_district(String name) {
        salesPage.clickOnDistrictTab();
        salesPage.selectDistrictName(name);
    }

    @And("I select min price {string}")
    public void i_select_min_price(String minPrice) {
        salesPage.selectMinPrice(minPrice);
    }

    @And("I select max price {string}")
    public void i_select_max_price(String maxPrice) {
        salesPage.selectMaxPrice(maxPrice);

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

    @When("I click on Списък button")
    public void i_click_on_списък_button() {
        listViewPage = salesPage.clickOnListButton();

    }

    @Then("a new page containing the filtered information in a list view is displayed")
    public void a_new_page_containing_the_filtered_information_in_a_list_view_is_displayed() {
        Assert.assertEquals(listViewPage.getPageTitle(), "Търсене на продажби | Явлена");
        listViewPage.verifyResultList(1);

    }

}

