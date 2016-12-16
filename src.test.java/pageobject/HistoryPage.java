package pageobject;

import org.openqa.selenium.WebDriver;

/**
 * Class contains methods related to History page in student home page
 * 
 * Navigations to this page ->1. Go to https://www.nasm.org -> click on My account
 * 							  2. Login with valid credentials -> Click on History link
 * 
 * @author Praveen.Maled
 * Date Created: 04-Oct-2016
 *
 */
public class HistoryPage extends ELearningCenterPage{

	WebDriver driver;
	
	
	protected HistoryPage(WebDriver webDriver) {
		super(webDriver);
		this.driver=webDriver;
	}
	
	

}
