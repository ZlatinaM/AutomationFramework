package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SelenuimDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SalesPage {

    public SalesPage(){
        PageFactory.initElements(SelenuimDriver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@placeholder='Тип имот']")
    public WebElement propertyType;

    @FindBy(xpath = "//input[@placeholder='Квартали']")
    public WebElement districts;

    @FindBy(xpath = "//input[@placeholder='Цена']")
    public WebElement priceTab;

    @FindBy(xpath = "//input[@name='PropertyMaxPrice']")
    public WebElement maxPriceField;

    @FindBy(xpath = "//input[@placeholder='Площ']")
    public WebElement area;

    @FindBy(xpath = "//input[@data-search-field='area-from']")
    public WebElement minAreaField;

    @FindBy(xpath = "//input[@data-search-field='area-to']")
    public WebElement maxAreaField;

    @FindBy(xpath = "//div[@class='search-results-map-holder custom-class']/div")
    public List<WebElement> results;

    @FindBy(xpath = "//div[@class='aside-holder']//a[@title='Списък']")
    public WebElement listButton;


    public void selectPropertyType(){
        waitUntilResultsAreLoaded(30);
        propertyType.click();

    }

    public void selectTypeOfApartment(String type){
        SelenuimDriver.getDriver().findElement(By.xpath("//div[@class='icheckbox_flat-green']/input[@value ='"+type+"']/following-sibling::ins")).click();
    }

    public void clickOnDistrictTab(){
        districts.click();
    }

    public void selectDistrictName(String name){
        SelenuimDriver.getDriver().findElement(By.xpath("//div[@class='icheckbox_flat-green']/input[@data-quarter ='"+name+"']/following-sibling::ins")).click();
    }

    public void selectMinPrice(String minPrice) {
        priceTab.click();
        //SelenuimDriver.waitUntilElementIsClickable(By.xpath("//ul[@class='min-price price']//li[@data-value='"+minPrice+"']"));
        SelenuimDriver.getDriver().findElement(By.xpath("//ul[@class='min-price price']//li[@data-value='"+minPrice+"']")).click();
    }

    public void selectMaxPrice(String maxPrice)   {
        maxPriceField.click();
        SelenuimDriver.getDriver().findElement(By.xpath("//ul[@class ='max-price price']//li[@data-value='"+maxPrice+"']")).click();
    }

    public void selectMinArea(String minArea) {
        area.click();
        minAreaField.click();
        SelenuimDriver.getDriver().findElement(By.xpath("//ul[@data-search-options='area-from']/li[@data-value='" + minArea + "']")).click();
    }

    public void selectMaxArea(String maxArea){
        maxAreaField.click();
        SelenuimDriver.getDriver().findElement(By.xpath("//ul[@data-search-options='area-to']/li[@data-value='"+maxArea+"']")).click();

    }
    public boolean areResultsDisplayed() {
        waitUntilResultsAreLoaded(30);
        return !results.isEmpty();
    }

    public void waitUntilResultsAreLoaded(int time){
        WebDriverWait wait = new WebDriverWait(SelenuimDriver.getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='results-loading']"), 1));
    }

    public String displayedResult() {
        WebDriverWait wait = new WebDriverWait(SelenuimDriver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='button' and @data-dismiss='alert']")));

        return SelenuimDriver.getDriver().findElement(By.xpath("//div[@id='list-results']/preceding-sibling::h2/strong")).getText();
    }

    public boolean verifyInformationIsFilteredCorrectlyBasedOnPrice() throws InterruptedException {
        boolean pricesMatch = false;
        WebDriverWait wait = new WebDriverWait(SelenuimDriver.getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='estate-details']/span"), 3));

        List<Integer> listPrices = new ArrayList<>();
        List<WebElement> prices = SelenuimDriver.getDriver().findElements(By.xpath("//div[@class='estate-details']/span"));
        for (int i = 0; i<prices.size(); i++){
            String price = prices.get(i).getText().replaceAll("[^\\d]", "");
            int priceToInt = Integer.parseInt(price);

            listPrices.add(priceToInt);

            for (int j=0; j<listPrices.size(); j++){
                if (priceToInt>10000 && priceToInt<500000){
                    pricesMatch = true;
                }else{
                    pricesMatch = false;
                }

                }
            }
        return pricesMatch;


        }

        public ListViewPage clickOnListButton(){
        listButton.click();

        return new ListViewPage();
        }













}
