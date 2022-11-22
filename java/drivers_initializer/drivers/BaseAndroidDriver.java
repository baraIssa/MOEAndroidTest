package drivers_initializer.drivers;

import io.appium.java_client.android.AndroidDriver;
import utils.PropReader;

import java.net.MalformedURLException;
import java.net.URL;

import static drivers_initializer.drivers.DriverConstants.ANDROID_CAPABILITIES;
import static drivers_initializer.drivers.DriverConstants.APPIUM_URL;
import static error_handlers.CustomErrorMessages.INVALID_APPIUM_URL_MESSAGE;

public class BaseAndroidDriver extends AppiumMobileDriver<AndroidDriver> {

    @Override
    public AndroidDriver createDriver() {
        try {
            return new AndroidDriver(new URL(PropReader.readConfig(APPIUM_URL)),
                    init(PropReader.readConfig(ANDROID_CAPABILITIES)));
        } catch (MalformedURLException e) {
            throw new RuntimeException(INVALID_APPIUM_URL_MESSAGE, e);
        }
    }
}
