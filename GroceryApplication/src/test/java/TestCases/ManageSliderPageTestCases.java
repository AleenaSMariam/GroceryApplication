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
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		msp.enterMobileSlide();
		msp.selectNewButton();
		msp.uploadImageOption();
		msp.enterLink(Constant.LINK_OF_SLIDER);
		msp.selectSaveButton();
		String actualresult = msp.alertSuccesfullMessage();
		String expectedresult = Constant.ALERT_MESSAGE_FOR_CREATING_SLIDER;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);

	}

}
