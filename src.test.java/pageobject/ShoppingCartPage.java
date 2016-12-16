package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class contains methods related to shopping cart page
 * 
 *  Navigations to page - Got o https://www.nasm.org -> Continuing education -> All courses -> Select any product -> Add to cart
 *  
 * @author Praveen.Maled
 * Date Created: 04-Oct-2016
 */
public class ShoppingCartPage extends HomePage{

	
	/*Variable*/
	private boolean flag=false;
	
	
	/*Constructor*/
	protected ShoppingCartPage(WebDriver driver) {
		super(driver);
	}


	By lnk_ProductName= By.className("product-name");
	By frm_CartPage= By.cssSelector("section[class*='ecommerce-shopping-cart']");
	By btn_Checkout= By.cssSelector("input[id*='checkoutButton']");
	By txt_Quantity= By.cssSelector("tbody tr:nth-child({1}) td div input[id*=quantity]");
	By lbl_Price= By.cssSelector("tbody tr:nth-child({1}) td span[id*=newPriceLabel]");
	By lnk_Update= By.cssSelector("span[tooltip='Update Item']");

	
	
	public boolean isShoppingCartPageDisplayed(){
		flag=false;
		flag=cm.isElementDisplayed(frm_CartPage);
		return flag;
	}
	
	
	
	public boolean isproductPresentInCart(String strProduct){
		flag=false;
		List<WebElement> lstproducts=driver.findElements(lnk_ProductName);
		for(WebElement prd:lstproducts){
			if(strProduct.equalsIgnoreCase(prd.getText().trim())){
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	
	public boolean isChekOutButtonDisplayed(){
		flag=false;
		flag=cm.isElementDisplayed(btn_Checkout);
		return flag;
	}
	
	
	public CheckOutPage clickOnChekOutButton() throws Exception{
		driver.findElement(btn_Checkout).click();
		return new CheckOutPage(driver);
	}
	
	
	
	public boolean isUpdateLinkPresent() throws Exception{
		flag=false;
		flag=cm.isElementDisplayed(lnk_Update);
		return flag;
	}
}
