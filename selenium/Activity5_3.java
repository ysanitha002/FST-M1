package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {

		    public static void main(String[] args) {

		        // Create a new instance of the Firefox driver
		        WebDriver driver = new FirefoxDriver();

		        //Open the browser
		        driver.get("https://training-support.net/selenium/dynamic-controls");

		        //Find the checkbox
		        WebElement textInput = driver.findElement(By.xpath("//input[@type='text']"));

		        //Print status
		        System.out.println("The textbox is selected: " + textInput.isEnabled());

		        driver.findElement(By.id("toggleInput")).click();
		        
		      //Print status
		        System.out.println("The textbox is selected: " + textInput.isEnabled());
		        
		        textInput.sendKeys("DataText");
		        
		        // this line code is not working !!
		        System.out.println("Text inputted is :" + textInput.getText());

		        //Close the browser
		        driver.close();

		    }

}
