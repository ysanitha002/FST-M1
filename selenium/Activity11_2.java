package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_2 {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
                      
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        System.out.println("Title of the page is :"+ driver.getTitle());
        
        WebElement confirm = driver.findElement(By.id("confirm"));
        
        confirm.click();
        Alert confirmAlert = driver.switchTo().alert();
           
        System.out.println("Alert text is :"+confirmAlert.getText());  // get Alert text
        Thread.sleep(1000);
        confirmAlert.accept();
        
        confirm.click();
        confirmAlert = driver.switchTo().alert();
        System.out.println("Alert text is :"+confirmAlert.getText());  // get Alert text
        Thread.sleep(1000);
        confirmAlert.dismiss();
        
        
        driver.close();
        
	}


}
