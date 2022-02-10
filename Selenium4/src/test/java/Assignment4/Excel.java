package Assignment4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Excel {
	WebDriver driver;
 
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Documents\\Selenium\\2nd video\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://en-gb.facebook.com/");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
  }
  
  @Test
  public void f() throws IOException, InterruptedException {
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  
	  String path="C:\\Users\\ASUS\\Desktop\\credentials.xlsx";
	  FileInputStream file=new FileInputStream(path);
	  
	  XSSFWorkbook workbook=new XSSFWorkbook(file);
	  XSSFSheet sheet=workbook.getSheetAt(0);
	  
	  int noRow=sheet.getLastRowNum()-sheet.getFirstRowNum();
	  System.out.println("Number of rows in sheet 0 are "+noRow);
	  
	  for(int i=1;i<=noRow;i++) {
		  
		
		  String userid=sheet.getRow(i).getCell(0).getStringCellValue();
		  String password=sheet.getRow(i).getCell(1).getStringCellValue();
		  System.out.println("The userid is "+userid);
		  System.out.println("The password is "+password);
		  
		  driver.findElement(By.id("email")).sendKeys(userid);
		  Thread.sleep(5000);
		  driver.findElement(By.id("pass")).sendKeys(password);
		  
		  String beforeLoginUrl=driver.getCurrentUrl();
		  System.out.println("before login URL "+beforeLoginUrl);
		  
		  Thread.sleep(5000);
		  driver.findElement(By.name("login")).click();
		  
		  String afterLoginUrl=driver.getCurrentUrl();
		  System.out.println("after login URL "+afterLoginUrl);
		  
		  Thread.sleep(5000);
		String msg = driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/div[2]")).getText();
		System.out.println(msg);
		
		Row currRow=sheet.getRow(i);
		Cell status=currRow.createCell(2);
		
		if(afterLoginUrl.equals(beforeLoginUrl)) {
			System.out.println("InvalidCredentials and login is Unsucessful");
			status.setCellValue("InvalidCredentials and login is Unsucessful");
			
		}
		else {
			System.out.println("validCredentials and login is sucessful");
			status.setCellValue("validCredentials and login is sucessful");
			
		}
		FileOutputStream out=new FileOutputStream(path);
		workbook.write(out);
		out.close();
		
		
		
		  
	  }
	  
	  
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
