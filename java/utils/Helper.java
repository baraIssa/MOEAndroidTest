package utils;

import drivers_initializer.drivers.AppiumMobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class Helper {

    public static void waitVisibility(AppiumMobileDriver driver,MobileElement element){
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), 40);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void scrollTo(AppiumMobileDriver appiumMobileDriver, String direction, int times) {
        if (direction.equalsIgnoreCase("down")) {Dimension dimensions = appiumMobileDriver.getDriver().manage().window().getSize();
            int width = dimensions.getWidth() / 2;
            for (int i = 0; i < times; i++) {
                int startY = (int) (dimensions.getHeight() * 0.5);
                int endY = (int) (dimensions.getHeight() * 0.2);
                new TouchAction(appiumMobileDriver.getDriver())
                        .press(point(width, startY))
                        .waitAction(waitOptions(Duration.ofSeconds(1)))
                        .moveTo(point(width, endY))
                        .release()
                        .perform();
            }
        }
    }
}
