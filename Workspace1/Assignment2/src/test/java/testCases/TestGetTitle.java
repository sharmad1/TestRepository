package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestGetTitle extends BaseClass {
	
	@Parameters({"browser"})
	@Test
	public void test1(String browser) {
		WebDriver driver = getBrowser(browser);
		String title = getTitle(driver);
		
		assertEquals(title, "Google");
	}
	
	@AfterTest
	public void terminateBrowse(){
		driver.quit();
	}

	
}
