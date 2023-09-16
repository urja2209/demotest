package com.demoblaze.browserfactory;

import com.demoblaze.propertyreader.PropertyReader;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ManageBrowser {
    public static WebDriver driver;
    static String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");

    // A constructor that initializes the PageFactory and the PropertyConfigurator
    public ManageBrowser() {
        PageFactory.initElements(driver, this);
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/java/resources/propertiesfile/log4j2.properties");
    }
    // A method that takes a String parameter and selects the browser accordingly
    public void selectBrowser(String browser) {
        // If the parameter is "chrome", create a ChromeDriver object
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            // If the parameter is "firefox", create a FirefoxDriver object
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            // If the parameter is "edge", create an EdgeDriver object
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        // If the parameter is not valid, print an error message
        else {
            System.out.println("Wrong browser name");
        }
        // Maximize the browser window
        driver.manage().window().maximize();

        // Set the implicit wait time for finding web elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(PropertyReader.getInstance().getProperty("implicitlyWait"))));

        // Navigate to the base URL
        driver.get(baseUrl);
    }

    // A method that closes the browser instance
    public void closeBrowser() {
        // If the driver is not null, quit the browser
        if (driver != null) {
            driver.quit();
        }
    }

}
