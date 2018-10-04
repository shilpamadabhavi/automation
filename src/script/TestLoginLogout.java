package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.HomePage;
import page.LoginPage;

public class TestLoginLogout extends BaseTest{
@Test(priority=1,groups= {"login","smoke"})
public void testLoginLogout()
{
	Reporter.log("testdemo2",true);
	LoginPage p=new LoginPage(driver);
	String un = Utility.getXLData(INPUT_PATH, "TestLoginLogout", 1, 0);
	String pw = Utility.getXLData(INPUT_PATH, "TestLoginLogout", 1, 1);
//	p.setUsername(Utility.getXLData(INPUT_PATH, "sheet1", 1, 0));
//	p.setPassword(Utility.getXLData(INPUT_PATH, "sheet1", 1, 1));
	p.setUsername(un);
	p.setPassword(pw);
	p.click();
	HomePage h=new HomePage(driver);
	h.clicklogout();
	
//	Utility.getXLData(INPUT_PATH, "sheet1", 0, 1);
}

}
