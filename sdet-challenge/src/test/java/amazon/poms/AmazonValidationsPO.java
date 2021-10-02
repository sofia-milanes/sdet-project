package amazon.poms;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import amazon.config.SetUtils;

public class AmazonValidationsPO extends AmazonObjectFactoryPO {
	
	public static AmazonValidationsPO getAmazonSearchPage() {
		driver = SetUtils.getDriver();
		page = PageFactory.initElements(driver, AmazonValidationsPO.class);
		return (AmazonValidationsPO) page;
	}
	
	public void validatePricesInDetailsPage() {
		String priceInResults = priceResultList.get(1).getText().replaceAll("\n", ".");
		AmazonSearchPO.getAmazonSearchPage().clickFirstResult();
		AmazonSearchPO.getAmazonSearchPage().priceComparison(priceInResults);	
	}
	
	public void validatePricesInCartPage() {
		String priceInDetails = priceInsideDetails.getText();
		AmazonItemDetailsPO.getAmazonItemDetailsPage().addToCart();
		AmazonItemDetailsPO.getAmazonItemDetailsPage().openAmazonCart();
		String priceInCart = priceInsideCart.getText();
		assertEquals(priceInDetails,priceInCart);
	}

	public void validateCartIsEmpty() {
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.textToBePresentInElement(cartIsEmptyText, "Your Amazon Cart is empty."));
		
		System.out.println(cartIsEmptyText.getText());
		System.out.println("Total Items in Cart = " + carItemList.size());
		assertTrue("Items successfully deleted, Cart is empty", carItemList.size()==0 );
		assertEquals(cartIsEmptyText.getText(),"Your Amazon Cart is empty.");
		
		
	}
}
