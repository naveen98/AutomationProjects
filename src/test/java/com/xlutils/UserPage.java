package com.xlutils;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.excelutils.BaseClass;

    public class UserPage {

	public WebDriver driver;

	public WebdriverwaitsMethod wait;

	DropDownMethods dd;

	// Constructor
	public UserPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

		dd = new DropDownMethods(driver);
		wait = new WebdriverwaitsMethod(driver);

	}

	// login Button
	By lgbtn = By.xpath("//button[@class='btn login-btn']");
	//Login credentials
	By txtusername = By.xpath("//input[@id='appUserName']");
	By txtpassword = By.xpath("//input[@id='appPassword']");
    // click on login 
	By btnbutton = By.xpath("//button[@type='submit']");

	
	// click on admin
	By admclick = By.xpath("(//div[@class='mngdescription'])[1]");
	// extract sidemodule
	By extclick = By.xpath("//a[@class='icon-angle-right sidebar-toggle d-flex']");
	// click on user module
	By drpclick = By.xpath("(//a[@class='nav-link nav-dropdown-toggle ng-star-inserted'])[2]");
	// click on sub module
	By userclick = By.xpath("(//span[@class='nav-link-text'])[4]");
	// click on add button
	By addclick = By.xpath("//i[@class='icon-plus-1 ng-star-inserted']");
	
	
	// user creation form:
	                           // drop down fields
	By salutationDropdown = By.xpath("//p-dropdown[@placeholder='Select']");
	By salutationOptions = By.xpath("//li[@role='option']");

	
	By firstname = By.xpath("//input[@id='first_name']");
	By middilename = By.xpath("//input[@placeholder='Enter middle name']");
	By lastname = By.xpath("//input[@id='last_name']");

	By emailid = By.xpath("//input[@id='email']");
	By mobilenumber = By.xpath("(//input[@id='phone'])[1]");
	By username = By.xpath("//input[@id='login_unique']");

	                         // dropdownfields
	By rolodropdown = By.xpath("//p-dropdown[@placeholder='Select role']");
	By roleoptions = By.xpath("//li[@role='option']");

	By password = By.xpath("//input[@id='password']");
	By confirmpassword = By.xpath("(//input[@type='password'])[3]");

	By savebutton = By.xpath("(//button[@type='button'])[3]");
	
	

	//popup  messages
	By popupmsg = By.className("modal-body");
	
	
    //click on ok 
	By popbtn = By.xpath("//button[@id='dialog-okay-btn']");
	
	
	//capture the validation message
	By mobnumerror = By.id("field-error-text_7161");
	
	


	
	
	
   // dialogbox toast messages	


	public String getPopupMessage() {
    try {
		wait.waitforclickable(popupmsg);
		WebElement message=driver.findElement(popupmsg);
		return message.getText();

	}
      catch(Exception e) {
	
	
	System.out.println("No message found"+ " "+e.getMessage());
      
        return null;
      }
	}
	
	
	public void closepopup() {

	    try {
	        wait.waitforclickable(popbtn); 
	        driver.findElement(popbtn).click();
	        
	    } catch (Exception e) {
	        System.out.println("ok button not clickable");
	    }
	}

	
	public String mobvalidation() {
		
		   try {
			   
		        wait.waitforclickable(mobnumerror);  
		        
		        return driver.findElement(mobnumerror).getText();
		    } 
		       catch (Exception e)
		   {
		        System.out.println("Mobile validation message not found " + e.getMessage());
		        return null;
		    }
		}
	
	
	
	// action methods

	public void lgbutton() {

		wait.clickElement(lgbtn);

	}

	public void login(String un, String pwd) {

		wait.enterText(txtusername, un);
		wait.enterText(txtpassword, pwd);
		wait.clickElement(btnbutton);

	}

	public void adminstration() {

		wait.clickElement(admclick);
		wait.clickElement(extclick);
		wait.clickElement(drpclick);
		wait.clickElement(userclick);
		wait.clickElement(addclick);

	}

	public void userdetails(String sal, String fname, String midname, String lname, String email, String mobilenum,
			String uname, String rol, String pwd, String cnfpwd) {

		dd.selectbytextList(driver, salutationDropdown, salutationOptions, sal);

		wait.enterText(firstname, fname);
		wait.enterText(middilename, midname);
		wait.enterText(lastname, lname);
		wait.enterText(emailid, email);
		wait.enterText(mobilenumber, mobilenum);
		wait.enterText(username, uname);
		dd.selectbytextList(driver, rolodropdown, roleoptions, rol);
		wait.enterText(password, pwd);
		wait.enterText(confirmpassword, cnfpwd);

		// wait.waitforclickable(savebutton);
		wait.clickElement(savebutton);
		
		wait.clickElement(popbtn);


	}


}
