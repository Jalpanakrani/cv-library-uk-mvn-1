package com.automation.testsuite;

import com.automation.pages.*;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class WomenCategoryPageTest extends TestBase {
    HomePage homePage;
    WomenCategoryPage womenCategoryPage;
    ProductPage productPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        womenCategoryPage = new WomenCategoryPage();
        productPage = new ProductPage();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToWomenCategoryPageSuccessfully() {
        homePage.clickOnWomantab();
        String expectedWomenText = "WOMWNText";
        String actualMessage = womenCategoryPage.getWomenText();
        Assert.assertEquals(expectedWomenText,actualMessage,"Login page not displayed");

    }

    @Test(dataProvider = "cart", dataProviderClass = TestData.class,groups = {"smoke","regression"})
    public void verifyUserShouldAddProductToTheCartSuccessfully(String product, String qty, String size, String colour) throws InterruptedException {
        homePage.clickOnWomantab();
        womenCategoryPage.clickOnProduct(product);
        productPage.enterQuantity(qty);
        productPage.selectSize(size);
        productPage.clickOnColur(colour);
        productPage.clickOnAddCart();
        String expectedAddToCartText="Product successfully added to your shopping cart";
        String actualAddToCartText=productPage.getSuccessFullyAddedText();
        Assert.assertEquals(actualAddToCartText,expectedAddToCartText,"displayed message is wrong ");
        productPage.clickOnCloseWindowTab();

    }

}