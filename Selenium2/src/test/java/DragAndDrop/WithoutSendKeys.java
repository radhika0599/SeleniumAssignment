package DragAndDrop;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class WithoutSendKeys {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Documents\\Selenium\\2nd video\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.google.com");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
  }
  
  @Test
  public void f() throws InterruptedException {
	  WebElement search=driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].value='infosys'", search);
	  Thread.sleep(5000);
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
