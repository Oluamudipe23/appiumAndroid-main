//package appiumDemoProjectOne;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		
		AndroidDriver<AndroidElement>  driver;
		
		File appDir = new File("apps");
		File app = new File(appDir, "ApiDemos-debug.apk");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		// Uncomment if running on against emulator
		// capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Device1");
		
		// Uncomment these 2 lines if running on against real Android devices
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
//		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//		capabilities.setCapability("noReset", true);
//		capabilities.setCapability("appWaitPackage", "com.google.android.packageinstaller");
//		capabilities.setCapability("appWaitActivity", "com.android.packageinstaller.permission.ui.GrantPermissionsActivity");
//		capabilities.setCapability("noReset", true);
//		capabilities.setCapability("autoGrantPermissions", true);
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		return driver;
	}
}
