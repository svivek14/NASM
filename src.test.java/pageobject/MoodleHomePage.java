package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class contains the methods related to the moodle home page
 * 
 * Navigations to page -> 1. Login to student home page as end user 
 * 						  2. Go to Courses -> Select any course
 * @author Praveen.Maled
 * Date Created: 04-Oct-2016
 *
 */
public class MoodleHomePage extends MoodleLeftNavigationPane{

	
	/*Variables*/
	private String strResult=null;
	
	By hed_PageHeader = By.cssSelector("[id*='page'][id*='header'] h1");
	By hed_MainContentHeader = By.cssSelector("#maincontent+h2");
	By lnk_Logout = By.cssSelector(".logininfo a+a");
	
	
	public MoodleHomePage(WebDriver webDriver) {
		super(webDriver);
	}

	
	
	public String getPageHeader(){
		strResult=null;
		strResult=driver.findElement(hed_PageHeader).getText();
		return strResult;
	}
	
	
	public String getMainContentHeader(){
		strResult=null;
		strResult=driver.findElement(hed_MainContentHeader).getText();
		return strResult;
	}
	
	
	public void clickOnLogout(){
		
		driver.findElement(lnk_Logout).click();
	}
}
