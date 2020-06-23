package assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
	@Test
	public void Assin1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.co.in/");
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Way2Automation");
		driver.findElement(By.xpath("//li[1]/div/div[1]")).click();
		driver.findElement(By.xpath("//h3[text()='Way2Automation']")).click();
		
		List<WebElement> tags = driver.findElements(By.tagName("a"));
		System.out.println(tags.size());
		for(WebElement tag: tags) {
			if(tag.getText().length()>0) 
			System.out.println(tag.getText());
		}
		
		driver.close();
		
	}

}
