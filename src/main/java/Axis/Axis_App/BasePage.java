package Axis.Axis_App;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BasePage {
	static AndroidDriver driver= null;
	
	//constructor
	public BasePage(AndroidDriver driver) {
		this.driver=driver;
	}
	public String SuccessPsw="111111";
	//get any element
	public static WebElement getElement(By locatore) {
		WebElement element=null;
		try {
			element=driver.findElement(locatore);
		} catch (Exception e) {
			System.out.print("Some error while locating element"+locatore);
			e.printStackTrace();
		}
		return element;
	}
	
	//Click on any element
	public static void ClickOnElement(By locatore) {
		try {
			getElement(locatore).click();
		} catch (Exception e) {
			System.out.print("Some error while locating element"+locatore);
			e.printStackTrace();
		}
	}
	
	public void ClickElementsByClass(By locatore, int index) {
		WebElement element=null;
		try {
			element=driver.findElements(locatore).get(index);
			element.click();
		} catch (Exception e) {
			System.out.print("Some error while locating element"+locatore);
			e.printStackTrace();
		}
	}
	//Send keys to any element
	public static void SendKeysToElement(By locatore, String key) {
		try {
			getElement(locatore).sendKeys(key);
		} catch (Exception e) {
			System.out.print("Some error while locating element"+locatore);
			e.printStackTrace();
		}
	}
	//Wait Element
	public void WaitToElementByVisible(By locatore) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30,1));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locatore));
		} catch (Exception e) {
			System.out.print("Some error while locating element"+locatore);
			e.printStackTrace();
		}
	}
	public static String getText(By locatore) {
		String title="";
		try {
			title = getElement(locatore).getAttribute("content-desc");
		} catch (Exception e) {
			System.out.print("Some error while locating element"+locatore);
			e.printStackTrace();
		}
		return title;
	}
}
