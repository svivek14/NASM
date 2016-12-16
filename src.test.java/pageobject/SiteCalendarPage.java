package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Praveen.Maled
 * Date Created: 04-Oct-2016
 */
public class SiteCalendarPage extends MoodleLeftNavigationPane{
	
	/*Variables*/
	private boolean flag=false;
	
	By tbl_calender=By.cssSelector("table[class*='calendarmonth']");
	
	/*Constructor*/
	public SiteCalendarPage(WebDriver webDriver) {
		super(webDriver);
	}

	
	
	public boolean isCalendarPageDisplayed() throws Exception{
		flag=false;
			flag=cm.isElementDisplayed(tbl_calender);
		return flag;
	}
}
