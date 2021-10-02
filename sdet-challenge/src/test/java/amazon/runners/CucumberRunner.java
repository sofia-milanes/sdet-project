package amazon.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import amazon.steps.Hooks;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features/ui", 
		glue="amazon.steps",
		monochrome = true,
		tags="@PriceVerification"
		)

public class CucumberRunner {
	
	@BeforeClass
	public static void setup() {
		//Hooks.beforeSuite();
	}
	
	@AfterClass
	public static void teardown() {
		//Hooks.afterSuite();
	}

}
