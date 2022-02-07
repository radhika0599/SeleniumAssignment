package Assignment1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class SetUp {
	WebDriver driver;
	
  @Test
  public void open() throws InterruptedException {
	  driver.get("https://www.google.com");
	 
	  System.out.println("Inside test ");
	  
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
  }
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("Wevdriver.chrome.driver", "C:\\Users\\ASUS\\Documents\\Selenium\\2nd video\\chromedriver.exe" );
	  driver=new ChromeDriver();
	  Thread.sleep(2000);
	  System.out.println("Inside beforeMethod ");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Inside afterMethod ");
	  
	  driver.close();
	  driver.quit();
	
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Inside beforeClass ");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Inside test ");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Inside beforeTest ");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Inside afterTest ");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Inside beforeSuite ");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Inside afterSuite ");
  }

}
