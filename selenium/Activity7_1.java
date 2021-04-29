package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7_1 {
	
	  public static void main(String[] args)
	  {
	
	   WebDriver driver = new FirefoxDriver();
	   WebDriverWait wait = new WebDriverWait(driver, 20);
       driver.get("https://www.training-support.net/selenium/dynamic-attributes");
       
       System.out.println("Title of Page is "+ driver.getTitle());

       WebElement username = driver.findElement(By.xpath("//input[starts-with(@class,'username')]"));
       WebElement password = driver.findElement(By.xpath("//input[starts-with(@class,'password')]"));
       
       username.sendKeys("admin");
       password.sendKeys("password");
       
       driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
       
       WebElement msgEle=driver.findElement(By.id("action-confirmation"));
       
       wait.until(ExpectedConditions.textToBePresentInElement(msgEle, "Welcome Back, admin"));
       
       String msg =msgEle.getText();
       System.out.println("Login Message : "+ msg);
       
       driver.close();
	
	  }
	

}
