package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
@FindBy(id="txtUsername")
private WebElement unTB;
@FindBy(id="txtPassword")
private WebElement pwTB;
@FindBy(name="Submit")
private WebElement logBTN;
public LoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(this.driver, this);
}
public void setUsername(String name)
{
	unTB.sendKeys(name);
}
public void setPassword(String pwd)
{
	pwTB.sendKeys(pwd);
}
public void click()
{
	logBTN.click();
//	HomePa  ge h=new HomePage(driver);
//	h.clicklogout();
//	return h;
}
}
