package DragAndDrop;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class PopUP {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Documents\\Selenium\\2nd video\\chromedriver.exe");
	  driver=new ChromeDriver();
	  //driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
  }

  @Test
  public void f() throws InterruptedException {
	  driver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");
	  driver.findElement(By.id("fakealert")).click();
	  Thread.sleep(5000);
	 
	  //driver.switchTo().alert().accept();
	  driver.findElement(By.id("dialog-ok")).click();
 }
  
  @Test
  public void f2() throws InterruptedException {
	  driver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");
	  driver.findElement(By.id("modaldialog")).click();
	  Thread.sleep(5000);
	  //driver.switchTo().alert().accept();
	  driver.findElement(By.xpath("//*[@id=\"dialog-ok\"]")).click();
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
