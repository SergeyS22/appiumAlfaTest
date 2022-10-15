package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

public class BasePage {

    private AppiumDriver driver;
    private WebDriverWait wait;

    public BasePage() {
        this.driver = BaseTest.getDriver();
        wait = new WebDriverWait(driver, 20);

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
