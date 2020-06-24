import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MavenTest {
		
		public static WebDriver driver;
		
		@BeforeTest
		public void setUp(){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		@Test
		public void launchWebSite() {
			driver.get("http://google.com");
			driver.getTitle();
		}
		
		@AfterTest
		public void tearDown() {
			driver.quit();
		}

}
