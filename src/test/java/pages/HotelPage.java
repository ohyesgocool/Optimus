package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HotelPage extends BasePage {

    public HotelPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Hotels']")
    protected WebElement Hotel;

    @FindBy(xpath = "//android.widget.TextView[@text='11']")
    protected WebElement fromDate;

    @FindBy(xpath = "//android.widget.TextView[@text='15']")
    protected WebElement toDate;

    @FindBy(id ="com.cleartrip.android:id/txt_hotel_city")
    protected WebElement hotelCity;

    @FindBy(id ="com.cleartrip.android:id/filter_edittext")
    protected WebElement enterHotelCity;

    @FindBy(id ="com.cleartrip.android:id/txtDateOneLiner")
    protected WebElement pickDate;

    @FindBy(id ="com.cleartrip.android:id/btn_search_hotels")
    protected WebElement searchHotelButton;
    //Text = SEARCH HOTELS



    @FindBy(xpath = "//android.widget.TextView[@text='Bangalore, India']")
    protected WebElement bangalore;


    public void setEnterHotelCity(){

        waitAndClick(Hotel);
        waitAndClick(hotelCity);
        waitForElement(enterHotelCity).sendKeys("Bangalore");
        waitAndClick(bangalore);

    }

    public String searchHotel(){
        waitAndClick(pickDate);
        waitAndClick(fromDate);
        waitAndClick(toDate);
        return waitForElement(searchHotelButton).getText();

    }








}
