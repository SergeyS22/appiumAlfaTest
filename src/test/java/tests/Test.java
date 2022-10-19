package tests;

import org.junit.Assert;
import pages.LoginPage;
import pages.SuccessfulAuth;

import static testdata.Data.CORRECT_LOGIN;
import static testdata.Data.CORRECT_PASSWORD;
import static testdata.Data.ERROR_MESSAGE_TEXT;
import static testdata.Data.INVALID_LOGIN;
import static testdata.Data.INVALID_LOGIN_WITH_SPEC_SYMBOLS;
import static testdata.Data.INVALID_PASSWORD;
import static testdata.Data.INVALID_PASSWORD_WITH_SPEC_SYMBOLS;
import static testdata.Data.MAX_STRING_LENGTH;
import static testdata.Data.TITLE_OF_LOGIN_FIELD;
import static testdata.Data.TITLE_OF_PASSWORD_FIELD;
import static testdata.Data.maxLengthOfLogin;
import static testdata.Data.maxLengthOfPassword;

public class Test extends BaseTest {

    private LoginPage loginPage;
    private SuccessfulAuth successfulAuth;

    @org.junit.Test
    public void verifyTitleIsDisplayTest() {
        loginPage = new LoginPage();
        Assert.assertTrue(loginPage.isElementShow(loginPage.getTitle()));
        Assert.assertTrue(loginPage.isElementEnabled(loginPage.getTitle()));
    }

    @org.junit.Test
    public void verifyLoginScreensItemsIsDisplayTest() {
        loginPage = new LoginPage();
        Assert.assertTrue(loginPage.isElementShow(loginPage.getLogin()));
        Assert.assertTrue(loginPage.isElementShow(loginPage.getPassword()));
        Assert.assertTrue(loginPage.isElementShow(loginPage.getShowPassword()));
        Assert.assertTrue(loginPage.isElementShow(loginPage.getEnterButton()));
        Assert.assertTrue(loginPage.isElementEnabled(loginPage.getLogin()));
        Assert.assertTrue(loginPage.isElementEnabled(loginPage.getPassword()));
        Assert.assertTrue(loginPage.isElementEnabled(loginPage.getShowPassword()));
        Assert.assertTrue(loginPage.isElementEnabled(loginPage.getEnterButton()));
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
    public void labelsVerifyTest() {
        loginPage = new LoginPage();
        Assert.assertEquals(loginPage.getValue(loginPage.getLogin()), TITLE_OF_LOGIN_FIELD);
        Assert.assertEquals(loginPage.getValue(loginPage.getPassword()), TITLE_OF_PASSWORD_FIELD);
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

    /* Вопросы по документации:
        В документе сказано "Разрешенное множество символов: все." (1 требование) для поля Пароль. Далее по документации сказано, что "При
        вводе неразрешенных символов необходимо отображать сообщение InvalidValue." (2 требование) -> требования противоречат друг другу
        (?). Первое говорит о том, что разрешены все символы, а второе требование накладывает ограничения, что при вводе (неразрешённых)
        символов необходимо отображать сообщение Invalid Value. Так же возник вопрос к Invalid Value, какой текст сообщения должен быть
        или текст и есть "Invalid Value" (в процессе тестирования не смог добиться появления Invalid Value)?
    */

    @org.junit.Test
    public void cutCheckLoginAndPasswordTest() {

        loginPage = new LoginPage();
        loginPage.clickOnLogin()
                 .typeOnLogin(INVALID_LOGIN_WITH_SPEC_SYMBOLS);
        Assert.assertEquals("Login-", loginPage.getValue(loginPage.getLogin()));
        loginPage.clickOnPassword()
                 .typeOnPassword(INVALID_PASSWORD_WITH_SPEC_SYMBOLS);
        // в требованиях не указаны допустимые и недопустимые символы. Предположительно те же условия как и для Логина (?)
        Assert.assertEquals("Pass-", loginPage.getValue(loginPage.getPassword()));
        // из требований не до конца ясно какое InvalidValue должно отображаться. В процессе Исследовательского тестирования приложения
        // не обнаружен текст сообщения
    }

    // Найден дефект: поле логин позволяет ввести более 50 символов на экране авторизации в приложении Alfa-Test
    @org.junit.Test
    public void loginMaxLength() {
        loginPage = new LoginPage();
        loginPage.clickOnLogin()
                 .typeOnLogin(maxLengthOfLogin)
                 .clickOnEnter();
        Assert.assertTrue(loginPage.isElementShow(loginPage.getErrorMessage()));
        Assert.assertEquals(MAX_STRING_LENGTH, loginPage.getValue(loginPage.getLogin()).length());
    }

    // Найден дефект: поле логин позволяет ввести более 50 символов на экране авторизации в приложении Alfa-Test
    @org.junit.Test
    public void passwordMaxLength() {
        loginPage = new LoginPage();
        loginPage.clickOnPassword()
                 .typeOnPassword(maxLengthOfPassword)
                 .clickOnEnter();
        Assert.assertTrue(loginPage.isElementShow(loginPage.getErrorMessage()));
        Assert.assertEquals(MAX_STRING_LENGTH, loginPage.getValue(loginPage.getPassword()).length());
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
        Assert.assertEquals(CORRECT_PASSWORD, loginPage.getValue(loginPage.getPassword()));
        loginPage.clickOnShowPassword();
        Assert.assertEquals(CORRECT_PASSWORD, loginPage.getValue(loginPage.getPassword()));
    }

    @org.junit.Test
    public void clickEnterBtnTest() {
        loginPage = new LoginPage();
        loginPage.clickOnEnter();
        Assert.assertTrue(loginPage.isElementShow(loginPage.getErrorMessage()));
        Assert.assertEquals(ERROR_MESSAGE_TEXT, loginPage.getValue(loginPage.getErrorMessage()));
    }
}
