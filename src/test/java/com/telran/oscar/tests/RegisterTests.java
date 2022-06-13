package com.telran.oscar.tests;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.RegisterPage;
import com.telran.oscar.utils.DataProviders;
import com.telran.oscar.utils.PropertiesLoader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTests extends TestBase {

    HomePage homePage;
    RegisterPage registerPage;

    public static String password = PropertiesLoader.loadProperty("valid.password");

    @BeforeMethod
    public void pageInit() {
   // public void setUp() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        registerPage = PageFactory.initElements(driver, RegisterPage.class);
    }

    @BeforeMethod
    public void precondition() {
        homePage.clickOnLoginAndRegisterLink();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "registrationWithInvalidEmail")
    public void newUserRegistrationWithInvalidEmailTest(String email) {
        homePage.clickOnLoginAndRegisterLink();
        registerPage.fillRegisterForm(email, password, password);
        Assert.assertTrue(registerPage.isRegisterFormDisplayed());
    }

}
