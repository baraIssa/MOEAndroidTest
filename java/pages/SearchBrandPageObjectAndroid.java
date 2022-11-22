package pages;

import drivers_initializer.drivers.AppiumMobileDriver;
import drivers_initializer.drivers.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.Helper.waitVisibility;

@Getter
public class SearchBrandPageObjectAndroid extends Base {

    public SearchBrandPageObjectAndroid(AppiumMobileDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver.getDriver()),this);
    }

    @AndroidFindBy(id="com.belongi.moe.beta:id/discoverBrands")
    MobileElement discoverBrandsBtn;

    @AndroidFindBy(id="com.belongi.moe.beta:id/layoutSearch")
    MobileElement searchField;

    @AndroidFindBy(id = "com.belongi.moe.beta:id/editTextSearch")
    public MobileElement searchInput;

    @AndroidFindBy(id = "com.belongi.moe.beta:id/recyclerTrendsData")
    private MobileElement recyclerTrendsData;

    @AndroidFindBy (accessibility = "SERVICES")
    MobileElement servicetab;


    public void discoverBrandsBtnClick(){
        discoverBrandsBtn.click();
    }

    public void searchTextAndClick(String text) throws InterruptedException {
        waitVisibility(appiumMobileDriver,searchField);
        searchInput.setValue(text);
        Thread.sleep(2000);
        waitVisibility(appiumMobileDriver, recyclerTrendsData);
        List<MobileElement> searchOptions = recyclerTrendsData.findElementsById("com.belongi.moe.beta:id/layoutSearchStore");
        for (MobileElement element : searchOptions) {
            if (element.findElementById("com.belongi.moe.beta:id/textStoreName").getText().equalsIgnoreCase(text)) {
                element.click();
                return;
            }
        }
        throw new IllegalArgumentException("unable to find element with value " + text);
    }


}
