package tests;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.LoginPage;
import pages.SuccessfulAuth;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import static testdata.Data.CORRECT_LOGIN;
import static testdata.Data.CORRECT_PASSWORD;
import static testdata.Data.ERROR_MESSAGE_TEXT;
import static testdata.Data.INVALID_LOGIN;
import static testdata.Data.INVALID_LOGIN_WITH_SPEC_SYMBOLS;
import static testdata.Data.INVALID_PASSWORD;
import static testdata.Data.INVALID_PASSWORD_WITH_SPEC_SYMBOLS;
import static testdata.Data.maxLengthOfLogin;
import static testdata.Data.maxLengthOfPassword;

public class Test extends BaseTest {

    private LoginPage loginPage;
    private SuccessfulAuth successfulAuth;

    @org.junit.Test
    public void verifyTitleIsDisplayTest() {
        loginPage = new LoginPage();
        Assert.assertTrue(loginPage.isElementShow(loginPage.getTitle()));
    }

    @org.junit.Test
    public void successfulAuthTest() {
        loginPage = new LoginPage();
        loginPage.clickOnLogin()
                 .typeOnLogin(CORRECT_LOGIN);
        loginPage.clickOnPassword()
                 .typeOnPassword(CORRECT_PASSWORD)
                 .clickOnEnter();
        successfulAuth = new SuccessfulAuth();
        Assert.assertTrue(successfulAuth.isElementShow(successfulAuth.getTitleOfSuccessAuth()));
    }

    @org.junit.Test
    public void changeLoginAndPasswordAuthTest() {
        loginPage = new LoginPage();
        loginPage.clickOnLogin()
                 .typeOnLogin(CORRECT_PASSWORD);
        loginPage.clickOnPassword()
                 .typeOnPassword(CORRECT_LOGIN)
                 .clickOnEnter();
        Assert.assertTrue(loginPage.isElementShow(loginPage.getErrorMessage()));
    }

    @org.junit.Test
    public void enterValidLoginTest() {
        loginPage = new LoginPage();
        loginPage.clickOnLogin();
        loginPage.typeOnLogin(CORRECT_LOGIN);
        Assert.assertEquals(loginPage.getValue(loginPage.getLogin()), CORRECT_LOGIN);
    }

    @org.junit.Test
    public void enterValidPasswordTest() {
        loginPage = new LoginPage();
        loginPage.clickOnPassword()
                 .typeOnPassword(CORRECT_PASSWORD);
        Assert.assertEquals(loginPage.getValue(loginPage.getPassword()), CORRECT_PASSWORD);
    }

    @org.junit.Test
    public void enterIncorrectLoginTest() {
        loginPage = new LoginPage();
        loginPage.clickOnLogin()
                 .typeOnLogin(INVALID_LOGIN)
                 .clickOnEnter();
        Assert.assertTrue(loginPage.isElementShow(loginPage.getErrorMessage()));
    }

    //Вопросы к документации
    @org.junit.Test
    public void cutCheckLoginAndPasswordTest() {

        StringSelection selection = new StringSelection(INVALID_LOGIN_WITH_SPEC_SYMBOLS);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);

        loginPage = new LoginPage();
        loginPage.clickOnLogin()
                 .typeOnLogin(Keys.chord(Keys.CONTROL + "v"));
        Assert.assertEquals(loginPage.getValue(loginPage.getLogin()), "Pass-");
        loginPage.clickOnPassword()
                 .typeOnPassword(INVALID_PASSWORD_WITH_SPEC_SYMBOLS);
        //в требованиях не указаны допустимые и недопустимые символы. Предположительно те же условия как и для Логина
        Assert.assertEquals(loginPage.getValue(loginPage.getPassword()), "Pass-");
        //из требований не до конца ясно какое InvalidValue должно отображаться. В процессе Исследовательского тестирования приложения не
        // не найден текст сообщения
    }


    @org.junit.Test
    public void loginMaxLength() {
        loginPage = new LoginPage();
        loginPage.clickOnLogin()
                 .typeOnLogin(maxLengthOfLogin)
                 .clickOnEnter();
        Assert.assertTrue(loginPage.isElementShow(loginPage.getErrorMessage()));
    }

    @org.junit.Test
    public void passwordMaxLength() {
        loginPage = new LoginPage();
        loginPage.clickOnPassword()
                 .typeOnPassword(maxLengthOfPassword)
                 .clickOnEnter();
        Assert.assertTrue(loginPage.isElementShow(loginPage.getErrorMessage()));
    }

    @org.junit.Test
    public void enterIncorrectPasswordTest() {
        loginPage = new LoginPage();
        loginPage.clickOnPassword()
                 .typeOnPassword(INVALID_PASSWORD)
                 .clickOnEnter();
        Assert.assertTrue(loginPage.isElementShow(loginPage.getErrorMessage()));
    }

    @org.junit.Test
    public void showPasswordTest() throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.clickOnPassword().typeOnPassword(CORRECT_PASSWORD);
        loginPage.clickOnShowPassword();
        Assert.assertEquals(loginPage.getValue(loginPage.getPassword()), CORRECT_PASSWORD);
    }

    @org.junit.Test
    public void clickEnterBtnTest() {
        loginPage = new LoginPage();
        loginPage.clickOnEnter();
        Assert.assertTrue(loginPage.isElementShow(loginPage.getErrorMessage()));
        Assert.assertEquals(loginPage.getValue(loginPage.getErrorMessage()), ERROR_MESSAGE_TEXT);
    }




}
