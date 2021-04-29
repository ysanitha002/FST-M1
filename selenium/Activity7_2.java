package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7_2 {
	
	  public static void main(String[] args)
	  {
	
	   WebDriver driver = new FirefoxDriver();
	   WebDriverWait wait = new WebDriverWait(driver, 20);
       driver.get("https://www.training-support.net/selenium/dynamic-attributes");
       
       System.out.println("Title of Page is "+ driver.getTitle());

       driver.findElement(By.xpath("//input[contains(@class, '-username')]")).sendKeys("Anitha");
       driver.findElement(By.xpath("//input[contains(@class,'-password')]")).sendKeys("password");
       driver.findElement(By.xpath("//label[text() = 'Confirm Password'] / following::input")).sendKeys("password");
       driver.findElement(By.xpath("//input[starts-with(@class, 'email')]")).sendKeys("ani@gmail.com");
       
      
       driver.findElement(By.xpath("//button[text() = 'Sign Up']")).click();
       
       WebElement msgEle=driver.findElement(By.id("action-confirmation"));
       
       System.out.println("Login Message : "+ msgEle.getText());
       
       driver.close();
	
	  }

}
