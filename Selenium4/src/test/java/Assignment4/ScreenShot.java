package Assignment4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ScreenShot {
	WebDriver driver;
	  @BeforeMethod
	  public void beforeMethod() throws InterruptedException {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Documents\\Selenium\\2nd video\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://api.jquery.com/dblclick/");
		  driver.manage().window().maximize();
		  Thread.sleep(5000);
	  }
	  
	  @Test
	  public void f() throws IOException {
		  TakesScreenshot ss=((TakesScreenshot) driver);
		  File scrFile=ss.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(scrFile,new File("C:\\Users\\ASUS\\Desktop\\dblclick.PNG"));
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.close();
		  driver.quit();
	  }
}
