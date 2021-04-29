package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity7 {
	   WebDriver driver;
	    WebDriverWait wait;

	    @BeforeClass
	    public void beforeMethod() {
	        driver = new FirefoxDriver();
	        wait = new WebDriverWait(driver, 10);

	        driver.get("https://www.training-support.net/selenium/login-form");
	    }
	    
	    @DataProvider(name = "Authentication")
	    public static Object[][] credentials() {
	        return new Object[][] { { "admin", "password" }};
	    }
	    
	    
	    @Test ( dataProvider = "Authentication")
	    public void loginTestCase(String username, String password) {
	       
	        WebElement usernameField = driver.findElement(By.id("username"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        
	        usernameField.sendKeys(username);
	        passwordField.sendKeys(password);
	        
	        driver.findElement(By.cssSelector("button[type='submit']")).click();
	        
	        //Assert Message
	        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
	        Assert.assertEquals(loginMessage, "Welcome Back, admin");
	        
	        System.out.println("Login success with credentials : "+username +"/"+password);
	    }

	    @AfterClass
	    public void afterMethod() {
	        driver.close();
	    }
	
}
