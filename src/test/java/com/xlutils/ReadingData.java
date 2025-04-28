package com.xlutils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.excelutils.BaseClass;

public class ReadingData {

	public static void main(String[] args) throws IOException {

	   //call static method by class name
		BaseClass.setupDriver(); 
		
		WebDriver driver = BaseClass.driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// enter application url
		driver.get("https://zcshorturl.v37.dev.zeroco.de/");

		// calling the userpage
		UserPage up = new UserPage(driver);
		up.lgbutton();

		up.login("admin", "TinyUrl@2025");

		up.adminstration();
        

		// total number of rows from the Excel sheet
		
		String excelpath="C:\\Users\\raj\\git\\repository4\\Myautomation\\src\\test\\resources\\Zc.xlsx";
		String Sheetname="Sheet1";
		 
		
		//reads the rows and get the count of rows 
	//	int rowCount = ExcelUtils.getrowcount(excelpath, Sheetname);
		
		
		//getting the excel data 
		String [][]data=ExcelUtils.getcelldata(excelpath, Sheetname);

		 for (int i = 0; i < data.length; i++) {
	
				
	            String salutation = data[i][0];
	            String firstName = data[i][1];
	            String middleName = data[i][2]; 
	            String lastName = data[i][3];  
	            String email = data[i][4];
	            String mobile = data[i][5];
	            String username = data[i][6];
	            String role = data[i][7];
	            String password = data[i][8];
	            String confirmPassword = data[i][9];
	            
	       try {
	       
	        up.userdetails(salutation, firstName,middleName,lastName, email, mobile, username,role, password, confirmPassword);
            
         
	        System.out.println(salutation+ " |" + firstName+  " |  "+middleName+ " |  "+lastName+ "  | "+ email+ "  | " +mobile+ " | "+ username + " | "+role+ " | " + password + " | " + confirmPassword);
	
	        
            String msg=  up.getsuccessfailuremsg();
        

            ExcelUtils.writecelldata(excelpath, Sheetname, i, 10, msg);
    
            
            
             up.ClickCancel();
  
            Thread.sleep(5000);
            


	         }catch(Exception e) {
	    	   
	    	//   System.out.println(e.getMessage());
	         }
	
       
             up.clickAddAgain();
             


		 }
		 
		
		 BaseClass.quitDriver();
	}

}
