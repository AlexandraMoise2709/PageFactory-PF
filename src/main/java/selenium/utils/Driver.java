package selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {
	
	//public WebDriver driver ;
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver(getChromeOptions()));
			return driver.get();
		}else if (browser.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver(getFirefoxOptions()));
			//driver.set(new FirefoxDriver());
		}else if (browser.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		}	
		return driver.get();
		
		
	}
	
	public static FirefoxOptions getFirefoxOptions() {
		FirefoxOptions option = new FirefoxOptions();
		option.addArguments("--headless");
		return option;
		
		
	}
	
	public static ChromeOptions getChromeOptions() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--window-size=1800,1200");
		option.addArguments("--headless");
		return option;
		
		
	}
	
	
}
