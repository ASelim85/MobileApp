package Axis.Axis_App;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.opentelemetry.api.internal.StringUtils;
public class P2pPage extends BasePage {

	public P2pPage(AndroidDriver driver) {
		super(driver);
	}
// locators 
	public By Sendbtn=By.xpath("//android.widget.ImageView[@content-desc=\"Send\"]");
	public By Sendtitle=By.xpath("//android.view.View[@index='1']");
	public By Amounttxtbox =By.xpath("//android.widget.EditText[@index='1']");
	String decimalnumber="1.5";
	String Intnumber="1";
	public By Mobiletxtbox =By.xpath("//android.widget.EditText[@index='3']");
	String MobileNumber="01001009000";
	public By Desctxtbox =By.xpath("//android.widget.EditText[@text='Description']");
	String Desctxt="test";
	public By ReviewRequestbtn =By.xpath("//android.widget.Button[@content-desc=\"Review request\"]");
	public By Authorizebtn=By.xpath("//android.widget.Button[@content-desc=\"Authorize transaction\"]");
	public By PINtxt =By.xpath("//android.widget.EditText[@index='2']");
	public By confirmBtn =By.xpath("//android.widget.Button[@content-desc=\"Confirm and send request\"]");
	//
	public By confirmationtitle=By.xpath("//android.view.View[@index='1']");
	public By confirmationAmountlbl=By.xpath("//android.view.View[@index='3']");
	public By confirmationMobilelbl=By.xpath("//android.view.View[@index='6']");
	public By confirmationdesclbl=By.xpath("//android.view.View[@index='8']");
	public By confirmationDateTime=By.xpath("//android.view.View[@index='9']");
	//

	//
	public By confirmationDonebtn=By.xpath("//android.view.View[@content-desc=\"Done\"]");
	public By p2p_TranxElement=By.className("android.widget.ImageView");
	public By ViewAllTranx=By.xpath("//android.view.View[@index='15']");
	public By Balancelbl=By.xpath("//android.view.View[@index='1']");
	
	//tranx details
	public By trnxdetailsTitle=By.xpath("//android.view.View[@index='1']");
	public By trnxdetailsSubTitle=By.xpath("//android.view.View[@index='2']");
	public By trnxdetailsDetails=By.xpath("//android.view.View[@index='3']");
	public By trnxdetailsAdditionalInfo=By.xpath("//android.view.View[@index='5']");
	public By trnxTxt=By.xpath("//android.view.View[@index='3']");
	
//methods
	public void ClickOn_Sendbtn() {
		ClickOnElement(Sendbtn);
	}
	public String getSendTitle() {
		String val="";
		val = getText(Sendtitle);
		System.out.println(val);
		return val;
	}
	public boolean IsDecimalNumberAcceptable() {
		 boolean result=true;
		//write decimal number
		 SendKeysToElement(Amounttxtbox, decimalnumber);
		 //write valid mobile number
		 ClickOnElement(Mobiletxtbox);
		 SendKeysToElement(Mobiletxtbox,MobileNumber);
		 //click on review request btn
		 ClickOnElement(ReviewRequestbtn);
		 //check if data displays or not
		 String ActualAmount=getText(confirmationAmountlbl);
		 String ExpectedAmount=decimalnumber+" EGP";
		 if (ActualAmount.equals(ExpectedAmount)) 
		 {return result;}
		 else {result=false;}
		return result;
	}
	public boolean IsIntegerNumberAcceptable() {
		 boolean result=true;
		//write decimal number
		 SendKeysToElement(Amounttxtbox, Intnumber);
		 //write valid mobile number
		 ClickOnElement(Mobiletxtbox);
		 SendKeysToElement(Mobiletxtbox,MobileNumber);
		 //click on review request btn
		 ClickOnElement(ReviewRequestbtn);
		 //check if data displays or not
		 String ActualAmount=getText(confirmationAmountlbl);
		 String ExpectedAmount=Intnumber+" EGP";
		 if (ActualAmount.equals(ExpectedAmount)) 
		 {return result;}
		 else {result=false;}
		return result;
	}
	public boolean IsMobilesavedSuccess() {
		 boolean result=true;
		//write decimal number
		 SendKeysToElement(Amounttxtbox, decimalnumber);
		 //write valid mobile number
		 ClickOnElement(Mobiletxtbox);
		 SendKeysToElement(Mobiletxtbox,MobileNumber);
		 //click on review request btn
		 ClickOnElement(ReviewRequestbtn);
		 //check if data displays or not
		 String ActualMobile=getText(confirmationMobilelbl).replaceAll("\\s+","");
		 //ActualMobile.replaceAll("\\s+","");
		 String ExpectedMobile=MobileNumber;
		 System.out.println(ActualMobile);
		 System.out.println(ExpectedMobile);
		 if (ActualMobile.equals(ExpectedMobile)) 
		 {return result;}
		 else {result=false;}
		return result;
	}	
	//keyword hasn't been written in text although it clicks on text box
	public boolean IsDescsavedSuccess() {
		 boolean result=true;
		 SendKeysToElement(Amounttxtbox, decimalnumber);
		 ClickOnElement(Mobiletxtbox);
		 SendKeysToElement(Mobiletxtbox,MobileNumber);
		 ClickOnElement(Desctxtbox);
		 SendKeysToElement(Desctxtbox,Desctxt);
		 driver.hideKeyboard();
		 ClickOnElement(ReviewRequestbtn);
		 String Actualdesc=getText(confirmationdesclbl);
		 String Expecteddesc=Desctxt;
		 System.out.println(Actualdesc);
		 System.out.println(Expecteddesc);
		 if (Actualdesc.equals(Expecteddesc)) 
		 {return result;}
		 else {result=false;}
		return result;
	}
	public boolean IsTranxCompletedSuccess() {
		 boolean result=true;
		 SendKeysToElement(Amounttxtbox, Intnumber);
		 ClickOnElement(Mobiletxtbox);
		 SendKeysToElement(Mobiletxtbox,MobileNumber);
		 ClickOnElement(Desctxtbox);
		 SendKeysToElement(Desctxtbox,Desctxt);
		 driver.hideKeyboard();
		 ClickOnElement(ReviewRequestbtn);
		 ClickOnElement(Authorizebtn);
		 ClickOnElement(PINtxt);
		 SendKeysToElement(PINtxt,SuccessPsw);
		 ClickOnElement(confirmBtn);
		 WaitToElementByVisible(confirmationtitle);
		 String Actualtitle=getText(confirmationtitle);
		 String Expecedtitle="Transaction has been completed";
		 String ActualAmount=getText(confirmationAmountlbl);
		 String pattern = "dd-MM-yyyy";
		 String dateInString =new SimpleDateFormat(pattern).format(new Date());
		 String ActualDate=getText(confirmationDateTime);
		 String ActDate=ActualDate.substring(0, 10);
		 System.out.println(dateInString);
		 System.out.println(ActDate);
		 System.out.println(ActualAmount);
		 System.out.println(Intnumber+" EGP");
		 ClickOnElement(confirmationDonebtn);
		 //
		 if (Expecedtitle.equals(Actualtitle)
				 && ActualAmount.equals(Intnumber+" EGP")
				 && dateInString.equals(ActDate)) 
		 {return result;}
		 else {result=false;}
		return result;
	}
	//check that tranx displayed in the latest transaction list
	public boolean IsTranxDisplayInLatesttranx() {
		boolean result=true;
		//
		WebElement ViewAllbtn=getElement(ViewAllTranx);
		ViewAllbtn.click();
		DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
		Date date = new Date();
		String Date = dateFormat.format(date);
		System.out.println("*************"+Date);
		String trnxAmount =Intnumber+".00 EGP"; 
		System.out.println("*************"+trnxAmount);
		
		WebElement lastTranx = getTrnxFromlist("android.widget.ImageView");
		String trnxData = lastTranx.getAttribute("content-desc");
		//check tranx data in list
		if(trnxData.contains("Send P2P")
				&&trnxData.contains(Date)
				&&trnxData.contains("Success")
				&&trnxData.contains(trnxAmount)) {
		lastTranx.click();
		//check tranx details data
		dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		date = new Date();
		Date = dateFormat.format(date);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30,1));
		//wait.until(ExpectedConditions.textToBePresentInElementLocated(trnxTxt, "Posted"));
		//WaitToElementByVisible(trnxdetailsTitle);
		String trnxdetailsTitleString=getText(trnxdetailsTitle);
		String trnxdetailsSubTitleString=getText(trnxdetailsSubTitle);
		String trnxdetailsDetailsString=getText(trnxdetailsDetails);
		String trnxdetailsAdditionalInfoString=getText(trnxdetailsAdditionalInfo);
			if((trnxdetailsTitleString.equals("Transaction Details"))
					&&(trnxdetailsSubTitleString.equals(Desctxt)||trnxdetailsSubTitleString.equals("Send P2P"))
					&&(trnxdetailsDetailsString.contains("Send P2P")
							&&trnxdetailsDetailsString.contains("Posted")
							&&trnxdetailsDetailsString.contains(Intnumber)
							&&trnxdetailsDetailsString.contains(Date))
					&&(trnxdetailsAdditionalInfoString.contains("Additional Info")
							&&trnxdetailsAdditionalInfoString.contains("Receiver Name")
							&&trnxdetailsAdditionalInfoString.contains("Receiver Number")))
			{
				return result;	
			}
			else {result=false; }
		return result;
		}
		else {result=false; }
		return result;
	}
	//check that tranx displayed in the latest transaction list
	public boolean IsFeesDisplayInLatesttranx() {
		boolean result=true;
		WebElement ViewAllbtn=getElement(ViewAllTranx);
		ViewAllbtn.click();
		DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
		Date date = new Date();
		String Date = dateFormat.format(date);
		System.out.println("*************"+Date);
		WebElement lastFeesTranx = getFeesTrnxFromlist("android.widget.ImageView");
		String trnxFeesData = lastFeesTranx.getAttribute("content-desc");
		//check fees tranx data in list
				if(trnxFeesData.contains("send p2p on us fees")
						&&trnxFeesData.contains(Date)
						&&trnxFeesData.contains("Success")) {
					lastFeesTranx.click();
					//check tranx details data
					dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					date = new Date();
					Date = dateFormat.format(date);
					System.out.println("fees date"+Date);
					new WebDriverWait(driver, Duration.ofSeconds(10));
					WaitToElementByVisible(trnxdetailsTitle);
					String trnxdetailsTitleString=getText(trnxdetailsTitle);
					System.out.println(trnxdetailsTitleString);					
					String trnxdetailsSubTitleString=getText(trnxdetailsSubTitle);
					System.out.println(trnxdetailsSubTitleString);
					String trnxdetailsDetailsString=getText(trnxdetailsDetails);
					System.out.println(trnxdetailsDetailsString);
						if((trnxdetailsTitleString.equals("Transaction Details"))
								&&(trnxdetailsSubTitleString.equals("Send P2P Service Fees Transfer"))
								&&(trnxdetailsDetailsString.contains("send p2p on us fees")
								&&trnxdetailsDetailsString.contains("Posted")
								&&trnxdetailsDetailsString.contains("1 EGP")
								&&trnxdetailsDetailsString.contains(Date)
										))
						{
							return result;	
						}
						else {result=false; }
					return result;
					}
					else {result=false; }
		return result;
	}

	/*public boolean IsSenderBalanceEffects() {
		boolean result=true;
		//get first sender balance before transaction
		String balanceAmountBefore=getText(Balancelbl);
		System.out.println(balanceAmountBefore);
		//get transaction amount= amount + fees
		
		
		//get first sender balance after transaction
		String balanceAmountAfter=getText(Balancelbl);
		System.out.println(balanceAmountAfter);

		if() {
			return result;
		}else {result=false;}
		return result;
	}*/
	
	//generic
	//get list of transactions
	public WebElement getTrnxFromlist(String className)
	{
		WebElement element=null;
		List<WebElement> lst=driver.findElements(By.className(className));
		for (WebElement ele : lst) {
	        if (ele.getAttribute("content-desc") !=null && ele.getAttribute("content-desc").contains("Send P2P")) {
	        	element=ele;
	        	break;}
	        else {element=null;}
	    }
		return element;
	}
	
	//get list of transactions fees
	private WebElement getFeesTrnxFromlist(String className)
	{
		WebElement element=null;
		List<WebElement> lst=driver.findElements(By.className(className));
		for (WebElement ele : lst) {
		       if (ele.getAttribute("content-desc") !=null && ele.getAttribute("content-desc").contains("send p2p on us fees")) {
		        element=ele;
		        break;}
		       else {element=null;}
		   }
		return element;
	}
}
