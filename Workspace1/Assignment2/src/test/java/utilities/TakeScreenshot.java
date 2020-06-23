package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testCases.BaseClass;

public class TakeScreenshot extends BaseClass {
	public static void captureScreenshot() throws IOException {

		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filePath = System.getProperty("user.dir")+".//screenshot//" + fileName;
		FileUtils.copyFile(screenshot, new File(filePath));

	}
	
}
