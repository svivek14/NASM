package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Praveen.Maled
 * Date Created: 04-Oct-2016
 *
 */
public class SitefinityTopNavigationPane extends HomePage{

	
	
	public SitefinityTopNavigationPane(WebDriver driver) {
		super(driver);
	}

	By lnk_AllCourses=By.cssSelector("[aria-label='All Courses']");
	
	
	public ProductsListPage clickOnAllCourses(){
		driver.findElement(lnk_AllCourses).click();
		return new ProductsListPage(driver);
	}
}
