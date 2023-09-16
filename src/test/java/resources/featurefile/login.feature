Feature: Login Test
  As a user navigation to Login Page

  @LoginPage
  Scenario: User should login successfully
    Given I am on the homepage
    When  I click on Login link
    And   I enter "Json" in username field
    And   I enter "martin" in Password field
    And   I Clicking On Login Button
    Then  Login should be Successful and verify Message 'Welcome Json'

#  I knowingly failed the test case to show the results in the reports
  @LoginPage
  Scenario: User should login successfully
    Given I am on the homepage
    When  I click on Login link
    And   I enter "Json1" in username field
    And   I enter "martin" in Password field
    And   I Clicking On Login Button
    Then  Login should be Successful and verify Message 'Welcome Json'