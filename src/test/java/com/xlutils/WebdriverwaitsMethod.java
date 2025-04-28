package com.xlutils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverwaitsMethod {
     public  WebDriver driver;
   
     public WebDriverWait wait;
     
        public WebdriverwaitsMethod(WebDriver driver) {
    	 
    	this. driver=driver;
    	this.wait=new WebDriverWait(driver,Duration.ofSeconds(60));
    	
     }
     
     public WebElement waitforvisibility(By locator) {
    	   
    	  return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    	 
    	 
     }
    

     public void waitforallelements(By locator) {
    	 
    	 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    	 
     }
     

     //Enter Text into fields
     public void enterText(By locator, String text) {
         WebElement element = waitforvisibility(locator);
         element.clear();
         element.sendKeys(text);
        
     }

     public WebElement waitforclickable(By locator) {
    	 
    	return wait.until(ExpectedConditions.elementToBeClickable(locator));
    	 
    	 
     }
     
         public WebElement clickElement(By locator) {
          WebElement element=waitforclickable(locator);
          JavascriptExecutor js=(JavascriptExecutor)driver;
          js.executeScript("arguments[0].click();", element);
		return element;
          
     }
         
         public void waitForInvisibility(By locator) {
        	    wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        	}



      public WebElement waitforvisibilityreturn(By locator) {
          return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
   }
}