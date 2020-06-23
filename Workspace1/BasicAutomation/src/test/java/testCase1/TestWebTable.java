package testCase1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> row = driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr"));
		System.out.println(row.size());
		List<WebElement> Column = driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr[1]/td"));
		System.out.println(Column.size());
		
		for(int i=1;i<=row.size();i++) {
			for(int j=1;j<=Column.size();j++ ) {
				System.out.print(driver.findElement(By.xpath("//*[@class='dataTable']/tbody/tr["+i+"]/td["+j+"]")).getText()+"    ");
			}
			System.out.println();
		}
		
	}

}
