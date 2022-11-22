package pages;

import drivers_initializer.drivers.AppiumMobileDriver;
import drivers_initializer.drivers.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;

@Getter
public class BrandPageObject extends Base {

    public BrandPageObject(AppiumMobileDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver.getDriver()), this);
    }

    @AndroidFindBy(id = "com.belongi.moe.beta:id/bottomNavigationContainer")
    AndroidElement navigateToStore;

    @AndroidFindBy(id = "com.belongi.moe.beta:id/textViewTitle")
    static
    AndroidElement ProductTileText;

    @AndroidFindBy(id = "com.belongi.moe.beta:id/textProductsCount")
    AndroidElement productCountLabel;

    @AndroidFindBy (id = "com.belongi.moe.beta:id/addToBagMafButton")
    MobileElement addToBagBtn;

    @AndroidFindBy (id = "com.belongi.moe.beta:id/textProductPrice")
    MobileElement ProductText;

    @AndroidFindBy (id = "com.belongi.moe.beta:id/buttonCheckout")
    static
    MobileElement checkoutBtn;

    @AndroidFindBy (id = "com.belongi.moe.beta:id/textTitle")
    MobileElement orderSummary;

    @AndroidFindBy (id = "com.belongi.moe.beta:id/imageProduct")
    MobileElement productImage;



    public static void clickCheckoutBtn(){
        checkoutBtn.click();
    }

    public static void clickOnProductTile(){
        ProductTileText.click();
    }




}
