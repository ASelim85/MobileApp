package Axis.Axis_App;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class RegistrationPage extends BasePage{

	public RegistrationPage(AndroidDriver driver) {
		super(driver);
	}
	LoginPage loginPage=new LoginPage(driver);
	public By changeNumlink = By.xpath("//android.widget.ImageView[@index='1']");
	String NewMobileNum="01555555555";
	public By skipReferralCode = By.xpath("//android.view.View[@content-desc=\"Skip\"]");
	public By SetPINtitle=By.xpath("//android.view.View[@index='1']");
	public By Backbtn=By.xpath("//android.widget.ImageView[@index='0']");
	public By referralCodetxtbox=By.xpath("//android.widget.EditText[@index='2']");
	String referralCode="do4t6X";
	public By Applybtn=By.xpath("//android.view.View[@content-desc=\"Apply\"]");
	public By SetPINtxtbox = By.xpath("//android.widget.EditText[@index='1']");
	public By CreatePIN=By.xpath("//android.view.View[@content-desc=\"Create PIN code\"]");
	String Newpassword="111111";
	public By ReSetPINtitle=By.xpath("//android.view.View[@index='1']");
	public By ReSetPINtxtbox = By.xpath("//android.widget.EditText[@index='1']");
	public By VerifyPIN=By.xpath("//android.view.View[@content-desc=\"Verify PIN code\"]");
	public By CameraTitle=By.xpath("//android.view.View[@index='1']");
	String CameraTitletxt="Verify your identity";
	public By Camerabtn=By.xpath("//android.view.View[@content-desc=\"Verify identity\"]");
	public By Setuptitle=By.xpath("//android.view.View[@index='1']");
	public By FNametxtbox=By.xpath("//android.view.View[@index='1']");
	public By LNametxtbox=By.xpath("//android.view.View[@index='1']");
	public By Governddl=By.xpath("//android.view.View[@index='1']");
	public By Cityddl=By.xpath("//android.view.View[@index='1']");
	public By Addresstxtbox=By.xpath("//android.view.View[@index='1']");
	public By NationalIDtxtbox=By.xpath("//android.view.View[@index='1']");
	public By GovernOption=By.xpath("//android.view.View[@content-desc=\"القاهرة\"]");
	public By cityOption=By.xpath("//android.view.View[@content-desc=\"الزمالك\"]");
	String Address="Test Address";
	String Nationaltxt="29107010203045";
	
	//click on change number and enter a new number
	public void ClickOnchangeNumber() {
		ClickOnElement(changeNumlink);
	}
	public void VerifyOTP()
	{
		loginPage.FillMobNum(NewMobileNum);
		loginPage.ClickOn_LoginCheckbox();
		loginPage.ClickOn_Continuebtn();
		loginPage.FillOTP();
		loginPage.ClickOn_OTPVerify();
	}
	public boolean CompleteRegistration() {
		boolean result=true;
		ClickOnElement(skipReferralCode);
		ClickOnElement(Backbtn);
		ClickOnElement(referralCodetxtbox);
		SendKeysToElement(referralCodetxtbox ,referralCode);
		ClickOnElement(Applybtn);
		String setPINtxt = getText(SetPINtitle);
			ClickOnElement(SetPINtxtbox);
			SendKeysToElement(SetPINtxtbox, Newpassword);
			ClickOnElement(CreatePIN);
			String ReSetPINtitletxt=getText(ReSetPINtitle);
			ClickOnElement(ReSetPINtxtbox);
			SendKeysToElement(ReSetPINtxtbox, Newpassword);
			ClickOnElement(VerifyPIN);
			String Cameratitletxt=getText(CameraTitle);
			ClickOnElement(Camerabtn);
			String Setuptitletxt=getText(Setuptitle);
			//Fill all inputs
			SendKeysToElement(FNametxtbox, "Test f Name");		
			SendKeysToElement(LNametxtbox, "Test l Name");	
			ClickOnElement(Governddl);
			ClickOnElement(GovernOption);
			ClickOnElement(Cityddl);
			ClickOnElement(cityOption);
			SendKeysToElement(Addresstxtbox,Address);
			SendKeysToElement(NationalIDtxtbox, Nationaltxt);
			
		return result;
	}
}
