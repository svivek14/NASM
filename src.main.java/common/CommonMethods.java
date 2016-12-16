package common;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import utils.ReadProperty;

/**
 * Class contains all the common methods required for the NASM application automation
 * 
 * @author Vivek.Sharma
 *
 */
public class CommonMethods {
	WebDriver driver;
	JavascriptExecutor executor;
	public static String pfileName = "testData.properties";
	public static Properties  prop = new ReadProperty().readPropertyFile(pfileName);
	public boolean flag=false;
	public String strResult=null;
	
	public CommonMethods (WebDriver driver){
		this.driver = DriverFactory.getDriver();
	}
	
	/**
	 * Method will wait till specified page title appears or 30 seconds whichever occurs first
	 * 
	 * @param pageTitle
	 */
	public void waitForPageTitle(String pageTitle){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleIs(pageTitle));
	}
	
	/**
	 * Method will wait for the specified element to be present in the page
	 * 
	 * @param element
	 */
	public void waitForElementPresent(By element){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
	}
	
	/**
	 * Method will selected the passed visible text from specified drop down 
	 * 
	 * @param we
	 * @param visibleText
	 */
	public void selectDropdownItemByVisibleText(By we, String visibleText) {
		try{
		Select dropDown = new Select(driver.findElement(we));
		if (dropDown != null) 
			dropDown.selectByVisibleText(visibleText);
		}
		catch(Exception e){
			Reporter.log("Either element not found or Requested value is not present in dropdown");
		}
	}
	
	/**
	 * Method will return true if element is present else it returns false
	 * 
	 * @param element
	 * @return boolean
	 */
    public boolean isElementDisplayed(By element){
    	try{
			flag=driver.findElement(element).isDisplayed();
		}catch(NoSuchElementException |TimeoutException e){
			flag=false;
		}
    	return flag;
    }
	
	/**
	 * Method used to click by Javascript
	 * @param element
	 */
	public void clickByJavascript(By element) {
			  executor = (JavascriptExecutor)driver;
			 executor.executeScript("arguments[0].click();", driver.findElement(element));
	}
	
	/**
	 * Method used to click by Javascript based on javascript query passed in method
	 * method will take string parameter which has javascript query
	 *  ex: document.getElementById('terms_and_conditions') 
	 * @param element
	 */
	public void clickByJavascript(String element) {
			  executor = (JavascriptExecutor)driver;
			 executor.executeScript(element+".click();");
	}
	
	/**
	 * Method used to switch to specified frame 
	 * Need to pass frame id or name as parameter for this method
	 * 
	 * @param strFrame
	 */
	public void switchToFrame(String strFrame){
		
		driver.switchTo().frame(strFrame);
		
	}
	
	
	/**
	 * Method used to switch to specified frame 
	 * Need to pass locator of the frame to which user wants to switch
	 * 
	 * @param locator
	 */
	public void switchToFrame(By locator){
		
		driver.switchTo().frame(driver.findElement(locator));
		
		
	}
	
	
	/**
	 * Method used to switch to Default content or the default frame in page
	 * 
	 */
	public void switchToDefaultFrame(){
		
		driver.switchTo().defaultContent();
		
	}
	
	
	/**
	 *  Replace value for dynamically defined element
	 * The value to be replaced in locater should be mention as {1} ,{2} etc
	 * Ex:if user passes replaceLocatorValues("//font[contains(text(),'{1}')]/[contains(text(),'{2}')]","header","test")
	 * returnvalue: //font[contains(text(),'header')]/[contains(text(),'test')]
	 * 
	 * @param locator
	 * @param values
	 * @return By 
	 * @throws Exception
	 */
	public By replaceLocatorValues(By locator,String... values){
		String type=null;
		String loc=null;
		try{
			strResult=locator.toString();
			 type=strResult.substring(strResult.indexOf(".")+1,strResult.indexOf(":"));
			 loc=strResult.substring(strResult.indexOf(":")+1);
	        for (int i = 0; i < values.length; i++) {
	            String value = values[i];
	            loc = loc.replace("{" + (i + 1) + "}", value);
	        }
		}catch(Exception e){
			System.out.println("FAILED TO REPLACE VALUES \n METHOD :replaceLocatorValues");
		}
		return regenerateLocator(type, loc);
	}
	
	
	
	/**
	 * Method will regenerate the locator based on the passed locator type and locator
	 * 
	 * @param strType
	 * @param strLocator
	 * @return
	 */
	public By regenerateLocator(String strType,String strLocator){

		By dynamicLocator=null;
		switch(strType){
		case "id":
			dynamicLocator = By.id(strLocator);
			break;
		case "name":
			dynamicLocator = By.name(strLocator);
			break;
		case "className":
			dynamicLocator = By.className(strLocator);
			break;
		case "linkText":
			dynamicLocator = By.linkText(strLocator);
			break;
		case "partialLinkText":
			dynamicLocator = By.partialLinkText(strLocator);
			break;
		case "tagName":
			dynamicLocator = By.tagName(strLocator);
			break;
		case "cssSelector":
			dynamicLocator = By.cssSelector(strLocator);
			break;
		case "xpath":
			dynamicLocator = By.xpath(strLocator);
			break;
		default:
				break;
		}
		return dynamicLocator;
	}
}
