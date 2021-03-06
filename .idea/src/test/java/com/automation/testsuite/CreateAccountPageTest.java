package com.automation.testsuite;

import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountPageTest extends TestBase {
    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPageTest createAccountPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPageTest();

    }


    @Test(groups = {"sanity","smoke","regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() throws InterruptedException {
        homePage.clickOnsignInLinkFiled();
        signInPage.enterEmailForCreatAccount("patel99999@gmail.com");
        signInPage.clickOnCreatAccountButton();

        createAccountPage.enterFirstNameInInfo("john");
        createAccountPage.enterlastNameInInfo("sena");
        createAccountPage.enterPasswordInInfo("john123456");
        createAccountPage.enterAddress("hinay road");
        Thread.sleep(5000);
        createAccountPage.enterCity("london");
        createAccountPage.selectStateFromDropDown("Hawaii");
        createAccountPage.enterZipCode("12345");
        createAccountPage.selectCountryFromDropDown("United States");
        createAccountPage.enterHomePhoneNumber("1234567890");
        createAccountPage.enterAliasAddress("My address");
        createAccountPage.clickOnRegisterField();
        String expectedMyAccountText="My Account";
        String actualMyAccountText=createAccountPage.getMyAccountText();
        Assert.assertEquals(actualMyAccountText,expectedMyAccountText,"my account text not match");


    }


}