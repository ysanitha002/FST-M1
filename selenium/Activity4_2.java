package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

	public static void main(String[] args) {
		
		WebDriver driver= new FirefoxDriver();
		
		driver.get("https://www.training-support.net/selenium/simple-form");
		
		System.out.println("Title is : "+ driver.getTitle());
		
		WebElement FName = driver.findElement(By.xpath("//input[@id='firstName']"));
		WebElement LName = driver.findElement(By.xpath("//input[@id='lastName']"));
		WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
		WebElement contactNumber = driver.findElement(By.xpath("//input[@id='number']"));
		
		FName.sendKeys("Anitha");
		LName.sendKeys("YS");
		email.sendKeys("ysanitha002@gmail.com");
		contactNumber.sendKeys("7896786786");
		
		driver.findElement(By.xpath("//div//textarea")).sendKeys("This is text message");
		
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		
		System.out.println("Entered the info and clicked the button. ");
		
		driver.quit();
		
	}

}
