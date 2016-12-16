package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.CommonMethods;


/**
 * Class contains the methods related to left navigation pane, 
 * this is common for all courses hence added it separately 
 *   
 * @author Praveen.Maled
 *Date Created: 04-Oct-2016
 */
public class MoodleLeftNavigationPane {

	
	WebDriver driver;
	CommonMethods cm;
	
	/*Variables*/
	private boolean flag=false;
	
	By lnk_MyHome = By.linkText("My home");
	By spn_SitePages = By.cssSelector("span[title='NASM eLearning']");
	By lnk_SiteBadges = By.linkText("Site badges");
	By lnk_SiteTags = By.linkText("Tags");
	By lnk_Calendar = By.linkText("Calendar");
	By spn_MyProfile =By.cssSelector("[class*='type_user'] p span");
	By lnk_ViewProfile = By.linkText("View profile");
	By lnk_Posts = By.linkText("Posts");
	By lnk_Discussions = By.linkText("Discussions");
	By lnk_ViewAllofMyEntries = By.linkText("View all of my entries");
	By lnk_AddNewEntry = By.linkText("Add a new entry");
	By lnk_Messages = By.linkText("Messages");
	
	By lnk_MyPrivateFiles = By.linkText("My private files");
	By lnk_MyBadges = By.linkText("My badges");
	By lnk_MyCourses = By.linkText("My courses");
	By lnk_MyCourses_Expanded = By.cssSelector("[class*='type_system'][aria-expanded='true']");
	By lnk_CourseAdminstration_Grades = By.linkText("Grades");
	By lnk_EditProfile = By.linkText("Edit profile");
	By lnk_ProfSetng_Messaging = By.linkText("Messaging");
	By lnk_ProfBlog_Preferences = By.linkText("Preferences");
	By lnk_Profsetng_ExternalBlogs = By.linkText("External blogs");
	By lnk_Profsetng_RegisterExternalBlogs = By.linkText("Register an external blog");
	By lnk_Profsetng_BackupsSetting = By.linkText("Backpack settings");
	
	/*Constructor*/
	protected MoodleLeftNavigationPane(WebDriver driver) {
		this.driver = driver;
		cm=new CommonMethods(driver);
	}

	
	
	public void clickOnMyHome() {
			
		driver.findElement(lnk_MyHome).click();
	}
	
	
	
	public void clickOnSitePages() {
		
		driver.findElement(spn_SitePages).click();
		
	}
	
	
	public void clickOnSitebadges() {
		driver.findElement(lnk_SiteBadges).click();
	}
	
	
	public void clickOnTags() {
		driver.findElement(lnk_SiteTags).click();
	}
	
	
	public SiteCalendarPage clickOnCalendar() {
		driver.findElement(lnk_Calendar).click();
		return new SiteCalendarPage(driver);
	}
	
	
	public void clickOnMyProfile() {
			driver.findElement(spn_MyProfile).click();
	}
	
	
	public ViewProfilePage clickOnViewProfile() {
			driver.findElement(lnk_ViewProfile).click();
		return new ViewProfilePage(driver);
	}
	
	
	public void clickOnPosts() {
			driver.findElement(lnk_Posts).click();
	}
	
	
	public void clickOnDiscussions() {
			driver.findElement(lnk_Discussions).click();
	}
	
	
	public void clickOnViewAllOfMyEntries() {
			driver.findElement(lnk_ViewAllofMyEntries).click();
	}
	
	
	public void clickOnAddNewEntry() {
			driver.findElement(lnk_AddNewEntry).click();
	}
	
	
	public void clickOnMessages() {
			driver.findElement(lnk_Messages).click();
	}
	
	
	public void clickOnMyPrivateFiles() {
			driver.findElement(lnk_MyPrivateFiles).click();
	}
	
	public void clickOnMybadges() {
			driver.findElement(lnk_MyBadges).click();
	}
		
	
	public void clickOnMyCourses() {
			driver.findElement(lnk_MyCourses).click();
	}
	
	
	public boolean isMyCoursesExpanded() {
		flag=false;
			flag=cm.isElementDisplayed(lnk_MyCourses_Expanded);
		return flag;
	}
	

	public void clickOnGrades() {
		driver.findElement(lnk_CourseAdminstration_Grades).click();
	}
	
	
	public void clickOnEditProfile() {
		driver.findElement(lnk_EditProfile).click();
	}
	
	
	public void clickOnMessaging() {
		driver.findElement(lnk_ProfSetng_Messaging).click();
	}
	
	
	public void clickOnMyProfileBlogPreferences() {
		driver.findElement(lnk_ProfBlog_Preferences).click();
	}
	
	
	public void clickExternalblogs() {
		driver.findElement(lnk_Profsetng_ExternalBlogs).click();
	}
	
	
	public void clickOnRegisterExternalblogs() {
		driver.findElement(lnk_Profsetng_RegisterExternalBlogs).click();
	}
	
	
	
	public void clickOnBackupSettings() {
		driver.findElement(lnk_Profsetng_BackupsSetting).click();
	}
}
