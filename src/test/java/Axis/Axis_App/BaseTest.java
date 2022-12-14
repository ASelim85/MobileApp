package Axis.Axis_App;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	public AndroidDriver driver ;
	LoginPage loginPage=null;
	P2pPage p2pPage=null;
	RegistrationPage registrationPage=null;

	Rp2pPage rp2pPage = null;
	String MobileNum="01222436611";
  @BeforeMethod
  public void Setup() throws InterruptedException, MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "SSGUW8IR9DJRW4YT"); // - 5200d6dac0dbb481
		capabilities.setCapability("AndroidVersion", "10");
		capabilities.setCapability("appPackage", "com.axispay.consumer.wallet.dev");
		capabilities.setCapability("appActivity", "com.axispay.consumer.wallet.MainActivity");
		capabilities.setCapability("skipDeviceInitialization", true);
		capabilities.setCapability("ignoreUnimportantViews", true);
		capabilities.setCapability("browserName", "");
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability("automationName", "UiAutomator2");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		loginPage =new LoginPage(driver);
		p2pPage=new P2pPage(driver);
		registrationPage =new RegistrationPage(driver);
	    rp2pPage = new Rp2pPage();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//--------------------------------------------
		//driver.findElement(By.xpath("//android.view.View[@content-desc=\"Get started with Axis\"]")).click();
		//driver.findElement(By.xpath("//android.view.View[@index='8']")).click();
		//driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).click();
		//driver.findElement(By.xpath("//android.widget.EditText[@index=1]")).sendKeys("01001234567");
		//driver.findElement(By.xpath("//android.widget.ImageView[@index=3]")).click();
		//driver.findElement(By.xpath("//android.view.View[@index=4]")).click();
		
		
		//String CheckMobNum = driver.findElement(By.xpath("//android.view.View[@index=1]")).getAttribute("content-desc");
		//System.out.println("Test is " + CheckMobNum);
		//AssertJUnit.assertEquals(CheckMobNum, "من فضلك قم بإدخال الكود المكون من 6 أرقام المُرسل لرقم هاتفك المحمول");
		
		
		//driver.findElement(By.xpath("//android.widget.EditText[@index=3]")).click();
		//driver.findElement(By.xpath("//android.widget.EditText[@index=3]")).sendKeys("004152");
		//driver.findElement(By.xpath("//android.view.View[@index=4]")).click();
		//Thread.sleep(5000);
		//String CheckWel = driver.findElement(By.xpath("//android.widget.ImageView[@index=1]")).getAttribute("content-desc");
		//System.out.println("Test is " + CheckWel);
		//AssertJUnit.assertTrue(CheckWel.contains("رقم المحمول"));
		
		//-------------------------------------------

  }
  
  public void OpenLoginPage () {
		
		loginPage.ClickOn_GetStartedBtn();
		loginPage.FillMobNum(MobileNum);
		loginPage.ClickOn_LoginCheckbox();
		loginPage.ClickOn_Continuebtn();
		loginPage.FillOTP();
		loginPage.ClickOn_OTPVerify();
		loginPage.WaitLoginpageOpens();
	}
  public void LoginWithValidCredentials () {
		
		loginPage.ClickOn_GetStartedBtn();
		loginPage.FillMobNum(MobileNum);
		loginPage.ClickOn_LoginCheckbox();
		loginPage.ClickOn_Continuebtn();
		loginPage.FillOTP();
		loginPage.ClickOn_OTPVerify();
		loginPage.WaitLoginpageOpens();
		loginPage.SendKeysToElement(loginPage.PswInput, loginPage.SuccessPsw);
		loginPage.ClickOnElement(loginPage.loginBtn);
	}
 
}
