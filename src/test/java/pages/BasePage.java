package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

public abstract class BasePage {

    private final AppiumDriver driver;
    private final WebDriverWait wait;

    public BasePage() {
        this.driver = BaseTest.getDriver();
        wait = new WebDriverWait(driver, 5);
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public String getValue(MobileElement element) {
        return element.getText();
    }

    public boolean isElementShow(MobileElement element) {
        return element.isDisplayed();
    }


}
