package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.CommonMethods;


/**
 * Class contains all the PO methods related to Login page
 * 
 *  Navigation steps to this page-> 1)get Login URL of NASM ->Click on Login Button
 *  								2)get Login URL of NASM ->Click on My Account Button (if user is not already logged in)
 * 
 * @author Praveen.Maled
 * Date Created: 04-Oct-2016
 *
 */
public class LoginPage {
	
	WebDriver driver;
	CommonMethods cm;
	
	private boolean flag=false;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		cm = new CommonMethods(driver);
	}
	
	
	By tbx_UserName = By.id("username");
	By tbx_Password = By.id("password");
	By btn_LogIn = By.id("login-submit");
	By lnk_ForgotPassword = By.cssSelector(".text-right a");
	By lnk_CreateNewAccount = By.cssSelector("div a[href*='register']");
	By img_NASMLogo=By.className("logo-img-nasm");
	
	
	public void typeUserName(String user){
		driver.findElement(tbx_UserName).sendKeys(user);
	}
	

	public void typePassword(String psw){
		driver.findElement(tbx_Password).sendKeys(psw);
	}
	
	
	public ELearningCenterPage clickLogInButton(){
		driver.findElement(btn_LogIn).click();
		return new ELearningCenterPage(driver);
	}
	
	
	
	public void clickForgotPasswordLink(){
		driver.findElement(lnk_ForgotPassword).click();
	}
	
	
	
	public UserResterationPage clickCreateNewAccountButton(){
		driver.findElement(lnk_CreateNewAccount).click();
		return new UserResterationPage(driver);
	}
	
	
	public ELearningCenterPage doLogin(String user, String psw){
		typeUserName(user);
		typePassword(psw);
		clickLogInButton();
		return new ELearningCenterPage(driver);
	}


	public boolean isLoginPageDisplayed(){
		flag=false;
		flag=cm.isElementDisplayed(lnk_CreateNewAccount);
		return flag;
		
	}
	
	public HomePage clickOnNASMLogo(){
		driver.findElement(img_NASMLogo).click();
		return new HomePage(driver);
	}
}
