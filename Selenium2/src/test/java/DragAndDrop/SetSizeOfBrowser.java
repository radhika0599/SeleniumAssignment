package DragAndDrop;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class SetSizeOfBrowser {
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
	  driver.manage().window().maximize(); //To maximize 
	  Thread.sleep(5000);
  }
  
  @Test
  public void f1() throws InterruptedException {
	  Dimension dimension=new Dimension(600,720); //Size given in pixel(x,y) to resize
	  driver.manage().window().setSize(dimension);
	  Thread.sleep(5000);
	System.out.println(driver.manage().window().getSize());
	  
  }
  
  @Test
  public void f2() throws InterruptedException {
	  Point point=new Point(0,3000); //To minimize size
	  driver.manage().window().setPosition(point);
	  Thread.sleep(5000);
	  System.out.println(driver.manage().window().getPosition());
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
