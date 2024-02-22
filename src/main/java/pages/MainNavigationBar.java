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

    @FindBy(xpath = "//input[@id='searchBox']")
    public WebElement searchField;

    @FindBy(xpath = "//div[@class='language-dropdown']")
    public WebElement languageDropDown;

    @FindBy(xpath = "//div[@class='language-selector']//span[@class='icon-bgr']")
    public WebElement bulgarianLanguage;

    @FindBy(xpath = "//div[@class='language-selector']//span[@class='icon-eng']")
    public WebElement englishLanguage;

    @FindBy(xpath = "//div[@class='language-selector']//span[@class='icon-rus']")
    public WebElement russianLanguage;

    @FindBy(xpath = "//ul[@id='ui-id-1']/li[@id='ui-id-2']")
    public WebElement sofiaCityOption;


    public void selectCityForSearch(String city) {
        searchField.clear();
        searchField.sendKeys(city);
        sofiaCityOption.click();
    }


    public void selectLanguage(String language) {
        languageDropDown.click();
        switch (language) {
            case "BGR":
                bulgarianLanguage.click();
                break;
            case "ENG":
                englishLanguage.click();
                break;
            case "RUS":
                russianLanguage.click();
                break;
        }
    }


    public SalesPage navigateToSalePage() {
        saleButton.click();
        return new SalesPage();
    }

    public CreditCalculatorPage navigateToCreditCalculator() throws InterruptedException {
        creditCalculatorButton.click();
        Thread.sleep(10000);
        return new CreditCalculatorPage();
    }

}





