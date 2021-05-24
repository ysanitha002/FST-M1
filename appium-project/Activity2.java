package Project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

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


public class Activity2 {

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
    	  
    	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("browse_note_interior_content")));
    	  driver.findElementById("editable_title").sendKeys(noteTitle);
      	  driver.findElementById("edit_note_text").sendKeys(noteDesc);
    	  
    	  driver.findElementByAccessibilityId("Open navigation drawer").click();
    	//  driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
    	  
    	  int noOfNotes = driver.findElementsById("browse_text_note").size();
    	  
    	  // need to add assertion for notes 
    	  assertEquals(noOfNotes, 1);
    	  System.out.println("Note is added successfully: ");   
      } 
      
      
      @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
}
