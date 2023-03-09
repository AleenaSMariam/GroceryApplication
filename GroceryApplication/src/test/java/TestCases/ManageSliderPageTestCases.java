package TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageSliderPage;
import utilities.ExcelRead;

public class ManageSliderPageTestCases extends BaseClass {
	LoginPage lp;
	ManageSliderPage msp;

	@Test
	public void verifyIfAlertMessageIsShownAfterAllTheDetailsAreAdded() throws AWTException, IOException {
		lp = new LoginPage(driver);
		msp = new ManageSliderPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		msp.enterMobileSlide();
		msp.selectNewButton();
		msp.uploadImageOption();
		msp.enterLink("www.amazon.com");
		msp.selectSaveButton();
		String actualresult = msp.alertSuccesfullMessage();
		String expectedresult = "�\n" + "Alert!\n" + "Slider Created Successfully";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}

}
