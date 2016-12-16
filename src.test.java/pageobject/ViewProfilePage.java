package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class contains methods related to View profile page
 * 
 * @author Praveen.Maled
 * Date Created: 04-Oct-2016
 *
 */
public class ViewProfilePage extends MoodleLeftNavigationPane{

	/*Variables*/
	private boolean flag=false;
	
	By loc_UserProfile=By.className("userprofile");
	
	/*Constructor*/
	public ViewProfilePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	
	public boolean isViewProfilePageDisplayed() throws Exception{
		flag=false;
			flag=cm.isElementDisplayed(loc_UserProfile);
		return flag;
	}
}
