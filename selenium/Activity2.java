package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		Thread.sleep(1000);
		
		String title = driver.getTitle();
		
		System.out.println("Title of the page:"+ title );
		
		WebElement IdLocator = driver.findElement(By.id("about-link"));
		System.out.println("Text using Id Element : "+IdLocator.getText());
		
		WebElement ClassName = driver.findElement(By.className("inverted"));
		System.out.println("Text using ClassName Element : "+ClassName.getText());
		
		WebElement LinkText = driver.findElement(By.linkText("About Us"));
		System.out.println("Text using LinkText Element : "+LinkText.getText());
		
		WebElement cssSelect = driver.findElement(By.cssSelector("#about-link"));
		System.out.println("Text using cssSelect Element : "+cssSelect.getText());
			
		driver.close();

	}

}
