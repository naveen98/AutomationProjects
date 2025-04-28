package com.xlutils;

import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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
	// Login credentials
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
	By salutationDropdown = By.xpath("//p-dropdown[@placeholder='Select']//label");
	By salutationOptions = By.xpath("//li[@role='option']");

	By firstname = By.xpath("//input[@id='first_name']");
	By middilename = By.xpath("//input[@placeholder='Enter middle name']");
	By lastname = By.xpath("//input[@id='last_name']");

	By emailid = By.xpath("//input[@id='email']");
	By mobilenumber = By.xpath("(//input[@id='phone'])[1]");
	By username = By.xpath("//input[@id='login_unique']");

	// dropdownfields
	By rolodropdown = By.xpath("//p-dropdown[@placeholder='Select role']//label"); 
	By roleoptions = By.xpath("//li[@role='option']");

	By password = By.xpath("//input[@id='password']");

	By confirmpassword = By.xpath("(//input[@type='password'])[3]");

	By savebutton = By.cssSelector("button[id='btnSave'] span[class='info'] span");

	By cancelbtn = By.cssSelector("span[aria-hidden='true']"); 
	// Success or error message 

	By messagelocators = By.xpath("//div[contains(@class, 'toast-title')] | //div[contains(@class, 'toast-title')] | //div[normalize-space()='Please fill mandatory fields']");

	//By errormessage = By.xpath("//div[contains(@class, 'toast-title')]");

	// popup messages
	//By popupmsg = By.cssSelector("div[class='zc-dialog'] div[class='modal-body']");

	// click on ok
	By popokbtn = By.cssSelector("#dialog-okay-btn");

	// capture the validation message
	By mobnumerror = By.id("field-error-text_7161");

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

		wait.clickElement(savebutton);

	}

	// success or error message
	public String getsuccessfailuremsg() {

		String message = "";
		try {

			WebElement Msg = wait.waitforvisibilityreturn(messagelocators);
			if (Msg != null && Msg.isDisplayed()) {
				message = Msg.getText();
				System.out.println(message);
				
				
				 WebElement okbutton = wait.clickElement(popokbtn);
		            if (okbutton != null && okbutton.isDisplayed()) 
		                okbutton.click();

		            return message; 
			}
				/* WebElement popmsg = wait.waitforvisibilityreturn(popupmsg);
			        if (popmsg != null && popmsg.isDisplayed()) {
			            message = popmsg.getText(); 
			            System.out.println(message);
			            
			            
			            WebElement okbutton = wait.waitforvisibilityreturn(popokbtn);
			            if (okbutton != null && okbutton.isDisplayed()) 
			                okbutton.click();

			            return message; 
			        }
			        */
			        
			        WebElement validations = wait.waitforvisibilityreturn(mobnumerror);
			        if (validations != null && validations.isDisplayed()) {
			            message = validations.getText(); 
			            System.out.println(message); 
			            return message; 
			        }

			
				
			
				switch (message) {
				
				case "user saved successfully":
					
					return message;
				
				case "Username Already exists,Email ID Already Exists,Mobile No. Already Exists":
					
					return message;
					
				case "New Password and Confirm Password did not match, please verify.,Email ID Already Exists":
					
					return message;
					
				case "please enter mandatory fields ":

                  return message;
					
                  
                  default :
                	  
					return"no message found";
					
				}
		}
		    catch(Exception e) {
			 
			System.out.println(e.getMessage());
			
			
		}
		return message;		
				
		}	
			
	/*		// popup
			WebElement popmsg = wait.waitforvisibilityreturn(popupmsg);

			if (popmsg != null && popmsg.isDisplayed()) {
				message = popmsg.getText();
				System.out.println(message);

				WebElement okbutton = wait.waitforvisibilityreturn(popokbtn);
				if (okbutton != null && okbutton.isDisplayed())
					okbutton.click();

				return message;

			}
			// validations
			WebElement validations = wait.waitforvisibilityreturn(mobnumerror);
			if (validations != null && validations.isDisplayed()) {
				message = validations.getText();
				System.out.println(message);
				return message;
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		return message;

	}
*/
	
	
	
	
	// click cancel button to cancel form
	public void ClickCancel() {
    try {
    	//WebElement cancel=wait.waitforvisibilityreturn(cancelbtn);
   	//	if(cancel!=null&&cancel.isDisplayed()) {
    	
    	
			wait.clickElement(cancelbtn);
			
			
			//cancel.click();
		//}
	}catch(Exception c)
    {
		System.out.println(c.getMessage());
    }
	}
	
	
	// click add again button
	public void clickAddAgain() {

		wait.clickElement(addclick);
	}

}
