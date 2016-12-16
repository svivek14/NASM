package pageobject;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Class contains methods related to the Accounts page
 * 
 * Navigation steps to this page-> Login to NASM application and navigate to student home page -> Click on Certificates tab/link
 *  								
 * @author Praveen.Maled
 * Date Created: 04-Oct-2016
 *
 */
public class CertificatesPage extends ELearningCenterPage{

	
	/*Variables*/
	private boolean flag=false;
	private String strResult=null;
	private int i=0;
	
	/*Constructor*/
	public CertificatesPage(WebDriver webDriver) {
		super(webDriver);
		this.driver=webDriver;
	}
	
	By lbl_CourseName = By.cssSelector(".textLayer div:nth-child(5)");
	By btn_ViewCertificate = By.cssSelector("tbody tr:nth-child({1}) td a");
	By lbl_CertificateName = By.cssSelector("tr td:nth-child(1)");
	
	
	
	public boolean isCertificatesPageDisplayed(String strPageTitle) throws Exception{
		flag=false;
		strResult=null;
			strResult=driver.getTitle();
			flag=strResult.equalsIgnoreCase(strPageTitle);
		return flag;
	}
	
	
	
	public boolean isCertificateDisplayed(String strCertificateName){
		flag=false;
		strResult=null;
			List<WebElement> lstcourse=driver.findElements(lbl_CertificateName);
			for(WebElement course:lstcourse){
				if(strCertificateName.equalsIgnoreCase(course.getText())){
					flag=true;
					break;
				}
			}
		return flag;
	}
	
	
	/**
	 * Method will click on view certificate button
	 * 
	 * @param strCertificateName
	 * @return boolean
	 * @throws Exception
	 *//*
	public void clickOnViewCertificateButton(String strCertificateName) throws Exception{
		strResult=null;
		i=1;
		try{
			log(logger,"Clicking on View certificate button");
			List<WebElement> lstcourse=textHandler.findElements(PropertiesRepository.getString("nasm.certificatespage.lblcertificatename"));
			if(lstcourse!=null && lstcourse.size()>1){
				for(WebElement course:lstcourse){
					i++;
					if(strCertificateName.equalsIgnoreCase(course.getText())){
						buttonHandler.clickButton(buttonHandler.replaceLocatorValues(PropertiesRepository.getString("nasm.certificatespage.btnviewcertificate"), String.valueOf(i)));
						break;
					}
				}
			}
		}catch(WebDriverException we){
			throw new Exception("Failed to click on view certificate button \n METHOD :clickOnViewCertificateButton "
					+ we.getLocalizedMessage());
		}
	}*/
	
	
	
	
//	public boolean isCertificateHasCourseName(String strCertificateCourseName) throws Exception{
//		flag=false;
//			if(DriverFactory.browser.equalsIgnoreCase("firefox")){
//				flag=strCertificateCourseName.equalsIgnoreCase(driver.findElement(lbl_CourseName).getText());
//			}else{
////				FileIOUtils fio=new FileIOUtils();
////				String path=fio.getLastModifiedFileName(PropertiesRepository.getString("global.download.location"));
////				strResult=	pdfHandler.getPDFContentUsingFilePath(path, 1, 1);
//			}
//		
//		return flag;
//	}
	
	
	public void download() throws Exception{
		try{

			System.out.println("enter111");
			Thread.sleep(10000);
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_L);
				robot.keyRelease(KeyEvent.VK_L);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				 robot.delay(600);
			robot.keyPress(KeyEvent.VK_TAB);
		    robot.keyRelease(KeyEvent.VK_TAB);
		    robot.delay(200);
			robot.keyPress(KeyEvent.VK_TAB);
		    robot.keyRelease(KeyEvent.VK_TAB);
		    robot.delay(200);
			robot.keyPress(KeyEvent.VK_TAB);
		    robot.keyRelease(KeyEvent.VK_TAB);
		    robot.delay(200);
			robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    robot.delay(7000);
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		}catch(Exception e){
			throw new Exception("error:"+e.getLocalizedMessage());
		}
	}
}
