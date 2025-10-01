Feature: Inventory Review and Purchase

  Scenario: Verify device details and choose shipping
    Given I am on the Inventory Review page
    Then the Device Summary should show the device type as "Smartphone"
    And the Device Summary should show the brand as "Samsung"
    And the Device Summary should show the storage as "128GB"
    And the Device Summary should show the quantity as "2y"
    When I choose the "Express" shipping option on the Inventory Review page
    And the selected shipping option should be "express"

  Scenario: Apply discount and check pricing
    Given I have selected "2 years" warranty
    And the Shipping cost in the Pricing Breakdown is "R5.00"
    When I enter the discount code "SAVE20"
    And I click the Apply Discount button
    Then the Total value in the Pricing Breakdown is "R950.00" # Example expected value after discount
    And I click the Add to Cart button