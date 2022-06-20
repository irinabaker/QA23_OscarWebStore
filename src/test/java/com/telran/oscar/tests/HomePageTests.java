package com.telran.oscar.tests;

import com.telran.oscar.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    HomePage homePage;
    ProductPage productPage;
    MenuBlock menuBlock;

    @BeforeMethod
    public void pageInit() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        productPage = PageFactory.initElements(driver, ProductPage.class);
        menuBlock = PageFactory.initElements(driver, MenuBlock.class);
    }

    @Test
    public void userCanSelectItemFromMenu() {
        homePage.selectCategory();
        Assert.assertTrue(productPage.isProductPage().contains("Books"));
    }

    @Test
    public void menuElementsTest() {
       menuBlock.checkMenuElements();
    }

}
