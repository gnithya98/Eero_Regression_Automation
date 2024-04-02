package Eero_Testcases;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Eero_Vlan_setup {
	
public AndroidDriver driver;
public int num = 112;
	
	public Eero_Vlan_setup(AndroidDriver driver) {
		
		this.driver = driver;
	}
	
	public void randomNum() {
		
		Random random = new Random();
		num = random.nextInt(4999);
	}
	
	String numText = String.valueOf(num);
	
public void eero_VlanSetup() throws InterruptedException {
		
		//Explicit wait for OTP
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		Thread.sleep(10000);
		//Home screen button
		driver.findElement(AppiumBy.accessibilityId("Home")).click();
		//Add menu
        driver.findElement(AppiumBy.accessibilityId("Open the add menu")).click();	
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
		Thread.sleep(25000);
		//Can't reach the internet, Internet settings button
		wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.eero.android.dogfood:id/secondary_button"))).click();
		Thread.sleep(10000);
		//VLAN tag page
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.eero.android.dogfood:id/basic_switch"))).click();
		//Enter VLAN tag id
		driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/input_text")).sendKeys("10");
		//Save settings button
		driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/primary_button")).click();
		Thread.sleep(30000);
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
		//Status of the online
		if(onlineStatus.equals("Online")) {
			System.out.println("VLAN network has been created successfully");
		}else {
			System.out.println("VLAN network has not been established");
		}
	}

public void eero_Vlan_Leafnode() throws InterruptedException {
	
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

public void eero_Vlan_MirrorError() throws InterruptedException {
	
	//Explicit wait for OTP
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
			//Home screen button
			wait.until(ExpectedConditions.presenceOfElementLocated((AppiumBy.accessibilityId("Home")))).click();
			//Settings
			driver.findElement(AppiumBy.accessibilityId("Settings")).click();
	        //Settings menu
			driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/settings_menu")).click();
			//Add a network button
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Add a network']/parent::*")).click();
			//you're ready to start button
			driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/next_button")).click();		
			//First, unplug your old modem......
			driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/button_next")).click();
			//Connect your Gateway.......
			driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/button_next")).click();
			//Plug your Gateway......
			driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/button_next")).click();
			//Can't reach the internet, Internet settings button
			wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.eero.android.dogfood:id/secondary_button"))).click();
			//VLAN tag page
			wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.eero.android.dogfood:id/basic_switch"))).click();
			//Enter VLAN tag id
			driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/input_text")).sendKeys(numText);
			//Save settings 
			driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/primary_button")).click();
			//Can't reach the internet, Internet settings button
			wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.eero.android.dogfood:id/secondary_button"))).click();
			//Enter VLAN tag id
			driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/input_text")).clear();
			driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/input_text")).sendKeys("10");
			//Save settings 
			driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/primary_button")).click();
			//Where's your eero Pro 6 ?
			wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Garage']/parent::*/parent::*"))).click();
			//Entering wifi name
			driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/network_name_edit_text")).sendKeys("wifi-1");
			//Entering wifi password
			driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/network_password_edit_text")).sendKeys("11112222");
			//Click on next button
			wait.until(ExpectedConditions.presenceOfElementLocated((AppiumBy.accessibilityId("Next")))).click();
			//Finish setup button
			wait.until(ExpectedConditions.presenceOfElementLocated((AppiumBy.id("com.eero.android.dogfood:id/button_next")))).click();
			//Skip the amazon page
			try {
				driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/right_action")).click();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//Home screen button
			wait.until(ExpectedConditions.presenceOfElementLocated((AppiumBy.accessibilityId("Home")))).click();
			//Wants to join the network?
			try {
				driver.findElement(AppiumBy.id("android:id/button1")).click();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			//Checking the online status of the network
			wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id='status_button']")));
			String onlineStatus = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='status_button']")).getText();
			//Status of the online
			if(onlineStatus.equals("Online")) {
				System.out.println("VLAN network has been created successfully");
			}else {
				System.out.println("VLAN network has not been established");
			}
}

}
