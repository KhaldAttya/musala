package com.musala.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.logging.Logger;

public class OpenPositions extends MusalaWebBasePage {
    //Web elements
    @FindBy(xpath = "//*[@name='get_location']")
    WebElement locationsPicker;

    public OpenPositions(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        fluentWaitForElement(locationsPicker);
    }

    public void selectLocationFilter(String location){
        locationsPicker.click();
        driver.findElement(By.xpath(String.format("//*[@value='%s']", location))).click();
    }

    public void selectPosition(String name){
        WebElement position =  driver.findElement(By.xpath(String.format("//*[@data-alt='%s']", name)));
        scrollToElement(position);
        position.click();

    }
    public void printCityJobs(String location){
        selectLocationFilter(location);
        System.out.println(location);
        List<WebElement> titles = driver.findElements(By.xpath("//*[@class='card-jobsHot__title']"));
        List<WebElement> jobsInfo = driver.findElements(By.xpath("//*[@class='card-jobsHot__info']"));
        for (int i=0; i<titles.size(); i++)
        {
            System.out.println("Position: " + titles.get(i).getText());
            System.out.println("More info: " + jobsInfo.get(i).getText());
        }
    }
}