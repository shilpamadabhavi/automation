package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Framehandling {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("http://jqueryui.com/droppable/");
	WebElement e = driver.findElement(By.className("demo-frame"));
	driver.switchTo().frame(e);
	WebElement src = driver.findElement(By.id("draggable"));
	WebElement dest = driver.findElement(By.id("droppable"));
	Actions action=new Actions(driver);
	action.dragAndDrop(src, dest).perform();;
	
}
}
