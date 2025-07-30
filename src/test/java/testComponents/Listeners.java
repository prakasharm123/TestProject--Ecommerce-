package testComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
 
import resources.ExtentReporterNG;


public class Listeners extends BaseTest implements ITestListener{
	ExtentReports extent = ExtentReporterNG.getReportObject();
	 ExtentTest test;
	 ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	 
	  @Override	
	  public void onTestStart(ITestResult result) {
		  test = extent.createTest(result.getMethod().getMethodName());
		  extentTest.set(test);
	  }

	  @Override
	  public void onTestSuccess(ITestResult result) {
	    extentTest.get().log(Status.PASS, "test Passed");
		  
	  }

	  @Override
	  public void onTestFailure(ITestResult result) {
		  extentTest.get().fail(result.getThrowable());
	    
	    //screenshot, attach to report
	    
	    try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	    
	    String Filepath = null;
		try {
			Filepath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(Filepath, result.getMethod().getMethodName());
	    
	    
	  }

	  @Override
	  public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }
	  
	  @Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
		  }

	  @Override	 
	  public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		  }

	  @Override	 
	  public void onStart(ITestContext context) {
		    // not implemented
		  }

	  @Override	
	  public void onFinish(ITestContext context) {
		    extent.flush();
		  }

	

}
