package testCase1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestElementPresence {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[6]/div[3]/div[7]/a/div[2]/span[1]")).isDisplayed());
		System.out.println(driver.findElement(By.id("searchLanguage")).isDisplayed());
		driver.close();
		
		// isDisplayed only checks visibility
		//Presence can't be checked. It can be done logically by writing a common method and passing locator as By class
	}

}
