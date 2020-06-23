package assignments;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://timesofindia.indiatimes.com/home/polls");
		driver.findElement(By.xpath("//input[@class='radio1'][@value='2']")).click();
		try {
			String[] text = driver.findElement(By.cssSelector("#mathq")).getText().split("=");
			String[] value = (text[0].trim().split("\\+"));
			int value1 = Integer.parseInt(value[0].trim());
			int value2 = Integer.parseInt(value[1].trim());
			String total = String.valueOf(value1 + value2);
			driver.findElement(By.cssSelector("#mathuserans")).click();
			driver.findElement(By.cssSelector("#mathuserans")).sendKeys(total);
			driver.findElement(By.xpath("//div[@class='homesprite vot']")).click();
			System.out.println("displayed 1");
		} catch (Throwable t) {
			System.out.println(t.getMessage());
			System.out.println("Not displayed 1");
			driver.close();
		}

		Set<String> handles = driver.getWindowHandles();
		try {
			if (handles.size() > 1) {
				System.out.println(handles.size());
				System.out.println("Displayed 2");
				driver.quit();
			}
		} catch (Throwable t) {
			t.getMessage();
			System.out.println("Error 2");
			driver.quit();
		}

	}

}
