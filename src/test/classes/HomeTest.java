package test.classes;

import Javatestbase.WebTestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class HomeTest extends WebTestBase {


        public HomePage homePage;

        public LoginPage loginpage;

        public MyAccountPage myAccountPage;


        @BeforeMethod
        public void beforeMethod() {
            initialization();
            homePage = new HomePage();
            loginpage = new LoginPage();
            myAccountPage = new MyAccountPage();

        }

        @Test(description = "Verify Login with valid username and valid password")
        public void verifyLogin(){
            SoftAssert softAssert = new SoftAssert();
            homePage.closedFirsAd();
            homePage.clickOnMyAccountBtn();
            loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
            softAssert.assertEquals(myAccountPage.getTextOfMyAccount(), "MY ACCOUNT", "text should be MY ACCOUNT" );
            softAssert.assertAll();
        }


        @Test(description = "Verify Login with valid username and invalid password")
        public void verifyLoginWithInvalidPassword(){
            SoftAssert softAssert = new SoftAssert();
            homePage.closedFirsAd();
            homePage.clickOnMyAccountBtn();
            loginpage.login(prop.getProperty("username"), prop.getProperty("invalidPassword"));
            softAssert.assertEquals(loginpage.getTextOfErrorElement(), "Error", "text should be ERROR" );
            softAssert.assertAll();
        }

        @Test(description = "Verify mouse should be move to element ")
        public void verifyMouseHoverAction() throws InterruptedException{
            SoftAssert softAssert = new SoftAssert();
            homePage.closedFirsAd();
            homePage.selectShopOptions(prop.getProperty("shopOption"));
            Thread.sleep(5000);
            softAssert.assertAll();

        }



        @AfterMethod
        public void afterMethod(){
            driver.close();

        }


    }

