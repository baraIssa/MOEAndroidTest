
package drivers_initializer.instance;

import drivers_initializer.drivers.AppiumMobileDriver;
import drivers_initializer.enums.AppiumMobilePlatforms;
import utils.PropReader;

import java.util.HashMap;
import java.util.Map;

import static drivers_initializer.drivers.DriverConstants.*;


public class MobileDriverInstance {

    private static final Map<String, AppiumMobilePlatforms> mobilePlatformsMap = new HashMap<>();

    static {
        mobilePlatformsMap.put(ANDROID, AppiumMobilePlatforms.ANDROID_DRIVER);
        mobilePlatformsMap.put(IOS, AppiumMobilePlatforms.IOS_DRIVER);
    }


    /**
     * EnumMap implementation of the Strategy design pattern. to get the MobileDriver instance.
     *
     * @return the mobile driver
     */

    public static AppiumMobileDriver getAppiumMobileDriver() {
        String driverType = PropReader.readConfig(APPIUM_MOBILE_DRIVER);
        return mobilePlatformsMap.get(driverType).getAppiumMobileDriver();
    }
}