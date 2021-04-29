package LMSProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LMS_Activity6 {
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
		 
		 driver.findElement(By.xpath("//a[@href ='#login']")).click();
		 System.out.println("Now, I am on the login page :  " + driver.getTitle());
		 
		 driver.findElement(By.id("user_login")).sendKeys("root");
		 driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		 
		 driver.findElement(By.id("wp-submit")).click();
		 
		 WebElement loggedInTitle= driver.findElement(By.xpath("//h1[contains(@class,'uagb-ifb-title')]"));
		 System.out.println("Logged in Successfully to : "+ loggedInTitle.getText());
		 
		 Assert.assertEquals(loggedInTitle.getText(), "My Account");
		 
	 }

	 @AfterMethod
	 public void afterMethod() {
		 driver.close();
	 }
	
	
	
	
}
