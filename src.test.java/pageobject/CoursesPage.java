package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * Class contains methods related to Courses page in student home page
 * 
 * Navigations to this page ->1. Go to https://www.nasm.org -> click on My account
 * 							  2. Login with valid credentials -> Click on Courses link
 * 
 * @author Praveen.Maled
 * Date Created: 04-Oct-2016
 *
 */
public class CoursesPage extends ELearningCenterPage{

	WebDriver driver;
	
	/*Variables*/
	private boolean flag=false;
	private String strResult=null;
	private int i=0;
	
	/*Constructor*/
	public CoursesPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	By lst_CourseNames = By.cssSelector("tbody tr td");
	By btn_CoursePlay = By.xpath("//tr[td[contains(text(),'{1}')]]/td/a");
	
	/**
	 * Method will Verify Courses page is displayed or not
	 * 
	 * @param strPageTitle
	 * @return boolean
	 */
	public boolean isCoursesPageDisplayed(String strPageTitle){
		flag=false;
		strResult=null;
		strResult=driver.getTitle();
		flag=strResult.equalsIgnoreCase(strPageTitle);
		return flag;
	}
	

	
	
	
	public boolean isCourseDisplayed(String strCourseName){
		flag=false;
		strResult=null;
		List<WebElement> lstcourse=driver.findElements(lst_CourseNames);
		if(lstcourse!=null && lstcourse.size()>1){
			for(WebElement course:lstcourse){
				if(course.getText().contains(strCourseName)){
					flag=true;
					break;
				}
			}
		}
		return flag;
	}
	
	
	public MoodleHomePage clickOnActionButtonOfCourse(String strCourseName){
		
		driver.findElement(cm.replaceLocatorValues(btn_CoursePlay, strCourseName)).click();
		return new MoodleHomePage(driver);
	}
}
