package com.automation.testsuite;

import com.automation.pages.*;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class SignInPageTest extends TestBase {

    HomePage homePage;
    SignInPage signInPage;
    CreatAccountPage creatAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        signInPage = new SignInPage();
        creatAccountPage = new CreatAccountPage();
    }

    @Test(groups = {"sanity","smoke",  "regression"})
    public void userShouldNavigateToSignInPageSuccessFully() {
        homePage.clickOnsignInLinkFiled();
        String expectedAuthenticationText = "AUTHENTICATION";
        String actualAuthenticationText = signInPage.getAuthenticationText();
        Assert.assertEquals(expectedAuthenticationText, actualAuthenticationText, "authentication text is not match");
    }

    @Test(dataProvider = "credential", dataProviderClass = TestData.class, groups = {"smoke", "regression"})
    public void verifyTheErrorMessageWithInValidCredentials(String username, String password, String message) {
        homePage.clickOnsignInLinkFiled();
        signInPage.enterEmailForSignIn(username);
        signInPage.enterPasswordForSignIn(password);
        signInPage.clickOnSignInButton();
        String expectedErrorMessage = "message";
        String actualErrorMessage = signInPage.getErrorMessage();
        Assert.assertEquals( expectedErrorMessage, actualErrorMessage,"Error message not displayed");

    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
        homePage.clickOnsignInLinkFiled();
        signInPage.enterEmailForSignIn("priya1234@gmail.com");
        signInPage.enterPasswordForSignIn("patel123");
        signInPage.clickOnSignInButton();
       // creatAccountPage.clickOnSignOutLink();
        String expectedMessage = "SignOutLinkText";
        String actualMessage = signInPage.getSignOutLinkText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");


    }
    @Test(groups = "regression")
    public void verifyThatUserShouldLogOutSuccessFully(){
        homePage.clickOnsignInLinkFiled();
        signInPage.enterEmailForSignIn("patel2222@gmail.com");
        signInPage.enterPasswordForSignIn("abc123456");
        signInPage.clickOnSignInButton();
        signInPage.clickOnSignOutLink();
        String expectedMessage = "SignInLinkText";
        String actualMessage = signInPage.getSignInLinkText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");


    }


}