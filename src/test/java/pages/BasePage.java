package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

    AndroidDriver<AndroidElement> driver;

    protected BasePage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected WebElement waitForElement(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitAndClick(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    protected String getText(WebElement element) {
        return element.getText();

    }

    protected void hideKeyboard() {
        driver.hideKeyboard();

    }

    public void scrollAndClick(String Text) {
        // scroll till finding Text
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                        + Text + "\").instance(0))")
                .click();
    }

    public void pressAndDrop(WebElement source, WebElement destination) {

        TouchAction action = new TouchAction(driver);

        // performing the long press
        action.longPress(new LongPressOptions().withElement(new ElementOption().withElement(source))).perform();

        // performing the move to touch operation
        action.moveTo(new ElementOption().withElement(destination)).perform();
    }

    public void clickWithCoordinates(int x, int y, int p, int q) {

        //X = (x,y) Y=(p,q)

        TouchAction action = new TouchAction(driver);
        action.press(new PointOption().withCoordinates(x, y)).moveTo(new PointOption().withCoordinates(p, q)).release()
                .perform();

    }


}
