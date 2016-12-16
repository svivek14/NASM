package common;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.ReadProperty;


public class DriverFactory {
	
	static String pfileName = "global.properties";
	static Properties  prop = new ReadProperty().readPropertyFile(pfileName);
	
	static WebDriver driver;
	static String url = prop.getProperty("url");
	static String browser = prop.getProperty("browser");
	static int timeOut = Integer.parseInt(prop.getProperty("timeOut"));
	static int implecitWait = Integer.parseInt(prop.getProperty("implecitWait"));
	
	
	public static WebDriver setUpDriver(){
		if (browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);
			//driver.get(url);
			driver.manage().timeouts().implicitlyWait(implecitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(implecitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		else if (browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/driver/geckodriver.exe");
			driver = new FirefoxDriver();
			//driver.get(url);
			driver.manage().timeouts().implicitlyWait(implecitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(implecitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		else if (browser.equals("ie")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			//driver.get(url);
			driver.manage().timeouts().implicitlyWait(implecitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(implecitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		else if (browser.equals("edge")){
			//Incomplete code
			driver = new EdgeDriver();
			//driver.get(url);
			driver.manage().window().maximize();
		}
		
		else if (browser.equals("safari")){
			System.setProperty("webdriver.safari.noinstall", "true"); //To stop uninstall each time
			driver = new SafariDriver();
			//driver.get(url);
			driver.manage().timeouts().implicitlyWait(implecitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(implecitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	
	public static void shutDownDriver(){
		driver.close();
		driver.quit();
	}
	
		
	public static WebDriver getDriver(){
		return driver;
	}
	

}
