package com.musala.pages;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    private final WebDriver driver;
    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage homePage() {
        return new HomePage(driver);
    }
    public ContactUs contactUs() { return new ContactUs(driver); }
    public Company company() { return new Company(driver); }
    public Careers careers() { return new Careers(driver); }
    public OpenPositions openPositions() { return new OpenPositions(driver); }
    public JobPosting jobPosting() { return new JobPosting(driver); }
    public JobApplication jobApplication() { return new JobApplication(driver); }
}
