package pages;

import drivers_initializer.drivers.AppiumMobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;

@Getter
public class HomePageObjectAndroid {

    public HomePageObjectAndroid(AppiumMobileDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver.getDriver()),this);
    }

    @AndroidFindBy(id="com.belongi.moe.beta:id/discoverBrands")
    public
    MobileElement discoverBrandsBtn;

    public void discoverBrandsBtnClick(){
        discoverBrandsBtn.click();
    }

    @AndroidFindBy (accessibility = "SERVICES")
    MobileElement servicetab;









}
