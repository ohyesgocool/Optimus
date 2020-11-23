package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='You']")
    protected WebElement LoginButton;

    @FindBy(id ="com.cleartrip.android:id/signin_btn")
    protected WebElement signInButton;

    @FindBy(id ="com.cleartrip.android:id/signin_button")
    protected WebElement performSiginIn;

    @FindBy(id ="com.cleartrip.android:id/username_field")
    protected WebElement userNameButton;

    @FindBy(id ="com.cleartrip.android:id/password_field")
    protected WebElement passwordButton;

    @FindBy(id ="com.cleartrip.android:id/achf_user_email")
    protected WebElement displayEmail;



    public String login(String userName , String password){
        waitAndClick(LoginButton);
        waitAndClick(signInButton);
        waitForElement(userNameButton).sendKeys(userName);
        waitForElement(passwordButton).sendKeys(password);
        hideKeyboard();
        waitAndClick(performSiginIn);
        return waitForElement(displayEmail).getText();

    }
    public String signOut(){
        scrollAndClick("Sign out");
        return waitForElement(signInButton).getText();

    }








}
