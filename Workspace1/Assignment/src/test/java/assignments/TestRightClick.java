package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRightClick {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://deluxe-menu.com/popup-mode-sample.html");
		
		WebElement click = driver.findElement(By.xpath("//*[@src='data-samples/images/popup_pic.gif']"));
		
		Actions action = new Actions(driver);
		
		action.contextClick(click).perform();
		
		WebElement mouseOver = driver.findElement(By.id("dm2m1i2tdT"));
		
		action.moveToElement(mouseOver).perform();
		
		driver.findElement(By.id("dm2m8i1tdT")).click();
		driver.quit();

	}

}
