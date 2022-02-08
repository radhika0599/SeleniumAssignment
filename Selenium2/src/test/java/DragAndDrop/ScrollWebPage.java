package DragAndDrop;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ScrollWebPage {
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
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,1000)","");  //Scroll using pixel
	  Thread.sleep(5000);
  }
  
  @Test
  public void f1() throws InterruptedException {
	 WebElement stop= driver.findElement(By.xpath("//*[@id=\"content\"]/ul[2]/li[6]"));
	 JavascriptExecutor js1=(JavascriptExecutor)driver;
	  js1.executeScript("arguments[0].scrollIntoView();",stop);  //Scroll till we find element
	  Thread.sleep(5000);
  }
  
  @Test
  public void f2() throws InterruptedException {
	  JavascriptExecutor js2=(JavascriptExecutor)driver;
	  js2.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // Scroll till bottom
	  Thread.sleep(5000);
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
