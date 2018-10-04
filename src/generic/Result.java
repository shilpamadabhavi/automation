/*
 * in the background result class will be running
 */
package generic;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Result  implements ITestListener,IAutoConst{
static int passCount=0,failCount=0;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		passCount++;
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		failCount++;
//		String P = Utility.getPhoto(driver, PHOTO_PATH);
//		Reporter.log("photo:" +P,true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Utility.writeResultToXL(SUMMARY_PATH, "sheet1", passCount, failCount);
	}

}
