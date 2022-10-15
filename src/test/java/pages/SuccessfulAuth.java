package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SuccessfulAuth extends BasePage {

//    @AndroidFindBy(xpath = "//android.widget.TextView")
    private MobileElement titleOfSuccessAuth = (MobileElement) getDriver().findElementByXPath("//*[@text='Вход в Alfa-Test выполнен']");;

    public MobileElement getTitleOfSuccessAuth() {
        return titleOfSuccessAuth;
    }

    public boolean isTitleOfSuccessAuth() {
        return titleOfSuccessAuth.isDisplayed();
    }
}
