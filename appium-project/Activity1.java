package Project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;

public class Activity1 {

      WebDriverWait wait;
      AppiumDriver<MobileElement> driver = null;

      @BeforeTest
      public void setup() throws MalformedURLException {

      // Set the Desired Capabilities
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "Pixel 4 AEmulator");
      caps.setCapability("platformName", "android");
      caps.setCapability("automationName", "UiAutomator2");
      caps.setCapability("appPackage", "com.google.android.apps.tasks");
      caps.setCapability("appActivity", ".ui.TaskListsActivity");
      caps.setCapability("noReset", true);

      URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub"); 
      
      // Instantiate Appium Driver
      driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
      wait = new WebDriverWait(driver, 10);
      }
      
      @Test
      public void addTask() {
    	  
    	  System.out.println("Google Taks App is Open");
    	  
    	  
    	  String[] tasksToAdd = { 
    			  "Complete Activity with Google Tasks",
    			  "Complete Activity with Google Keep",
    			  "Complete the second Activity Google Keep"
    	  };
    	  
    	  for ( String task :tasksToAdd ) {
    	  
    	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task")));
    	  
    	  driver.findElementByAccessibilityId("Create new task").click();
    	 // driver.findElementById("tasks_fab").click();
    	  
    	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
    	  driver.findElementById("add_task_title").sendKeys(task);
    	  driver.findElementById("add_task_done").click();
    	  
    	  System.out.println("Task is added successfully: "+task);
    	  }
    	  
    	  assertEquals(driver.findElementsById("task_name").size(), 3);
    	  System.out.println("All the 3 Tasks are is added successfully");
    	  
      } 
      
      
      @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
}
