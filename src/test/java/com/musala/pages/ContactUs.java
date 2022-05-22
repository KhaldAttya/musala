package com.musala.pages;

import com.musala.models.ContactUsForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ContactUs extends MusalaWebBasePage {
    //Web elements
    @FindBy(xpath = "//*[@class='popup_form']")

    WebElement contactUsView;
    @FindBy(xpath = "//*[@name='your-name']")
    WebElement name;
    @FindBy(xpath = "//*[@name='your-email']")
    WebElement email;
    @FindBy(xpath = "//*[@name='mobile-number']")
    WebElement mobile;
    @FindBy(xpath = "//*[@name='your-subject']")
    WebElement subject;
    @FindBy(xpath = "//*[@name='your-message']")
    WebElement yourMessage;
    @FindBy(xpath = "//*[@type='submit']")
    WebElement sendButton;
    @FindBy(xpath = "//*[@class='wpcf7-not-valid-tip']")
    WebElement invalidEmailError;

    public ContactUs(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        fluentWaitForElement(contactUsView);
    }

    public void populateContactUsForm(ContactUsForm contactUs) {

        if(!contactUs.getName().isEmpty()){
            name.sendKeys(contactUs.getName());
        }

        if(!contactUs.getEmail().isEmpty()){
            email.sendKeys(contactUs.getEmail());
        }

        if(contactUs.getMobile() != null){
            mobile.sendKeys(contactUs.getMobile());
        }

        if(!contactUs.getSubject().isEmpty()){
            subject.sendKeys(contactUs.getSubject());
        }

        if(!contactUs.getYourMessage().isEmpty()){
            yourMessage.sendKeys(contactUs.getYourMessage());
        }
    }
    public void clickSend() {
        sendButton.click();
    }
    public void verifyErrorMessage(ContactUsFormError error){
        switch (error){
            case InvalidEmail:
                fluentWaitForElement(invalidEmailError);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.textToBePresentInElement(invalidEmailError, "The e-mail address entered is invalid."));
                break;
            default:
                break;
        }

    }

   public enum ContactUsFormError {
        InvalidEmail,
    }

}
