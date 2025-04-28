package com.xlutils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownMethods {

	public   WebDriver driver;
    public   WebDriverWait wait;
    
    
	public DropDownMethods(WebDriver driver) {

	   this.driver = driver;
		
       this.wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        
        
	} 

	public void selectbytextList(WebDriver driver,By dropdownlocator, By optionlocator,String visibletext) {

		WebElement drpelement = wait.until(ExpectedConditions.elementToBeClickable(dropdownlocator));
	
		//    drpelement.click();


			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", drpelement);
			js.executeScript("arguments[0].click();", drpelement);

	
		
		// find all elements in options
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(optionlocator));
		
		for(int i=0;i<options.size();i++) {
			
		if(options.get(i).getText().equalsIgnoreCase(visibletext)) {
			
			options.get(i).click();
			
		   break;
			
		}

	}
			

	}
	 
	
	public  void selectbyindex(By dropdownlocator,int index) {
		
		WebElement drpelement=wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownlocator));
		drpelement.click();
				
			Select	s= new Select(drpelement);
		    s.selectByIndex(index);
		
	}
	
	 public  void AllDropdownOptions(By dropdownLocator,int index) {
		 
	        WebElement drpElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownLocator)); 
	        Select s = new Select(drpElement);
	        List<WebElement>op=s.getOptions();
	        for(int i=0;i<op.size();i++) {
	        	
	        op.get(index).click();
	        System.out.println(op.get(i).getText());
	        
	        }
	    }
	
	 
	 public  void selectbylist(By dropdownlocator,By Selectdropdownlocator,int index)
	 {
		 
		// WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		 
     	WebElement salutration = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownlocator));
        salutration.click(); 
  
		List<WebElement>options=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Selectdropdownlocator));
		
		options.get(index).click();
		
	
		 
	 }
	
}
