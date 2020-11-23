package tests;

import org.testng.Assert;

import org.testng.annotations.Test;
import pages.LoginPage;
import resources.Constants;



public class LoginTest extends TestBase {


    @Test(priority = 1)
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);
            Assert.assertEquals(loginPage.login(Constants.userName ,Constants.password), Constants.userName );

    }

    @Test(priority = 2)
    public void logOutTest(){
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertEquals(loginPage.signOut() , "SIGN IN OR REGISTER" );

    }

}
