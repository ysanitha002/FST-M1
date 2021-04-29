package LMSProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LMSActivity2 {
	WebDriver driver;
	
	 @BeforeMethod
	  public void beforeMethod() {	  
		 driver = new FirefoxDriver();
		 driver.get("https://alchemy.hguy.co/lms");
		 
	  }
	
	 @Test
	 public void verifyLMSHeading() {
    
		 String heading = driver.findElement(By.xpath("//h1[contains(@class,'title')]")).getText();
		 System.out.println("Heading of the website is : " + heading);
        
		 //Assertion for page heading
		 Assert.assertEquals(heading, "Learn from Industry Experts");
	 }


	 @AfterMethod
	 public void afterMethod() {
		 driver.close();
	 }


}
