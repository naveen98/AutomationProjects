package com.excelutils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	 public static WebDriver driver;
	   

	    @BeforeClass 
	    public static void setupDriver() {
	      
	        driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	    
	        
	    }
	    @AfterClass
	    public static void quitDriver() {
	        if (driver != null) {
	            driver.quit();
	        }
	    
}
}