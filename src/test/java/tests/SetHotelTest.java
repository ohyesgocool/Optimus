package tests;

import org.testng.Assert;

import org.testng.annotations.Test;
import pages.HotelPage;


public class SetHotelTest extends TestBase{


    @Test(priority = 1)
    public void setHotelCityTest(){
        HotelPage hotelPage=new HotelPage(driver);
        hotelPage.setEnterHotelCity();
    }

    @Test(priority = 2)
    public void hotelSearchButtonTest(){
        HotelPage hotelPage=new HotelPage(driver);
        Assert.assertEquals(hotelPage.searchHotel() , "SEARCH HOTELS");
    }


}
