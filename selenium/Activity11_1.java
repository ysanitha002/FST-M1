package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity11_1 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
                      
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        System.out.println("Title of the page is :"+ driver.getTitle());
        
        driver.findElement(By.id("simple")).click();
        
        Alert simpleAlert = driver.switchTo().alert();
           
        System.out.println("Alert text is :"+simpleAlert.getText());
        simpleAlert.accept();
        
        driver.close();
        
	}

}
