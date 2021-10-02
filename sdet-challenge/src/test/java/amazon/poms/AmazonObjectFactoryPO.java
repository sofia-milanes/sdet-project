package amazon.poms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.config.SetUtils;

public class AmazonObjectFactoryPO extends PageObject {
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement searchBox;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement searchButton;
	
	@FindBy(xpath = "//*[@id='search']//div/h2/a")
	List<WebElement> resultList;
	
	@FindBy(xpath = "//span[@class='a-price']/span")
	List<WebElement> priceResultList;
	
	public WebElement priceResultList1() {
		return driver.findElement(By.xpath("//span[@class='a-price']/span[1]"));
	}
	
	@FindBy(xpath = "//span[@id='price_inside_buybox']")
	WebElement priceInsideDetails;

	@FindBy(xpath="//p[@class='a-spacing-mini']")
	WebElement priceInsideCart;
	
	@FindBy(xpath="//span[@data-action='delete']")
	WebElement deleteButton;
	
	@FindBy(xpath = "//input[@value='Delete']")
	List<WebElement> cartList;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addToCartButton;
	
	@FindBy(xpath="//div[@id='nav-cart-count-container']")
	WebElement cartButton;
	
	@FindBy(xpath="//h1")
	WebElement cartIsEmptyText;
	
	@FindBy(xpath="//span[@id='sc-subtotal-label-activecart']")
	WebElement cartEmptyText;
	
	@FindBy(xpath = "//form//div//ul")
	List<WebElement> carItemList;
	
	@FindBy(xpath="//body//div//span[@class='a-offscreen']")
	List<WebElement> pricesResultList;
	
	public static String[] myStringArray1 = {null};

	
	@Override
	public PageObject getPage() {
		driver = SetUtils.getDriver();
		page = PageFactory.initElements(driver, AmazonObjectFactoryPO.class);
		return (AmazonObjectFactoryPO) page;
	}


}
