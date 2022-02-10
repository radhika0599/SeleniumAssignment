package DragAndDrop;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Google {
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
  public void automateSearch() throws InterruptedException {
	  driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("java");
	  List<WebElement> list= driver.findElements(By.xpath("//input"));
	  Thread.sleep(5000);
	  System.out.println(list.size());
	  
	  for(int i=0;i<list.size();i++) {
		  String listitem=list.get(i).getText();
		  if(listitem.contains("java tutorial")) {
			  list.get(i).click();
			  break;
		  }
	  }
	  
	  
  }
  @Test
  public void customisedXpath() {
	 List<WebElement> match=driver.findElements(By.xpath("//input"));
	 int total=match.size();
	 System.out.println("No of element matching xpath "+total);
	 
	 for(int i=0;i<total;i++) 
	 {
		WebElement e=match.get(i);
		System.out.println(e.getText());
		if(e.isEnabled()==true) {
			e.click();
			System.out.println("click operation is performed for"+e);
		}
		else {
			System.out.println("click operation is not avaliable for" +e);
		}
		
		 
	 }
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
