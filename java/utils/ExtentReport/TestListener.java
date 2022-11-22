
package utils.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import drivers_initializer.drivers.AppiumMobileDriver;
import drivers_initializer.instance.MobileDriverInstance;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.error_handlers.Logger;

import java.io.IOException;

import static javax.management.remote.JMXConnectionNotification.FAILED;

public class TestListener extends MobileDriverInstance implements ITestListener {
    private static final ExtentReports extent = ExtentManager.createInstance();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Extent Reports Test Suite started!");
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        Logger.info(("Extent Reports Test Suite is ending!"));
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        Logger.info((result.getMethod().getMethodName() + " started!"));
        ExtentTest extentTest = extent.createTest(getMethodName(result), result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        Logger.info((getMethodName(result) + " passed!"));
        test.get().pass("Test passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        Logger.info((getMethodName(result) + FAILED));
       // Logger.info((result.getMethod().getMethodName() + " failed!"));
        test.get().fail(result.getThrowable().getMessage());
       // String temp = Utility.getScreenshot(driver);
//        MobileDriverInstance.getAppiumMobileDriver().getDriver().quit();
      /*  try {
            test.get().addScreenCaptureFromPath(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void onTestSkipped(ITestResult result) {


    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Logger.info("onTestFailedButWithinSuccessPercentage for" + result.getMethod().getMethodName());
    }

    private String getMethodName(ITestResult result) {
        return result.getMethod().getDescription();
    }
}