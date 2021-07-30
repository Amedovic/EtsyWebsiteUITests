package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver, WebDriverWait waiter, Properties locators) {
        super(driver, waiter, locators);
    }

    private WebElement getSignIn(){
        return driver.findElement(By.xpath(locators.getProperty("signInBtn")));
    }

    public void goToRegistration(){
        this.getSignIn().click();
    }

    private WebElement getSearchBar(){
        return driver.findElement(By.cssSelector(locators.getProperty("searchBar")));
    }

    private WebElement getSearchBtn(){
        return driver.findElement(By.xpath(locators.getProperty("searchBtn")));
    }

    public void search(String itemName){
        this.getSearchBar().sendKeys(itemName);
        this.getSearchBtn().click();
    }

    private WebElement allFilterBtn(){
        return driver.findElement(By.id(locators.getProperty("allFiltersBtn")));
    }

    public void goToFilters(){
        this.allFilterBtn().click();
    }

    private WebElement getJewelryAndAccessoriesLink(){
        return driver.findElement(By.xpath(locators.getProperty("jewelryAndAccessoriesLink")));
    }

    private WebElement getSunglassesAndEyewearLink(){
        return driver.findElement(By.xpath(locators.getProperty("sunglassesAndEyewearLink")));
    }

    public void goToSunglassesAndEyewear(){
        Actions action = new Actions(driver);
        action.moveToElement(this.getJewelryAndAccessoriesLink()).build().perform();
        this.getSunglassesAndEyewearLink().click();
    }

    private WebElement getAddToFavoritesBtn(){
        return driver.findElement(By.xpath(locators.getProperty("addToFavoritesBtn")));
    }

    public void addToFavorites(){
        this.getAddToFavoritesBtn().click();
    }

    private WebElement getFavoritesBtn(){
        return driver.findElement(By.xpath(locators.getProperty("favoritesBtn")));
    }

    public void goToFavorites(){
        this.getFavoritesBtn().click();
    }

    public boolean isDisplayed(){
        try {
            if (this.getSignIn().isDisplayed() && this.getSearchBar().isDisplayed() && this.getSearchBtn().isDisplayed()
                    && this.getFavoritesBtn().isDisplayed() && this.getJewelryAndAccessoriesLink().isDisplayed()) {
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
