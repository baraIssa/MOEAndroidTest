package drivers_initializer.drivers;

import io.appium.java_client.ios.IOSDriver;
import utils.PropReader;

import java.net.MalformedURLException;
import java.net.URL;

import static drivers_initializer.drivers.DriverConstants.APPIUM_URL;
import static drivers_initializer.drivers.DriverConstants.IOS_CAPABILITIES;
import static error_handlers.CustomErrorMessages.INVALID_APPIUM_URL_MESSAGE;

public class BaseIOSDriver extends AppiumMobileDriver<IOSDriver> {

    @Override
    public IOSDriver createDriver() {
        try {
            return new IOSDriver(new URL(PropReader.readConfig(APPIUM_URL)),
                    init(PropReader.readConfig(IOS_CAPABILITIES)));
        } catch (MalformedURLException e) {
            throw new RuntimeException(INVALID_APPIUM_URL_MESSAGE, e);
        }
    }
}
