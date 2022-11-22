package drivers_initializer.drivers;

import drivers_initializer.instance.MobileDriverInstance;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Helper;
import utils.XMLReader;


public class Base {


    public static XMLReader objXMLReader;

    public AppiumMobileDriver appiumMobileDriver = MobileDriverInstance.getAppiumMobileDriver();

    @BeforeMethod
    public void initializeDriver() {
        appiumMobileDriver.setup();
    }

    @AfterMethod
    public void tearDown() {
        appiumMobileDriver.getDriver().quit();
        appiumMobileDriver.removeDriver();
    }
    public Base(XMLReader objXMLReader) {

        this.objXMLReader=objXMLReader;
    }

    //This is the default constructor
    public Base() {

    }
}