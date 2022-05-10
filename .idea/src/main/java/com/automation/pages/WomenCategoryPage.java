package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WomenCategoryPage extends Utility {
    public WomenCategoryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class='title_block']")
    WebElement womanTextField;
    @FindBy(xpath = "//div[@class='block_content']//a[normalize-space()='Tops']")
    WebElement topLinkField;
    @FindBy(xpath = "//div[@class='block_content']//a[contains(@title,'Find your favorites dresses from our wide choice of evening, casual or summer dresses!')][normalize-space()='Dresses']")
    WebElement dressesLink;
    @FindBy(xpath = "//div[@class='block_content']//a[contains(@title,'Find your favorites dresses from our wide choice of evening, casual or summer dresses!')][normalize-space()='Dresses']")
    WebElement shortBydropDownField;
    @FindBy(xpath = "//h5[@itemprop=\"name\"]/child::a[@class=\"product-name\"]")
    List<WebElement> productLists;
    @FindBy(xpath = "//a[normalize-space()='Blouse']")
    WebElement blouse;
    @FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-in-line first-item-of-tablet-line last-item-of-mobile-line hovered']//a[@title='Printed Dress'][normalize-space()='Printed Dress']")
    WebElement printedDress;
    @FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-item-of-tablet-line hovered']//a[@title='Printed Summer Dress'][normalize-space()='Printed Summer Dress']")
    WebElement printedSummerDress;
    @FindBy(xpath = "//a[normalize-space()='Printed Chiffon Dress']")
    WebElement printeCiffonDress;
    public String getWomenText() {
        return getTextFromElement(womanTextField);
    }
    public void clickOnTopsLink() {
        clickOnElement(topLinkField);
    }
    public void clickOnDressesLink() {
        clickOnElement(dressesLink);
    }
    public void clickOnDropDownField() {
        clickOnElement(shortBydropDownField);
    }
    public int getProductListsize() {
        List<WebElement> lists = productLists;
        return lists.size();
    }
    public String getTextFromBlouseLink() {
        return getTextFromElement(blouse);
    }
    public void clickOnProduct(String product) {
        WebElement[] products = {blouse, printedDress, printeCiffonDress, printedSummerDress};
        for (WebElement lists : products)
            if (lists.getAttribute("title").matches(product)) {
                lists.click();

            }
    }

}
