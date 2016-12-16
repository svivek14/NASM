package pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Class contains methods related to Products details page
 * 
 * Navigations to page - Got o https://www.nasm.org -> Continuing education -> All courses -> Select any product
 * 
 * @author Praveen.Maled
 * Date Created: 04-Oct-2016
 *
 */
public class ProductDetailsPage extends SitefinityTopNavigationPane {

	

	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}


	By btn_AddToCart= By.cssSelector("a[id*='addToCartLink'");



	
	
	
	public ShoppingCartPage clickOnAddToCartButton() {
		cm.waitForElementPresent(btn_AddToCart);
		driver.findElement(btn_AddToCart).click();
		return new ShoppingCartPage(driver);
	}
	
	

}
