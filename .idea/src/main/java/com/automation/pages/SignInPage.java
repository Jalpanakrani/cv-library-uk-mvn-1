package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends Utility {
    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;
    @FindBy(id = "passwd")
    WebElement passWordField;
    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    WebElement signInButton;
    @FindBy(xpath = "//h1[@class='page-heading']")
    WebElement authenticationTextField;
    @FindBy(xpath = "//h3[normalize-space()='Create an account']")
    WebElement creatAccountTextField;
    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement creatAccoutnButtonField;
    @FindBy(xpath = "//input[@id='email_create']")
    WebElement emailFieldInCreatAccount;
    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement SignInLinkText;
    @FindBy(xpath = "//header/div[2]/div[1]/div[1]/nav[1]/div[2]/a[1]")
    WebElement SignOutLinkText;

    WebElement SignoutLink;
   WebElement errorMessage;
    public String getErrorMessage() {
        return getTextFromElement(errorMessage);}
    public String getSignInLinkText() {
        return getTextFromElement(SignInLinkText);
    }
    public void clickOnSignOutLink(){
        clickOnElement(SignoutLink);
    }

    public String getSignOutLinkText() {
        return getTextFromElement(SignOutLinkText);
    }
        public void enterEmailForCreatAccount(String email) {
        sendTextToElement(emailFieldInCreatAccount, email);
    }

    public void clickOnCreatAccountButton() {
        clickOnElement(creatAccoutnButtonField);
    }

    public void enterEmailForSignIn(String email) {
        sendTextToElement(emailField, email);
    }

    public void enterPasswordForSignIn(String password) {
        sendTextToElement(passWordField, password);
    }

    public String getAuthenticationText() {
        return getTextFromElement(authenticationTextField);
    }

    public String getCreatAnAccountText() {
        return getTextFromElement(creatAccountTextField);
    }

    public void clickOnSignInButton() {
        clickOnElement(signInButton);
    }

    public void signInApplication(String username, String password) {
        enterEmailForSignIn(username);
        enterPasswordForSignIn(password);
        clickOnElement(signInButton);

    }

}