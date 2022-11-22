
package utils.ExtentReport;
import drivers_initializer.drivers.AppiumMobileDriver;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.error_handlers.Logger;

import java.io.File;
import java.io.IOException;

public class Utility {

    public static String getScreenshot(AppiumDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir") + "/Screenshot/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            Logger.info("Capture Failed " + e.getMessage());
        }
        return path;
    }
}