package com.musala.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MusalaWebBasePage {
    protected WebDriver driver;
    protected Actions actions;

    public MusalaWebBasePage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    protected void fluentWaitForElement(WebElement webElement) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void scrollToElement(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }
    protected void verifyPageLink(String link) {
        Assertions.assertEquals(link.replace("http://","").replace("https://",""), driver.getCurrentUrl().replace("http://","").replace("https://",""));
    }

    protected void switchToWindowByTitle(String title) {
        String currentWindow = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            if (driver.switchTo().window(winHandle).getTitle().contains(title)) {
                driver.switchTo().window(winHandle);
                break;
            } else {
                driver.switchTo().window(currentWindow);
            }
        }
    }
}
