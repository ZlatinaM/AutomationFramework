package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SelenuimDriver;

public class MainNavigationBar {

    public MainNavigationBar(){
        PageFactory.initElements(SelenuimDriver.getDriver(), this);
    }

    @FindBy(xpath = "//nav[@class='main-nav']//a[text()='Продажба']")
    public WebElement saleButton;

    @FindBy(xpath = "//nav[@class='main-nav']//a[text()='Наем']")
    public WebElement rentButton;

    public SalesPage navigateToSalePage(){
        saleButton.click();
        return new SalesPage();
    }

}
