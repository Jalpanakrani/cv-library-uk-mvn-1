package uk.co.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.library.utility.Utility;

public class HomePage extends Utility {

    @FindBy(xpath = "//span[contains(text(),'Accept All')]")
    WebElement cookiesAcceptField;

    @FindBy(xpath = "//input[@id='keywords']")
    WebElement jobTitleKeyword;
    @FindBy(xpath = "//input[@id='location']")
    WebElement findlocation;
    @FindBy(xpath = "//select[@id='distance']")
    WebElement distanceDropDown;
    @FindBy(xpath = "//button[@id='toggle-hp-search']")
    WebElement moreSearchOptionsLink;
    @FindBy(xpath = "//input[@id='salarymin']")
    WebElement salaryMin;
    @FindBy(xpath = "//input[@id='salarymax']")
    WebElement salaryMax;
    @FindBy(xpath = "//select[@id='salarytype']")
    WebElement salaryTypeDropDown;
    @FindBy(xpath = "//select[@id='tempperm']")
    WebElement jobTypeDropDown;
    @FindBy(xpath = "//input[@id='hp-search-btn']")
    WebElement findJobsBtn;

    public  void handlingIframeWindow(){
        driver.switchTo().frame("gdpr-consent-notice");
        clickOnElement(cookiesAcceptField);
        driver.switchTo().defaultContent();
    }

    public void enterJobTitle(String jobTitle){
        sendTextToElement(jobTitleKeyword,jobTitle);
    }

    public void enterLocation(String location){
        sendTextToElement(findlocation,location);
    }

    public void selectDistance(String distance){
        selectByVisibleTextFromDropDown(distanceDropDown,distance);
    }

    public void clickOnMoreSearchOptionLink(){
        clickOnElement(moreSearchOptionsLink);
    }

    public void enterMinSalary(String minSalary){
        sendTextToElement(salaryMin,minSalary);
    }

    public void enterMaxSalary(String maxSalary){
        sendTextToElement(salaryMax,maxSalary);
    }

    public void selectSalaryType(String sType){
        selectByVisibleTextFromDropDown(salaryTypeDropDown,sType);
    }

    public void selectJobType(String jobType){
        selectByVisibleTextFromDropDown(jobTypeDropDown,jobType);
    }

    public void clickOnFindJobsButton(){
        clickOnElement(findJobsBtn);
    }

}