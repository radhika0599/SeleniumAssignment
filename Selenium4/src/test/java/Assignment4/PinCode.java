package Assignment4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class PinCode {
	WebDriver driver;
 
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Documents\\Selenium\\2nd video\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://chennaiiq.com/india/pincode/index.asp");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
  }
  
  @Test
  public void f() throws InterruptedException {
	  driver.findElement(By.name("txtsearch")).sendKeys("403001");
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[3]/td[2]/input[3]")).click();
	  driver.findElement(By.xpath("//*[@id=\"optpin\"]")).click();
	  
	  
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  WebElement state=driver.findElement(By.id("state"));
	  
	 Thread.sleep(5000);
	  Select select=new Select(state);
	   Thread.sleep(5000);
	 select.selectByVisibleText("Goa");
	 driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody/tr[7]/td/div/input")).click();
	
	WebElement table  =driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table/tbody"));
	  List <WebElement> area=table.findElements(By.tagName("tr"));
	  int n=area.size();
	  System.out.println("The no of rows in webtable is "+area.size());
	  
	  if(n>1) {
		  System.out.println("Given Pincode is not unique for single area  ");
		  
	  }
	  else {
		  System.out.println("Given Pincode is  unique for single area  ");
	  }
	 
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
