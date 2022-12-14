package Axis.Axis_App;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	//Open Login page
	@Test(priority = 1)
	private void CheckOpenLoginPage() {
		OpenLoginPage();
		System.out.println("Test is " + loginPage.getLoginTitle());
		Assert.assertTrue(loginPage.getLoginTitle().contains("Please enter your PIN code in order to access your AXIS account"));
	}
	//failed login  ----------> can not catch validation pop up
	//@Test(priority = 2)
	private void CheckLoginFailed() {
		OpenLoginPage();
		Assert.assertTrue(loginPage.CheckLoginValidation_Failed().contains("Failed Invalid Password"));		
	}
	//success login
	@Test(priority = 3)
	private void CheckLoginSuccess() {
		OpenLoginPage();
		Assert.assertTrue(loginPage.CheckLoginValidation_Success().contains("My Balance"));		
	}
	
	
	
	
	
	
	
}
