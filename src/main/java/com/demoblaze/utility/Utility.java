package com.demoblaze.utility;

import com.demoblaze.browserfactory.ManageBrowser;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utility extends ManageBrowser {

    /**
     Utility Class extends to ManageBrowser for the driver to finding locators
     All common methods are fixed in the utility Class.
     */


    /**
     * This method will generate random string
     */
    public static String getRandomString() {
        String username;
        Random randomPartOfUserGenerator = new Random(5000);
        int randomNumberInString = randomPartOfUserGenerator.nextInt();
        RandomString randomString = new RandomString(5);
        String randomStringInUserGenerator = randomString.nextString();
        return username = "john" + randomNumberInString + randomStringInUserGenerator + "";
    }

    /**
     * This method will click on element
     */
    public void clickOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            // Handle the exception
            System.err.println("Error occurred while clicking the element: " + e.getMessage());
        }
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            // Handle the exception here
            e.printStackTrace(); // This prints the exception details to the console for debugging purposes
            return "Error: Unable to retrieve text from the element";
        }
    }

    /**
     * This method will send text on element
     */

    public void sendTextToElement(WebElement element, String str) {
        try {
            element.sendKeys(str);
        } catch (Exception e) {
            // Handle the exception here
            e.printStackTrace(); // This prints the exception details to the console for debugging purposes
        }
    }

    /**
     * This method will get text from alert
     */
    public String getTextFromAlert() {
        try {
            return driver.switchTo().alert().getText();
        } catch (NoAlertPresentException e) {
            // Handle the case where there is no alert present
            e.printStackTrace(); // This prints the exception details to the console for debugging purposes
            return "No alert found";
        }

    }

    /**
     * This method will mouser hover and click on the element
     */
    public void mouseHoverToElementAndClick(WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().perform();
        } catch (NoSuchElementException e) {
            // Handle the case where the element is not found
            e.printStackTrace(); // This prints the exception details to the console for debugging purposes
        }
    }

    /**
     * This method will take Failed Test Case screenshot
     */
    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // After execution, you could see a "FailedTestsScreenshots" folder
        String destination = System.getProperty("user.dir") + "/src/main/java/com/demoblaze/FailedTestsScreenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }


}
