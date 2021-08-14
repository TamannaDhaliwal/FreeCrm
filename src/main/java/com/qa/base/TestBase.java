package com.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.utils.TestUtils;
import com.qa.utils.WebEventListener;

public class TestBase {
public 	static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream(
					"C:\\Tamanna\\RestAssured\\FreeCrmPOM\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
			} catch (Exception e) {
			
			e.printStackTrace();
		}
	

	}


	public static void intialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();

		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtils.implicit_wait, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
	}
	
	

}
