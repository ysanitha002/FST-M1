package LMSProject;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LMS_Activity8 {
	 WebDriver driver;
		
	 @BeforeMethod
	  public void beforeMethod() {	  
		 driver = new FirefoxDriver();
		 driver.get("https://alchemy.hguy.co/lms");		 
	  }
	
	 @Test
	 public void contactUs() throws InterruptedException {

		 driver.findElement(By.linkText("Contact")).click();
		 Thread.sleep(100);
		 String contactTitle = driver.getTitle();
		 System.out.println("Title of My Account Page : " + contactTitle);
  
		 //Assertion for page heading
		 Assert.assertEquals(contactTitle, "Contact – Alchemy LMS");
		 
		 System.out.println("Sending msg to contact the Admin");
		 
		 driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Anitha YS");
		 driver.findElement(By.id("wpforms-8-field_1")).sendKeys("anithys1@in.ibm.com");
		 driver.findElement(By.id("wpforms-8-field_3")).sendKeys("Selenium");
		 driver.findElement(By.id("wpforms-8-field_2")).sendKeys("Sample Message for Contacting Admin");
		 
		 driver.findElement(By.xpath("//button[text() ='Send Message']")).click();
		 
		 String confirmationMsg = driver.findElement(By.xpath("//div[@id='wpforms-confirmation-8']")).getText();
		 System.out.println("Message displayed after Submission : " + confirmationMsg);
		 
	 }

	 @AfterMethod
	 public void afterMethod() {
		 driver.close();
	 }
}
