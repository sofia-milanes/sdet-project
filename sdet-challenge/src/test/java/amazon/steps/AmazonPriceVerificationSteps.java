package amazon.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import amazon.poms.AmazonSearchPO;
import amazon.poms.AmazonValidationsPO;

public class AmazonPriceVerificationSteps {

	@Given("Amazon web page is open {string}")
	public void amazon_web_page_is_open(String webPage){
		AmazonSearchPO.getAmazonSearchPage().openWebPage(webPage);
	}
	
	@When("I perform the search {string}")
	public void i_perform_the_search(String searchText) {
		AmazonSearchPO.getAmazonSearchPage().enterSearchText(searchText);
		AmazonSearchPO.getAmazonSearchPage().clickSearchButton();
	}
	
	@And("I store the first price in results to compare with details page")
	public void i_store_the_first_price_in_results_to_compare_with_details_page() throws Exception {
		AmazonValidationsPO.getAmazonSearchPage().validatePricesInDetailsPage();
	}
	
	@And("I add it to cart to compare the price in cart page")
	public void  i_add_it_to_cart_to_compare_the_price_in_cart_page() {
		AmazonValidationsPO.getAmazonSearchPage().validatePricesInCartPage();
	}
	
	@And("delete the item from the cart")
	public void delete_the_item_from_the_cart() {
		AmazonSearchPO.getAmazonSearchPage().deleteLastItemFromCart();
	}
	
	@Then("I validate item was removed")
	public void i_validate_item_was_removed() {
		AmazonValidationsPO.getAmazonSearchPage().validateCartIsEmpty();
	}
}
