package Assignment3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class ExtentReport {
	public ExtentReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentTest;
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		//htmlReporter=new ExtentReporter("./reports/extent.html");
		
	}
	
  @Test
  public void f() {
	  
  }
}
