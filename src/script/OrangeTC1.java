package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import generic.WebGeneric;
import page.DashboardPage;
import page.LoginPage;

public class OrangeTC1 extends BaseTest {
@Test
public void testOrangeTC1()
{
String un=Utility.getXLData(INPUT_PATH, "OrangeTC1", 1, 0);
String pw=Utility.getXLData(INPUT_PATH, "OrangeTC1", 1, 1);
String dbpURL=Utility.getXLData(INPUT_PATH, "OrangeTC1", 1, 2);
String logipURL=Utility.getXLData(INPUT_PATH, "OrangeTC1", 1, 3);
	//Enter valid un,pwand click login
LoginPage p=new LoginPage(driver);
p.setUsername(un);
p.setPassword(pw);
p.click();
//verify that dashboard page is displayed
WebGeneric.verifyPAgeIsDisplayed(driver, lngETO, dbpURL);
//click on logout 
DashboardPage d=new DashboardPage(driver);
d.clicklogout();
//verify that login page is displayed
WebGeneric.verifyPAgeIsDisplayed(driver, lngETO, logipURL);
}
}
