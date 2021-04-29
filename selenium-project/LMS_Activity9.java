package LMSProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LMS_Activity9 {
	 WebDriver driver;
		
	 @BeforeClass
	  public void beforeMethod() {	  
		 driver = new FirefoxDriver();
		 driver.get("https://alchemy.hguy.co/lms");		 
	  }
	
	 @Test ( priority = 1)
	 public void adminLogin() throws InterruptedException {

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
		 Thread.sleep(100);
		 
	 }
	 
	 @Test (priority = 2)
	 public void lesson() throws InterruptedException {

		 driver.findElement(By.linkText("All Courses")).click();
		 Thread.sleep(100);
		 String myCoursesTitle = driver.getTitle();
		 System.out.println("Title of My Account Page : " + myCoursesTitle);
   
		 //Assertion for page heading
		 Assert.assertEquals(myCoursesTitle, "All Courses – Alchemy LMS");
		 
		 WebElement courses = driver.findElement(By.xpath("//a[contains(@href, 'email-marketing-strategies')]/img"));
		 courses.click();
		 	 
		 Thread.sleep(100);
		 System.out.println("You are on the page :"+driver.getTitle());
		 
		 WebElement lesson = driver.findElement(By.xpath("(//div[@class='ld-item-title'])[2]"));
		 lesson.click();
		 Thread.sleep(100);
		 
		 String lessonTitle = driver.getTitle();
		 System.out.println("Title of the Lesson on the course  :"+ lessonTitle);
		 Assert.assertEquals(lessonTitle, "Improving & Designing Marketing Emails – Alchemy LMS");
		 
		 boolean isElementPresent = driver.findElements(By.xpath("//input[contains(@class,'mark_complete')]")).size()!=0;
		 
		 System.out.println("mark Complete Button Present  :"+ isElementPresent);
		 
		 if(isElementPresent==true)
		 {
			 System.out.println("mark Complete Button Present");
			 driver.findElement(By.xpath("//input[contains(@class,'mark_complete')]")).click(); 
			 
		 }

		 
	 }

	 @AfterClass
	 public void afterMethod() {
		 driver.close();
	 }
}
