package pages;

import io.appium.java_client.MobileElement;

public class SuccessfulAuth extends BasePage {

    //    @AndroidFindBy(xpath = "//android.widget.TextView")
    private final MobileElement titleOfSuccessAuth = (MobileElement) getDriver().findElementByXPath("//*[@text='Вход в Alfa-Test выполнен']");

    public MobileElement getTitleOfSuccessAuth() {
        return titleOfSuccessAuth;
    }

    public boolean isTitleOfSuccessAuth() {
        return titleOfSuccessAuth.isDisplayed();
    }
}
