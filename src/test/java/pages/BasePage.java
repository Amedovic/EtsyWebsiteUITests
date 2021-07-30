package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public abstract class BasePage {

    public WebDriver driver;
    public WebDriverWait waiter;
    public Properties locators;

    public BasePage(WebDriver driver, WebDriverWait waiter, Properties locators){
        this.driver = driver;
        this.waiter = waiter;
        this.locators = locators;
    }

}
