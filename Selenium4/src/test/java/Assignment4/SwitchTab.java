package Assignment4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class SwitchTab {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Documents\\Selenium\\2nd video\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
  }
 
  @Test
  public void f() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  String tab=Keys.chord(Keys.CONTROL,Keys.ENTER);
	  
	  driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]/a")).sendKeys(tab);  //.sendKeys(Keys.CONTROL+"t")
	  for(String tab1 : driver.getWindowHandles()) {
		  driver.switchTo().window(tab1);
		  System.out.println("After opening new tab  "+driver.getCurrentUrl());
		  
	  }
	  
	   Thread.sleep(5000);
	   
	  driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]/a")).click();
	  
	  WebElement name=driver.findElement(By.id("search_type"));
	  Select select=new Select(name);
		Thread.sleep(5000);
		 select.selectByVisibleText("First Name");
		 driver.findElement(By.id("search_patient")).click();
	  
	  
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }
  

}
