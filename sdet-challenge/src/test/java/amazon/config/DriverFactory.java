package amazon.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	private static final Map<String, Supplier<WebDriver>> BROWSERS = new HashMap<String, Supplier<WebDriver>>();

	private static final Supplier<WebDriver> chromeSupplier = () -> {
		//System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver");
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		return new ChromeDriver(chromeOptions);
	};
	
	private static final Supplier<WebDriver> firefoxSupplier = () -> {
		//System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver");
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\geckodriver");
		return new FirefoxDriver();
	};

	private static final Supplier<WebDriver> IESupplier = () -> {
		return null;
	};

	static {
		BROWSERS.put("chrome", chromeSupplier);
		BROWSERS.put("firefox", firefoxSupplier);
		BROWSERS.put("ie", IESupplier);
	}

	public static WebDriver getDriver(String name) {
		return BROWSERS.get(name).get();
	}

	public static WebDriver getChromeDriver() {
		return getDriver("chrome");
	}

	public static WebDriver getFirefoxDriver() {
		return getDriver("firefox");
	}

	public static WebDriver getIEDriver() {
		return getDriver("ie");
	}

	public static WebDriver getDriver() {
		System.out.println("Using ChromeDriver");
		return new ChromeDriver();
	}
}
