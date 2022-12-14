package Axis.Axis_App;


import org.testng.Assert;
import org.testng.annotations.Test;

public class Rp2pTest extends BaseTest{
	//Open Send page
		@Test(priority = 1)
		private void CheckOpenSendPage() {
			OpenSendPage();
			rp2pPage.getSendTitle();
			Assert.assertTrue(rp2pPage.getSendTitle().contains("Select Number"));
		}
		//check that amount text box accepts decimal numbers
		@Test(priority = 2)
		private void CheckAmountacceptsDecimal() {
			OpenSendPage();
			Assert.assertTrue(rp2pPage.IsDecimalNumberAcceptable());
		}
		
		//check that amount text box accepts decimal numbers
		@Test(priority = 3)
		private void CheckAmountacceptsInteger() {
			OpenSendPage();
			Assert.assertTrue(rp2pPage.IsIntegerNumberAcceptable());
		}
			
		//check that mobile number saved successfully
		@Test(priority = 4)
		private void CheckMobileSavedSuccess() {
			OpenSendPage();
			Assert.assertTrue(rp2pPage.IsMobilesavedSuccess());
		}
		//check that description saved successfully
		@Test(priority = 5)
		private void CheckDescSavedSuccess() {
			OpenSendPage();
			Assert.assertTrue(rp2pPage.IsDescsavedSuccess());
		}
		//check that tranx has been completed
		//*************************************************************************
		//Check that sender balance effects after sending p2p
		@Test(priority = 6)
		private void CheckTranxCompleted() {
			OpenSendPage();
			Assert.assertTrue(rp2pPage.IsTranxCompletedSuccess());
			//
			//Assert.assertTrue(rp2pPage.IsSenderBalanceEffects());
		}
		
		
		//check that tranx displayed in the latest transaction list
		//Check trnx details page contains data successfully
		@Test(priority = 7)
		private void CheckTranxDisplayInLatesttranx() {
			LoginWithValidCredentials();
			Assert.assertTrue(rp2pPage.IsTranxDisplayInLatesttranx());
		}

		//check that p2p fees displayed in the latest transaction list
		@Test(priority = 8)
		private void CheckFeesDisplayInLatesttranx() {
			LoginWithValidCredentials();
			Assert.assertTrue(rp2pPage.IsFeesDisplayInLatesttranx());
		}
		
		
	
		//Check that after send p2p notification sent to receiver number
		
		
		
		//Check that balance effects after receiving p2p
		
		
		
		
		
		
		
		
		//generic
		
		private void OpenSendPage() {
			LoginWithValidCredentials();
			rp2pPage.ClickOnSendbtn();
		}
		
}
