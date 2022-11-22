
package drivers_initializer.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.File;
import java.util.List;

import static utils.Reading_Helper.FileHelper.getFileAbsolutePath;
import static utils.readers.TxtReader.readTxtFile;


/**
 * The type Mobile driver.
 */
public abstract class AppiumMobileDriver<D extends AppiumDriver> {

    private static final ThreadLocal<AppiumDriver> driverThreadLocal = new ThreadLocal<>();

    /**
     * This method initialize capabilities values and return Capabilities object
   
     * Instantiates a new Mobile driver.
     */

    @NotNull
    static DesiredCapabilities init(String capabilitiesFile) {
        if (isNotValid(capabilitiesFile))
            Assert.fail("Please provide a capabilitiesFile for mobile.");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        List<String> lines = readTxtFile(capabilitiesFile);
        if (isNullLines(lines))
            Assert.fail("Please provide capabilities file for mobile");

        for (String line : lines) {
            @NonNls String key = line.split("=").length > 0 ? line.split("=")[0] : "";
            String value = line.split("=").length > 1 ? line.split("=")[1] : "";
            // Check if app provided then return absolute path
            if (isApp(key)) {
                value = getFileAbsolutePath(value, true);
                if (isNullValue(value) || value.isEmpty())
                    Assert.fail("Please provide the mobile app name or check if the app exists in your project resource folder");
            }
            if (!key.isEmpty() && !value.isEmpty())
                desiredCapabilities.setCapability(key, value);
        }
        return desiredCapabilities;
    }


    private static boolean isNullValue(String value) {
        return value == null;
    }

    private static boolean isApp(String key) {
        return key.equalsIgnoreCase("app");
    }

    private static boolean isNullLines(List<String> lines) {
        return lines == null;
    }

    private static boolean isNotFound(String capabilitiesFile) {
        File file = new File(capabilitiesFile);
        return !file.exists();
    }

    private static boolean isNotValid(String capabilitiesFile) {
        return isNull(capabilitiesFile) || capabilitiesFile.isEmpty() || isNotFound(capabilitiesFile);
    }

    private static boolean isNull(String capabilitiesFile) {
        return capabilitiesFile == null;
    }

    abstract D createDriver();

    public static AppiumDriver getDriver() {
        return driverThreadLocal.get();
    }

    public void setup() {
        driverThreadLocal.set(createDriver());
    }

    public void removeDriver(){
        driverThreadLocal.remove();
    }

    public MobileElement findElement(By by) {
        return (MobileElement) getDriver().findElement(by);
    }

}
