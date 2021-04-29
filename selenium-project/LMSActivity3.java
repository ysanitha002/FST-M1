package LMSProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LMSActivity3 {
	WebDriver driver;
	
	 @BeforeMethod
	  public void beforeMethod() {	  
		 driver = new FirefoxDriver();
		 driver.get("https://alchemy.hguy.co/lms");		 
	  }
	
	 @Test
	 public void verifyfirstinfoTitle() {
   
		 String firstInfoTitle = driver.findElement(By.xpath("//*[contains(text(),'Actionable Training')]")).getText();
		 System.out.println("Title of First Info Box : " + firstInfoTitle);
       
		 //Assertion for page heading
		 Assert.assertEquals(firstInfoTitle, "Actionable Training");
	 }

	 @AfterMethod
	 public void afterMethod() {
		 driver.close();
	 }
		
}
