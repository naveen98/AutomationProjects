package Excelutil;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.excelutils.BaseClass;
import com.excelutils.ExcelRead;
import com.excelutils.LoginPage;

public class Test_LoginExcel extends BaseClass {


	@Test
	public void testLogin() {
		// Read data from Excel
		
		String[][] testData = ExcelRead.readExcel("C:\\Users\\raj\\eclipse-workspace1\\Myautomation\\src\\test\\resources\\logdata.xlsx", "Sheet1");

		for (String[] credentials : testData) {
			 // First column (Username)
			String username = credentials[0]; 
			// Second column (Password
			String password = credentials[1]; 

			driver.get("https://the-internet.herokuapp.com/login");
			LoginPage lp = new LoginPage(driver);

			// Perform login actions
			lp.enterUsername(username);
			lp.enterPassword(password);
			lp.clickLogin();

		}
	}
}
