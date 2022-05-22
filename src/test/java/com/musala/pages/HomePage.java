package com.musala.pages;

import com.musala.pages.MusalaWebBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends MusalaWebBasePage {
    //Web elements
    @FindBy(xpath = "//*[@class='contact-label btn btn-1b']")
    WebElement contactUs;
    @FindBy(xpath = "//*[@class='brand']")
    WebElement logo;
    @FindBy(xpath = "//*[@id='menu-main-nav-1']/li[1]/a")
    WebElement company;
    @FindBy(xpath = "//*[@id='menu-main-nav-1']/li[5]/a")
    WebElement careers;
    @FindBy(xpath = "//*[@data-cli_action='accept_all']")
    WebElement acceptCookies;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        fluentWaitForElement(logo);
        fluentWaitForElement(acceptCookies);
        acceptCookies.click();
    }

    public void goToContactUs() {
        scrollToElement(contactUs);
        contactUs.click();
    }

    public void goToCompany() {
        company.click();
    }

    public void goToCareers() {
        careers.click();
    }
}