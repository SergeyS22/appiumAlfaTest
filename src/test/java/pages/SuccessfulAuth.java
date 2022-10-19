package pages;

import io.appium.java_client.MobileElement;

public class SuccessfulAuth extends BasePage {

    private final MobileElement titleOfSuccessAuth = (MobileElement) getDriver().findElementByXPath(
            "//*[@text='Вход в Alfa-Test выполнен']");

    public SuccessfulAuth() {
        super();
    }

    public MobileElement getTitleOfSuccessAuth() {
        return titleOfSuccessAuth;
    }
}
