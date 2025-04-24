package com.excelutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

 
	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Locators
		@FindBy(xpath = "//input[@id='username']")
		WebElement txt_username;
		@FindBy(xpath = "//input[@id='password']")
		WebElement txt_password;
		@FindBy(xpath = "//button[@type='submit']")
		WebElement btn_login;
	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}

	public void enterPassword(String password) {
		txt_password.sendKeys(password);
		;
	}

	public void clickLogin() {
		btn_login.click();
	}
}
