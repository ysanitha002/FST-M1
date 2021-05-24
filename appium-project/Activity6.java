package Project;

import java.net.MalformedURLException;
import java.net.URL;
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
    
    @Test (priority = 1)
    public void successTest()
    {
    	String msg = cardLogin("admin","password");
    	System.out.println("Success Test Executed");
    	Assert.assertEquals(msg, "Welcome Back, admin");
    }
    
    @Test (priority = 2)
    public void failureTest()
    {
    	String msg = cardLogin("admin","passd");
    	System.out.println("Failure Test Executed");
    	Assert.assertEquals(msg, "Invalid Credentials");
    	
    }
    
  
    public String cardLogin (String username, String password) {
    	
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.training-support.net/selenium");
        
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        
        //scroll to the end of the page
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).flingToEnd(5)"));
        
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[contains(@text,'To-Do List')]")));
        driver.findElementByXPath("//android.view.View[contains(@text,'Popups')]").click();
        
        System.out.println("We are on the Popups Page");
        
        // Click on Sign in button 
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[contains(@text,'Sign In')]")));
        driver.findElementByXPath("//android.widget.Button[contains(@text,'Sign In')]").click();
     
        //Enter Username
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View/android.widget.EditText[1]")));
        driver.findElementByXPath("//android.view.View/android.widget.EditText[1]").sendKeys(username);
        
        //Enter password
        driver.findElementByXPath("//android.view.View/android.widget.EditText[2]").sendKeys(password);
        
        // click on Login Button 
        driver.findElementByXPath("//android.widget.Button[contains(@text,'Log in')]").click();
        
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        
        
        
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.className("android.webkit.WebView")));
        driver.findElementByClassName("android.webkit.WebView").click();
        
                // confirmation message   
        //wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[1]/android.view.View[4]")));
       // String LoginMsg = driver.findElementByXPath("//android.view.View[1]/android.view.View[4]").getText();      
       // System.out.println(LoginMsg);    
        
        String msg = driver.findElementByXPath("//android.webkit.WebView/android.view.View[1]/android.view.View[4]").getText();
        if ( msg.isBlank()) {
        	msg = driver.findElementByXPath("//android.webkit.WebView/android.view.View[1]/android.view.View[2]").getText();
        }	 
        
        System.out.println(msg);  
        return msg;
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

