package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {

	public static void main(String[] args) {
		
        WebDriver driver= new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
		
		System.out.println("Title is : "+ driver.getTitle());
		
        //Find the third header
		String thirdHeader = driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
	    System.out.println("Third header text is: " + thirdHeader);
	
        //Find the fifth header and get it's colour
	    WebElement fifthHeader= driver.findElement(By.xpath("//h5[contains(text(),'Fifth')]"));
	    System.out.println("Color of the Fifth header is : " + fifthHeader.getCssValue("color"));
	    
	    //Find the violet button and print it's classes
	    WebElement violet= driver.findElement(By.xpath("//button[contains(text(),'Violet')]"));
	    System.out.println("Violet Button classes are : " + violet.getAttribute("class"));	
	    
	    //Find the grey button with Absolute XPath
	    WebElement greyB= driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"));
	    System.out.println("Grey Button text is  : " + greyB.getText());
	
        driver.close();

	}

}
