package LMSProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LMS_Activity1 {
	WebDriver driver;
	
	 @BeforeMethod
	  public void beforeMethod() {	  
		 driver = new FirefoxDriver();
		 driver.get("https://alchemy.hguy.co/lms");
		 
	  }
	
 @Test
 public void verifyLMSTitle() {
     
     String title = driver.getTitle();
     System.out.println("Title of the website is : " + title);
         
         //Assertion for page title
     Assert.assertEquals(title, "Alchemy LMS – An LMS Application");
 }


 @AfterMethod
 public void afterMethod() {
	  driver.close();
 }
 	
}
