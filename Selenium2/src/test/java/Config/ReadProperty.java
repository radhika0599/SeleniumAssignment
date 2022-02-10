package Config;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ReadProperty {
   WebDriver driver;
   static Properties prop=new Properties();
   
  @BeforeMethod
  public void beforeMethod() throws InterruptedException, IOException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Documents\\Selenium\\2nd video\\chromedriver.exe");
	  driver=new ChromeDriver();
	//  InputStream input=new FileInputStream("C:\\Users\\ASUS\\git\\SeleniumAssignment\\Selenium2\\src\\test\\java\\Config\\config.properties");
	//	prop.load(input);
	//	String out=prop.getProperty("URL");
	//	System.out.println(out);
	  
		//OutputStream output=new FileOutputStream("C:\\Users\\ASUS\\git\\SeleniumAssignment\\Selenium2\\src\\test\\java\\Config\\config.properties");
		//prop.setProperty("browser","FireFox");
	//  driver.manage().window().maximize();
	//  Thread.sleep(5000);
	 
  }
  
  @Test
  public void f() throws InterruptedException, IOException {

	  InputStream input=new FileInputStream("C:\\Users\\ASUS\\git\\SeleniumAssignment\\Selenium2\\src\\test\\java\\Config\\config.properties");
		prop.load(input);
		String out=prop.getProperty("url");
		System.out.println(out);
		
	  driver.get(out);
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Infosys");
	  Thread.sleep(5000);
	 
  }
  
  @Test
  public void login() throws InterruptedException, IOException {
	  InputStream input=new FileInputStream("C:\\Users\\ASUS\\git\\SeleniumAssignment\\Selenium2\\src\\test\\java\\Config\\config.properties");
		prop.load(input);
		String out1=prop.getProperty("url1");
		System.out.println(out1);
	  driver.get(out1);
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
	  
	  String userId=prop.getProperty("Username");
		System.out.println(userId);
		
		String password=prop.getProperty("password");
		System.out.println(password);
	  
	  driver.findElement(By.id("email")).sendKeys(userId);
	  Thread.sleep(5000);
	  driver.findElement(By.id("pass")).sendKeys(password);
	  Thread.sleep(5000);
	  driver.findElement(By.name("login")).click();
	  Thread.sleep(5000);
	String msg = driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/div[2]")).getText();
	System.out.println(msg);
	  
	  
  }
 
 

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
