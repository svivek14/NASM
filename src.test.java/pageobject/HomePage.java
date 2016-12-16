package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.CommonMethods;


/**
 * Class contains all the PO methods related to NASM Home page
 * 
 * Navigation steps to this page-> Access https://www.nasm.org
 * 
 * @author Praveen.Maled
 * Date Created: 04-Oct-2016
 *
 */
public class HomePage {



	WebDriver driver;
	CommonMethods cm;
	private boolean flag=false;
	private String strResult=null;
	//private String newsFormFrame="cboxIframe";


	public HomePage(WebDriver driver){
		this.driver = driver;
		cm=new CommonMethods(driver);
	}

	By btn_Register= By.cssSelector("input[id*='registerBtn']");
	By link_MyAccount = By.cssSelector("a[href*='portal.nasm.org']");
	By btn_LogIn = By.cssSelector("input[id*='loginBtn']");
	By lnk_Cart = By.cssSelector("li span a span");
	By lbl_CartCount = By.id("countlabel");
	By lbl_LoginPanel=By.cssSelector("[class*='login-panel']");
	By spn_UserName= By.cssSelector("[id*='messageLabel']");
	By btn_Logout= By.cssSelector("input[id*='logoutBtn']");

	By lnk_ContinueEducation=By.xpath("//a[contains(text(),'Continuing Education')]");
	By lnk_AllCourses=By.xpath("//a[contains(text(),'All Courses')]");

	By rad_ShippingOptions_RadioButton= By.cssSelector("[id*='shippingMethodsList'] li:nth-child({1}) input");
	By tbx_UserName = By.id("username");
	By tbx_NewsFirstName = By.id("newsFirstName");
	By tbx_NewsLastName = By.id("newsLastName");
	By tbx_NewsEmail = By.id("newsEmail");
	By tbx_NewsPhone = By.id("newsPhone");
	By btn_NewsSubmit = By.id("newsSubmit");
	By txt_ActOnMessage=By.cssSelector("td div");
	By btn_ActOnClose=By.id("cboxClose");
	By frm_ActOnMsg=By.cssSelector("div iframe[class='cboxIframe']");

	public void loadURL(String strURL) {
		driver.get(strURL);

	}


	public UserResterationPage clickOnRegisterButton(){
		cm.waitForElementPresent(btn_Register);
		driver.findElement(btn_Register).click();
		return new UserResterationPage(driver);
	}


	public LoginPage clickOnLoginuBtton(){
		driver.findElement(btn_LogIn).click();
		return new LoginPage(driver);
	}


	public Object clickOnMyAccountLink(){
		if(cm.isElementDisplayed(link_MyAccount)) {
			driver.findElement(link_MyAccount).click();
		}
		if(cm.isElementDisplayed(tbx_UserName))
			return new LoginPage(driver);
		else
			return new ELearningCenterPage(driver);
	}



	public boolean isLoginWidgetDisplayed(){
		flag=false;
		try{
			flag=driver.findElement(lbl_LoginPanel).isDisplayed();
		}catch( Exception e){
			flag=false;
		}
		return flag;
	}


	public String getFirstName(){
		strResult=null;
		strResult=driver.findElement(spn_UserName).getText();
		return strResult;
	}



	public boolean isLogoutButtontDisplayed() throws Exception{
		flag=false;
		try{
			flag=driver.findElement(btn_Logout).isDisplayed();
		}catch(Exception e){
			flag=false;
		}
		return flag;
	}


	public void clickOnLogoutbutton() {
		driver.findElement(btn_Logout);
	}


	public void clickOnContinuingEducation(){
		cm.waitForElementPresent(lnk_ContinueEducation);
		driver.findElement(lnk_ContinueEducation).click();
	}


	public ProductsListPage clickOnAllCoursesLink(){
		driver.findElement(lnk_AllCourses).click();
		return new ProductsListPage(driver);
	}


	public void enterFirstNameinStayConnectedForm(String strFirstName){

		driver.findElement(tbx_NewsFirstName).sendKeys(strFirstName);
	}

	public void enterLastNameinStayConnectedForm(String strLastName){

		driver.findElement(tbx_NewsLastName).sendKeys(strLastName);
	}


	public void enterEmailinStayConnectedForm(String strEmail){

		driver.findElement(tbx_NewsEmail).sendKeys(strEmail);
	}

	public void enterPhoneinStayConnectedForm(String strPhoneNumber){

		driver.findElement(tbx_NewsPhone).sendKeys(strPhoneNumber);
	}
	
	public void clickOnActOnSubmit(){
		driver.findElement(btn_NewsSubmit).click();
	}
	
	public String getActOnSuccessMessage(){
		cm.switchToFrame(frm_ActOnMsg);
		strResult=driver.findElement(txt_ActOnMessage).getText();
		cm.switchToDefaultFrame();
		return strResult;
	}
	
	public void submitStayConnectedForm(String strFirstName, String strLastName, String strEmail, String strPhoneNumber){
		
		driver.findElement(tbx_NewsFirstName).sendKeys(strFirstName);
		driver.findElement(tbx_NewsLastName).sendKeys(strLastName);
		driver.findElement(tbx_NewsEmail).sendKeys(strEmail);
		driver.findElement(tbx_NewsPhone).sendKeys(strPhoneNumber);
		driver.findElement(btn_NewsSubmit).click();
		cm.waitForElementPresent(frm_ActOnMsg);
		cm.switchToFrame(frm_ActOnMsg);
		cm.waitForElementPresent(txt_ActOnMessage);
		strResult=driver.findElement(txt_ActOnMessage).getText();
		cm.switchToDefaultFrame();
		driver.findElement(btn_ActOnClose).click();
	}
}
