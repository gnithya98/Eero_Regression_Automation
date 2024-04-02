package Eero_Testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumExecutionMethod;
import io.appium.java_client.android.AndroidDriver;

public class Eero_pppoe_setup {
	
public AndroidDriver driver;
	
	public Eero_pppoe_setup(AndroidDriver driver) {
		
		this.driver = driver;
	}
	
public void eero_PppoeSetup_Gateway() throws InterruptedException {
	
	//Menu section
	driver.findElement(AppiumBy.accessibilityId("Open the add menu")).click();
	//Network is offline 
	driver.findElement(AppiumBy.id("android:id/button1")).click();
	//Add a network button
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/add_network")).click();
	//you're ready to start button
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/next_button")).click();		
	//First, unplug your old modem......
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/button_next")).click();
	//Connect your Gateway.......
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/button_next")).click();
	//Plug your Gateway......
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/button_next")).click();
	Thread.sleep(5000);
	//Looking for the green light
	try {
		driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/setup_confirmation_next_button")).click();
	} catch (Exception e) {
		e.printStackTrace();
	}
	Thread.sleep(25000);
	//Can't reach the internet, Internet settings button
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.eero.android.dogfood:id/secondary_button"))).click();
	Thread.sleep(10000);
	//WAN type
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/value")).click();
	//Selecting PPPOE option
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/pppoe_radio_row")).click();
	//Entering credentials
	driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id='com.eero.android.dogfood:id/pppoe_username_input']/child::*/child::*")).sendKeys("vanshil");
	driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id='com.eero.android.dogfood:id/pppoe_password_input']/child::*/child::*")).sendKeys("PASSWORD");
	//Apply button
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/primary_button")).click();
	Thread.sleep(5000);
	//Save settings button
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/primary_button")).click();
	Thread.sleep(15000);
	//Selecting the router location
			wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Living room']/parent::*/parent::*"))).click();
			//Entering wifi name
			driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/network_name_edit_text")).sendKeys("wifi-1");
			Thread.sleep(2000);
			//Entering wifi password
			driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/network_password_edit_text")).sendKeys("11112222");
			Thread.sleep(2000);
			//Click on next button
			driver.findElement(AppiumBy.accessibilityId("Next")).click();
			Thread.sleep(5000);
			//Finish setup button
			driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/button_next")).click();
			//Skip the amazon page
			try {
				driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/right_action")).click();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Thread.sleep(15000);
			//Home screen button
			driver.findElement(AppiumBy.accessibilityId("Home")).click();
			Thread.sleep(5000);
			//Checking the online status of the network
			String onlineStatus = driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/status_button")).getText();
			System.out.println(onlineStatus);
			//Status of the online
			if(onlineStatus.equals("Online")) {
				System.out.println("PPPOE network has been created successfully");
			}else {
				System.out.println("PPPOE network has not been established");
			}
}

public void eero_Pppoe_Leafnode() throws InterruptedException {
	driver.findElement(AppiumBy.accessibilityId("Home")).click();
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/navigation_add")).click();
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/add_eero_device")).click();
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/primary_button")).click();
	//Place your eero device
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/button_next")).click();
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/button_next")).click();
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/button_next")).click();
	//plug in your eero device
	driver.findElement(AppiumBy.accessibilityId("Next")).click();
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/button_next")).click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Kitchen']/parent::*/parent::*"))).click();
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/button_next")).click();
	Thread.sleep(10000);
	try {
		//Let's get your network up to speed
		driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/zero_day_update_secondary_button")).click();
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		Thread.sleep(10000);
	} catch (Exception e) {
		e.printStackTrace();
	}
	//Home screen button
	Thread.sleep(35000);
	driver.findElement(AppiumBy.accessibilityId("Home")).click();
	Thread.sleep(5000);
	//Checking the online status of the network
	String onlineStatus = driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/status_button")).getText();
	System.out.println(onlineStatus);
	//Status of the online
	if(onlineStatus.equals("Online")) {
		System.out.println("Leaf node successfully added to the network");
	}else {
		System.out.println("Leaf node failed to add to the network");
	}
}

public void eero_Pppoe_CredentialChange() throws InterruptedException {
	
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/home")).click();
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/settings")).click();
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/advanced")).click();
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='ISP Settings']/parent::*/parent::*")).click();
	driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/value")).click();
	driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id='com.eero.android.dogfood:id/pppoe_email_input']/child::*/child::*")).clear();
	driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id='com.eero.android.dogfood:id/pppoe_email_input']/child::*/child::*")).sendKeys("amazon");
	driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id='com.eero.android.dogfood:id/pppoe_password_input']/child::*/child::*")).sendKeys("amazon123");
	driver.findElement(AppiumBy.className("android.widget.Button")).click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Home"))).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id='status_button']")));
	String onlineStatus = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='status_button']")).getText();
	System.out.println(onlineStatus);
	//Status of the online
		if(onlineStatus.equals("Online")) {
			System.out.println("Leaf node successfully added to the network");
		}else {
			System.out.println("Leaf node failed to add to the network");
		}
	
	
}
}
