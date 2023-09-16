package com.demoblaze.pages;

import com.demoblaze.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends Utility {

    // Initialize Logger
    private static final Logger log = LogManager.getLogger(SignUpPage.class.getName());

    // Constructor
    public SignUpPage() {
        // Initialize Page Elements
        PageFactory.initElements(driver, this);}

    public static String username;

    // WebElements
    @CacheLookup
    @FindBy(id="sign-username")
    WebElement userName;

    @CacheLookup
    @FindBy(id="sign-password")
    WebElement password1;
    @CacheLookup
    @FindBy(xpath="//button[normalize-space()='Sign up']")
    WebElement signup;

    /**
     * Enters the given username into the username input field.
     */
    public void enterUserName() {
        sendTextToElement(userName,getRandomString());
        log.info("Enter User " + userName.toString());
    }

    /**
     * Enters the given password into the password input field.
     */

    public void enterPassword(String password)  {
        log.info("Enter Password " + password + " to Password field " + password1.toString());
        sendTextToElement(password1, password);
    }

    /**
     * Clicks on the SignUp button.
     */

    public void clickOnSigunUp() {
        log.info("Clicking on SignUp Button" );
        clickOnElement(signup);
    }

    /**
     * Retrieves the text from the alert dialog.
     *
     * @return The text content of the alert dialog.
     */
    public String getTextFromAlert() {
        log.info("Get the Title of text from alert" );
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        return actualMessage;
    }

    /**
     * Accepts the alert dialog by clicking the 'OK' button.
     */
    public void clickOnOk(){
        log.info("Clicking on Ok Button" );
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
