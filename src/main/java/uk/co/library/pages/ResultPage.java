package uk.co.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import uk.co.library.utility.Utility;

public class ResultPage extends Utility {
        public void inIt(){
            PageFactory.initElements(driver,this);
        }

        @FindBy(xpath = "//h1[@class='search-header__title']")
        WebElement ResultText;


    public String getResultText(){
        return getTextFromElement(ResultText);}

}

