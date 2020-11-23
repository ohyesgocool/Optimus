package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage extends BasePage{

    public FlightsPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Flights']")
    protected WebElement flights;

    @FindBy(id ="com.cleartrip.android:id/fhf_roundtrip")
    protected WebElement roundTrip;

    @FindBy(id ="com.cleartrip.android:id/txt_from_city")
    protected WebElement fromCity;

    @FindBy(id ="com.cleartrip.android:id/txt_to_city")
    protected WebElement toCity;

    @FindBy(id ="com.cleartrip.android:id/filter_edittext")
    protected WebElement searchCity;

    @FindBy(xpath = "//android.widget.TextView[@text='BLR']")
    protected WebElement bangaloreAirPot;

    @FindBy(xpath = "//android.widget.TextView[@text='DXB']")
    protected WebElement dubaiAirPot;

    @FindBy(id ="com.cleartrip.android:id/fhf_btn_search_flights")
    protected WebElement searchFlights;

    @FindBy(id ="com.cleartrip.android:id/rdbtnSortPrice")
    protected WebElement sortPrice;

    public void selectCityForFlight(){
        waitAndClick(flights);
        waitAndClick(roundTrip);
        waitAndClick(fromCity);
        waitForElement(searchCity).sendKeys("Bangalore");
        waitAndClick(bangaloreAirPot);
        waitAndClick(toCity);
        waitForElement(searchCity).sendKeys("Dubai");
        waitAndClick(dubaiAirPot);
    }

    public String searchFlight(){
        return waitForElement(searchFlights).getText();

    }

    public void sortPrice(){
        waitAndClick(searchFlights);
        waitAndClick(sortPrice);

    }











}
