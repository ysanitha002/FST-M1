package activites;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;



public class Activity5 {  
     WebDriverWait wait;
	AndroidDriver<MobileElement> driver = null;
	
	@BeforeClass
	public void setup() throws MalformedURLException{
		
		 DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "Pixel 4 AEmulator");
	        caps.setCapability("platformName", "android");
	        caps.setCapability("automationName", "UiAutomator2"); 
	        caps.setCapability("ensureWebviewsHavePages", true); 
	        caps.setCapability("appPackage", "com.google.android.apps.messaging");
	        caps.setCapability("appActivity", ".ui.ConversationListActivity");
	        caps.setCapability("noReset", true);
	        
	        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub"); 
	        driver = new AndroidDriver<MobileElement>(remoteUrl, caps);	
	        wait = new WebDriverWait(driver, 5);
	}	
	
	@Test
    public void smsTest() {
        // Locate the button to write a new message and click it
        //driver.findElement(MobileBy.AndroidUIAutomator("description(\"Create New Message\")")).click();
        driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/start_new_conversation_button")).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.messaging:id/recipient_text_view")));
        driver.findElementById("recipient_text_view").sendKeys("7353801352");
        //driver.findElementById("recipient_text_view").click();
        
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        
               
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        
        // Focus on the contact found 
        //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.messaging:id/contact_list_view")));
       // driver.findElementById("com.google.android.apps.messaging:id/contact_picker_create_group").click();
        
 
        // Focus on the message text box
        String messageBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")";
        driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator)).click();
        
        driver.findElementById("com.google.android.apps.messaging:id/compose_message_text").sendKeys("Hello from Appium");
 
        // Send the message
        driver.findElementById("com.google.android.apps.messaging:id/send_message_button_icon").click();
 
        // Wait for message to show
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("message_text")));
 
        // Assertion
        String sentMessageText = driver.findElementById("com.google.android.apps.messaging:id/message_text").getText();
        Assert.assertEquals(sentMessageText, "Hello from Appium");
    }
 
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

	
}
