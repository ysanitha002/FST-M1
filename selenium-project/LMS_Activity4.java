package LMSProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LMS_Activity4 {
	 WebDriver driver;
	
	 @BeforeMethod
	  public void beforeMethod() {	  
		 driver = new FirefoxDriver();
		 driver.get("https://alchemy.hguy.co/lms");		 
	  }
	
	 @Test
	 public void verifySecPopCourse() {
  
		 String secondPopularCourse = driver.findElement(By.xpath("(//h3[@class='entry-title'])[2]")).getText();
		 System.out.println("Title of Seond Popular Course is : " + secondPopularCourse);
      
		 //Assertion for page heading
		 Assert.assertEquals(secondPopularCourse, "Email Marketing Strategies");
	 }

	 @AfterMethod
	 public void afterMethod() {
		 driver.close();
	 }
}
