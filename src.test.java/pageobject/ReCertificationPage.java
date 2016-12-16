package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**Class contains all the PO methods related to Student portal Recertification page
* 
* Navigation steps to this page-> Login to Student home page -> click on Recertification tab
* 
* @author Praveen.Maled
* Date Created: 21-Oct-2016
*/
public class ReCertificationPage extends ELearningCenterPage{
	
	/*Variables*/
	private boolean flag=false;
	private String strResult=null;
	
	/*Constructor*/
	protected ReCertificationPage(WebDriver webDriver){
		super(webDriver);
		this.driver=webDriver;
	}
	
	By lbl_Message = By.cssSelector(".alert.alert-danger");
	
	public String getMessage(){
		strResult=driver.findElement(lbl_Message).getText();
		return strResult;
	}
	

}
