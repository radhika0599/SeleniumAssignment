package Assignment3;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class DataProviderTest {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Documents\\Selenium\\2nd video\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://en-gb.facebook.com/");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
  }
  
  @Test(dataProvider="credentials")
  public void f(String userId, String password) throws InterruptedException {
	  driver.findElement(By.id("email")).sendKeys(userId);
	  Thread.sleep(5000);
	  driver.findElement(By.id("pass")).sendKeys(password);
	  Thread.sleep(5000);
	  driver.findElement(By.name("login")).click();
	  Thread.sleep(5000);
	String msg = driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/div[2]")).getText();
	System.out.println(msg);
	  
	  
	  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }
  
  @DataProvider(name="credentials")
  public Object[][] data() {
		Object[][] input=new Object[1][2];

		input[0][0]="radhi";
		input[0][1]="radhi123";
		
		//input[0][0]=" ";
		//input[0][0]="ra87";
	
		//input[0][0]="radhika";
		//input[0][0]=" ";

		return input; 
  }
		

}
