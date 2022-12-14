package Axis.Axis_App;


import org.testng.Assert;
import org.testng.annotations.Test;

public class P2pTest extends BaseTest{
	//Open Send page
		@Test(priority = 1)
		private void CheckOpenSendPage() {
			OpenSendPage();
			p2pPage.getSendTitle();
			Assert.assertTrue(p2pPage.getSendTitle().contains("Select Number"));
		}
		//check that amount text box accepts decimal numbers
		@Test(priority = 2)
		private void CheckAmountacceptsDecimal() {
			OpenSendPage();
			Assert.assertTrue(p2pPage.IsDecimalNumberAcceptable());
		}
		
		//check that amount text box accepts decimal numbers
		@Test(priority = 3)
		private void CheckAmountacceptsInteger() {
			OpenSendPage();
			Assert.assertTrue(p2pPage.IsIntegerNumberAcceptable());
		}
			
		//check that mobile number saved successfully
		@Test(priority = 4)
		private void CheckMobileSavedSuccess() {
			OpenSendPage();
			Assert.assertTrue(p2pPage.IsMobilesavedSuccess());
		}
		//check that description saved successfully
		@Test(priority = 5)
		private void CheckDescSavedSuccess() {
			OpenSendPage();
			Assert.assertTrue(p2pPage.IsDescsavedSuccess());
		}
		//check that tranx has been completed--> Done
		
		@Test(priority = 6)
		private void CheckTranxCompleted() {
			OpenSendPage();
			Assert.assertTrue(p2pPage.IsTranxCompletedSuccess());
			//
			//Assert.assertTrue(p2pPage.IsSenderBalanceEffects());
		}
		
		//*************************************************************************
		//check that tranx displayed in the latest transaction list
		//Check trnx details page contains data successfully
		@Test(priority = 7)
		private void CheckTranxDisplayInLatesttranx() {
			LoginWithValidCredentials();
			Assert.assertTrue(p2pPage.IsTranxDisplayInLatesttranx());
		}

		//check that p2p fees displayed in the latest transaction list
		@Test(priority = 8)
		private void CheckFeesDisplayInLatesttranx() {
			LoginWithValidCredentials();
			Assert.assertTrue(p2pPage.IsFeesDisplayInLatesttranx());
		}
		
		
		
		
		
		//Check that balance effected after sending p2p
		
		
		
		
		
		
		
		
		//generic
		
		private void OpenSendPage() {
			LoginWithValidCredentials();
			p2pPage.ClickOn_Sendbtn();
		}
		
}
