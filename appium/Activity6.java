package activites;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity6 {
  
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
    public void imageScrollTest() {
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    	
    	driver.get("https://www.training-support.net/selenium/lazy-loading");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	
        MobileElement pageTitle = driver.findElementByXPath("//android.view.View[contains(@text,'Lazy Loading')]");
        wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, "Lazy Loading"));
 
        // Count the number of images shown on the screen
        List<MobileElement> numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println("Number of image shown currently: " + numberOfImages.size());
           
        // Scroll to Helen's post
       // driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"helen\")"));
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"+ ".scrollIntoView(new UiSelector().textContains(\"helen\"))"));     
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // Find the number of images shown after scrolling
        numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println("Number of image shown currently: " + numberOfImages.size());
             
    }
    
    
    
    
    
}
