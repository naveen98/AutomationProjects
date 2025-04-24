package com.xlutils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
		// open application
		driver.get("https://zcshorturl.v37.dev.zeroco.de/zcbase/account/login");

		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(60));

		driver.manage().window().maximize();
		// entering usernamre
		WebElement username = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='undefined']")));
		username.sendKeys("admin");
		// password
		driver.findElement(By.xpath("//input[@id='appPassword']")).sendKeys("TinyUrl@2025");
		driver.findElement(By.xpath("//button[@id='loginBtn']")).click();

		// click on adminstration
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='administration']"))).click();

		// extract side module toggle
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@class='icon-angle-right sidebar-toggle d-flex']"))).click();

		// click on user module

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='nav-link-text'])[3]")))
				.click();
		// sub module
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='nav-link-text'])[4]")))
				.click();

		// click on add button
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-plus-1 ng-star-inserted']")))
				.click();

		// dropdown field

		WebElement saludrp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//p-dropdown[@placeholder='Select']")));

		saludrp.click();
		
		List<WebElement >sel=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@role='option']")));
	//	sel.click();
		
		sel.get(2).click();
		
//		for(int i=0;i<sel.size();i++) {
//			
//			
//			sel.get(i).click();
//			
//	
//		}
		


		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("naveen");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("(//input[@id='phone'])[1]")).sendKeys("9876543234");
		driver.findElement(By.xpath("//input[@id='login_unique']")).sendKeys("user1");

		
		//role dropdown
		WebElement drprole = driver.findElement(By.xpath(
				"//p-dropdown[@placeholder='Select role']"));
		drprole.click();

		WebElement roleli=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[@role='option'])[3]")));
		roleli.click();
		
		
	

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Abc@1345678");
		driver.findElement(By.xpath("(//input[@type='password'])[3]")).sendKeys("Abc@1234567");
		driver.findElement(By.xpath("//button[@id='btnSave']")).click();

	}

}
