package com.musala.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class Company extends MusalaWebBasePage {
    //Web elements
    @FindBy(xpath = "//*[@id='menu-main-nav-1']/li[1]/a")
    WebElement company;
    @FindBy(xpath = "//*[@class='company-members']")
    WebElement leadership;
    @FindBy(xpath = "//*[@class='musala musala-icon-facebook']")
    WebElement facebookIcon;
    @FindBy(xpath = "//*[@aria-label='Musala Soft profile photo']")
    WebElement facebookProfilePicture;

    public Company(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        fluentWaitForElement(company);
    }

    public void verifyPageElements() {
        scrollToElement(leadership);
    }
    public void verifyPageLink() {
        verifyPageLink("http://www.musala.com/company/");
    }
    public void clickFacebookIcon(){
        scrollToElement(facebookIcon);
        facebookIcon.click();
    }
    public void verifyFacebookPage() {
        switchToWindowByTitle("Facebook");
        verifyPageLink("https://www.facebook.com/MusalaSoft?fref=ts");
        fluentWaitForElement(facebookProfilePicture);
    }
}