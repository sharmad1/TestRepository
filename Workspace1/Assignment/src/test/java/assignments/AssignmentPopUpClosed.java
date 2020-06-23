package assignments;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentPopUpClosed {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.softwaretestinghelp.com/handle-alerts-popups-selenium-webdriver-selenium-tutorial-16/");

		driver.findElement(By.cssSelector("[name='sa']")).click();
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		/*
		 * if(driver.findElement(By.cssSelector("[title='Close']")).is()) {
		 * driver.findElement(By.cssSelector("[title='Close']")).click(); }
		 */
		Thread.sleep(1000);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iter = handles.iterator();
		int count = handles.size();
		System.out.println(count);
		String itit = null;
		for (int i = 1; i <= count; i++) {
			itit = iter.next();
			System.out.println(itit);
			driver.switchTo().window(itit);
			System.out.println(driver.getTitle());
		}
		driver.switchTo().defaultContent();
		driver.quit();


	}
}