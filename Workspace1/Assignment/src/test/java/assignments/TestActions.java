package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestActions {
// This is to test mouse over actions
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.co.in/");
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Way2Automation");
		driver.findElement(By.xpath("//li[1]/div/div[1]")).click();
		driver.findElement(By.xpath("//h3[text()='Way2Automation']")).click();
		
		WebElement menu = driver.findElement(By.xpath("//a[text()='Resources']"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(menu).perform();
		driver.findElement(By.xpath("//a[@href='http://qa.way2automation.com']")).click();
		driver.close();
	}

}
