package ogame.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;

public class Browser {
	
	public static WebDriver launch() {

		//System.setProperty("webdriver.chrome.driver","D:/Manizone/bin/chromedriver.exe");

		WebDriver driver = null;
		try {
			driver = getChromeDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.get("http://www.google.com");

		return new ChromeDriver();

	}

	public static WebDriver getChromeDriver()
			throws Exception
	{
		String baseDir = new File(".").getPath();
		System.out.println("******** " + baseDir);

		String path = "src/test/resources";
		System.out.println("******** " + path);
		System.setProperty("webdriver.chrome.driver", path);

		DesiredCapabilities capabilities =  DesiredCapabilities.chrome();
		capabilities.setCapability("marionette", true);
		capabilities.setCapability("networkConnectionEnabled", true);
		capabilities.setCapability("browserConnectionEnabled", true);


		WebDriver driver = new RemoteWebDriver(
				new URL("http://localhost:4444"),
				capabilities);

//		WebDriver driver = new MarionetteDriver(capabilities);

		return driver;
	}
}
