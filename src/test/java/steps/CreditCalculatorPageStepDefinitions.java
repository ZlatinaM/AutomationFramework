package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CreditCalculatorPage;
import pages.MainNavigationBar;


public class CreditCalculatorPageStepDefinitions {

    CreditCalculatorPage creditCalculatorPage;

    @When("I click on Credit Calculator button")
    public void i_click_on_credit_calculator_button() {
        MainNavigationBar navigationBar = new MainNavigationBar();
        creditCalculatorPage = navigationBar.navigateToCreditCalculator();
    }

    @Then("the credit calculator of Pro Credit bank is open")
    public void the_credit_calculator_of_pro_credit_bank_is_open() {
        Assert.assertTrue(creditCalculatorPage.isCreditCalculatorPageOpen());
    }

    @When("I select the minimal credit amount")
    public void i_select_the_minimal_credit_amount() {
        creditCalculatorPage.selectCreditAmount();
    }

    @And("I select the maximum period in months")
    public void i_select_the_maximum_period_in_months() {
        creditCalculatorPage.selectCreditPeriod();
    }

    @Then("I can see the credit parameters calculated")
    public void i_can_see_the_credit_parameters_calculated() {
        Assert.assertTrue(creditCalculatorPage.verifyTheCreditParametersAreCalculated());
    }

    @When("I click on the Apply button")
    public void i_click_on_the_apply_button() {
        creditCalculatorPage.clickOnApplyButton();
    }
    @Then("I am redirected to external web page of Pro Credit bank")
    public void i_am_redirected_to_external_web_page_of_pro_credit_bank() {
        Assert.assertTrue(creditCalculatorPage.verifyProCreditBankPageIsOpen());


    }

}
