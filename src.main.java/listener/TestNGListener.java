package listener;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import common.DriverFactory;
import utils.DateTimeMethods;



public class TestNGListener implements ITestListener {
	WebDriver driver;
	String screenshotPath=System.getProperty("user.dir") + "/build/test-output/screenshots/";

	
	
	@Override
	public void onFinish(ITestContext arg0) {

		
	}

	@Override
	public void onStart(ITestContext arg0) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		driver = DriverFactory.getDriver();
		
		final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
		System.setProperty(ESCAPE_PROPERTY, "false");
		
		String fileName=screenshotPath +arg0.getName()
				+"_"+DateTimeMethods.getCurrentDate("ddMMMyyyyhhmm")+".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    
		try {
	        FileUtils.copyFile(scrFile, new File(fileName));
	        Reporter.log("<a href='"+fileName+"'> <img src='"+ fileName + "' height='150' width='150'/> </a>");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {

		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		
	}

}
