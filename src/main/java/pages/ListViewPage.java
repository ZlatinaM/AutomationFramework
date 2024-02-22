package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SelenuimDriver;

import java.time.Duration;


public class ListViewPage {

    @FindBy(xpath = "//div[@class='search-results-map results-overflow-list']")
    public WebElement listResults;

    @FindBy(xpath = "//div[@class ='results-loading' and @style='display: block;']")
    public WebElement loader;

    public ListViewPage() {
        PageFactory.initElements(SelenuimDriver.getDriver(), this);
    }


    public boolean verifyListPageIsDisplayed() {
        waitPageToLoad();
        return listResults.isDisplayed();
    }

    public void waitPageToLoad(){
        WebDriverWait wait = new WebDriverWait(SelenuimDriver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(loader));

    }

}
