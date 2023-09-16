package com.demoblaze.pages;

import com.demoblaze.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends Utility {

    // Initialize Logger
    private static final Logger log = LogManager.getLogger(CartPage.class.getName());

    // Constructor
    public CartPage() {
        // Initialize Page Elements
        PageFactory.initElements(driver, this);
    }

    // WebElements
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Add to cart']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//a[@id='cartur']")
    WebElement cart;

    @CacheLookup
    @FindBy(xpath = "//td[normalize-space()='Iphone 6 32gb']")
    WebElement getProductAdded;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Place Order']")
    WebElement placeOrder;

    @CacheLookup
    @FindBy(xpath = "//input[@id='name']")
    WebElement cardHolderNameInputBox;

    @CacheLookup
    @FindBy(xpath = "//input[@id='country']")
    WebElement cardHolderCountryName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='city']")
    WebElement cardHolderCityName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='card']")
    WebElement cardHolderCardNumber;

    @CacheLookup
    @FindBy(xpath = "//input[@id='month']")
    WebElement cardHolderExpireMonth;

    @CacheLookup
    @FindBy(xpath = "//input[@id='year']")
    WebElement cardHolderExpireYear;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Purchase']")
    WebElement purchase;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Thank you for your purchase!']")
    WebElement thankYouForPurchase;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement ok;
    @CacheLookup
    @FindBy(xpath = "//a[@id='nava']")
    WebElement productStoreLogo;


    // Click on the "Add to Cart" button
    public void clickOnAddToCartButton() {
        log.info("Clicking on Add To Cart Button");
        clickOnElement(addToCart);
    }

    // Get text from the alert that appears when the product is added
    public String getTextFromAlertProductAdded() {
        log.info("Get text from alert when product is added");
        Alert alert1 = driver.switchTo().alert();
        String actualMessage1 = alert1.getText();
        return actualMessage1;

    }

    // Click on the "OK" button of the alert
    public void clickOnOkButton() {
        log.info("Clicking on Ok button");
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // Click on the "Cart" tab
    public void clickOnCartTab() {
        log.info("Clicking on Cart Tab");
        clickOnElement(cart);
    }
    // Verify that the product is added successfully

    public String verifyProductAddedSuccessfully() {
        log.info("get actual title text of Product Name");
        return getTextFromElement(getProductAdded);
    }
    // Click on the "Place Order" button
    public void clickOnPlaceOrderButton() {
        log.info("Clicking on Place To Order Button");
        clickOnElement(placeOrder);
    }
    // Fill in the cardHolder's name

    public void fillInCardHolderNameInputBox(String name) {
        log.info("Enter card holder name " + name + " to Name field " + cardHolderNameInputBox.toString());
        sendTextToElement(cardHolderNameInputBox, name);
    }
    // Fill in the cardHolder's country name

    public void fillInCardHolderCountry(String countryName) {
        log.info("Enter card holder Country name " + countryName + " to Country field " + cardHolderCountryName.toString());
        sendTextToElement(cardHolderCountryName, countryName);
    }

    // Fill in the cardHolder's city name
    public void fillInCardHolderCityName(String cityName) {
        log.info("Enter card holder City name " + cityName + " to City field " + cardHolderCityName.toString());
        sendTextToElement(cardHolderCityName, cityName);
    }

    // Fill in the cardHolder's Card Number
    public void fillInCardNumberInputBox(String cardNumber) {
        log.info("Enter Card holder Card Number " + cardNumber + " to Credit Card field " + cardHolderCardNumber.toString());
        sendTextToElement(cardHolderCardNumber, cardNumber);
    }

    // Fill in the cardHolder's Expiry Month in Card
    public void fillInCardExpiryMonth(String expiryMonth) {
        log.info("Enter card holder Expire Month " + expiryMonth + " to Month field " + cardHolderExpireMonth.toString());
        sendTextToElement(cardHolderExpireMonth, expiryMonth);
    }
    // Fill in the cardHolder's Expiry Year in Card

    public void fillInCardExpiryYear(String expiryYear) {
        log.info("Enter card holder Expire Year " + expiryYear + " to Year field " + cardHolderExpireYear.toString());
        sendTextToElement(cardHolderExpireYear, expiryYear);
    }

    // Click on the "Purchase" button
    public void clickOnPurchaseButton() {
        log.info("Clicking on Purchase Button");
        clickOnElement(purchase);
    }

    // Verify that the "Thank you for your purchase!" message is displayed
    public String verifyThankYouForYourPurchaseMessageDisplayed() {
        log.info("Verify actual title text of Thank you for your purchase!");
        return getTextFromElement(thankYouForPurchase);
    }

    // Click on the "OK" button
    public void clickOnOK() {
        log.info("Click on ok button");
        clickOnElement(ok);
    }

    // Verify that the "Product Store Logo" is displayed
    public boolean verifyProductStoreLogoIsDisplayed() {
        log.info("get actual title text of Logo");
        return productStoreLogo.isDisplayed();
    }
}
