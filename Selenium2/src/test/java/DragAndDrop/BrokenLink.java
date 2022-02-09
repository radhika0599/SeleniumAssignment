package DragAndDrop;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BrokenLink {
	WebDriver driver;
 
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Documents\\Selenium\\2nd video\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.zlti.com/");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
  }
  @Test
  public void f() {
	  List<WebElement> links=driver.findElements(By.tagName("a"));
	  int n=links.size();
	  System.out.println("Total links are "+n);
	  for(int i=0;i<n;i++)
	  {
		  WebElement link=links.get(i);
		  String url=link.getAttribute("href");
		  verifyLinkSelected(url);
		  
	}
  }
  
  public static void verifyLinkSelected(String linkurl) {
	  
	  try {
		URL url=new URL(linkurl);
		  HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
		  httpURLConnection.setConnectTimeout(3000);
		  httpURLConnection.connect();
		  
		/*  if(httpURLConnection.getResponseCode()==200)
		  {
			  System.out.println(linkurl +"-"+httpURLConnection.getResponseMessage());
			  
		  } */
		  if(httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
		  {
			  System.out.println(linkurl +"-"+httpURLConnection.getResponseMessage() + "-"+HttpURLConnection.HTTP_NOT_FOUND);
		  }
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
