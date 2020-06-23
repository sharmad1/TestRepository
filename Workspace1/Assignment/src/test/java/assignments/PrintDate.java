package assignments;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class PrintDate {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		Date d = new Date();
		String FileName = (d.toString().replace(" ", "_").replace(":", "_"))+".jpg";
		System.out.println(FileName);
		/*
		 * File screenshot = ((TakesScreenshot)
		 * driver).getScreenshotAs(OutputType.FILE); FileUtils.copyFile(screenshot, new
		 * File(".//src//test//resources//Screenshot//"+FileName));
		 */

	}

}
