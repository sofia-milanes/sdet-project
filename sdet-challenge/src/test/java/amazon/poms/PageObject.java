package amazon.poms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public abstract class PageObject {
	protected static WebDriver driver;
	protected static PageObject page;

	public void waitForVisibility(WebElement element) throws Error {
		getPage();
		waitForVisibility(element);
	}
	

	public void click(WebElement element) throws Error {
		try {
			click(element);
		} catch (Exception e) {
			for (int i = 0; i < 3; i++) {
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					element.click();
					break;
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	public void clickJS(WebElement element) throws Error {
		waitForVisibility(element);
		clickJS(element);
	}

	public void sendKeys(WebElement element, String keys) {
		try {
			waitForVisibility(element);
			element.sendKeys(keys);
		} catch (Exception e) {
			for (int i = 0; i < 3; i++) {
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					element.sendKeys(keys);
					break;
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	public void sendKeys(WebElement element, Keys keys) {
		try {
			waitForVisibility(element);
			element.sendKeys(keys);
		} catch (Exception e) {
			for (int i = 0; i < 3; i++) {
				try {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					element.sendKeys(keys);
					break;
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	public abstract PageObject getPage();

	public static boolean isDisplayed(WebElement element) {
		try {
			if (element.isDisplayed()) {
				return true;
			}
		} catch (NullPointerException | NoSuchElementException e) {
			System.err.println("Unable to locate element ");
		} catch (Exception e) {
			System.err.println("Unable to check display status of element ");
			e.printStackTrace();
		}
		return false;
	}

}
