package pages;

import com.google.common.collect.Iterables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class SunglassesPage extends BasePage{

    String orderItem = driver.findElement(By.xpath(locators.getProperty("orderingItem"))).toString();

    public SunglassesPage(WebDriver driver, WebDriverWait waiter, Properties locators){
        super(driver, waiter, locators);
    }

    private WebElement getOversizeSunglasses(){
        return driver.findElement(By.xpath(locators.getProperty("oversizeSunglasses")));
    }

    public void selectOversizeSunglasses(){
        this.getOversizeSunglasses().click();
    }

    public WebElement getAddToCartBtn(){
        return driver.findElement(By.xpath(locators.getProperty("addToCartBtn")));
    }

    public void addToCart(){
        this.selectOversizeSunglasses();
        String[] tabs = Iterables.toArray(driver.getWindowHandles(), String.class);
        driver.switchTo().window(tabs[1]);
        waiter.until(ExpectedConditions.elementToBeClickable(this.getAddToCartBtn())).click();
    }

    public boolean isItemAddedToCart(){
        try {
            if(driver.findElement(By.xpath(locators.getProperty("itemDescription"))).getText().equalsIgnoreCase(orderItem));
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
