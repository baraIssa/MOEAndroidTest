import drivers_initializer.drivers.Base;
import drivers_initializer.drivers.BaseAndroidDriver;
import drivers_initializer.drivers.BaseIOSDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrandPageObject;
import pages.HomePageObjectAndroid;
import pages.LoginPageObject;
import pages.SearchBrandPageObjectAndroid;
import org.testng.asserts.SoftAssert;

import static utils.Helper.scrollTo;
import static utils.Helper.waitVisibility;

public class AddToChart extends Base {

    @Test (description = "Verify adding item to chart functionality")
    public void addItemToChart() throws InterruptedException {
        if (appiumMobileDriver instanceof BaseAndroidDriver){
            SoftAssert softAssert = new SoftAssert();
            HomePageObjectAndroid homePageObject = new HomePageObjectAndroid(appiumMobileDriver);
            SearchBrandPageObjectAndroid SearchBrandPageObject = new SearchBrandPageObjectAndroid(appiumMobileDriver);
            BrandPageObject brandPageObject = new BrandPageObject(appiumMobileDriver);
            LoginPageObject loginPageObject = new LoginPageObject(appiumMobileDriver);
            //validate the login functionality.
            waitVisibility(appiumMobileDriver, homePageObject.getServicetab());
            loginPageObject.profileBtn.click();
            waitVisibility(appiumMobileDriver, loginPageObject.editTextEmail);
            loginPageObject.editTextEmail.sendKeys("baramaf9@gmail.com");
            loginPageObject.editTextPassword.sendKeys("Test@123");
            loginPageObject.buttonLogin.click();
            waitVisibility(appiumMobileDriver, homePageObject.getServicetab());
            softAssert.assertEquals(true,homePageObject.getServicetab().isDisplayed(),"Login failed");
            //validate the login functionality.
            Assert.assertEquals(true, homePageObject.getServicetab().isDisplayed());
            scrollTo(appiumMobileDriver, "down", 3);
            waitVisibility(appiumMobileDriver, homePageObject.getDiscoverBrandsBtn());
            //Check the Brand button appearance.
            softAssert.assertEquals(true,homePageObject.getDiscoverBrandsBtn().isDisplayed(),"Discover button doesn't appear");
            homePageObject.discoverBrandsBtnClick();
            //Check the Search functionality.
            SearchBrandPageObject.searchTextAndClick("Automation-store1");
            waitVisibility(appiumMobileDriver, brandPageObject.getNavigateToStore());
            softAssert.assertEquals(true,brandPageObject.getNavigateToStore().isDisplayed(),"Automation-store1 is not founded");
            //Check the click on the first product and the redirection to the product page.
            brandPageObject.clickOnProductTile();
            //check add to bag button appearance.
            waitVisibility(appiumMobileDriver, brandPageObject.getAddToBagBtn());
            softAssert.assertEquals(true,brandPageObject.getAddToBagBtn().isDisplayed(),"Add to bad button doesn't appear");
            //check add to chart button appearance
            brandPageObject.getAddToBagBtn().click();
            Thread.sleep(2000);
            brandPageObject.clickCheckoutBtn();
            Assert.assertEquals(true, brandPageObject.getProductImage().isDisplayed());
            softAssert.assertAll();
        } else if (appiumMobileDriver instanceof BaseIOSDriver) {

        }


    }
}
