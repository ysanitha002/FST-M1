package activites;

import java.net.MalformedURLException;
import java.net.URL;

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

public class Activity4 {
   
	WebDriverWait wait;
	AndroidDriver<MobileElement> driver = null;
	
	@BeforeClass
	public void setup() throws MalformedURLException{
		
		 DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "Pixel 4 AEmulator");
	        caps.setCapability("platformName", "android");
	        caps.setCapability("automationName", "UiAutomator2"); 
	        caps.setCapability("ensureWebviewsHavePages", true); 
	        caps.setCapability("appPackage", "com.android.contacts");
	        caps.setCapability("appActivity", ".activities.PeopleActivity");
	        caps.setCapability("noReset", true);
	        
	        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub"); 
	        driver = new AndroidDriver<MobileElement>(remoteUrl, caps);	
	        wait = new WebDriverWait(driver, 5);
	}	
	
	
	 @Test
	 public void addContact() {
		 
		    driver.findElementByAccessibilityId("Create new contact").click();
		   
		    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar")));
		    driver.findElementByXPath("//android.widget.EditText[contains (@text,'First name')]").sendKeys("Aditya");
		    
		    driver.findElementByXPath("//android.widget.EditText[contains (@text,'Last name')]").sendKeys("Varma");
		    
		   // driver.findElementByXPath("//android.widget.EditText[contains(@text='Phone')]").sendKeys("9886623456");
		    
		    MobileElement Phone = driver.findElementByXPath("//android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText");
		    Phone.sendKeys("9886623456");
		    
		    driver.findElementById("com.android.contacts:id/editor_menu_save_button").click();
		    
		    System.out.println("contact is added successfully");
		    
		    wait = new WebDriverWait(driver, 5);
		    
		    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.android.contacts:id/toolbar")));
		    
	        // Assertion
	        MobileElement mobileCard = driver.findElementById("toolbar");
	        Assert.assertTrue(mobileCard.isDisplayed());
	        
	        String contactName = driver.findElementById("title_gradient").getText();
	        Assert.assertEquals(contactName, "Aaditya Varma"); 
		        		      
	  }
	 
	 @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
}
