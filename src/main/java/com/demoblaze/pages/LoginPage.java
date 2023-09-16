package com.demoblaze.pages;

import com.demoblaze.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utility {

    // Initialize Logger
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());
    // Constructor

    public LoginPage() {
        // Initialize Page Elements
        PageFactory.initElements(driver, this);
    }
    // WebElements

    @CacheLookup
    @FindBy(id="loginusername")
    WebElement username1;

    @CacheLookup
    @FindBy(id="loginpassword")
    WebElement password1;

    @CacheLookup
    @FindBy(xpath="//button[normalize-space()='Log in']")
    WebElement login;
    @CacheLookup
    @FindBy(xpath="//a[@id='nameofuser']")
    WebElement getTitle;

/**
 * Enters the given username into the username input field.
 */
       public void enterUserName(String username) {
        log.info("Enter username " + username + " to username field " + username1.toString());
        sendTextToElement(username1, username);
        }

/**
 * Enters the given password into the password input field.
 */
        public void enterPassword(String password) {
        log.info("Enter Password " + password + " to Password field " + password1.toString());
        sendTextToElement(password1, password);
         }
    /**
     * Clicks on the Login button.
     */
    public void clickOnLoginTab() {
        log.info("Clicking on Login Button" );
        clickOnElement(login);
    }

    /**
     * Verifies and retrieves the text of the Welcome message.
     *
     * @return The text of the Welcome message.
     */
    public String verifyMessageWelcomeJson() throws InterruptedException {
        log.info("get actual title text of Welcome");
      Thread.sleep(2000);
        return getTextFromElement(getTitle) ;
    }


}
