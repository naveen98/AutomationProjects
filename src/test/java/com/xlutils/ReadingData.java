package com.xlutils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.excelutils.BaseClass;

public class ReadingData {

	public static void main(String[] args) throws IOException {

	   //call static method by class name
		BaseClass.setupDriver(); 
		
		WebDriver driver = BaseClass.driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// enter application url
		driver.get("https://zcshorturl.v37.dev.zeroco.de/");

		// calling the userpage
		UserPage up = new UserPage(driver);
		up.lgbutton();

		up.login("admin", "TinyUrl@2025");

		up.adminstration();
        

		// total number of rows from the Excel sheet
		
		String excelpath="C:\\Users\\raj\\eclipse-workspace1\\Myautomation\\src\\test\\resources\\zcurl.xlsx";
		
		
		//reads the rows and get the count of rows 
		int rowCount = ExcelUtils.getrowcount(excelpath, "userform");
		
		
		//getting the excel data 
		String [][]data=ExcelUtils.getcelldata(excelpath, "userform");

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
	            
	            
	            
	       
	       up.userdetails(salutation, firstName,middleName,lastName, email, mobile, username,role, password, confirmPassword);
            
           System.out.println(salutation+ " |" + firstName+  " |  "+middleName+ " |  "+lastName+ "  | "+ email+ "  | " +mobile+ " | "+ username + " | "+role+ " | " + password + " | " + confirmPassword);
		
           
           String popmessage=up.getPopupMessage();
           
           System.out.println(popmessage);
           
           up.closepopup();    
           
          
           String mobnumval=up.mobvalidation();
           
           System.out.println(mobnumval);
           
           
           
          
           
           
		 }
		 
	}

}
