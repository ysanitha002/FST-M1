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

public class Activity5 {
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
    public void successTest()
    {
    	String msg = testLogin("admin","password");
    	System.out.println("Success Test Executed");
    	Assert.assertTrue(msg.contains("Welcome Back, admin"));
   	
    }
    
    @Test 
    public void failureTest()
    {
    	String msg = testLogin("admin","passd");
    	System.out.println("Failure Test Executed");
    	Assert.assertTrue(msg.contains("Invalid Credentials"));
    	
    }
    
       public String testLogin (String username, String password) {
    	
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("https://www.training-support.net/selenium");

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        
        //Scroll to find the Login Form card and click it. 
        
        System.out.println("Using Scroll Forward 1)");
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
        
        System.out.println("Using Scroll Forward 2)");
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()")); 
              
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[contains(@text,'Login Form')]")));
        driver.findElementByXPath("//android.view.View[contains(@text,'Login Form')]").click();
        
        System.out.println("We are working on the Login Page");
        
        // Wait for the Sign In Page to Load
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[contains(@text,'Please sign in!')]")));   
        
        //Enter Username
        //driver.findElementByXPath("//android.view.View[2]/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[1]")
        driver.findElementByXPath("//android.view.View/android.widget.EditText[1]").sendKeys(username);
        
        //Enter password
        driver.findElementByXPath("//android.view.View/android.widget.EditText[2]").sendKeys(password);
        
        // click on Login Button 
        driver.findElementByXPath("//android.widget.Button[contains(@text,'Log in')]").click();
        
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[contains(@text,'Login Form')]")));
        
        System.out.println("Successfully Logged In");
        
       // System.out.println(driver.findElementByXPath("//android.webkit.WebView/android.view.View[1]/android.view.View[2]").getText());     
        System.out.println(driver.findElementByXPath("//android.webkit.WebView/android.view.View[1]/android.view.View[3]").getText());      
        System.out.println(driver.findElementByXPath("//android.webkit.WebView/android.view.View[1]/android.view.View[4]").getText());
               
        MobileElement actionConfirm = driver.findElementByXPath("//android.webkit.WebView/android.view.View[1]/android.view.View[4]");
              
        String LoginMsg = actionConfirm.getText();
        System.out.println("LoginMsg : "+ LoginMsg);
        
        return LoginMsg;
        
    }

    @AfterTest
    public void tearDown() { 
        driver.quit();
    }
}
