package Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;

public class Activity4 {
	
	WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {

        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 AEmulator");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub"); 
        
        // Instantiate Appium Driver
        driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
        wait = new WebDriverWait(driver, 10);
    }
    
    @Test
    public void toDoListPage() throws InterruptedException {
    	
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.training-support.net/selenium");
     
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        
        //scroll to the end of the page
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).flingToEnd(5)"));
        
        // this below code is not working to identify the element and click ?? *******************
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[contains(@text,'To-Do List')]")));
        
       
        driver.findElementByXPath("//android.view.View[contains(@text,'To-Do List')]").click();
        
        System.out.println("We are in the page to add the to do list tasks");
        
        Thread.sleep(100);
        
        String[] tasksToAdd = { 
        		"Add tasks to list",
        		"Get number of tasks",
        		"Clear the list"
  	     };
        
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[contains(@text,'To-Do List')]")));
      	  
       // Getting 3 tasks added
  	  for ( String task :tasksToAdd ) {
  		  
  		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
  		driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").click();
  		//driver.findElementById("taskInput").click();
  		
  		System.out.println("Task Input : "+task);
  		driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").sendKeys(task);
  	    
  	    // Click on Add Task Button
  		driver.findElementByXPath("//android.widget.Button[contains(@text,'Add Task')]").click();   
  		System.out.println("Task is added successfully: "+ task);
  	  }
  	  
  	  // Click on each of the tasks added to strike them out.
  	  
  	List<MobileElement> addedTasks = driver.findElementsByXPath("//android.view.View[2][@class='android.view.View']");
  	//List<MobileElement> addedTasks = driver.findElementsByXPath("//android.view.View/android.view.View[4]/android.view.View[2][@class='android.view.View']");
  	
  	System.out.println("==============Striked Off Tasks =========================");
  	System.out.println("No. of Tasks for Strike of is"+addedTasks.size());
  	 for ( MobileElement task :addedTasks) { 
   		System.out.println(task.getText());
   	  }
  	
 	 
  	 for ( MobileElement task :addedTasks) { 
  		driver.findElementByXPath("//android.view.View[contains(@text,task)]").click(); 
  		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
  		System.out.println(task.getText() + " -------- Striked Off");
  	  }
  	  
  	 Thread.sleep(1000);
  	 driver.findElementByXPath("//android.view.View[contains(@text,'To-Do List')]").click();
  	  // Finally, clear the list  - find xpath with child element contains ClearList
  	 driver.findElementByXPath("//android.view.View[contains(@text,'Clear List')]").click();
  	 System.out.println("Cleared the List");
  	 
  	 Thread.sleep(1000);
  	 
  	 //Assert.assertEquals(pageTitle, "Training Support");
  	
  	List<MobileElement> remTasks = driver.findElementsByXPath("//android.view.View/android.view.View[4]/android.view.View");
  	//System.out.println("post clear list, no of tasks remaining is : "+remTasks.size()); 
  	Assert.assertEquals(2, remTasks.size());
    }
   
    
    @AfterTest
    public void tearDown() {
        driver.quit();
    }	

}
