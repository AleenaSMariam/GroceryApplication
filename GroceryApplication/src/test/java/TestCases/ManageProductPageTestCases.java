package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageProductPage;
import elementRepository.PushNotificationsPage;

public class ManageProductPageTestCases extends BaseClass {
	LoginPage lp;
	ManageProductPage mpp;

	@Test
	public void verifyDropDownValueOfWeightUnitInTheNewOption() {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignIn();
		mpp.enterManageProductPage();
		mpp.clickNew();
		String actualresult = mpp.dropdownValueOfType(1);
		String expectedresult = "g";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}

	@Test
	public void verifyRadioButtonInProductTypeInTheNewOption() {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignIn();
		mpp.enterManageProductPage();
		mpp.clickNew();
		mpp.clickProductTypeRadioButton();
		boolean actualresult = mpp.productTypeRadioButtonValue();
		boolean expectedresult = true;
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}

	@Test
	public void verifyRadioButtonInPriceTypeInTheNewOption() {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignIn();
		mpp.enterManageProductPage();
		mpp.clickNew();
		mpp.clickPriceTypeRadioButton();
		boolean actualresult = mpp.priceTypeRadioButtonValue();
		boolean expectedresult = true;
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}

	@Test
	public void verifyifunlimitedStockCheckBoxIsSelectedInNewOption() {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignIn();
		mpp.enterManageProductPage();
		mpp.clickNew();
		Boolean actualresult = mpp.ifunlimitedStockCheckBoxIsSelected();
		Boolean expectedresult = true;
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}

}
