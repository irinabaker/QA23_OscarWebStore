package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MenuBlock extends PageBase{

    public MenuBlock(WebDriver driver) {
        super(driver);
    }

    public MenuBlock checkMenuElements() {
        String [] menuElements= new String[] {"All products", "Clothing", "Books", "Offers"};
        for (int i = 0; i < menuElements.length; i++){
            if (menuElements[i].equals("All products")) {
                clickAllProductsMenu();
                Assert.assertTrue(isAllProductsPageDisplayed());
                returnToHomePage();
            } else if (menuElements[i].equals("Clothing")) {
                clickClothingMenu();
                Assert.assertTrue(isClothingPageDisplayed());
                returnToHomePage();
            } else if (menuElements[i].equals("Books")) {
                clickBooksMenu();
                Assert.assertTrue(isBooksPageDisplayed());
                returnToHomePage();
            }else if (menuElements[i].equals("Offers")) {
                clickOffersMenu();
                Assert.assertTrue(isOffersPageDisplayed());
                returnToHomePage();
            }
            else {
                Assert.fail();
            }
        }
        return this;
    }

    @FindBy(xpath = "//a[text()='All products']")
    WebElement menuAllProducts;


    public AllProductsPage clickAllProductsMenu() {
        click(menuAllProducts);
        return new AllProductsPage(driver);
    }

    @FindBy(tagName = "h1")
    WebElement pageHeader;

    public boolean isAllProductsPageDisplayed() {
        return pageHeader.getText().equals("All products");
    }

    @FindBy (xpath = "//a[@href = '/en-gb/']")
    WebElement logo;

    public HomePage returnToHomePage() {
        click(logo);
        return new HomePage(driver);
    }

    @FindBy (xpath = "//a[text()='Clothing']")
    WebElement menuClothing;

    public ClothingPage clickClothingMenu() {
        click(menuClothing);
        return new ClothingPage(driver);
    }

    @FindBy (tagName = "h1")
    WebElement clothingHeader;

    public boolean isClothingPageDisplayed() {
        return clothingHeader.getText().equals("Clothing");
    }

    @FindBy (xpath = "//a[text()='Books']")
    WebElement menuBooks;

    public BooksPage clickBooksMenu(){
        click(menuBooks);
        return new BooksPage(driver);
    }

    @FindBy(tagName = "h1")
    WebElement booksHeader;

    public boolean isBooksPageDisplayed() {
        return booksHeader.getText().equals("Books");
    }

    @FindBy (xpath = "//a[text()='Offers']")
    WebElement menuOffers;

    public OffersPage clickOffersMenu(){
        click(menuOffers);
        return new OffersPage(driver);
    }

    @FindBy(tagName = "h1")
    WebElement offersHeader;

    public boolean isOffersPageDisplayed() {
        return offersHeader.getText().equals("Offers");
    }
}
