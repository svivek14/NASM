package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Class contains methods related to the checkout page
 * 
 * Navigation steps for checkout page ->1. Go to https://www.nasm.org -> continuing education -> All course
 * 	                                    2. Select and product and add to cart
 * 										3. In cart page click on Proceed to checkout button and login with valid credentials
 * @author Praveen.Maled
 * Date Created: 04-Oct-2016
 *
 */
public class CheckOutPage extends HomePage{



	/*Variables*/
	private boolean flag=false;
	private String creditcardframe="braintree-hosted-field-number";
	private String cvvframe="braintree-hosted-field-cvv";
	private String expirationMonthframe="braintree-hosted-field-expirationMonth";
	private String expirationYearframe="braintree-hosted-field-expirationYear";
	private String termsandconditionsquery="document.getElementById('terms_and_conditions')";
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	
	By frm_CheckoutPage= By.cssSelector("form[action='checkout']");
	By tbx_FirstName= By.cssSelector("input[id*='firstNameBilling']");
	By tbx_LastName= By.cssSelector("input[id*='lastNameBilling']");
	By tbx_Email= By.cssSelector("input[id*='emailBilling']");
	By tbx_PhoneNumber= By.cssSelector("input[id*='phoneNumberBilling']");
	
	By tbx_BillAdd_Address1= By.cssSelector("input[id*='address1Billing']");
	By tbx_BillAdd_Address2= By.cssSelector("input[id*='address2Billing']");
	By tbx_BillAdd_City= By.cssSelector("input[id*='cityBilling']");
	By tbx_BillAdd_Zip= By.cssSelector("input[id*='zipBilling']");
	By drpdn_BillAdd_Country= By.cssSelector("input[id*='countryBilling']");
	By drpdn_BillAdd_State= By.cssSelector("input[id*='stateBilling']");
	
	By tbx_ShipAdd_Address1= By.cssSelector("input[id*='address1Shipping']");
	By tbx_ShipAdd_Address2= By.cssSelector("input[id*='address2Shipping']");
	By tbx_ShipAdd_City= By.cssSelector("input[id*='cityShipping']");
	By tbx_ShipAdd_Zip= By.cssSelector("input[id*='zipShipping']");
	By drpdn_ShipAdd_Country= By.cssSelector("input[id*='countryShipping']");
	By drpdn_ShipAdd_State= By.cssSelector("input[id*='stateShipping']");
	
	By chk_ShippingAdd= By.cssSelector("input[id*='UseBillingAddressAsShippingAddress']");
	By btn_Addr_Continue= By.cssSelector("input[id*='addressComplete']");
	By frm_ShippingOptions_Form= By.cssSelector("[id*='shippingMethodsList']");
	By lst_ShippingOptions_Labels= By.cssSelector("[id*='shippingMethodsList'] li label");
	By rad_ShippingOptions_RadioButton= By.cssSelector("[id*='shippingMethodsList'] li:nth-child({1}) input");
	By rad_ShippingOptions_txtError= By.className("sfError");
	By btn_ShippingOptions_Next= By.cssSelector("input[id*='btnShippingDone']");
	
	By tbx_PaymentOptions_CardHolderName= By.cssSelector("input[id*='cardHolderName']");
	By tbx_PaymentOptions_frame_CardNumber= By.cssSelector("#card-number iframe");
	By tbx_PaymentOptions_CardNumber= By.id("credit-card-number");
	By tbx_PaymentOptions_frame_Cvv= By.cssSelector("#card-number iframe");
	By tbx_PaymentOptions_Cvv= By.id("cvv");
	By tbx_PaymentOptions_frame_ExpirationMonth= By.cssSelector("#braintree-hosted-field-expirationMonth");
	By tbx_PaymentOptions_Expiration_Month= By.id("expiration-month");
	By tbx_PaymentOptions_frame_ExpirationYear= By.cssSelector("#braintree-hosted-field-expirationYear");
	By tbx_PaymentOptions_Expiration_Year= By.id("expiration-year");
	By btn_PaymentOptions_PlaceThisOrder= By.cssSelector("input[id*='placeOrderButton']");
	By chk_TermsAndConditions=By.cssSelector("terms_and_conditions");
	
	
	
	public boolean isCheckOutPageDisplayed(){
		flag=false;
		flag=cm.isElementDisplayed(frm_CheckoutPage);
		return flag;
	}

	public void enterBillingFirstName(String strFirstName){
		driver.findElement(tbx_FirstName).sendKeys(strFirstName);
	}


	public void enterBillingLastName(String strLastName){
		driver.findElement(tbx_LastName).sendKeys(strLastName);
	}


	public void enterPhoneNumber(String strPhoneNuumber) {
		driver.findElement(tbx_PhoneNumber).sendKeys(strPhoneNuumber);
	}

	
	public void enterShippingEmailAddress(String strEmailAddress) throws Exception{
		
		driver.findElement(tbx_Email).sendKeys(strEmailAddress);
	}

	
	public void enterBillingAddress1(String strAddress1){
		
		driver.findElement(tbx_BillAdd_Address1).sendKeys(strAddress1);
	}


	public void enterBillingAddress2(String strAddress2){
		driver.findElement(tbx_BillAdd_Address2).sendKeys(strAddress2);
	}


	public void enterBillingCityName(String strCityName){
	
		driver.findElement(tbx_BillAdd_City).sendKeys(strCityName);
	}


	public void enterBillingZipCode(String strZipCode) {
		
		driver.findElement(tbx_BillAdd_Zip).sendKeys(strZipCode);
	}


	public void selectBillingAddCountry(String strBillingAddCountry) {
		
		cm.selectDropdownItemByVisibleText(drpdn_BillAdd_Country, strBillingAddCountry);
	}


	public void selectBillingAddState(String strBillingAddState)  {
		cm.selectDropdownItemByVisibleText(drpdn_BillAdd_State, strBillingAddState);
	}


	public void enterShippingAddress1(String strAddress1){
		
		driver.findElement(tbx_ShipAdd_Address1).sendKeys(strAddress1);
	}


	public void enterShippingAddress2(String strAddress2){
		
		driver.findElement(tbx_ShipAdd_Address2).sendKeys(strAddress2);
	}


	public void enterShippingCityName(String strCityName){
		
		driver.findElement(tbx_ShipAdd_City).sendKeys(strCityName);
	}


	public void enterShippingZipCode(String strZipCode){
		
		driver.findElement(tbx_ShipAdd_Zip).sendKeys(strZipCode);
	}


	public void selectShippingAddCountry(String strBillingAddCountry) {
		
		cm.selectDropdownItemByVisibleText(drpdn_ShipAdd_Country, strBillingAddCountry);
	}


	public void selectShippingAddState(String strShippingAddState)  {
		
		cm.selectDropdownItemByVisibleText(drpdn_ShipAdd_State, strShippingAddState);
	}


	public boolean isShippingAddressCheckboxDisplayed(){
		
		flag=false;
		flag=cm.isElementDisplayed(chk_ShippingAdd);
		return flag;
	}


	public void clickOnAddrContinueButton() throws Exception{
		
		driver.findElement(btn_Addr_Continue).click();
	}


	public boolean isShippingOptionsDisplayed(){
		flag=false;
		flag=cm.isElementDisplayed(frm_ShippingOptions_Form);
		return flag;
	}


	public void selectShippingOPtions(String strShippingOption){
			List<WebElement> lstoptions=driver.findElements(lst_ShippingOptions_Labels);
			for(WebElement optn:lstoptions){
				if(optn.getText().toLowerCase().contains(strShippingOption.toLowerCase())){
					optn.click();
					break;
				}
			}
	}


	public boolean isShippingOptionSelected(String strOption) throws Exception{
		flag=false;
		int i=0;
		try {
			List<WebElement> lstoptions=driver.findElements(lst_ShippingOptions_Labels);
			for(WebElement optn:lstoptions){
				i++;
				if(optn.getText().contains(strOption)){
					flag=driver.findElement(cm.replaceLocatorValues(rad_ShippingOptions_RadioButton, String.valueOf(i))).isSelected();
					break;
				}
			}
		} catch (Exception e) {
			flag=false;
		}
		return flag;
	}


	public void clickOnShippingOptNextButton() {
		
		driver.findElement(btn_ShippingOptions_Next).click();
	}

	public void enterCardHolderName(String strName) {
		
		driver.findElement(tbx_PaymentOptions_CardHolderName).sendKeys(strName);
	}

	public void enterCardNumber(String strCardNumber){
		cm.switchToFrame(creditcardframe);
		driver.findElement(tbx_PaymentOptions_CardNumber).sendKeys(strCardNumber);
		cm.switchToDefaultFrame();
	}


	public void enterCVV(String strCVV){
		cm.switchToFrame(cvvframe);
		driver.findElement(tbx_PaymentOptions_Cvv).sendKeys(strCVV);
		cm.switchToDefaultFrame();
	}


	public void enterExpirationMonth(String strExiprationMonth) {
		cm.switchToFrame(expirationMonthframe);
		driver.findElement(tbx_PaymentOptions_Expiration_Month).sendKeys(strExiprationMonth);
		cm.switchToDefaultFrame();
	}

	public void enterExpirationYear(String strExiprationYear) {
		cm.switchToFrame(expirationYearframe);
		driver.findElement(tbx_PaymentOptions_Expiration_Year).sendKeys(strExiprationYear);
		cm.switchToDefaultFrame();
	}

	public void checkTermsAndConditionsCheckbox() {
		cm.clickByJavascript(termsandconditionsquery);
		cm.waitForElementPresent(btn_PaymentOptions_PlaceThisOrder);
	}
	
	public OrderConfirmationPage clickOnPlaceThisOrderButton(){
		System.out.println(cm.isElementDisplayed(btn_PaymentOptions_PlaceThisOrder));
		cm.clickByJavascript(btn_PaymentOptions_PlaceThisOrder);
		return new OrderConfirmationPage(driver);
	}
	

	public void enterPaymentDetailsAndPlaceOrder(String strName, String strCardNumber, String strCVV, String strExiprationMonth,String strExiprationYear ){
		driver.findElement(tbx_PaymentOptions_CardHolderName).sendKeys(strName);
		cm.switchToFrame(creditcardframe);
		driver.findElement(tbx_PaymentOptions_CardNumber).sendKeys(strCardNumber);
		cm.switchToDefaultFrame();
		cm.switchToFrame(cvvframe);
		driver.findElement(tbx_PaymentOptions_Cvv).sendKeys(strCVV);
		cm.switchToDefaultFrame();
		cm.switchToFrame(expirationMonthframe);
		driver.findElement(tbx_PaymentOptions_Expiration_Month).sendKeys(strExiprationMonth);
		cm.switchToDefaultFrame();
		cm.switchToFrame(expirationYearframe);
		driver.findElement(tbx_PaymentOptions_Expiration_Year).sendKeys(strExiprationYear);
		cm.switchToDefaultFrame();
		cm.clickByJavascript(termsandconditionsquery);
		driver.findElement(btn_PaymentOptions_PlaceThisOrder).click();
	}

}