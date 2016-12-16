package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class contains methods related to Order Confirmation page
 * 
 * Navigations to page -1. Compelete the purchase flow in NASM
 *  
 * @author Praveen.Maled
 * Date Created: 04-Oct-2016
 *
 */
public class OrderConfirmationPage extends HomePage{

	
	
	/* Variables */
	private boolean flag=false;
	
	
	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	By frm_OrderSuccessPage= By.className("orderSuccessWrapper");
	By lnk_OrderSuccessPage_MyAccount= By.cssSelector("a[id*='linkToPortal']");

	
	public boolean isOrderConfirmationPageDisplayed(){
		flag=false;
		flag=cm.isElementDisplayed(frm_OrderSuccessPage);
		return flag;
	}
	
	
	
}
