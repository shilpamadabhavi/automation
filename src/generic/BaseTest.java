
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
@Listeners(Result.class)
abstract public class BaseTest implements IAutoConst {
	
	public WebDriver driver;
	public String url=Utility.getPropertyValue(CONFIG_PATH, "URL");//dont make url as static bcz its keep changing
	String ITO=Utility.getPropertyValue(CONFIG_PATH, "ITO");
	public long duration=Long.parseLong(ITO);//dont make duration as static bcz its keep changing
	static
	{
		System.setProperty(chrome_key,chrome_value);
		System.setProperty(gecko_key, gecko_value);
	}
	
	@BeforeMethod
public void openApplication()
{
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	driver.get(url);
	
}
	@AfterMethod
	public void closeApplication()
	{
		driver.close();
	}
}
