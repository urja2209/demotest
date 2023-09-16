package com.demoblaze.pages;

import com.demoblaze.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {

    // Initialize Logger
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    // Constructor
    public HomePage() {
        // Initialize Page Elements
        PageFactory.initElements(driver, this);
    }

    // WebElements
    @CacheLookup
    @FindBy(id = "signin2")
    WebElement signUp;

    @CacheLookup
    @FindBy(id = "login2")
    WebElement login;

    @CacheLookup
    @FindBy(xpath = "//div[@id='contcont']//div[5]//div[1]//a[1]//img[1]")
    WebElement iphone6;

    /**
     * Clicks on the SignUp button
     */
    public void clickOnSignUpButton() {
        log.info("Clicking on SignUp Button");
        clickOnElement(signUp);
    }

    /**
     * Clicks on the Login button
     */
    public void clickOnLoginButton() {
        log.info("Clicking on Login Button");
        clickOnElement(login);
    }

    /**
     * Performs mouse hover on the iPhone 6 element and then clicks it
     */
    public void mouseHoverAndClickOnIphone6() {
        log.info("Mouse Hover And Click IPhone6");
        mouseHoverToElementAndClick(iphone6);
    }
}
