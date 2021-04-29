package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_6_1 {
	
	public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver(); 
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        driver.get("https://training-support.net/selenium/dynamic-controls");
        
        System.out.println("Title of the page is : " + driver.getTitle());

        //Find the checkbox toggle button
        WebElement checkboxToggle = driver.findElement(By.id("toggleCheckbox"));
        WebElement checkbox=driver.findElement(By.xpath("//input[@type='checkbox']"));
        
        checkboxToggle.click();
        System.out.println("Checkbox Toggle is clicked which will hide it");

      //Wait for checkbox to disappear
        wait.until(ExpectedConditions.invisibilityOf(checkbox));

        checkboxToggle.click();
        System.out.println("Checkbox Toggle is clicked which will display it");
        
        wait.until(ExpectedConditions.visibilityOf(checkbox));

        driver.close();
	}

}
