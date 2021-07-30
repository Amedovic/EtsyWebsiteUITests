package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class FiltersPage extends BasePage{

    public FiltersPage(WebDriver driver, WebDriverWait waiter, Properties locators){
        super(driver, waiter, locators);
    }

    private WebElement getFreeShippingBox(){
        return driver.findElement(By.id(locators.getProperty("freeShippingBox")));
    }

    public void setFreeShipping(){
        this.getFreeShippingBox().click();
    }

    private WebElement getLowPriceInput(){
        return driver.findElement(By.id(locators.getProperty("minPriceInput")));
    }

    public void setLowPrice(String minPrice){
        this.getLowPriceInput().sendKeys(minPrice);
    }

    private WebElement getHighPriceInput(){
        return driver.findElement(By.id(locators.getProperty("maxPriceInput")));
    }

    public void setHighPrice(String maxPrice){
        this.getHighPriceInput().sendKeys(maxPrice);
    }

    private WebElement getPowerBox(){
        return driver.findElement(By.xpath(locators.getProperty("mechanicalPowerBox")));
    }

    public void setPower(){
        this.getPowerBox().click();
    }

    private WebElement getShopLocation(){
        return driver.findElement(By.id(locators.getProperty("shopLocation")));
    }

    public void setShopLocation(){
        this.scrollAndClick(this.getShopLocation());
    }

    private WebElement getShippingDestination(){
        return driver.findElement(By.id(locators.getProperty("shippingDestination")));
    }

    public void setShippingDestination(String shippingDestination){
        this.getShippingDestination().click();
        Select destinations = new Select(this.getShippingDestination());
        destinations.selectByValue(shippingDestination);
    }

    private WebElement getApplyBtn(){
        return driver.findElement(By.cssSelector(locators.getProperty("applyBtn")));
    }

    public void setFilters(String minPrice, String maxPrice, String shippingDestination){
        this.setFreeShipping();
        this.setLowPrice(minPrice);
        this.setHighPrice(maxPrice);
        this.setPower();
        this.setShopLocation();
        this.setShippingDestination(shippingDestination);
        this.getApplyBtn().click();
    }

    public boolean isFiltered(){
        try {
            driver.findElement(By.xpath(locators.getProperty("filterResult"))).isDisplayed();
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public void scrollAndClick(WebElement element) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView();", element);
            waiter.until(ExpectedConditions.elementToBeClickable(element));
            jse.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }element.click();
    }
}
