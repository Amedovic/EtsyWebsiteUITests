package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class RegistrationPage extends BasePage{

    public RegistrationPage (WebDriver driver, WebDriverWait waiter, Properties locators){
        super(driver, waiter, locators);
    }

    private WebElement getEmail(){
        return driver.findElement(By.id(locators.getProperty("email")));
    }

    public void setEmail(String email){
        this.getEmail().sendKeys(email);
    }

    private WebElement getContinueBtn(){
        return driver.findElement(By.xpath(locators.getProperty("continueBtn")));
    }

    public void continueRegistration(){
        this.getContinueBtn().click();
    }

    private WebElement getFirstName(){
        return driver.findElement(By.id(locators.getProperty("firstName")));
    }

    public void setFirstName(String firstName){
        waiter.until(ExpectedConditions.elementToBeClickable(this.getFirstName())).sendKeys(firstName);
    }

    private WebElement getPassword(){
        return driver.findElement(By.id(locators.getProperty("password")));
    }

    public void setPassword(String password){
        this.getPassword().sendKeys(password);
    }

    private WebElement getRegisterBtn(){
        return driver.findElement(By.xpath(locators.getProperty("registerBtn")));
    }

    private WebElement getSignInBtn(){
        return driver.findElement(By.name(locators.getProperty("signIn")));
    }

    public void registration(String email, String firstName, String password){
        this.setEmail(email);
        this.continueRegistration();
        this.setFirstName(firstName);
        this.setPassword(password);
        this.getRegisterBtn().click();
    }

    public void invalidMailRegistration(String invalidMail){
        this.setEmail(invalidMail);
        this.continueRegistration();
    }

    public void signIn(String email, String password){
        this.setEmail(email);
        this.setPassword(password);
        this.getSignInBtn().click();

    }

    public boolean isRegistered(){
        try {
            driver.findElement(By.xpath(locators.getProperty("welcomeMsg")));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean isNotRegistered(){
        try {
            driver.findElement(By.xpath(locators.getProperty("errorMsg")));
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
