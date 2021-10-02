package amazon.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import amazon.config.SetUtils;
import io.cucumber.java.After;

public class Hooks {
	
	public static WebDriver driver;
	
	@Before
	public static void beforeSuite(){
		/*
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sofia.milanes\\eclipse-workspace\\libs\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();*/
	}
	
	@After
	public static void afterSuite(){
		//driver.quit();
		SetUtils.getDriver().quit();
	}


}
