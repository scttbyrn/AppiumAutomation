package appiumSetup;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseWebApp {

	public static UiAutomator2Options options;
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;

	@Test
	public void AppiumConnect() throws MalformedURLException, URISyntaxException, InterruptedException {

		/*Setup automatically connect on appium server*/
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C://Users//scottbyron.escueta//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
		service.start();

		/*Setup uiAutomator2*/
		options = new UiAutomator2Options();
		options.setDeviceName("TestAppiumGPTT");
		options.setChromedriverExecutable("C:\\Users\\scottbyron.escueta\\Downloads\\chromedriver-win64\\chromedriver.exe");
		options.setCapability("browserName","Chrome");

		/*Setup androidDriver*/
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		/*TestExecution*/
		driver.get("https://www.udemy.com"); //webApp
		System.out.println("Title of the current page: " +driver.getTitle());
		driver.quit();

		/*Stop Appium Server*/
		service.stop();
		
		

		//return driver;

	}

}
