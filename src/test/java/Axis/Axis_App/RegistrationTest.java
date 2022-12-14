package Axis.Axis_App;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{
	//Open Login page
	@Test(priority = 1)
	private void CheckOpenRegistraionPage() {
		OpenLoginPage();
		registrationPage.ClickOnchangeNumber();
		registrationPage.VerifyOTP();
		registrationPage.CompleteRegistration();
		
		
		
		//Assert
	}
	
	//
}
