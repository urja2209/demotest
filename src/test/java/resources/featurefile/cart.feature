Feature: Cart Test
  As a user, I should add the product to the cart and place the order successfully.

@CartPage
  Scenario: User should be able to add items to cart and place the order successfully
    Given I am on the homepage
    When  I mouse hover on and click on Iphone Item
    And   I click On Add To Cart Button
    Then  Product should be added successfully  and verify Message 'Product added'
    And   I click on OK Button in Popup
    And   I click on Cart Tab
    Then Verify that Product added successfully to the cart
    And   I click on Place Order Button
    And  I fill below details in Place Order form
      |Mr Smith|United Kingdom|London|5105105105105100|12|2025|
    And   I click on Purchase Button
    Then Thank You For Your Purchase message should be displayed
    And I click on OK
    And I should be redirected to the Home Page