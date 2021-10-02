package amazon.poms;

import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertEquals;
import amazon.config.SetUtils;

public class AmazonSearchPO extends AmazonObjectFactoryPO {

	public static AmazonSearchPO getAmazonSearchPage() {
		driver = SetUtils.getDriver();
		page = PageFactory.initElements(driver, AmazonSearchPO.class);
		return (AmazonSearchPO) page;	
	}

	public void clickSearchButton() {
		searchButton.click();
	}
	
	public void enterSearchText(String searchText){
		searchBox.sendKeys(searchText);
	}
		
	public void openWebPage(String webPage) {
		driver.get(webPage);
	}
	
	public void clickFirstResult() {
		SetUtils.hardWaitMs(1000);
		if (resultList.size() > 0) {
			resultList.get(0).click();
			}
	}
	
	public void priceComparison(String priceInSearchPage){
		String priceInDetails = priceInsideDetails.getText();
		assertEquals(priceInSearchPage,priceInDetails);
		System.out.println("Prices are the same");
				
	}

	public void deleteLastItemFromCart() {
		cartList.get(0).click();
		SetUtils.hardWaitMs(1000);
	}

}
