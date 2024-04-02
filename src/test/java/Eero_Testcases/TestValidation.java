package Eero_Testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Eero_capabilities.Base_setup;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestValidation {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	
	
	@BeforeClass(alwaysRun = true)
	public void ConfigureAppium() throws MalformedURLException, InterruptedException {
		
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Team EERO\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		
	//	options.setDeviceName("RingEmulator");
		options.setDeviceName("OnePlus GM1911");
		options.setApp("C:\\Users\\Team EERO\\Documents\\Crio\\Eero\\src\\main\\java\\Eero_Resorces\\eero-v6.41.0.36641-dogfood-debug.apk");
		options.setCapability("autoGrantPermissions", true);
		options.setCapability("ignoreHiddenApiPolicyError", true);
		options.setCapability("appWaitActivity", "com.eero.android.v3.features.onboarding.V3OnboardingActivity");
		options.setCapability("noReset", true);
		Thread.sleep(20000);
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
	@Test(enabled = false, description = "Vlan setup on gateway", priority = 1, groups = {"Vlan_setup"})
	public void vlanSetupOnGateway() throws InterruptedException {
		
		Eero_Vlan_setup vlan = new Eero_Vlan_setup(driver);
		vlan.eero_VlanSetup();	
	}
	
	@Test(enabled = false, description = "Vlan setup on leaf node", priority = 2, groups = {"Vlan_setup"})
	public void basicSetupOnLeaf() throws InterruptedException {
		
		Eero_Vlan_setup vlan = new Eero_Vlan_setup(driver);
		vlan.eero_Vlan_Leafnode();
	}
	
	@Test(enabled = false, description = "Vlan network soft reset.", priority = 3, groups = {"Vlan_setup"})
	public void softReset_Vlan() throws InterruptedException {
		
		Base_setup basic = new Base_setup(driver);		
		basic.eero_RestartNetwork();		
	}
	
	@Test(enabled = false, description = "Vlan network hard reset.", priority = 4, groups = {"Vlan_setup"})
	public void hardReset_Vlan() throws InterruptedException {
		
		Base_setup basic = new Base_setup(driver);		
		basic.eero_HardresetNetwork();
	}
	
	@Test(enabled = true, description = "Vlan network mirror error state", priority = 5, groups = {"Vlan_setup"})
	public void mirrorError_Vlan() throws InterruptedException {
		
		Eero_Vlan_setup vlan = new Eero_Vlan_setup(driver);
		vlan.eero_Vlan_MirrorError();
	}

	
	@Test(enabled = false, description = "PPPOE setup on gateway", priority = 1, groups = {"Pppoe_setup"})
	public void pppoeSetupOnGateway() throws InterruptedException {
		
		Eero_pppoe_setup pppoe = new Eero_pppoe_setup(driver);
		pppoe.eero_PppoeSetup_Gateway();
	}
	
	@Test(enabled = false, description = "PPPOE setup on gateway", priority = 2, groups = {"Pppoe_setup"})
	public void pppoeLeafnodeSetup() throws InterruptedException {
		
		Eero_pppoe_setup pppoe = new Eero_pppoe_setup(driver);
		pppoe.eero_Pppoe_Leafnode();
	}
		
	@Test(enabled = false, description = "PPPOE network soft reset.", priority = 3, groups = {"Pppoe_setup"})
	public void softReset_PPPOE() throws InterruptedException {
		
		Base_setup basic = new Base_setup(driver);		
		basic.eero_RestartNetwork();		
	}
	
	@Test(enabled = false, description = "PPPOE network hard reset.", priority = 4, groups = {"Pppoe_setup"})
	public void hardReset_PPPOE() throws InterruptedException {
		
		Base_setup basic = new Base_setup(driver);		
		basic.eero_HardresetNetwork();
	}
	
	@Test(enabled = false, description = "PPPOE credential change.", priority = 5, groups = {"Pppoe_setup"})
	public void credentialChange_PPPOE() throws InterruptedException {
		
		Eero_pppoe_setup pppoe = new Eero_pppoe_setup(driver);
		pppoe.eero_Pppoe_CredentialChange();
	}
	
	@Test(enabled = false, description = "Static setup on gateway", priority = 1, groups = {"Static_setup"})
	public void StaticIpSetupOnGateway() throws InterruptedException {
		
		Eero_StaticIp_Setup staticIp = new Eero_StaticIp_Setup(driver);
		staticIp.eero_Static_GatewaySetup();
	}
	
	@Test(enabled = false, description = "Static setup on gateway", priority = 2, groups = {"Static_setup"})
	public void StaticIpSetupOnLeafnode() throws InterruptedException {
		
		Eero_StaticIp_Setup staticIp = new Eero_StaticIp_Setup(driver);
		staticIp.eero_StaticIp_Leafnode();
	}
	
	@Test(enabled = false, description = "PPPOE network soft reset.", priority = 3, groups = {"Static_setup"})
	public void softReset_Static() throws InterruptedException {
		
		Base_setup basic = new Base_setup(driver);		
		basic.eero_RestartNetwork();		
	}
	
	@Test(enabled = false, description = "PPPOE network hard reset.", priority = 4, groups = {"Static_setup"})
	public void hardReset_Static() throws InterruptedException {
		
		Base_setup basic = new Base_setup(driver);		
		basic.eero_HardresetNetwork();
	}
	
	

	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
