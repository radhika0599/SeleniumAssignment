package DragAndDrop;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class BootStrapDropDown {
	WebDriver driver;
	
    
	
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Documents\\Selenium\\2nd video\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
  }
  
  @Test
  public void dropDown() throws InterruptedException {
	 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  WebElement dd=driver.findElement(By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select"));
	  
	 //Thread.sleep(5000);
	  Select select=new Select(dd);
	//Thread.sleep(5000);
	 select.selectByVisibleText("India");
  }
  
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
