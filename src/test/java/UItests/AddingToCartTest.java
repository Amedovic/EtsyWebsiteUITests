package UItests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddingToCartTest extends BaseTest{

    @Test
    @Description("Adding item to a cart - guest user")
    public void addingItemToCartValidation(){
        homePage.goToSunglassesAndEyewear();
        sunglassesPage.addToCart();

        Assert.assertTrue(sunglassesPage.isItemAddedToCart());
    }
}
