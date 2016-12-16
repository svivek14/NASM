package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.CommonMethods;


/**
 * Class contains all the PO methods related to Student home page
 * 
 * Navigation steps to this page-> 1)get Login URL of NASM ->Click on My Account Button -> Login with valid credentials
 *  							   2)get Login URL of NASM ->Click on My Account Button (if user is already logged in)
 * 
 * @author Praveen.Maled
 * Date Created: 04-Oct-2016
 */
public class ELearningCenterPage{



	WebDriver driver;
	CommonMethods cm;

	private boolean flag=false;
	private String strResult=null;

	/*Constructor*/
	public ELearningCenterPage(WebDriver driver) {
		this.driver = driver;
		cm=new CommonMethods(driver);
	}

	By lnk_Courses = By.xpath("//h3/a[contains(.,'Courses')]");
	By lnk_History = By.xpath("//h3/a[contains(.,'History')]");
	By lnk_Certificates = By.xpath("//h3/a[contains(.,'Certificates')]");
	By lnk_Account = By.xpath("//h3/a[contains(.,'Account')]");
	By lnk_EnrollmentKey = By.xpath("//h3/a[contains(.,'Enrollment')]");
	By lnk_Recertification = By.xpath("//h3/a[contains(.,'Re-Certification')]");
	By lnk_nav_Courses = By.cssSelector("#course a");
	By lnk_nav_History = By.cssSelector("#orderhistory a");
	By lnk_nav_Certificates = By.cssSelector("#certificate a");
	By lnk_nav_Account = By.cssSelector("#account a");
	By lnk_nav_EnrollmentKey = By.cssSelector("#enrollmentkey a");
	By lnk_nav_Recertification = By.cssSelector("#recertification a");
	By lnk_Logoff=By.id("logoffLink");
	By lbl_PageHeader = By.cssSelector("h2");
	By img_NASMLogo=By.id("nasmLogo");
	By img_AFAALogo=By.id("afaaLogo");
	By lnk_UserName=By.cssSelector("a[href='/']");


	public boolean iseLearningCenterPageDisplayed(String strPageTitle) throws Exception{
		flag=false;
		strResult=null;
		strResult=driver.getTitle();
		flag=strResult.equalsIgnoreCase(strPageTitle);
		return flag;
	}



	public boolean isCourseTabDisplayed() throws Exception{
		flag=false;
		flag=cm.isElementDisplayed(lnk_Courses);
		return flag;
	}



	public boolean isCertificatesTabDisplayed() throws Exception{
		flag=false;
		flag=cm.isElementDisplayed(lnk_Certificates);
		return flag;
	}


	public boolean isAccountTabDisplayed() throws Exception{
		flag=false;
		flag=cm.isElementDisplayed(lnk_Account);
		return flag;
	}


	public boolean isEnrollmentKeyTabDisplayed() throws Exception{
		flag=false;
		flag=cm.isElementDisplayed(lnk_EnrollmentKey);
		return flag;
	}


	public boolean isHistoryTabDisplayed() throws Exception{
		flag=false;
		flag=cm.isElementDisplayed(lnk_History);
		return flag;
	}
	
	public boolean isReCertificationabDisplayed() throws Exception{
		flag=false;
		flag=cm.isElementDisplayed(lnk_Recertification);
		return flag;
	}

	public boolean isLogoffLinkDisplayed() throws Exception{
		flag=false;
		flag=cm.isElementDisplayed(lnk_Logoff);
		return flag;
	}




	public CoursesPage clickOnCourseTab() throws Exception{
		if(cm.isElementDisplayed(lnk_Courses))
			driver.findElement(lnk_Courses).click();
		else
			driver.findElement(lnk_nav_Courses).click();
		return new CoursesPage(driver);
	}


	public CertificatesPage clickOnCertificatesTab() throws Exception{
		if(cm.isElementDisplayed(lnk_Certificates))
			driver.findElement(lnk_Certificates).click();
		else
			driver.findElement(lnk_nav_Certificates).click();
		return new CertificatesPage(driver);
	}


	public AccountsPage clickOnAccountTab() throws Exception{
		if(cm.isElementDisplayed(lnk_Account))
			driver.findElement(lnk_Account).click();
		else
			driver.findElement(lnk_nav_Account).click();
		return new AccountsPage(driver);
	}


	public EnrollmentKeyPage clickOnEnrollmentKeyTab() throws Exception{
		if(cm.isElementDisplayed(lnk_EnrollmentKey))
			driver.findElement(lnk_EnrollmentKey).click();
		else
			driver.findElement(lnk_nav_EnrollmentKey).click();
		return new EnrollmentKeyPage(driver);
	}


	public HistoryPage clickOnHistoryTab() throws Exception{
		if(cm.isElementDisplayed(lnk_History))
		driver.findElement(lnk_History).click();
		else
			cm.clickByJavascript(lnk_nav_History);
		
		return new HistoryPage(driver);
	}
	
	public ReCertificationPage clickOnReCertificationTab() throws Exception{
		if(cm.isElementDisplayed(lnk_Recertification))
		driver.findElement(lnk_Recertification).click();
		else
			cm.clickByJavascript(lnk_nav_Recertification);
		
		return new ReCertificationPage(driver);
	}


	public void clickOnLogoffTab() throws Exception{
		cm.waitForElementPresent(lnk_Logoff);
		driver.findElement(lnk_Logoff).click();
	}


	public String getPageHeader() throws Exception{
		strResult=null;
		strResult=driver.findElement(lbl_PageHeader).getText();
		return strResult;
	}
	
	public String getUserName() throws Exception{
		strResult=null;
		strResult=driver.findElement(lnk_UserName).getText();
		return strResult;
	}
	
	public boolean isNASMLogoPresent(){
		return cm.isElementDisplayed(img_NASMLogo);
	}
	
	public boolean isAFAALogoPresent(){
		return cm.isElementDisplayed(img_AFAALogo);
	}
	
	
	public void clickOnUserName() throws Exception{
		driver.findElement(lnk_UserName).click();
	}
}
