package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12_3 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions builder = new Actions(driver);
        
        driver.get("https://www.training-support.net/selenium/popups");
        System.out.println("Title of the page is :"+ driver.getTitle());
        
        
        WebElement signIn = driver.findElement(By.xpath("//button[contains(@class, 'orange')]"));
        
        //Hover over button
        builder.moveToElement(signIn).pause(Duration.ofSeconds(1)).build().perform();
        String tooltipText = signIn.getAttribute("data-tooltip");
        System.out.println("Tooltip text: " + tooltipText);
        
        //Click on the button
        signIn.click();
        
        //Wait for modal to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        
        //Find username and pasword and fill in the details
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        
     
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println(message);
        
      
        driver.close();
		

	}

}
