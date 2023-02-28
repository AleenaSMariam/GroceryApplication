package TestCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageProductPage;
import elementRepository.ManageSliderPage;

public class ManageSliderPageTestCases extends BaseClass {
	LoginPage lp;
	ManageSliderPage msp;

	@Test
	public void verifyIfAlertMessageIsShownAfterAllTheDetailsAreAdded() throws AWTException {
		lp = new LoginPage(driver);
		msp = new ManageSliderPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
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
