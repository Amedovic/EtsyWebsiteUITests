package UItests;

import common.Constants;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{

    @Test
    @Description("Verifying presence of all elements")
    public void presenceOfAllElementsValidation(){
        Assert.assertTrue(homePage.isDisplayed());
    }

    @Test
    @Description("Validation of new user registration, using valid credentials")
    public void successfulRegistrationValidation(){
        homePage.goToRegistration();
        registrationPage.registration(randoms.generateRandomEmail(), randoms.generateRandomName(), randoms.generateRandomPassword());

        Assert.assertTrue(registrationPage.isRegistered());
    }

    @Test
    @Description("Validation of new user registration, using invalid email format")
    public void unsuccessfulRegistrationValidation(){
        homePage.goToRegistration();
        registrationPage.invalidMailRegistration(Constants.INVALID_EMAIL);

        Assert.assertTrue(registrationPage.isNotRegistered());
    }
}
