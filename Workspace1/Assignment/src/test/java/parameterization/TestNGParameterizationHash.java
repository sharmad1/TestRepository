package parameterization;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelReader;

/*
* Create a public variable for excel
* In @Test, use Hashtable<String, String> data
* Create an object of Hashtable in your data provider
* Use table.put to insert key value pair
*/
public class TestNGParameterizationHash {
	public static ExcelReader excel = null;

	@Test(dataProvider = "getData")
	public void doLogin(Hashtable<String,String> data) {
		System.out.println(data.get("UserName")+(data.get("Password")));
	}

	@DataProvider
	public Object[][] getData() {
		
		if (excel == null) {
			excel = new ExcelReader(".//src//test//resources//Excel//TestNG.xlsx");
		}
		String sheetName = "Test1";
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rowNum-1][1];
		Hashtable<String, String> table = null;
		for (int row = 2; row <= rowNum; row++) {
			table = new Hashtable<String, String>();
			for (int col = 0; col < colNum; col++) {
				table.put(excel.getCellData(sheetName, col, 1), excel.getCellData(sheetName, col, row));
				data[row-2][0] = table;
			}
		}
		return data;

	}

}
