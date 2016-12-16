package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class contains methods related to the Accounts page
 * 
 * Navigation steps to this page-> Login to NASM application and navigate to student home page -> Click on Account tab/link
 *  								
 * @author Praveen.Maled
 * Date Created: 04-Oct-2016
 *
 */
public class AccountsPage extends ELearningCenterPage{

	
	
	/*Variables*/
	private boolean flag=false;
	List<WebElement> lstele;
	
	/*Constructor*/
	protected AccountsPage(WebDriver webDriver){
		super(webDriver);
		this.driver=webDriver;
	}
	
	By lbl_AccountLabel = By.cssSelector(".dl-horizontal dt");
	By btn_Change = By.cssSelector(".btn.btn-large.btn-warning");
	
	
	public boolean isLabelDisplayed(String strLabel){
		flag=false;
			lstele=driver.findElements(lbl_AccountLabel);
			for(WebElement lbl:lstele){
				if(lbl.getText().equalsIgnoreCase(strLabel)){
					flag=true;
					break;
				}
			}
		return flag;
	}
	
	
	
	public boolean isChangeButtonDisplayed(){
		return cm.isElementDisplayed(btn_Change);
	}

}
