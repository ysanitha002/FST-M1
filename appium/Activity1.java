package activites;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Activity1 {
	AndroidDriver<MobileElement> driver = null;
	
	
	@BeforeClass
	public void setup() throws MalformedURLException{
		
		 DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "Pixel 4 AEmulator");
	        caps.setCapability("platformName", "android");
	        caps.setCapability("automationName", "UiAutomator2"); 
	       // caps.setCapability("ensureWebviewsHavePages", true); 
	        caps.setCapability("appPackage", "com.android.calculator2");
	        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
	        
	        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub"); 
	        driver = new AndroidDriver<MobileElement>(remoteUrl, caps);	
	}
	
	
    @Test
    public void calc() throws InterruptedException, IOException {
            
        // Initialize driver
		//driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		System.out.println("Calculator is open");
    }
}