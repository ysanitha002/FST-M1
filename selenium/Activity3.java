package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*Create a Class with a main() method.
Create a WebDriver instance, named driver, with the FirefoxDriver().
Open a browser with https://training-support.net/selenium/simple-form
Get the title of the page using driver.getTitle() and print out the title.
Use findElement() with name() to find the text fields - firstname and lastname.
Use WebElement.sendKeys() to type in those text fields.
Similarly, find and type into the email and contact number fields.
Finally, submit the form by clicking the Submit button.
Close the browser with driver.close() */

public class Activity3 {

	public static void main(String[] args) throws InterruptedException {
		
	WebDriver driver = new FirefoxDriver();
	
	driver.get("https://training-support.net/selenium/simple-form");
	
	Thread.sleep(1000);
	
	System.out.println("Title of the Window : "+ driver.getTitle());
	
	WebElement FName, LName, email, contactNumber, submit;
		
	FName = driver.findElement(By.id("firstName"));
	LName = driver.findElement(By.id("lastName"));
	email=driver.findElement(By.id("email"));
	contactNumber = driver.findElement(By.id("number"));
	
	FName.sendKeys("Anitha");
	LName.sendKeys("YS");
	email.sendKeys("ysanitha002@gmail.com");
	contactNumber.sendKeys("7896786786");
	
	submit = driver.findElement(By.cssSelector(".green"));
	submit.click();
	
	System.out.println("Entered the info and clicked the button. ");
	
	driver.close();

	}

}
