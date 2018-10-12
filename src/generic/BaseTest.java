
//this code works for any project
//in testng class make all the variable as public
//dont use @Test in the base test 
//if we make webdriver as staic parallel execution is not posiible
//if webdriver is final we cannot change the browser
//donot hard code the input always store in a variable and use
package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@Listeners(Result.class)
abstract public class BaseTest implements IAutoConst {
//dont make driver as static it will not run multiple browser when we excecute through selenium 
//grid
	public WebDriver driver;
	public String url=Utility.getPropertyValue(CONFIG_PATH, "URL");//dont make url as static bcz its keep changing
	String strITO=Utility.getPropertyValue(CONFIG_PATH, "ITO");
	public long lngITO=Long.parseLong(strITO);//dont make duration as static bcz its keep changing
	String strETO=Utility.getPropertyValue(CONFIG_PATH, "ETO");
	public long lngETO=Long.parseLong(strETO);
	static
	{
		System.setProperty(chrome_key,chrome_value);
		System.setProperty(gecko_key, gecko_value);
	}
	@Parameters({"ip","browser"})
	@BeforeMethod(alwaysRun=true)
public void openApplication(@Optional("localhost")String ip,@Optional( "chrome")String browser)
{
//	driver=new ChromeDriver();
	driver=Utility.openBrowser(driver,ip ,browser);
	driver.manage().timeouts().implicitlyWait(lngITO, TimeUnit.SECONDS);
	driver.get(url);
		
	
}
	@AfterMethod
	public void closeApplication(ITestResult result)
	{
		String name = result.getName();
		int status = result.getStatus();//1=pass 2=fail 3=skip
		if(status==2)
		{
			//whenever test will fail we need to take the screen shot
			String path = Utility.getPhoto(driver, PHOTO_PATH);
			Reporter.log("Test:"+name+"is failed &photo is:"+path,true);
		}
		else
		{
			Reporter.log("Test:"+name+"is passed ",true);
		}
		driver.quit();
		
	}
}
