package appiumSetup;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumDesiredCaps {


	public static UiAutomator2Options options;
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;


	@Test
	public void DesiredCaps() throws MalformedURLException, URISyntaxException {

//		/*Setup automatically connect on appium server*/
//		service = new AppiumServiceBuilder()
//				.withAppiumJS(new File("C://Users//scottbyron.escueta//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
//				.withIPAddress("127.0.0.1")
//				.usingPort(4723)
//				.build();
//		service.start();
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("udid", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("deviceName", "TestAppiumGPTT");
		caps.setCapability("automationName", "UiAutomator2");
//		caps.setCapability("appium:app", "C:\\Users\\scottbyron.escueta\\AppData\\Local\\Android\\Sdk\\platform-tools");
		
		
		
//		caps.setCapability("deviceName", "TestAppiumGPTT");
//		caps.setCapability("udid", "emulator-5554");
		
		
//		caps.setCapability(CapabilityType.BROWSER_NAME, "Google");
//		caps.setCapability("app", "C:\\Users\\scottbyron.escueta\\AppData\\Local\\Android\\Sdk\\platform-tools\\app-dev-release.apk" );
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), caps);

		driver.quit();

//		/*Setup uiAutomator2*/
//		options = new UiAutomator2Options();
//		options.setDeviceName("TestAppiumGPTT");
//		options.setApp("C://Users//scottbyron.escueta//eclipse-workspace//AppiumSetup//src//test//resources//Apk//app-dev-release.apk"); //nativeApp


	}

}
