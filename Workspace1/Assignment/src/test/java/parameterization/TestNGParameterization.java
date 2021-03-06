package parameterization;
import utilities.*;

import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGParameterization {
	public static ExcelReader excel = null;
	@Test(enabled=false,dataProvider = "getData")
	public void doLogin(String Username, String Password, String is_Correct) throws InterruptedException {
		System.out.println(Username+" "+Password+" "+" "+is_Correct);
		Date d = new Date();
		System.out.println(d);
		Thread.sleep(3000);
		
	}
	
	@DataProvider
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
