package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_1 {

	public static void main(String[] args) {
		
		 WebDriver driver= new FirefoxDriver();
			driver.get("https://www.training-support.net/selenium/tables");
			
			//Get columns
	        List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[1]/td"));
	        //Get rows
	        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr"));
	 
	        //Number of columns
	        System.out.println("Number of columns are: " + cols.size());
	        //Number of rows
	        System.out.println("Number of rows are: " + rows.size());
	        
	        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[3]/td"));
	       // List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[3]/td"));
	        
	        
	        for ( WebElement i:thirdRow )       
	              System.out.println("Cell value : " + i.getText());
	 
	        //Cell value of second row, Third column
	        WebElement cellvalue2_2 = driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[3]"));
	        System.out.println("2nd Row, 2rd Column Data is : "+ cellvalue2_2.getText());
	        
	        //Close browser
	        driver.close();	
		
	}

}
