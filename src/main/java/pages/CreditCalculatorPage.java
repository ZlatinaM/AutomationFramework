package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SelenuimDriver;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class CreditCalculatorPage {

    public CreditCalculatorPage() {
        PageFactory.initElements(SelenuimDriver.getDriver(), this);
    }

    WebDriverWait wait = new WebDriverWait(SelenuimDriver.getDriver(), Duration.ofSeconds(30));

    @FindBy(xpath = "//img[@class='calculator-logo']")
    public WebElement proCreditLogo;

    @FindBy(xpath = "//iframe[@class='credit-iframe']")
    public WebElement iframe;

    @FindBy(xpath = "//input[@id='creditAmount']/../div")
    public WebElement moveCreditAmountSlider;

    @FindBy(xpath = "//input[@id='creditPeriod']/../div")
    public WebElement moveCreditPeriodSlider;

    @FindBy(css = "#resultMonthlyFee")
    public WebElement monthlyFee;

    @FindBy(css = "#resultAmount")
    public WebElement amount;

    @FindBy(css = "#resultIRRDesktop")
    public WebElement irr;

    @FindBy(css = "#interestRate")
    public WebElement interestRate;

    @FindBy(css = "#pbcreditCalculator")
    public WebElement applyButton;

    WebDriver driver = SelenuimDriver.getDriver();

    Actions action = new Actions(driver);

    public boolean isCreditCalculatorPageOpen() {
        return wait.until(ExpectedConditions.visibilityOf(proCreditLogo)).isDisplayed();
    }

    public void selectCreditAmount() {
        driver.switchTo().frame(iframe);
        action.dragAndDropBy(moveCreditAmountSlider, -200, 0).perform();
    }

    public void selectCreditPeriod() {
        action.dragAndDropBy(moveCreditPeriodSlider, 200, 0).perform();
    }

    public boolean verifyTheCreditParametersAreCalculated() {
        return monthlyFee.isDisplayed() && amount.isDisplayed() && irr.isDisplayed() && interestRate.isDisplayed();
    }

    public void clickOnApplyButton() {
        driver.switchTo().frame(iframe);
        applyButton.click();
    }

    public boolean verifyProCreditBankPageIsOpen(){
        String originalWindow = SelenuimDriver.getDriver().getWindowHandle();
        wait.until(numberOfWindowsToBe(2));
        for (String windowHandle : SelenuimDriver.getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                SelenuimDriver.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        wait.until(titleIs("Жилищен кредит"));
        return (SelenuimDriver.getDriver().findElement(By.xpath("//img[@alt='procredit bulgarian logo']")).isDisplayed());
    }
}
