package LMSProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LMSActivity7 {
	 WebDriver driver;
	
	 @BeforeMethod
	  public void beforeMethod() {	  
		 driver = new FirefoxDriver();
		 driver.get("https://alchemy.hguy.co/lms");		 
	  }
	
	 @Test
	 public void courses() throws InterruptedException {

		 driver.findElement(By.linkText("All Courses")).click();
		 Thread.sleep(100);
		 String myCoursesTitle = driver.getTitle();
		 System.out.println("Title of My Account Page : " + myCoursesTitle);
   
		 //Assertion for page heading
		 Assert.assertEquals(myCoursesTitle, "All Courses – Alchemy LMS");
		 
		 List<WebElement> courses = driver.findElements(By.xpath("//h3[@class='entry-title']"));
		 
		 System.out.println("Total number of courses on the page is :"+ courses.size());
		 
		 System.out.println("Courses names are :");
		 
		 for (WebElement i:courses)
		 {
			 System.out.println(i.getText());
		 }
		 
	 }

	 @AfterMethod
	 public void afterMethod() {
		 driver.close();
	 }
}
