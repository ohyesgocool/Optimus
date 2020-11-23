package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ActivitiesPage;


public class BookProductCardTest extends TestBase {

    @Test(priority = 1)
    public void ProductCardTextTest()
    {
        ActivitiesPage activitiesPage = new ActivitiesPage(driver);
        activitiesPage.SetLocation();
        Assert.assertEquals(activitiesPage.getProductCard() , "Product Cards");

    }
    @Test(priority = 2)
    public void SeeAllButtonTextTest()
    {
        ActivitiesPage activitiesPage = new ActivitiesPage(driver);
        Assert.assertEquals(activitiesPage.getSeeAllText(), "SEE ALL");

    }

}
