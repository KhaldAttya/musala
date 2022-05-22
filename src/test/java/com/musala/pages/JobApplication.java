package com.musala.pages;

import com.musala.models.ContactUsForm;
import com.musala.models.JobApplicationForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobApplication extends MusalaWebBasePage {
    //Web elements
    @FindBy(xpath = "//*[@class='popup_form']")
    WebElement jobApplicationView;
    @FindBy(xpath = "//*[@name='your-name']")
    WebElement name;
    @FindBy(xpath = "//*[@name='your-email']")
    WebElement email;
    @FindBy(xpath = "//*[@name='mobile-number']")
    WebElement mobile;
    @FindBy(xpath = "//*[@name='uploadtextfield']")
    WebElement upload;
    @FindBy(xpath = "//*[@name='linkedin']")
    WebElement linkedin;
    @FindBy(xpath = "//*[@name='your-message']")
    WebElement yourMessage;
    @FindBy(xpath = "//*[@type='submit']")
    WebElement sendButton;
    @FindBy(id = "adConsentChx")
    WebElement consentCheckbox;
    @FindBy(xpath = "//*[@class='wpcf7-not-valid-tip']")
    WebElement invalidEmailError;

    public JobApplication(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        fluentWaitForElement(jobApplicationView);
    }

    public void populateJobApplicationForm(JobApplicationForm jobApplicationForm) {

        if(!jobApplicationForm.getName().isEmpty()){
            name.sendKeys(jobApplicationForm.getName());
        }

        if(!jobApplicationForm.getEmail().isEmpty()){
            email.sendKeys(jobApplicationForm.getEmail());
        }

        if(!jobApplicationForm.getMobile().isEmpty()){
            mobile.sendKeys(jobApplicationForm.getMobile());
        }

        if(jobApplicationForm.getCV() != null){
            upload.sendKeys(jobApplicationForm.getCV().getAbsolutePath());
        }

        if(!jobApplicationForm.getLinkedinProfileLink().isEmpty()){
            linkedin.sendKeys(jobApplicationForm.getLinkedinProfileLink());
        }
        if(!jobApplicationForm.getYourMessage().isEmpty()){
            yourMessage.sendKeys(jobApplicationForm.getYourMessage());
        }
    }
    public void clickSend() {
        sendButton.click();
    }
    public void clickConsentCheckbox() {
        consentCheckbox.click();
    }
    public void verifyErrorMessage(JobApplication.JobApplicationFormError error){
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

    public enum JobApplicationFormError {
        InvalidEmail,
    }

}