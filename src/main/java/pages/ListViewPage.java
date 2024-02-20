package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.SelenuimDriver;

import java.util.List;

public class ListViewPage {

    @FindBy(xpath = "//article[@class='card-list-item']")
    List<WebElement> listResults;

    public ListViewPage() {
        PageFactory.initElements(SelenuimDriver.getDriver(), this);
    }

    public String getPageTitle() {
        return SelenuimDriver.getDriver().getTitle();

    }

    public void verifyResultList(int expectedResult) {
        Assert.assertEquals(listResults.size(), expectedResult);
    }

}
