package Config;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ReadProperty {
   WebDriver driver;
   static Properties prop=new Properties();
   
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Documents\\Selenium\\2nd video\\chromedriver.exe");
	  driver=new ChromeDriver();
	  
	//  driver.manage().window().maximize();
	//  Thread.sleep(5000);
	 
  }
  
  @Test
  public void f() {
	readProperty();
	 writeProperty();
	 readProperty();
	 
	 
  }
  
 public void readProperty() {
	  
	
	   try {
		InputStream input=new FileInputStream("C:\\Users\\ASUS\\git\\SeleniumAssignment\\Selenium2\\src\\test\\java\\Config\\config.properties");
		prop.load(input);
		String out=prop.getProperty("URL");
		System.out.println(out);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
 
 public static void writeProperty() {
	 try {
		OutputStream output=new FileOutputStream("C:\\Users\\ASUS\\git\\SeleniumAssignment\\Selenium2\\src\\test\\java\\Config\\config.properties");
		prop.setProperty("browser","FireFox");
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
 }

  @AfterMethod
  public void afterMethod() {
  }

}
