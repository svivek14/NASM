package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * Class contains methods related to product list page
 * 
 * Navigations to page - Go to https://www.nasm.org -> Continuing education -> All courses
 * 
 * @author Praveen.Maled
 * Date Created: 04-Oct-2016
 *
 */
public class ProductsListPage extends SitefinityTopNavigationPane{


	private String strResult=null;
	private boolean flag=false;
	

	public ProductsListPage(WebDriver driver) {
		super(driver);
	}


	By lst_ProductsName= By.className("sfproductTitleLnk");
	By lnk_ProductName=By.xpath("//h4/a[contains(.,'{1}')]");
	By btn_Next=By.cssSelector("a[id*='cmdNext']");
	By btn_Prev=By.cssSelector("a[id*='cmdPrev']");
	
	public ProductDetailsPage selectProductA(String strProduct) {
		List<WebElement> productNames=driver.findElements(lnk_ProductName);
		for(WebElement product:productNames){
			strResult=product.getText();
			if(product.getText()!=null && strProduct.equalsIgnoreCase(strResult)){
				product.click();
				flag=true;
				break;
			}
			continue;
		}
		return new ProductDetailsPage(driver);
	}
	
	
	public ProductDetailsPage selectProduct(String strProductName) throws Exception{
		By prd= cm.replaceLocatorValues(lnk_ProductName, strProductName);
		while(!cm.isElementDisplayed(prd) && cm.isElementDisplayed(btn_Next) ){
			driver.findElement(btn_Next).click();
		}
		if(cm.isElementDisplayed(prd)){
			driver.findElement(prd).click();
		}else{
			throw new Exception("Specified product is nor listed in the site");
		}
		return new ProductDetailsPage(driver);
	}
	
	
	public void clickOnNextButton(){
		driver.findElement(btn_Next).click();
	}

}
