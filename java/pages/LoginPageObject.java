package pages;

import drivers_initializer.drivers.AppiumMobileDriver;
import drivers_initializer.drivers.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends Base {
    AndroidDriver androidDriver;

    public LoginPageObject(AppiumMobileDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver.getDriver()), this);
    }

    @AndroidFindBy(id = "com.belongi.moe.beta:id/buttonProfile")
    public
    AndroidElement profileBtn;

    @AndroidFindBy(id = "com.belongi.moe.beta:id/editTextEmail")
    public
    AndroidElement editTextEmail;

    @AndroidFindBy(id = "com.belongi.moe.beta:id/editTextPassword")
    public
    AndroidElement editTextPassword;

    @AndroidFindBy(id = "com.belongi.moe.beta:id/buttonLogin")
    public
    AndroidElement buttonLogin;

    @AndroidFindBy(id = "android:id/message")
    public
    AndroidElement invalidMessage;

}
