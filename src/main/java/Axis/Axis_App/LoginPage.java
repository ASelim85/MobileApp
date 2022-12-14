package Axis.Axis_App;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends BasePage {

	public LoginPage(AndroidDriver driver) {
		super(driver);
	}
	
	String wrongPsw="624562";
	
	//locate Welcome screen elements
	public By GetStartedbtn = By.xpath("//android.view.View[@content-desc=\"Get started with Axis\"]");
	public By MobileNumtxtbox=By.xpath("//android.widget.EditText[@index='1']");
	public By LoginCheckboxClass=By.className("android.widget.CheckBox");
	public By Continuebtn=By.xpath("//android.view.View[@index=4]");
	
	public By OTPtxtbox= By.xpath("//android.widget.EditText");
	String OTPValue = "004152";
	public By VerifyOTPbtn= By.xpath("(//android.view.View[@content-desc=\"Verify your phone number\"])[2]");
	public By ForgetPasw =By.xpath("//android.view.View[@content-desc=\"Forgot your PIN?\"]");
	public By LoginTitle=By.xpath("//android.widget.Button[@index=0]");
	public By PswInput=By.xpath("//android.widget.EditText[@index=3]");
	public By loginBtn=By.xpath("//android.view.View[@index=7]");
	public By wrongPswPop=By.xpath("//android.view.View[@content-desc=\"Failed Invalid Password\"]");
	public By SuccessLogin=By.xpath("//android.view.View[@content-desc=\"My Balance\"]");
	
	//Click on Get Started btn to open login Screen
	public void ClickOn_GetStartedBtn() {
		ClickOnElement(GetStartedbtn);
	}
	//TC:Can not check if button dimmed or not
	//Fill Mobile Number with my number
	public void FillMobNum(String MobileNum) {
		SendKeysToElement(MobileNumtxtbox,MobileNum);
	}
	
	public void ClickOn_LoginCheckbox() {
		//ClickOnElement(LoginCheckbox);
		ClickElementsByClass(LoginCheckboxClass,0);
		//WebElement chbox= driver.findElements(LoginCheckboxClass).get(0);
		//chbox.click();
	}
	
	public void ClickOn_Continuebtn() {
		ClickOnElement(Continuebtn);
	}
	
	public void FillOTP() {
		SendKeysToElement(OTPtxtbox,OTPValue);
	}
	
	public void ClickOn_OTPVerify() {
		ClickOnElement(VerifyOTPbtn);
		//ClickElementsByClass(VerifyOTPbtn,2);
	}
	
	public void WaitLoginpageOpens()
	{
		WaitToElementByVisible(ForgetPasw);
	}
	public String getLoginTitle() {
		String Logintitle="";
		Logintitle = getText(LoginTitle);
		return Logintitle;
	}
	public String CheckLoginValidation_Failed()
	{
		SendKeysToElement(PswInput, wrongPsw);
		ClickOnElement(loginBtn);
		String valtxt=getText(wrongPswPop);
		System.out.println(valtxt);
		return valtxt;
	}
	public String CheckLoginValidation_Success()
	{
		SendKeysToElement(PswInput, SuccessPsw);
		ClickOnElement(loginBtn);
		String valtxt=getText(SuccessLogin);
		System.out.println(valtxt);
		return valtxt;
	}
}
