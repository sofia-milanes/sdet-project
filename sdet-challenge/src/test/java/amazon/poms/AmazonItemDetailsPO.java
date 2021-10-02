package amazon.poms;

import org.openqa.selenium.support.PageFactory;

import amazon.config.SetUtils;

public class AmazonItemDetailsPO extends AmazonObjectFactoryPO {
	
	public static AmazonItemDetailsPO getAmazonItemDetailsPage() {
		driver = SetUtils.getDriver();
		page = PageFactory.initElements(driver, AmazonItemDetailsPO.class);
		return (AmazonItemDetailsPO) page;	
	}
	
	public void addToCart() {
		addToCartButton.click();
	}
	
	public void openAmazonCart() {
		cartButton.click();
	}
	
	@Override
	public PageObject getPage() {
		// TODO Auto-generated method stub
		return null;
	}

}
