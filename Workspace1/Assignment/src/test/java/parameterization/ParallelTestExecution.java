package parameterization;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ParallelTestExecution extends BaseClass {
	
	@Parameters({"browser"})
	@Test(invocationCount = 2, threadPoolSize = 2)
	public void getBrowserTitle(String browser1){
		Date d = new Date();
		System.out.println(browser1);
		WebDriver driver = getBrowser(browser1);
		driver.get("https://www.google.co.in/");
		System.out.println(driver.getTitle()+d);
		driver.quit();
	}
	
}
