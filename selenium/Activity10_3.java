package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity10_3 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);
        Actions dragdrop = new Actions(driver);
               
        driver.get("https://training-support.net/selenium/drag-drop");
        System.out.println("Title of the page is :"+ driver.getTitle());
        
        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement drop1 = driver.findElement(By.id("droppable"));
        WebElement drop2 = driver.findElement(By.id("dropzone2"));
        
        dragdrop.dragAndDrop(ball, drop1).build().perform();
        // Verify that the ball has entered Dropzone 1.
        //System.out.println(drop1.getCssValue("color"));
        
        wait.until(ExpectedConditions.attributeToBeNotEmpty(drop1, "background-color"));
        System.out.println("Entered dropzone 1");
        
        
        dragdrop.dragAndDrop(ball, drop2).build().perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(drop2, "background-color"));
        System.out.println("Entered dropzone 2");
		
		driver.close();
		
	}

}
