package activites;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity3 {
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
	        caps.setCapability("noReset", true);
	        
	        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub"); 
	        driver = new AndroidDriver<MobileElement>(remoteUrl, caps);	
	}	
	
	
	 @Test
	 public void add() {
	        driver.findElementById("digit_5").click();
	        driver.findElementById("op_add").click();
	        driver.findElementById("digit_9").click();
	        // Perform Calculation
	        driver.findElementById("eq").click();
	 
	        // Display Result
	        String result = driver.findElementById("result").getText();
	        System.out.println(result);
	        Assert.assertEquals(result, "14");
	  }
	 
	 
	 // Calculate 10 - 5 and print the result to the console.
	 @Test
	 public void subtract(){
		 driver.findElementById("digit_1").click();
		 driver.findElementById("digit_0").click();
		 driver.findElementByAccessibilityId("minus").click();
		 driver.findElementById("digit_5").click();
		 
		 // Perform Calculation
		 driver.findElementByAccessibilityId("equals").click();
	 
	     // Display Result
	     String result = driver.findElementById("result").getText();
	     System.out.println(result);
	     Assert.assertEquals(result, "5");
	 }
	 
	 //Calculate 5 * 100 and print the result to the console.
	  @Test
	  public void multiply() {
	        driver.findElementById("digit_5").click();
	        driver.findElementById("op_mul").click();
	        driver.findElementById("digit_1").click();
	        driver.findElementById("digit_0").click();
	        driver.findElementById("digit_0").click();
	        // Perform Calculation
	        driver.findElementById("eq").click();
	 
	        // Display Result
	        String result = driver.findElementById("result").getText();
	        System.out.println(result);
	        Assert.assertEquals(result, "500");
	    }
	  
		 
	 //Calculate 50 / 2 and print the result to the console.
	    @Test
	    public void divide() {
	        driver.findElementById("digit_5").click();
	        driver.findElementById("digit_0").click();
	        driver.findElementById("op_div").click();
	        driver.findElementById("digit_2").click();
	        // Perform Calculation
	        driver.findElementById("eq").click();
	 
	        // Display Result
	        String result = driver.findElementById("result").getText();
	        System.out.println(result);
	        Assert.assertEquals(result, "25");
	    }
	 
	 @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
	
}
