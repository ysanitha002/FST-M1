package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class Activity2 {
	WebDriver driver;
	
	@BeforeClass
	  public void beforeClass() {
		  driver = new FirefoxDriver();
	      driver.get("https://www.training-support.net/selenium/target-practice");

	  }
	
	//In the first @Test method, use getTitle() to get and assert the title of the page.
  @Test
  public void firstTest() {
	  String title =driver.getTitle();
	  System.out.println("title is : "+ title);
	  Assert.assertEquals(title,"Target Practice");
  }
  
  //In the second @Test method, use findElement() to look for the black button. Make an incorrect assertion. (This test case is meant to throw an error)
  
  @Test
  public void  secondTest() {
	  //This test case will Fail
      WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
      Assert.assertTrue(blackButton.isDisplayed());
      System.out.println("Black button text is : "+ blackButton.getText());
      Assert.assertEquals(blackButton.getText(), "White");
	  
  }
  
  
  //For the third @Test method, skip it by setting it's enabled parameter to false.
  //The third method will be skipped, but will not be shown as skipped.
  
  @Test (enabled = false)
  public void  thirdTest() {
	//This test will be skipped and not counted
      String subHeading = driver.findElement(By.className("sub")).getText();
      Assert.assertTrue(subHeading.contains("Practice"));
  }
  
  
  // For the fourth @Test method, skip it by throwing a SkipException inside the method.
  //The fourth method will be skipped and it will be shown as skipped.
  @Test
  public void  fourthTest() {	  
	  throw new SkipException("Skipping test case");  
  }  

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
