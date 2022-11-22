import drivers_initializer.drivers.Base;

import drivers_initializer.drivers.Base;
import drivers_initializer.drivers.BaseAndroidDriver;
import drivers_initializer.drivers.BaseIOSDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrandPageObject;
import pages.HomePageObjectAndroid;
import pages.LoginPageObject;
import pages.SearchBrandPageObjectAndroid;

import static utils.Helper.scrollTo;
import static utils.Helper.waitVisibility;

public class Login extends Base {

    @Test (description = "Verify login functionality with valid access")
    public void validLogin() throws InterruptedException {
        if (appiumMobileDriver instanceof BaseAndroidDriver){
            HomePageObjectAndroid homePageObject = new HomePageObjectAndroid(appiumMobileDriver);
            LoginPageObject loginPageObject = new LoginPageObject(appiumMobileDriver);
            waitVisibility(appiumMobileDriver, homePageObject.getServicetab());
            loginPageObject.profileBtn.click();
            waitVisibility(appiumMobileDriver, loginPageObject.editTextEmail);
            loginPageObject.editTextEmail.sendKeys("baramaf9@gmail.com");
            loginPageObject.editTextPassword.sendKeys("Test@123");
            loginPageObject.buttonLogin.click();
            waitVisibility(appiumMobileDriver, homePageObject.getServicetab());
            Assert.assertEquals(true, homePageObject.getServicetab().isDisplayed());
        } else if (appiumMobileDriver instanceof BaseIOSDriver) {

        }


    }
}

















//
//
//
//
//
////
//
//public class Login extends Base {
//
//
//    @Test
//    public void validLogin() {
//        if (appiumMobileDriver instanceof BaseAndroidDriver) {
////            BrandPageObject brandPageObject = new BrandPageObject(appiumMobileDriver);
////            HomePageObjectAndroid homePageObject = new HomePageObjectAndroid(appiumMobileDriver);
//            LoginPageObject loginPageObject = new LoginPageObject(appiumMobileDriver);
////            waitVisibility(appiumMobileDriver, homePageObject.getServicetab());
//            loginPageObject.profileBtn.click();
////        waitVisibility(appiumMobileDriver, loginPageObject.editTextEmail);
////        loginPageObject.editTextEmail.sendKeys("baramaf9@gmail.com");
////        loginPageObject.editTextPassword.sendKeys("Test@123");
////        loginPageObject.buttonLogin.click();
////        waitVisibility(appiumMobileDriver, homePageObject.getServicetab());
////        Assert.assertEquals(true, homePageObject.getServicetab().isDisplayed());
////    }
//    } else if (appiumMobileDriver instanceof BaseIOSDriver) {
//
//    }
//    }
//
//}