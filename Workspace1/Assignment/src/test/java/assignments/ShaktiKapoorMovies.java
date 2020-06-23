package assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShaktiKapoorMovies {

	private static void countStringOccurences(String[] strArray) {
		HashMap<String, Integer> countMap = new HashMap<String, Integer>();
		for (String string : strArray) {
			if (!countMap.containsKey(string)) {
				countMap.put(string, 1);
			} else {
				Integer count = countMap.get(string);
				count = count + 1;
				countMap.put(string, count);
			}
		}
		printCount(countMap);
	}

	private static void printCount(HashMap<String, Integer> countMap) {
        Set<String> keySet = countMap.keySet();
        for (String string : keySet) {
            System.out.println(string + " : " + countMap.get(string));
        }
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.google.co.in/");
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Shakti Kapoor Filmography");
		driver.findElement(By.xpath("//li[1]/div/div[1]")).click();
		driver.findElement(By.xpath("//h3[text()='Shakti Kapoor filmography - Wikipedia']")).click();
		List<WebElement> rows = driver
				.findElements(By.xpath("//table[1][@class='wikitable sortable jquery-tablesorter']/tbody/tr"));
		int total = rows.size();
	
		String[] uniqueValues = new String[total];
		
		for (int row = 1; row <= total; row++) {
			String value = driver.findElement(By.xpath("//table[1][@class='wikitable sortable jquery-tablesorter']/tbody/tr[" + row + "]/td[1]")).getText();
			uniqueValues[row-1]=value;
		}
		// System.out.println(uniqueValues.size());
		countStringOccurences(uniqueValues);
		driver.close();

	}

}
