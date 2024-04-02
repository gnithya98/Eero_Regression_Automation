package Eero_capabilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Base_setup {
	
	public AndroidDriver driver;
	
	public Base_setup(AndroidDriver driver) {
		
		this.driver = driver;
	}
	
	public void eero_login() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.id("com.eero.android.dogfood:id/signup_button")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/sign_in_with_phone")).click();
		Thread.sleep(2000);
//		WebElement credential = driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/credentials_edit_text"));		
//		if(!credential.isDisplayed()) {
//			driver.findElement(AppiumBy.id("com.google.android.gms:id/cancel")).click();
//		}
//		else
//		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/credentials_edit_text"))
		.sendKeys("nithya.kalyani@eero.com");
		driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/next_button")).click();
		Thread.sleep(20000);
		
	}
	
	public void eero_DeleteNetwork() throws InterruptedException {
		
		//Explicit wait for OTP
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.eero.android.dogfood:id/settings"))).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/advanced")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Delete network\").instance(0))")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/delete_network_button")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		System.out.println("Network deleted successfully.");
	}
	
	
	
	public void eero_RestartNetwork() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Home")).click();
		driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/header_list")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Advanced\").instance(0))")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Restart \").instance(0))")).click();
		driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/restart_eero_button")).click();
		Thread.sleep(50000);
		driver.findElement(AppiumBy.accessibilityId("Home")).click();
		Thread.sleep(50000);
		driver.findElement(AppiumBy.accessibilityId("Home")).click();
		Thread.sleep(50000);
		driver.findElement(AppiumBy.accessibilityId("Home")).click();
		String onlineStatus = driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/status_button")).getText();
		//Status of the online
		if(onlineStatus == "Online") {
			System.out.println("Network is online");
		}else {
			System.out.println("Network is offline");
		}
	}
	
	public void eero_HardresetNetwork() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Home")).click();
		driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/header_list")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Advanced\").instance(0))")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Remove \").instance(0))")).click();
		driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/remove_eero_button")).click();
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		driver.findElement(AppiumBy.accessibilityId("Home")).click();
		Thread.sleep(30000);
		driver.findElement(AppiumBy.accessibilityId("Home")).click();
		String networkName = driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/network_name")).getText();
		//Status of the online
		if(networkName == "wifi-1") {
			System.out.println("Network is online");
		}else {
			System.out.println("Network is Deleted");
		}
	}
	
	public void eero_AddingLeaf() throws InterruptedException {
		
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
		Thread.sleep(25000);
		driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/button_next")).click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Kitchen']/parent::*/parent::*"))).click();
		Thread.sleep(15000);
		driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/button_next")).click();
		Thread.sleep(25000);
		//Home screen button
		driver.findElement(AppiumBy.accessibilityId("Home")).click();
		Thread.sleep(15000);
		//Checking the online status of the network
		String onlineStatus = driver.findElement(AppiumBy.id("com.eero.android.dogfood:id/status_button")).getText();
		//Status of the online
		if(onlineStatus == "Online") {
			System.out.println("Leaf node successfully added to the network");
		}else {
			System.out.println("Leaf node failed to add to the network");
		}
	}

	
}
