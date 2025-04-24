package com.xlutils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverwaitsMethod {
     public  WebDriver driver;
   
     public WebDriverWait wait;
     
            public WebdriverwaitsMethod(WebDriver driver) {
    	 
    	this. driver=driver;
    	this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    	
     }
     
     public WebElement waitforvisibility(By locator) {
    	   
    	  return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    	 
    	 
     }
    

     
     public void waitforallelements(By locator) {
    	 
    	 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    	 
     }
     
     
     
     public void enterText(By locator, String text) {
         WebElement element = waitforvisibility(locator);
         element.sendKeys(text);
         element.clear();
     }
     
     
     
     public WebElement waitforclickable(By locator) {
    	 
    	return wait.until(ExpectedConditions.elementToBeClickable(locator));
    	 
    	 
     }
     
         public void clickElement(By locator) {
            waitforclickable(locator).click();
     }

}
