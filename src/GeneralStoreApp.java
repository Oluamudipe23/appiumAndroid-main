
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GeneralStoreApp extends BaseGeneralStoreApp {

	public static void generalStoreTest1() throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = null;

		if (driver == null) {
			driver = capabilities();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("android:id/text1").click();
		driver.findElementsByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Cyprus\"))");
		
		// Alternative to the top scroll
		// driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));  
		driver.findElementByAndroidUIAutomator("text(\"Cyprus\")").click();
		
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Olu");
		driver.hideKeyboard();
		
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

		Thread.sleep(3000);

		driver.quit();
	}
	
	public static void generalStoreToastTest() throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = null;

		if (driver == null) {
			driver = capabilities();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		// Lecture 40 - Udemy Appium tutorial
		// The standard is that toast elements have a className 'android.widget.Toast'
		// Also, 'name' attribute of toasts have content
		// You can use class name as tag in an Xpath
		String firstToastMessage = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");

		System.out.println("Text on the toast is: " + firstToastMessage);

		Thread.sleep(3000);

		driver.quit();
	}
}
