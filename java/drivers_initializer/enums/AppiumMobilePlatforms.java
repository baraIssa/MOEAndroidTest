package drivers_initializer.enums;

import drivers_initializer.drivers.AppiumMobileDriver;
import drivers_initializer.drivers.BaseAndroidDriver;
import drivers_initializer.drivers.BaseIOSDriver;
import interfaces.AppiumMobileDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


public enum AppiumMobilePlatforms implements AppiumMobileDriverProvider<AppiumMobileDriver> {
    IOS_DRIVER() {
        @Override
        public AppiumMobileDriver<IOSDriver> getAppiumMobileDriver() {
            return new BaseIOSDriver();
        }
    },
    ANDROID_DRIVER() {
        @Override
        public AppiumMobileDriver<AndroidDriver> getAppiumMobileDriver() {
            return new BaseAndroidDriver();
        }
    }
}
