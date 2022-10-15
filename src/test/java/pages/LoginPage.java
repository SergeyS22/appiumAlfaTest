package pages;

import io.appium.java_client.MobileElement;

public class LoginPage extends BasePage {

    //    @AndroidFindBy(id = "com.alfabank.qapp:id/tvTitle")
    private final MobileElement title = (MobileElement) getDriver().findElementById("com.alfabank.qapp:id/tvTitle");

    //    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Логин']")
    private final MobileElement login = (MobileElement) getDriver().findElementById("com.alfabank.qapp:id/etUsername");

    //    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Пароль']")
    private final MobileElement password = (MobileElement) getDriver().findElementById("com.alfabank.qapp:id/etPassword");

    //    @AndroidFindBy(id = "com.alfabank.qapp:id/btnConfirm")
    private final MobileElement enterButton = (MobileElement) getDriver().findElementById("com.alfabank.qapp:id/btnConfirm");

    //    @AndroidFindBy(id = "com.alfabank.qapp:id/tvError")
    private final MobileElement errorMessage = (MobileElement) getDriver().findElementById("com.alfabank.qapp:id/tvError");

    //    @AndroidFindBy(id = "com.alfabank.qapp:id/text_input_end_icon")
    private final MobileElement showPassword = (MobileElement) getDriver().findElementById("com.alfabank.qapp:id/text_input_end_icon");

    public LoginPage() {
        super();
    }

    public MobileElement getTitle() {
        return title;
    }

    public MobileElement getLogin() {
        return login;
    }

    public MobileElement getEnterButton() {
        return enterButton;
    }

    public MobileElement getErrorMessage() {
        return errorMessage;
    }

    public MobileElement getShowPassword() {
        return showPassword;
    }

    public MobileElement getPassword() {
        return password;
    }

    public void clickOnEnter() {
//        getWait().until(ExpectedConditions.visibilityOfElementLocated((WebElement) By.id(enterButton)));
        enterButton.click();
    }

    public LoginPage clickOnLogin() {
        login.click();
        return new LoginPage();
    }

    public LoginPage typeOnLogin(String line) {
        login.sendKeys(line);
        return new LoginPage();
    }

    public LoginPage clickOnPassword() {
        password.click();
        return new LoginPage();
    }

    public LoginPage typeOnPassword(String line) {
        password.sendKeys(line);
        return new LoginPage();
    }

    public LoginPage clickOnShowPassword() {
        showPassword.click();
        return new LoginPage();
    }


}
