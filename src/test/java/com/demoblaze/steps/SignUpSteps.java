package com.demoblaze.steps;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.SignUpPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SignUpSteps {
    @Given("^I am on the homepage$")
    public void iAmOnTheHomepage() {
    }
    @When("^I click on SignUp link$")
    public void iClickOnSignUpLink() {
new HomePage().clickOnSignUpButton();
    }

    @And("^I enter userName in username field$")
    public void iEnterUserNameInUsernameField() {
        new SignUpPage().enterUserName();
    }
    @And("^I enter \"([^\"]*)\" in password field$")
    public void iEnterInPasswordField(String password)   {
new SignUpPage().enterPassword(password);
    }
    @And("^I Clicking On SignUp Button$")
    public void iClickingOnSignUpButton() {
new SignUpPage().clickOnSigunUp();
    }
    @Then("^Sign Up Successful pop-up should be displayed$")
    public void signUpSuccessfulPopUpShouldBeDisplayed() throws InterruptedException {
Thread.sleep(3000);
        Assert.assertEquals("User Sign Up Not Successfully","Sign up successful.",new SignUpPage().getTextFromAlert());
    }
    @And("^I click on OK Button$")
    public void iClickOnOKButton() {
        new SignUpPage().clickOnOk();
    }
}
