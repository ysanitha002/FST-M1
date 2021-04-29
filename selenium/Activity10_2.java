package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {
	 public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);
               
        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println("Title of the page is :"+ driver.getTitle());
        
        //Press the key of your first name in caps
        actions.sendKeys("A").build().perform();
        String keyPressed = driver.findElement(By.id("keyPressed")).getText();
        System.out.println("Key Pressed is :"+ keyPressed);
        
        //Press CTRL+a and the CTRL+c to copy all the text on the page.
         //actions.sendKeys(Keys.CONTROL+"a").build().perform();
         //actions.sendKeys(Keys.CONTROL+"c").build().perform();
        
        actions
           .keyDown(Keys.CONTROL)
           .sendKeys("a")
           .sendKeys("c")
           .keyUp(Keys.CONTROL)
           .build().perform();  
       
        keyPressed = driver.findElement(By.id("keyPressed")).getText();
        System.out.println("Key Pressed is :"+ keyPressed);
        
        driver.close();
        
	 }
}
