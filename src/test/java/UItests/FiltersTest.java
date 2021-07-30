package UItests;

import common.Constants;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FiltersTest extends BaseTest{

    @Test
    @Description("Narrowing down the search using filters")
    public void searchFilteringValidation(){
        homePage.search(Constants.SEARCHING_ITEM);
        homePage.goToFilters();
        filtersPage.setFilters(Constants.MIN_PRICE, Constants.MAX_PRICE, Constants.SHIPPING_DESTINATION);

        Assert.assertTrue(filtersPage.isFiltered());
    }
}
