package com.musala.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Careers extends MusalaWebBasePage {
    //Web elements
    @FindBy(xpath = "//*[@data-alt='Check our open positions']")
    WebElement openPositions;

    public Careers(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        fluentWaitForElement(openPositions);
    }
    public void goToOpenPositions(){
        openPositions.click();
    }
}