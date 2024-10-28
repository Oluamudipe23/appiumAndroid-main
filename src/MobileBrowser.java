
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MobileBrowser extends BaseMobileBrowser {

	public static void facebookTest() throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver = null;
		
		if (driver == null) {
			driver = capabilities();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://membership-app-by-kay.herokuapp.com/registration");
		driver.findElementById("inputFirstName").sendKeys("Olu");
		driver.findElementById("inputLastName").sendKeys("Man");
		driver.findElementById("inputEmail").sendKeys("olu@gmail.com");
		Thread.sleep(2000);
		driver.findElementById("btnContinueSubmit").click();
		Thread.sleep(2000);
		
		driver.quit();
	}
}
