package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SelenuimDriver;

public class MainNavigationBar {

    public MainNavigationBar() {
        PageFactory.initElements(SelenuimDriver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@data-container='PropertySale']")
    public WebElement saleButton;

    @FindBy(xpath = "//li[@id='creditCalculator']/a")
    public WebElement creditCalculatorButton;


    public SalesPage navigateToSalePage() {
        saleButton.click();
        return new SalesPage();
    }

    public CreditCalculatorPage navigateToCreditCalculator() {
        creditCalculatorButton.click();
        return new CreditCalculatorPage();
    }

}
