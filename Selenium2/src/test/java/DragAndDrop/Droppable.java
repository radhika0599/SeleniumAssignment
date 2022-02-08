package DragAndDrop;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class Droppable {
	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Documents\\Selenium\\2nd video\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://jqueryui.com/dropable/");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
	  
  }
  
  @Test
  public void demo() throws InterruptedException {
	  driver.findElement(By.linkText("Demos")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.linkText("Droppable")).click();
	  Thread.sleep(5000);
	  WebElement Frame=driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
	  driver.switchTo().frame(Frame);
	  WebElement fromElement=driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
	  Thread.sleep(5000);
	  WebElement toElement=driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
	  Thread.sleep(5000);
	  Actions action=new Actions(driver);
	  action.dragAndDrop(fromElement, toElement).build().perform();
	  Thread.sleep(5000);
	  String afterDrop=driver.findElement(By.xpath("//*[@id=\"droppable\"]")).getText();
	  if(afterDrop.equals("Dropped!")) 
		  System.out.println("Sucessfully dropped");
	  else 
		  System.out.println("dropping action unsucessful");
	  
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
	
  }

}
