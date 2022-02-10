package Assignment4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class GoogleAccount {
	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Documents\\Selenium\\2nd video\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
  }
  
  @Test
  public void f() throws InterruptedException {
	  driver.findElement(By.id("firstName")).sendKeys("Harmione");
	  Thread.sleep(5000);
	  String firstname = driver.findElement(By.xpath("//*[@id=\"firstName\"]")).getAttribute("id");
	  System.out.println("Attribute of firstname "+firstname);
	  
	  driver.findElement(By.id("lastName")).sendKeys("G");
	  Thread.sleep(5000);
	  String lastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]")).getAttribute("id");
	  System.out.println("Attribute of lastName "+lastName);
	  
	  driver.findElement(By.id("username")).sendKeys("harmioneG1");
	  Thread.sleep(5000);
	  String username = driver.findElement(By.xpath("//*[@id=\"username\"]")).getAttribute("id");
	  System.out.println("Attribute of username "+username);
	  
	  driver.findElement(By.name("Passwd")).sendKeys("Yaaahhhhhh@14");
	  Thread.sleep(5000);
	  String password = driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input")).getAttribute("id");
	  System.out.println("Attribute of password "+password);
	  
	  driver.findElement(By.name("ConfirmPasswd")).sendKeys("Yaaahhhhhh@14");
	  Thread.sleep(5000);
	  String ConfirmPasswd = driver.findElement(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")).getAttribute("id");
	  System.out.println("Attribute of ConfirmPasswd "+ConfirmPasswd);
	  
	  driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button/span")).click();
	  Thread.sleep(5000);
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
