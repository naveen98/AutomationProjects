package Excelutil;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListener  implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	
	
	// common info report
	public ExtentReports extent;
	
	
	// creating test case entries
	public ExtentTest test;
	

    // onstart method will execute only onetime
	public void onTestStart(ITestResult result)
	{
		
		System.out.println("onteststart");
		// this is forn report generation location
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myreport.html");
		// title of report
		
		sparkReporter.config().setDocumentTitle("Automation report");
		// name of report
		
		sparkReporter.config().setReportName("Funtional Testing");
		// theme of the report
		sparkReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("computer name ", "local host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name ", "Banala Naveen");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser name ", "Firefox");

	}
    
	  public  void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());
		
		//create a new entry in the report
		test.log(Status.PASS, "Test Case Passed is :"+result.getName());		
	  
	  }
	  public  void onTestFailure(ITestResult result) {
		  
		    test=extent.createTest(result.getName());
		    test.log(Status.FAIL, "Testcase Failed is:"+result.getName());
		    test.log(Status.FAIL, "Testcase Failed is:"+result.getThrowable());
		  }
	public  void onTestSkipped(ITestResult result) {
		    test=extent.createTest(result.getName());
		    test.log(Status.SKIP, "testcase Skipped is :"+result.getName());
		  }
	public  void onFinish(ITestContext context) {
	 extent.flush();  
	  }
}
