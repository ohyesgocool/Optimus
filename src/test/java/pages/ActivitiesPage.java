package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivitiesPage extends BasePage {

    public ActivitiesPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Activities']")
    protected WebElement activities;

    @FindBy(xpath = "//android.widget.EditText[@text='Search for a city']")
    protected WebElement searchBar;

    @FindBy(xpath = "//android.widget.TextView[@text='Bangalore, India']")
    protected WebElement chooseDestination;

    @FindBy(id ="com.cleartrip.android:id/filter_edittext")
    protected WebElement inputSearchCity;

    @FindBy(xpath = "//android.widget.TextView[@text='Product Cards']")
    protected WebElement productCards;

    @FindBy(id ="com.cleartrip.android:id/show_more")
    protected WebElement seeMoreButton;

    public void SetLocation(){
        waitAndClick(activities);
        waitAndClick(searchBar);
        waitForElement(inputSearchCity).sendKeys("Bangalore");
        waitAndClick(chooseDestination);
    }

    public String getProductCard()
    {
        return waitForElement(productCards).getText();

    }
    public String getSeeAllText()
    {
        return waitForElement(seeMoreButton).getText();

    }



}
