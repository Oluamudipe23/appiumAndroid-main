
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class TestsClass extends Base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		 firstTest();

//		 longPressTest();

//		 swipeGesture();

//		 scrollGesture();

//		 dragAndDrop();
		
//		MobileBrowser.facebookTest();
		
//		GeneralStoreApp.generalStoreTest1();
		
//		GeneralStoreApp.generalStoreToastTest();
	}

	public static void firstTest() throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = null;

		if (driver == null) {
			driver = capabilities();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();

		int size = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
		System.out.println(size);

		driver.findElementByXPath("//android.widget.CheckBox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByXPath("//android.widget.EditText").sendKeys("1234");
		driver.findElementByAndroidUIAutomator("text(\"OK\")").click();

		driver.quit();
	}

	public static void longPressTest() throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = null;

		if (driver == null) {
			driver = capabilities();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")").click();

		WebElement customAdapter = driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")");

		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(tapOptions().withElement(element(customAdapter))).perform();

		WebElement peopleNames = driver.findElementByAndroidUIAutomator("text(\"People Names\")");

		// WORKS
		// ======
		// Option - 1
		// import org.openqa.selenium.interactions.Actions;
		// new Actions(driver).clickAndHold(peopleNames).perform();

		// Option - 2
		touchAction.longPress(longPressOptions().withElement(element(peopleNames)).withDuration(ofSeconds(2))).release()
				.perform();

		String copy = driver.findElementByAndroidUIAutomator("text(\"Sample menu\")").getText();
		boolean isDisplayed = driver.findElementByAndroidUIAutomator("text(\"Sample menu\")").isDisplayed();
		System.out.println("Copy is: " + copy);
		System.out.println("isDisplayed is: " + isDisplayed);

		driver.quit();
	}

	public static void swipeGesture() throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = null;

		if (driver == null) {
			driver = capabilities();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TouchAction touchAction = new TouchAction(driver);

		WebElement views = driver.findElementByAndroidUIAutomator("text(\"Views\")");
		touchAction.tap(tapOptions().withElement(element(views))).perform();

		WebElement dateWidgets = driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")");
		touchAction.tap(tapOptions().withElement(element(dateWidgets))).perform();

		WebElement inlineDateWidget = driver.findElementByAndroidUIAutomator("text(\"2. Inline\")");
		touchAction.tap(tapOptions().withElement(element(inlineDateWidget))).perform();

		WebElement initialTimeSelection = driver.findElementByAndroidUIAutomator("index(0)");
		WebElement finalTimeSelection = driver.findElementByAndroidUIAutomator("index(7)");

		// long press //on element// 2 sec// move to another element // release
		touchAction.longPress(longPressOptions().withElement(element(initialTimeSelection)).withDuration(ofSeconds(2)))
				.moveTo(element(finalTimeSelection)).release().perform();

		

		driver.quit();
	}

	public static void scrollGesture() throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = null;

		if (driver == null) {
			driver = capabilities();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TouchAction touchAction = new TouchAction(driver);

		WebElement views = driver.findElementByAndroidUIAutomator("text(\"Views\")");
		touchAction.tap(tapOptions().withElement(element(views))).perform();

		driver.findElementsByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView2\"))");

		WebElement webView2 = driver.findElementByXPath("//*[@text='WebView2']");

		System.out.println("webView2 is displayed: " + webView2.isDisplayed());

		Thread.sleep(2000);

		driver.quit();
	}

	public static void dragAndDrop() throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = null;

		if (driver == null) {
			driver = capabilities();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TouchAction touchAction = new TouchAction(driver);
		
		// Scroll 'Views' element into view
		driver.findElementsByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))");

		// Tap on 'Views' element
		WebElement views = driver.findElementByAndroidUIAutomator("text(\"Views\")");
		touchAction.tap(tapOptions().withElement(element(views))).perform();

		WebElement elementToDrag = driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")");
		touchAction.tap(tapOptions().withElement(element(elementToDrag))).perform();

		WebElement sourceElement = driver.findElementsByClassName("android.view.View").get(0);
		WebElement destinationElement = driver.findElementsByClassName("android.view.View").get(1);

		// Long press // on element // moveTo destination // release
		touchAction.longPress(element(sourceElement)).moveTo(element(destinationElement)).release().perform();

		// ALTERNATIVE (If you want to specify 'longPressOptions' such as 'withDuration()')
		// =======================
		// touchAction.longPress(longPressOptions().withElement(element(sourceElement)))
		// .moveTo(element(destinationElement)).release().perform();

		Thread.sleep(2000);

		driver.quit();
	}
}


//		export JAVA_HOME=$(/usr/libexec/java_home)
//		export PATH=$JAVA_HOME/bin:$PATH
//		export PATH=$M2:$PATH
//		export M2_HOME=/usr/local/apache-maven-3.6.3
//		export M2=$M2_HOME/bin
//		export MAVEN_OPTS=-"Xms256m -Xmx512m"
//		export PATH="$PATH:/Applications/Visual Studio Code.app/Contents/Resources/app/bin"
//		export RUBY_CONFIGURE_OPTS="--with-openssl-dir=$(brew --prefix openssl@1.1)"
//		export PATH="/usr/local/mysql/bin:$PATH"
//		export ANDROID_HOME=$HOME/Library/Android/sdk
//		export PATH=$ANDROID_HOME/tools
//		export PATH=$ANDROID_HOME/platform-tools
//		export PATH=$ANDROID_HOME/build-tools/30.0.3
//		eval "$(rbenv init -)"
