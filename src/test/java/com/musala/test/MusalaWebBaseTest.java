package com.musala.test;

import com.musala.pages.PageFactory;
import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class MusalaWebBaseTest {
    protected static WebDriver driver;
    protected static String browser;
    protected PageFactory page;

    @BeforeEach
    public void setup() throws IOException {
       browser = getProperties("Configuration.properties").getProperty("browser");
       prepareDriver(browser);
        if (page == null)
            page = new PageFactory(driver);
        String url = "http://www.musala.com/";
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected Properties getProperties(String name) throws IOException {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(name)) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find properties file name: " + name);
                return null;
            }
            prop.load(input);
            return prop;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    private static void prepareDriver(String browser){
        switch (browser){
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                if (driver == null)
                    driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                if (driver == null)
                    driver = new FirefoxDriver();
                break;
            default:
                break;
        }
    }
}
