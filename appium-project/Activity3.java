package Project;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity3 {

    WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {

    // Set the Desired Capabilities
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("deviceName", "Pixel 4 AEmulator");
    caps.setCapability("platformName", "android");
    caps.setCapability("automationName", "UiAutomator2");
    caps.setCapability("appPackage", "com.google.android.keep");
    caps.setCapability("appActivity", ".activities.BrowseActivity");
    caps.setCapability("noReset", true);

    URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub"); 
    
    // Instantiate Appium Driver
    driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
    wait = new WebDriverWait(driver, 10);
    }
    
    @Test
    public void addNote() {
  	  
  	  System.out.println("Google Keep App is Open");
  	  
  	  String noteTitle = "This is my Note Title";
  	  String noteDesc = "This is small desciption on the notes";
  	  
 	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
  	  driver.findElementById("new_note_button").click();
  	  
  	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("editable_title")));
  	  driver.findElementById("editable_title").sendKeys(noteTitle);
  	  driver.findElementById("edit_note_text").sendKeys(noteDesc);
  	  
  	   //click to add reminder
  	   driver.findElementById("menu_switch_to_list_view").click();
  	   //driver.findElementByAccessibilityId("Single-column view").click();
  	   
  	   System.out.println("We are on the pickDate");
  	   
  	   
  	  // pick a date and time
  	   wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/bs_list_view")));
  	   driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]").click();
  	   
  	    // click on time of reminder page 
  	   wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/time_spinner")));
  	   driver.findElementById("com.google.android.keep:id/time_spinner").click();
  	   // driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Time - Currently selected - 8:00 AM\"]/android.widget.Spinner").click();
  	    
  	   
  	   System.out.println("We are on the pop up for selection of time");
  	   
  	   
  	   
  	   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.TextView[contains(@text,'Afternoon')]")));
  	   // select afternoon 
  	   driver.findElementByXPath("//android.widget.TextView[contains(@text,'Afternoon')]").click();
  	
  	    // click on save button 
  	    driver.findElementById("com.google.android.keep:id/save").click();
  	
  	
  	   wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Open navigation drawer")));
  	   //click back button 
  	   driver.findElementByAccessibilityId("Open navigation drawer").click();
  	   
  	   // Assert note added with reminder 	   
  	   wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/browse_reminder_chip")));
  	   Assert.assertEquals(true, driver.findElementById("com.google.android.keep:id/reminder_chip_icon").isDisplayed());
  	   System.out.println("Google Note with reminder Activity is completed");
  	     	   
    } 
    
    
    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
}