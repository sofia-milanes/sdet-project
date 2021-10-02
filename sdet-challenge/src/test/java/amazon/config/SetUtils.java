package amazon.config;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetUtils {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		initializeDriver();
		new WebDriverWait(driver, 1000);
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		SetUtils.driver = driver;
	}
	
	private static void initializeDriver() {
		if (!isDriverActive()) {
			driver = DriverFactory.getDriver();
			//Adding the implicitlyWait required
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	}
		
	public static boolean isDriverActive() {
		return driver != null && ((RemoteWebDriver) driver).getSessionId() != null;
	}
	
	public static void hardWaitMs(int mlseconds) {
		try {
			Thread.sleep(mlseconds);
		} catch (Exception e) {
		}

	}

	

}
