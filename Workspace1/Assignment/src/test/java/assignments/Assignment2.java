package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String name = "Dhruv DS";
		String country = "India";
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		driver.findElement(By.cssSelector("[name=name")).sendKeys(name);
		driver.findElement(By.xpath("//*[@name='country']")).getAttribute(country);
		driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("1234552177");
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys("ajshbc@gmail.com");
		driver.findElement(By.xpath("//*[@name='city']")).sendKeys("Delhi");
		driver.findElement(By.xpath("//div[@id='load_box']/form/fieldset/input[@name='username']")).sendKeys("Tisdtle1112");
		driver.findElement(By.xpath("//div[@id='load_box']/form/fieldset/input[@name='password']")).sendKeys("Tisdtliie");
		driver.findElement(By.xpath("//div[@id='load_box']/form/div/div/input[@type='submit']")).click();
		
		if(driver.findElement(By.xpath("//img[@src='images/logo.png']")).isEnabled()) {
			System.out.println("Passed");
		}
	}

}
