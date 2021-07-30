package UItests;

import common.Constants;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemovingFromFavoritesTest extends BaseTest{

    @Test
    @Description("Removing an item from favorites - registered user")
    public void removingItemFromFavoritesValidation(){
        homePage.goToRegistration();
        registrationPage.signIn(Constants.MY_EMAIL, Constants.MY_PASSWORD);
        homePage.addToFavorites();
        homePage.goToFavorites();
        favoritesPage.removeTagFromItem();
        favoritesPage.removeItemFromFavorites();
        driver.navigate().refresh();

        Assert.assertFalse(favoritesPage.isDisplayed());
    }
}
