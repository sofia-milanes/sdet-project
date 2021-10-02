@TestUI @AmazonPriceVerification
Feature: Amazon items price verification

  @PriceVerification
  Scenario: Verify item price in cart and delete it 
  	Given Amazon web page is open "http://amazon.com"
    When I perform the search "Samsung Galaxy Note 20"
    And I store the first price in results to compare with details page
    And I add it to cart to compare the price in cart page
    And delete the item from the cart
    Then I validate item was removed
 
    

