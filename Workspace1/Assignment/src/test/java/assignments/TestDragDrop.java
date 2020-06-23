package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDragDrop {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.cssSelector("._2AkmmA._29YdH8")).click();
		
		Actions action = new Actions(driver);
		WebElement menu = driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/ul/li[3]/span"));
		WebElement menu1 = driver.findElement(By.cssSelector("a[title='Shirts']"));
		
		action.moveToElement(menu).perform();
		menu1.click();
		WebElement slider = driver.findElement(By.xpath("//*[@id='container']/div/div[3]/div[2]/div/div[1]/div/div/div/section[2]/div[3]/div[1]/div[1]/div"));
		Thread.sleep(3000);
		int size = driver.findElement(By.xpath("//div[@class='gl5Kwg']")).getSize().width/2;
		System.out.println(size);
		action.dragAndDropBy(slider, 50, 0);
		
		
		
	}

}
