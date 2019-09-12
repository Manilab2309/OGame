package ogame.util;

import ogame.application.OGameApplication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Browser {

	/** Logger */
	private static final Logger logger = LoggerFactory.getLogger(OGameApplication.class);

	public static WebDriver launchChrome() {

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		//options.addArguments("headless");

		return new ChromeDriver(options);
	}

	public static WebDriver launchFirefox() {

		System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");

		return new FirefoxDriver();


	}
}
