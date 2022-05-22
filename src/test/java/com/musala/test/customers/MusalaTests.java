package com.musala.test.customers;
import com.musala.models.ContactUsForm;
import com.musala.models.JobApplicationForm;
import com.musala.pages.ContactUs;
import com.musala.pages.JobApplication;
import com.musala.test.MusalaWebBaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.IOException;

@Execution(ExecutionMode.CONCURRENT)

public class MusalaTests extends MusalaWebBaseTest {

    @ParameterizedTest
    @Execution(ExecutionMode.SAME_THREAD)
    @CsvFileSource(resources = "/invalid-emails.csv")
    public void TC_01_contactUsInvalidEmailsTest(String email){
        page.homePage().goToContactUs();
        page.contactUs().populateContactUsForm(new ContactUsForm().name("Khaled").email(email).mobile("201000283834").subject("test-message").yourMessage("This is an automated message").build());
        page.contactUs().clickSend();
        page.contactUs().verifyErrorMessage(ContactUs.ContactUsFormError.InvalidEmail);
    }

    @Test
    public void TC_02_verifyCompanyPageFacebookLinkTest(){
        page.homePage().goToCompany();
        page.company().verifyPageLink();
        page.company().verifyPageElements();
        page.company().clickFacebookIcon();
        page.company().verifyFacebookPage();
    }

    @Test
    public void TC_03_verifyJobApplicationFormErrorsTest() throws IOException {
       page.homePage().goToCareers();
       page.careers().goToOpenPositions();
       page.openPositions().selectLocationFilter("Anywhere");
       page.openPositions().selectPosition("Automation QA Engineer");
       page.jobPosting().verifyPageElements();
       page.jobPosting().clickApply();
       page.jobApplication().populateJobApplicationForm(new JobApplicationForm()
               .name("Khaled")
               .email("khaled.attia@musala")
               .mobile("201000283834")
               .CV(File.createTempFile("CVFile","Khaled"))
               .linkedinProfileLink("https://www.linkedin.com/in/khald-attya/")
               .yourMessage("This is an automated message").build());
       page.jobApplication().clickConsentCheckbox();
       page.jobApplication().clickSend();
       page.jobApplication().verifyErrorMessage(JobApplication.JobApplicationFormError.InvalidEmail);
    }

    @ParameterizedTest
    @Execution(ExecutionMode.SAME_THREAD)
    @ValueSource(strings = {"Sofia", "Skopje"})
    public void TC_04_availablePositionsByCityTest(String city) {
        page.homePage().goToCareers();
        page.careers().goToOpenPositions();
        page.openPositions().printCityJobs(city);
    }
}
