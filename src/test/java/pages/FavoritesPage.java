package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class FavoritesPage extends BasePage{

    public FavoritesPage(WebDriver driver, WebDriverWait waiter, Properties locators ){
        super(driver, waiter, locators);
    }

    private WebElement getFavoriteTag(){
        return driver.findElement(By.xpath(locators.getProperty("itemsFavoriteTag")));
    }

    public void removeTagFromItem(){
        this.getFavoriteTag().click();
    }

    private WebElement getRemove(){
        return driver.findElement(By.xpath(locators.getProperty("remove")));
    }

    public void remove(){
        this.getRemove().click();
    }

    private WebElement getDoneBtn(){
        return driver.findElement(By.xpath(locators.getProperty("doneBtn")));
    }

    public void removeItemFromFavorites(){
        this.removeTagFromItem();
        this.remove();
        this.getDoneBtn().click();
    }

    public boolean isDisplayed(){
        try {
            driver.findElement(By.xpath(locators.getProperty("favoriteItem")));
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
