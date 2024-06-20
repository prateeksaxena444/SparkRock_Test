Feature: SauceDemo Inventory Page

  Background:
    Given I am on the SauceDemo login page
    When I enter the username "standard_user"
    And I enter the password "secret_sauce"
    And I click the "Login" button
    Then I should be redirected to the inventory page

  @product_listing
  Scenario: Display Products
    Given I am on the inventory page
    Then I should see a list of products
    And each product should have a name, price, image, and description

  @product_listing
  Scenario: Product Sorting
    Given I am on the inventory page
    When I select "Name (A to Z)" from the sorting dropdown
    Then the products should be sorted alphabetically by name in ascending order
    When I select "Name (Z to A)" from the sorting dropdown
    Then the products should be sorted alphabetically by name in descending order
    When I select "Price (low to high)" from the sorting dropdown
    Then the products should be sorted by price in ascending order
    When I select "Price (high to low)" from the sorting dropdown
    Then the products should be sorted by price in descending order

  @product_listing
  Scenario: View Product Details
    Given I am on the inventory page
    When I click on a product
    Then I should be redirected to the product details page
    And the product details page should display the product name, price, image, and description

  @cart_operations
  Scenario: Add to Cart
    Given I am on the inventory page
    When I click the "Add to cart" button for a product
    Then the "Add to cart" button should change to "Remove" for the added product
    And the cart icon should update with the correct number of items

  @cart_operations
  Scenario: Remove from Cart
    Given I am on the inventory page
    And I have added a product to the cart
    When I click the "Remove" button for the product in the cart
    Then the "Remove" button should change back to "Add to cart" for the removed product
    And the cart icon should update with the correct number of items

  @cart_operations
  Scenario: View Cart
    Given I am on the inventory page
    And I have added products to the cart
    When I click the cart icon
    Then I should be redirected to the cart page
    And the cart page should display the added products with their name, price, and quantity
