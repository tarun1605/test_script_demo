@test
Feature: Customer is able to add least priced product to cart from wishlist
  As a customer - I want to select different products to wishlist
  I want to add a lowest priced product from the wishlist to cart
  I want to see whether the added product is in cart

  Scenario Outline: Customer should be able to add product from wishlist to cart
    Given the customer has navigated to Test script demo page in <Browser Name>
    And the customer has navigated to shop section
    And the customer has added 4 products to wishlist
    And the customer has navigate to wishlist page
    And the customer can see all the added products
    And the customer can search and add the lowest product to cart
    When the customer has navigated to cart
    Then the customer should be able to see selected product in cart
    Examples:
      | Browser Name |
      | Chrome       |
      | Firefox      |
      | Edge         |
