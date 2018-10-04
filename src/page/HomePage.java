package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
@FindBy(id="logoutLink")
private WebElement logoutBTN;
public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void clicklogout()
{
	logoutBTN.click();
}
}
