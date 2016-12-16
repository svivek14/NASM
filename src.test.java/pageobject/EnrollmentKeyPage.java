package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class contains methods related to Enrollment key page in student home page
 * 
 * Navigations to this page ->1. Go to https://www.nasm.org -> click on My account
 * 							  2. Login with valid credentials -> Click on Enrollment key link
 * 
 * @author Praveen.Maled
 * Date Created: 04-Oct-2016
 *
 */
public class EnrollmentKeyPage extends ELearningCenterPage {

	
	/*Variables*/
	private boolean flag=false;
	private String strResult=null;
	
	/*Constructor*/
	public EnrollmentKeyPage(WebDriver webDriver) {
		super(webDriver);
		this.driver=webDriver;
	}

	By tbx_EnrollmentKey = By.id("Key");
	By btn_Next = By.cssSelector(".btn.btn-default");
	By btn_RedeemAllCourses = By.cssSelector("input[type='submit']");
	By txt_Course = By.cssSelector(".text-info td:nth-child(1)");
	By btn_RedeemCourse = By.cssSelector(".text-info:nth-child({1}) td form input[type='submit']");
	By lbl_SuccessMessage = By.cssSelector(".alert.alert-info");
	
	
	public boolean isEnrollmentKeyPageDisplayed(String strPageTitle) throws Exception{
		flag=false;
		strResult=null;
			strResult=driver.getTitle();
			flag=strResult.equalsIgnoreCase(strPageTitle);
		return flag;
	}
	
	
	public void enterEnrollmentkey(String strEnrollmentKey){
			driver.findElement(tbx_EnrollmentKey).sendKeys(strEnrollmentKey);
	}
	

	public void clickOnNextButton(){
		
		driver.findElement(btn_Next).click();
	}
	
	
	public void clickOnRedeemAllCoursesButton(){
		
		driver.findElement(btn_RedeemAllCourses).click();
	}
	
	
	/**
	 * Method will click on Redeem Course button for specified course name
	 * 
	 * @param strCourseName
	 * @return void
	 */
/*	public void clickOnRedeemCourseButtonForCourse(String strCourseName) throws Exception{
		strResult=null;
		int i=1;
		try{
			log(logger,"clicking on Redeem Course button");
			List<WebElement> lstcourse=buttonHandler.findElements(PropertiesRepository.getString("nasm.enrollmentkeypage.txtcourse"));
			for(WebElement course:lstcourse){
				i++;
				System.out.println("i:"+"="+course.getText());
				if(strCourseName.equalsIgnoreCase(course.getText().trim())){
					buttonHandler.clickButton(buttonHandler.replaceLocatorValues(PropertiesRepository.getString("nasm.enrollmentkeypage.btnredeemcourse"), String.valueOf(i)));
					break;
				}
			}
		}catch(WebDriverException we){
			throw new Exception("Failed to click on RedRedeem Course button for specified course name \n METHOD : clickOnRedeemCourseButtonForCourse "
					+ we.getLocalizedMessage());
		}
	}*/
	
	
	public String getSuccessRedeemedMessage() throws Exception{
		strResult=null;
		try{
			strResult=driver.findElement(lbl_SuccessMessage).getText();
		}catch(Exception we){
			System.out.println("Success message Element not found");
		}
		return strResult;
	}
	
	
	
}
