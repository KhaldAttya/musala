package com.musala.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobPosting extends MusalaWebBasePage {
    //Web elements
    @FindBy(xpath = "//*[@class='joinus-content']")
    WebElement joinUsContent;
    @FindBy(xpath = "//*[text() = 'General description']")
    WebElement generalDescription;
    @FindBy(xpath = "//*[text() = 'Requirements']")
    WebElement requirements;
    @FindBy(xpath = "//*[text() = 'Responsibilities']")
    WebElement responsibilities;
    @FindBy(xpath = "//*[text() = 'What we offer']")
    WebElement whatWeOffer;
    @FindBy(xpath = "//*[@value ='Apply']")
    WebElement apply;

    public JobPosting(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        fluentWaitForElement(joinUsContent);
    }

    public void verifyPageElements(){
        scrollToElement(generalDescription);
        scrollToElement(requirements);
        scrollToElement(responsibilities);
        scrollToElement(whatWeOffer);
        scrollToElement(apply);
    }
    public void clickApply(){
        scrollToElement(apply);
        apply.click();
    }

}