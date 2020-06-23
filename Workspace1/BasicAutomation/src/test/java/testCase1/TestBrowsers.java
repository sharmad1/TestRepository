package testCase1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowsers {
// ChromeDriver extends RemoteWebDriver. Very Important
// WebDriver extends SearchContext

	public static String browser = "Chrome";
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		// CTRL +SHIFT +F
		if (browser == "Chrome") {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); // Can also write ChromeDriver driver = new ChromeDriver();
		} else if (browser == "Firefox") {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); // Can also write ChromeDriver driver = new ChromeDriver();
		} else if (browser == "IE") {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver(); // Can also write ChromeDriver driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String url = "http://dev.gbipuns.sncorp.smith-nephew.com/";
		String userId = "sharmad1";
		String password = "Gangasahar123*";
		driver.get(url);

		String title = driver.getTitle();
		driver.manage().window().maximize();
		System.out.println(title.length());
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/header/div[1]/div/div[3]/div/span[2]")).click();

		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div/div[1]/input")).sendKeys(userId);

		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div/div[2]/input")).sendKeys(password);

		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div/button")).click();
		String text = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div/p")).getText();
		System.out.println(text);

		/*
		 * driver.close(); // Closes the current window driver.quit(); // Closes all
		 * associated window in the current session
		 */ }

}
