package UItests;

import common.Randoms;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public Properties locators;
    public WebDriverWait waiter;
    HomePage homePage;
    RegistrationPage registrationPage;
    FiltersPage filtersPage;
    SunglassesPage sunglassesPage;
    FavoritesPage favoritesPage;
    Randoms randoms;

    public WebDriver createWebDriver() throws IOException {
        locators = new Properties();
        locators.load(new FileInputStream("configuration.properties"));
        String browser = locators.getProperty("browser");
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

    @BeforeClass
    public void setUp() throws IOException {
        driver = this.createWebDriver();
        waiter = new WebDriverWait(driver, 10);
        homePage = new HomePage(driver, waiter, locators);
        registrationPage = new RegistrationPage(driver, waiter, locators);
        filtersPage = new FiltersPage(driver, waiter, locators);
        sunglassesPage = new SunglassesPage(driver, waiter, locators);
        favoritesPage = new FavoritesPage(driver, waiter, locators);
        randoms = new Randoms();
    }

    @BeforeMethod
    public void setUpForTests(){
        driver.manage().window().maximize();
        driver.navigate().to(locators.getProperty("homePageUrl"));
    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }
}
