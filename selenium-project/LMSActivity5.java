package LMSProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LMSActivity5 {
	 WebDriver driver;
		
	 @BeforeMethod
	  public void beforeMethod() {	  
		 driver = new FirefoxDriver();
		 driver.get("https://alchemy.hguy.co/lms");		 
	  }
	
	 @Test
	 public void myaccount() throws InterruptedException {
 
		 WebElement myAccount = driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
		 myAccount.click();
		 Thread.sleep(1000);
		 String myAccountTitle = driver.getTitle();
		 System.out.println("Title of My Account Page : " + myAccountTitle);
     
		 //Assertion for page heading
		 Assert.assertEquals(myAccountTitle, "My Account – Alchemy LMS");
	 }

	 @AfterMethod
	 public void afterMethod() {
		 driver.close();
	 }
}
