package grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelReader;


public class GridTestCase {
	
	public static ExcelReader excel = null;
	public ThreadLocal<DesiredCapabilities> dc = new ThreadLocal<DesiredCapabilities>();
	public static DesiredCapabilities cap;
	
	public ThreadLocal<WebDriver> rdriver = new ThreadLocal<WebDriver>();
	public static RemoteWebDriver driver;
	
	public WebDriver getDriver() {
		return rdriver.get();
	}
	
	public DesiredCapabilities getDesiredCapabilities() {
		return dc.get();
	}
	
	public void setDriver(WebDriver driver) {
		rdriver.set(driver);
	}
	
	public void setCapabilities(DesiredCapabilities cap) {
		dc.set(cap);
	}
	
	@Test(dataProvider="getData")
	public void readData(String browser, String Url) throws MalformedURLException {
		Date d = new Date();
		if (browser.equals("chrome")) {
			cap = new DesiredCapabilities();
			setCapabilities(cap);
			getDesiredCapabilities().setBrowserName("chrome");
			getDesiredCapabilities().setPlatform(Platform.ANY);
			ChromeOptions options = new ChromeOptions();
			options.merge(getDesiredCapabilities());

		} else if (browser.equals("iexplore")) {
			cap = new DesiredCapabilities();
			setCapabilities(cap);
			getDesiredCapabilities().setBrowserName("iexplore");
			getDesiredCapabilities().setPlatform(Platform.WINDOWS);
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.merge(getDesiredCapabilities());

		} else if (browser.equals("firefox")) {
			cap = new DesiredCapabilities();
			setCapabilities(cap);
			getDesiredCapabilities().setBrowserName("firefox");
			getDesiredCapabilities().setPlatform(Platform.ANY);
			FirefoxOptions options = new FirefoxOptions();
			options.merge(getDesiredCapabilities());
		}
	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getDesiredCapabilities());
	setDriver(driver);
	getDriver().get(Url);
	getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	getDriver().manage().window().maximize();
	System.out.println(browser+ " "+ Url + " "+getDriver().getTitle()+" "+d);
	getDriver().quit();
	}
	
	
	/*
	 * @DataProvider(parallel= true) public Object[][] getData1() { Object[][] data
	 * = new Object[6][2];
	 * 
	 * data[0][0] = "chrome"; data[0][1] = "http://cricbuzz.com";
	 * 
	 * data[1][0] = "chrome"; data[1][1] = "http://gmail.com";
	 * 
	 * data[2][0] = "firefox"; data[2][1] = "http://cricinfo.com";
	 * 
	 * data[3][0] = "firefox"; data[3][1] = "http://google.com";
	 * 
	 * data[4][0] = "chrome"; data[4][1] = "http://aajtak.com";
	 * 
	 * data[5][0] = "chrome"; data[5][1] = "http://google.com";
	 * 
	 * 
	 * return data; }
	 */
	
	@DataProvider(parallel= true)
	public Object[][] getData2(){
	
		if (excel==null) {
			excel = new ExcelReader(".//src//test//resources//Excel//TestNG.xlsx");
		}
	String sheetName ="Test1";	
	int rowNum = excel.getRowCount(sheetName);
	int colNum = excel.getColumnCount(sheetName);
	Object [][] data = new Object[rowNum-1][colNum];
	for(int row=2;row<=rowNum;row++) {
		for(int col=0; col<colNum; col++) {
			data[row-2][col] = excel.getCellData(sheetName, col, row);
		}
	}
	return data;
		
	}
	
	@DataProvider(parallel= true)
	public Object[][] getData(){
	
		if (excel==null) {
			excel = new ExcelReader(".//src//test//resources//Excel//TestNG.xlsx");
		}
	String sheetName ="Test1";	
	int rowNum = excel.getRowCount(sheetName);
	int colNum = excel.getColumnCount(sheetName);
	Object [][] data = new Object[rowNum-1][colNum];
	for(int row=2;row<=rowNum;row++) {
		for(int col=0; col<colNum; col++) {
			data[row-2][col] = excel.getCellData(sheetName, col, row);
		}
	}
	return data;
		
	}

}
