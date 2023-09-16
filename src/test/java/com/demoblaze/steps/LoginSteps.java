package com.demoblaze.steps;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    @When("^I click on Login link$")
    public void iClickOnLoginLink() {
new HomePage().clickOnLoginButton();
    }

    @And("^I enter \"([^\"]*)\" in username field$")
    public void iEnterInUsernameField(String username) {
      new LoginPage().enterUserName(username);
    }

    @And("^I enter \"([^\"]*)\" in Password field$")
    public void iEnterInPasswordField(String password)  {
        new LoginPage().enterPassword(password);
    }
    @And("^I Clicking On Login Button$")
    public void iClickingOnLoginButton() {
        new LoginPage().clickOnLoginTab();
    }
    @Then("^Login should be Successful and verify Message 'Welcome Json'$")
    public void loginShouldBeSuccessfulAndVerifyMessageWelcomeJson() throws InterruptedException {
        Assert.assertEquals("User Login Not Successfully","Welcome Json",new LoginPage().verifyMessageWelcomeJson());
    }
}
