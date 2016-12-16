package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.CommonMethods;


/**
 * Class contains all the PO methods related to New User Registration page
 * 
 * Navigation steps to this page-> get Login URL of NASM ->Click on Create New Account button
 * 
 * @author Praveen.Maled
 * Date Created: 04-Oct-2016
 *
 */
public class UserResterationPage{


	WebDriver driver;
	CommonMethods cm;

	private boolean flag=false;
	private String strResult=null;

	/* Constructor */
	public UserResterationPage(WebDriver driver) {
		this.driver = driver;
		cm = new CommonMethods(driver);
	}


	By lbl_Header = By.cssSelector("h2");
	By txt_FirstName = By.id("first_name");
	By txt_LastName = By.id("last_name");
	By txt_UserName = By.id("user_form_username");
	By txt_Email = By.id("email");
	By txt_Password = By.id("user_form_password");
	By txt_ConfPassword = By.id("user_form_password_confirmation");
	By txt_Pwd_Recovery_Que = By.id("password_reset_question");
	By txt_Pwd_Recovery_Ans = By.id("password_reset");
	By txt_PhoneNumber = By.id("phone_number");

	By txt_BilAdd_StAdd1 = By.id("street_address_billing_street_address1");
	By txt_BilAdd_StAdd2 = By.id("street_address_billing_street_address2");
	By txt_BilAdd_City = By.id("street_address_billing_city");
	By txt_BilAdd_County = By.id("street_address_billing_locality");
	By txt_BilAdd_State = By.id("street_address_billing_province");
	By txt_BilAdd_Zip = By.id("street_address_billing_postal_code");
	By drp_BilAdd_Country = By.id("street_address_billing_country_code");

	By chk_BillingSameAsShipping = By.id("shipping_same_as_billing");

	By txt_ShipAdd_StAdd1 = By.id("street_address_shipping_street_address1");
	By txt_ShipAdd_StAdd2 = By.id("street_address_shipping_street_address2");
	By txt_ShipAdd_City = By.id("street_address_shipping_city");
	By txt_ShipAdd_County = By.id("street_address_shipping_locality");
	By txt_ShipAdd_State = By.id("street_address_shipping_province");
	By txt_ShipAdd_Zip = By.id("street_address_shipping_postal_code");
	By drp_ShipAdd_Country = By.id("street_address_shipping_country_code");

	By btn_Register = By.id("register-submit");



	public boolean isRegisterationPageDisplayed(String strPageTitle) throws Exception{
		flag=false;
		strResult=null;
		strResult=driver.findElement(lbl_Header).getText();
		flag=strPageTitle.equalsIgnoreCase(strResult);
		return flag;
	}


	public void enterFirstName(String strFirstName)	throws Exception {

		driver.findElement(txt_FirstName).sendKeys(strFirstName);
	}

	
	public void enterLastName(String strlatName) throws Exception {

		driver.findElement(txt_LastName).sendKeys(strlatName);
	}


	
	public void enterUserName(String strUserName) throws Exception {

		driver.findElement(txt_UserName).sendKeys(strUserName);
	}


	public void enterEmail(String strEmail)	throws Exception {

		driver.findElement(txt_Email).sendKeys(strEmail);
	}


	
	public void enterPassword(String strPassword) throws Exception {

		driver.findElement(txt_Password).sendKeys(strPassword);
	}


	public void enterConfirmPassword(String strConfirmPassword)	throws Exception {

		driver.findElement(txt_ConfPassword).sendKeys(strConfirmPassword);
	}


	
	public void enterPwdRecoveryQuestion(String strpwdRecoveryQuestion)	throws Exception {

		driver.findElement(txt_Pwd_Recovery_Que).sendKeys(strpwdRecoveryQuestion);
	}

	
	public void enterPwdRecoveryAnswer(String strpwdRecoveryAnswer)	throws Exception {

		driver.findElement(txt_Pwd_Recovery_Ans).sendKeys(strpwdRecoveryAnswer);
	}

	
	public void enterPhoneNumber(String strPhoneNumber)	throws Exception {

		driver.findElement(txt_PhoneNumber).sendKeys(strPhoneNumber);
	}


	public void enterBillingAddress1(String strBillingAddress1)	throws Exception {

		driver.findElement(txt_BilAdd_StAdd1).sendKeys(strBillingAddress1);
	}


	public void enterBillingAddress2(String strBillingAddress2)	throws Exception {

		driver.findElement(txt_BilAdd_StAdd2).sendKeys(strBillingAddress2);
	}


	public void enterBillingAddCity(String strBillingAddCity) throws Exception {

		driver.findElement(txt_BilAdd_City).sendKeys(strBillingAddCity);
	}


	public void enterBillingAddLocality(String strBillingAddLocaltiy) throws Exception {

		driver.findElement(txt_BilAdd_County).sendKeys(	strBillingAddLocaltiy);

	}


	public void enterBillingAddState(String strBillingAddState)	throws Exception {

		driver.findElement(txt_BilAdd_State).sendKeys(strBillingAddState);
	}


	public void enterBillingAddZipCode(String strBillingAddZipCode)	throws Exception {

		driver.findElement(txt_BilAdd_Zip).sendKeys(strBillingAddZipCode);
	}



	public void selectBillingAddCountry(String strBillingAddCountry) throws Exception {

		cm.selectDropdownItemByVisibleText(drp_BilAdd_Country, strBillingAddCountry);
	}



	public void enterShippingAddress1(String strShippingAddress1)	throws Exception {

		driver.findElement(txt_ShipAdd_StAdd1).sendKeys(strShippingAddress1);
	}


	public void enterShippingAddress2(String strShippingAddress2)	throws Exception {

		driver.findElement(txt_ShipAdd_StAdd2).sendKeys(strShippingAddress2);
	}


	public void enterShippingAddCity(String strShippingAddCity) throws Exception {

		driver.findElement(txt_ShipAdd_City).sendKeys(strShippingAddCity);
	}


	public void enterShippingAddLocality(String strShippingAddLocaltiy) throws Exception {

		driver.findElement(txt_ShipAdd_County).sendKeys(	strShippingAddLocaltiy);

	}


	public void enterShippingAddState(String strShippingAddState)	throws Exception {

		driver.findElement(txt_ShipAdd_State).sendKeys(strShippingAddState);
	}


	public void enterShippingAddZipCode(String strShippingAddZipCode)	throws Exception {

		driver.findElement(txt_ShipAdd_Zip).sendKeys(strShippingAddZipCode);
	}


	public void selectShippingAddCountry(String strShippingAddCountry) throws Exception {

		cm.selectDropdownItemByVisibleText(drp_ShipAdd_Country, strShippingAddCountry);
	}



	public ELearningCenterPage clickOnRegister() throws Exception {

		driver.findElement(btn_Register).click();

		return new ELearningCenterPage(driver);
	}
	

	public ELearningCenterPage registeraUserWithShipAddSameAsBillingAdd(String strFirstName,String strlatName,
			String strUserName,String strEmail, String strPassword,String strConfirmPassword,
			String strpwdRecoveryQuestion, String strpwdRecoveryAnswer, String strPhoneNumber,
			String strBillingAddress1,String strBillingAddress2,String strBillingAddCity,
			String strBillingAddLocaltiy,String strBillingAddState, String strBillingAddZipCode,
			String strBillingAddCountry) throws Exception {
		driver.findElement(txt_FirstName).sendKeys(strFirstName);
		driver.findElement(txt_LastName).sendKeys(strlatName);
		driver.findElement(txt_UserName).sendKeys(strUserName);
		driver.findElement(txt_Email).sendKeys(strEmail);
		driver.findElement(txt_Password).sendKeys(strPassword);
		driver.findElement(txt_ConfPassword).sendKeys(strConfirmPassword);
		driver.findElement(txt_Pwd_Recovery_Que).sendKeys(strpwdRecoveryQuestion);
		driver.findElement(txt_Pwd_Recovery_Ans).sendKeys(strpwdRecoveryAnswer);
		driver.findElement(txt_PhoneNumber).sendKeys(strPhoneNumber);
		driver.findElement(txt_BilAdd_StAdd1).sendKeys(strBillingAddress1);
		driver.findElement(txt_BilAdd_StAdd2).sendKeys(strBillingAddress2);
		driver.findElement(txt_BilAdd_City).sendKeys(strBillingAddCity);
		driver.findElement(txt_BilAdd_County).sendKeys(	strBillingAddLocaltiy);
		driver.findElement(txt_BilAdd_State).sendKeys(strBillingAddState);
		driver.findElement(txt_BilAdd_Zip).sendKeys(strBillingAddZipCode);
		cm.selectDropdownItemByVisibleText(drp_BilAdd_Country, strBillingAddCountry);
		driver.findElement(btn_Register).click();
		return new ELearningCenterPage(driver);
	}
	
	public ELearningCenterPage registeraUserWithDiffShipAddAndBillingAdd(String strFirstName,String strlatName,
			String strUserName,String strEmail, String strPassword,String strConfirmPassword,
			String strpwdRecoveryQuestion, String strpwdRecoveryAnswer, String strPhoneNumber,
			String strBillingAddress1,String strBillingAddress2,String strBillingAddCity,
			String strBillingAddLocaltiy,String strBillingAddState, String strBillingAddZipCode,
			String strBillingAddCountry, String strShippingAddress1,String strShippingAddress2,
			String strShippingAddCity,String strShippingAddLocaltiy,String strShippingAddState, 
			String strShippingAddZipCode,String strShippingAddCountry) throws Exception {

		driver.findElement(txt_FirstName).sendKeys(strFirstName);
		driver.findElement(txt_LastName).sendKeys(strlatName);
		driver.findElement(txt_UserName).sendKeys(strUserName);
		driver.findElement(txt_Email).sendKeys(strEmail);
		driver.findElement(txt_Password).sendKeys(strPassword);
		driver.findElement(txt_ConfPassword).sendKeys(strConfirmPassword);
		driver.findElement(txt_Pwd_Recovery_Que).sendKeys(strpwdRecoveryQuestion);
		driver.findElement(txt_Pwd_Recovery_Ans).sendKeys(strpwdRecoveryAnswer);
		driver.findElement(txt_PhoneNumber).sendKeys(strPhoneNumber);
		driver.findElement(txt_BilAdd_StAdd1).sendKeys(strBillingAddress1);
		driver.findElement(txt_BilAdd_StAdd2).sendKeys(strBillingAddress2);
		driver.findElement(txt_BilAdd_City).sendKeys(strBillingAddCity);
		driver.findElement(txt_BilAdd_County).sendKeys(	strBillingAddLocaltiy);
		driver.findElement(txt_BilAdd_State).sendKeys(strBillingAddState);
		driver.findElement(txt_BilAdd_Zip).sendKeys(strBillingAddZipCode);
		cm.selectDropdownItemByVisibleText(drp_BilAdd_Country, strBillingAddCountry);
		//add code to uncheck checkbox
		driver.findElement(txt_ShipAdd_StAdd1).sendKeys(strShippingAddress1);
		driver.findElement(txt_ShipAdd_StAdd2).sendKeys(strShippingAddress2);
		driver.findElement(txt_ShipAdd_City).sendKeys(strShippingAddCity);
		driver.findElement(txt_ShipAdd_County).sendKeys(strShippingAddLocaltiy);
		driver.findElement(txt_ShipAdd_State).sendKeys(strShippingAddState);
		driver.findElement(txt_ShipAdd_Zip).sendKeys(strShippingAddZipCode);
		cm.selectDropdownItemByVisibleText(drp_ShipAdd_Country, strShippingAddCountry);
		driver.findElement(btn_Register).click();
		cm.waitForPageTitle("eLearning Center");
		return new ELearningCenterPage(driver);
	}
}
