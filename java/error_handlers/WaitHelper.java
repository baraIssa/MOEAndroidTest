package error_handlers;

import interfaces.ImplicitHandler;
import org.openqa.selenium.WebDriver;
import utils.Reading_Helper.implicitTimeReader;

import java.util.concurrent.TimeUnit;

public class WaitHelper {

    public static void handleImplicit(WebDriver webDriver) {
        ImplicitHandler implicit = (webDriver1, time) -> setImplicit(webDriver1, time);
        implicit.handleImplicitTime(webDriver, implicitTimeReader.readTime());
    }

    private static void setImplicit(WebDriver webDriver, long time) {
        webDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
}
