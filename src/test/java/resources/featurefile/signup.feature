Feature: SignUp Test
  As a user, I should be navigated to SignUp Page

  @SignUpPage
  Scenario: User should sign up successfully
    Given I am on the homepage
    When  I click on SignUp link
    And   I enter userName in username field
    And   I enter "cena" in password field
    And   I Clicking On SignUp Button
    Then  Sign Up Successful pop-up should be displayed
    And   I click on OK Button