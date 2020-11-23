package tests;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.testvagrant.optimuscloud.dashboard.testng.OptimusCloudConstants;
import com.testvagrant.optimuscloud.entities.MobileDriverDetails;
import com.testvagrant.optimuscloud.remote.OptimusCloudDriver;
import com.testvagrant.optimuscloud.remote.OptimusCloudManager;
import io.appium.java_client.remote.MobileCapabilityType;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.JSONMapper;
import utils.SetCapability;

import java.io.IOException;

public class TestBase {

 protected AndroidDriver<AndroidElement> driver;
    private MobileDriverDetails mobileDriverDetails;
    private OptimusCloudManager optimusCloudManager;



    SetCapability setCapability = new SetCapability();
    JSONMapper jsonMapper = new JSONMapper();


    @Parameters({"deviceIndex"})
    public AndroidDriver<AndroidElement> setupDriver(String deviceIndex) throws IOException, ParseException {

        JSONObject config = jsonMapper.getJSONConfig("src/test/java/resources/browserstackparallel.conf.json");
        JSONArray envs = (JSONArray) config.get("environments");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        Map<String, String> envCapabilities = (Map<String, String>) envs.get(Integer.parseInt(deviceIndex));
        setCapability.mapCapability(envCapabilities ,capabilities );

        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        setCapability.mapCapability(commonCapabilities ,capabilities );
        capabilities.setCapability("app", System.getenv("BROWSERSTACK_APP_ID"));

        driver = new AndroidDriver(new URL("http://"+(String) config.get("username")+":"+(String) config.get("access_key")+"@"+config.get("server")+"/wd/hub"), capabilities);
        return driver;


    }

    @BeforeTest(alwaysRun = true)
    public AndroidDriver<AndroidElement> genyMotionSetUp(ITestContext iTestContext) throws MalformedURLException {
        File f = new File("app");
        File fs = new File(f, "cleartrip.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");

        capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        optimusCloudManager = new OptimusCloudManager();
        mobileDriverDetails = new OptimusCloudDriver().createDriver(capabilities);
        iTestContext.setAttribute(OptimusCloudConstants.MOBILE_DRIVER, mobileDriverDetails);
        driver = (AndroidDriver<AndroidElement>) mobileDriverDetails.getMobileDriver();
        return driver;

    }



    @AfterTest(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
