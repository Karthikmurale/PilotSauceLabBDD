@Alltest
Feature: Commerce Test Cases
  @Logintest
  Scenario: Verify Login functionality
    Given I am on the login page
    When I enter my "standard_user" and "secret_sauce"
    And I click on the login button
    Then I should be redirected to the homepage

  @TshirtOrder
  Scenario: Verify Sauce Labs Bolt TShirt
    Given I am on the login page
    When I enter my "standard_user" and "secret_sauce"
    And I click on the login button
    Then I should be redirected to the homepage
    And I choose "Sauce Labs Bolt T-Shirt" Product from Inventory page
    And I select the cart and validate the Product "Sauce Labs Bolt T-Shirt"
    And I click on the continue button in cart page
    And I write firstname as "joseph" lastname as "vijay" Postalcode as "603945" and click continue in checkoutpage
    Then I click finish button in checkout page

  @BackPackOrder
  Scenario: Verify Sauce Labs Backpack
    Given I am on the login page
    When I enter my "standard_user" and "secret_sauce"
    And I click on the login button
    Then I should be redirected to the homepage
    And I choose "Sauce Labs Backpack" Product from Inventory page
    And I select the cart and validate the Product "Sauce Labs Backpack"
    And I click on the continue button in cart page
    And I write firstname as "joseph" lastname as "vijay" Postalcode as "603945" and click continue in checkoutpage
    Then I click finish button in checkout page


