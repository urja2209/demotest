package com.demoblaze.steps;

import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.HomePage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class CartSteps {
    @When("^I mouse hover on and click on Iphone Item$")
    public void iMouseHoverOnAndClickOnIphoneItem() throws InterruptedException {
        Thread.sleep(2000);
        new HomePage().mouseHoverAndClickOnIphone6();
    }
    @And("^I click On Add To Cart Button$")
    public void iClickOnAddToCartButton() {
        new CartPage().clickOnAddToCartButton();
    }

    @Then("^Product should be added successfully  and verify Message 'Product added'$")
    public void productShouldBeAddedSuccessfullyAndVerifyMessageProductAdded() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals("Product Not Added Successfully", "Product added", new CartPage().getTextFromAlertProductAdded());
    }
    @And("^I click on OK Button in Popup$")
    public void iClickOnOKButtonInPopup() throws InterruptedException {
        Thread.sleep(3000);
        new CartPage().clickOnOkButton();
    }
    @And("^I click on Cart Tab$")
    public void iClickOnCartTab() throws InterruptedException {
        Thread.sleep(3000);
        new CartPage().clickOnCartTab();
    }
    @Then("^Verify that Product added successfully to the cart$")
    public void verifyThatProductAddedSuccessfullyToTheCart() throws InterruptedException {

        Thread.sleep(3000);
        Assert.assertEquals("Product Not Added Successfully", "Iphone 6 32gb", new CartPage().verifyProductAddedSuccessfully());
    }

    @And("^I click on Place Order Button$")
    public void iClickOnPlaceOrderButton() {
        new CartPage().clickOnPlaceOrderButton();
    }

    /**
     * Fills the place order form with credit card details from the provided DataTable.
     *
     * @param dataTable A DataTable containing credit card details such as card holder name,
     *                  country, city, card number, expiry month, and expiry year.
     */
    @And("^I fill below details in Place Order form$")
    public void iFillBelowDetailsInPlaceOrderForm(DataTable dataTable) {
        // Extract credit card details from the DataTable
        List<List<String>> creditCardDetails = dataTable.asLists(String.class);
        String cardHolderName = creditCardDetails.get(0).get(0);
        String country = creditCardDetails.get(0).get(1);
        String city = creditCardDetails.get(0).get(2);
        String cardNumber = creditCardDetails.get(0).get(3);
        String expiryMonth = creditCardDetails.get(0).get(4);
        String expiryYear = creditCardDetails.get(0).get(5);

        // Fill in the place order form with the extracted credit card details
        new CartPage().fillInCardHolderNameInputBox(cardHolderName);
        new CartPage().fillInCardHolderCountry(country);
        new CartPage().fillInCardHolderCityName(city);
        new CartPage().fillInCardNumberInputBox(cardNumber);
        new CartPage().fillInCardExpiryMonth(expiryMonth);
        new CartPage().fillInCardExpiryYear(expiryYear);
    }

    @And("^I click on Purchase Button$")
    public void iClickOnPurchaseButton() {
        new CartPage().clickOnPurchaseButton();
    }
    /**
     * Verifies that the "Thank You For Your Purchase" message is displayed on the page.
     * It pauses the test execution for 3 seconds to allow time for the message to appear
     * and then asserts that the expected message matches the actual message displayed.
     */
    @Then("^Thank You For Your Purchase message should be displayed$")
    public void thankYouForYourPurchaseMessageShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals("Thank You Message Not added Successfully", "Thank you for your purchase!", new CartPage().verifyThankYouForYourPurchaseMessageDisplayed());
    }


    @And("^I click on OK$")
    public void iClickOnOK() {
        new CartPage().clickOnOK();
    }
    /**
     * Verifies that after a certain action (e.g., completing a purchase), the user is redirected
     * to the Home Page.
     * and then asserts that the Home Page is displayed by checking for the presence of the product store logo.
     *
     * @throws InterruptedException if there's an interruption while pausing the test execution.
     */
    @And("^I should be redirected to the Home Page$")
    public void iShouldBeRedirectedToTheHomePage() throws InterruptedException {
        Thread.sleep(3000);
        // Verify if the product store logo is displayed on the Home Page
        Assert.assertTrue(new CartPage().verifyProductStoreLogoIsDisplayed());
    }
}

