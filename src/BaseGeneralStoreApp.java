
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseGeneralStoreApp {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		
		File appDir = new File("apps");
		File app = new File(appDir, "General-Store.apk");
		
		AndroidDriver<AndroidElement>  driver;
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Device1");
//		capabilities.setCapability("chromedriverExecutable", "/Users/kayodeomo/Documents/workspace/chromedriver-83/chromedriver.exe")
//		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		
		capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		return driver;
	}
}
