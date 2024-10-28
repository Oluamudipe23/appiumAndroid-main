
// Code for Mobile Browser capabilities

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseMobileBrowser {
	
	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

		AndroidDriver<AndroidElement> driver;

		DesiredCapabilities capabilities = new DesiredCapabilities();
		
//		Old path to chromedriver.exe
//		capabilities.setCapability("chromedriverExecutable", "/Users/kayodeomo/Documents/workspace/chromedriver.exe");
		
		capabilities.setCapability("chromedriverExecutable", "/Users/kayodeomo/Documents/workspace/chromedriver.exe");
		
		capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Device1");

		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		return driver;
	}
}
