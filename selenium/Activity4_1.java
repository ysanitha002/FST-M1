package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		Thread.sleep(1000);
		
		String title = driver.getTitle();
		
		System.out.println("Title is : "+title);
		
	   driver.findElement(By.xpath("//a[contains(@id,'about-link')]")).click();
	   
	   
	   System.out.println("Title of the new page is : "+ driver.getTitle());
	   
	   driver.quit();		
	  

	}

}
