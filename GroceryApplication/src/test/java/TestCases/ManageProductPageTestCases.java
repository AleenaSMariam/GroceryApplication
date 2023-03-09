package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageProductPage;
import elementRepository.PushNotificationsPage;
import utilities.ExcelRead;

public class ManageProductPageTestCases extends BaseClass {
	LoginPage lp;
	ManageProductPage mpp;

	@Test
	public void verifyDropDownValueOfWeightUnitInTheNewOption() throws IOException {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		mpp.enterManageProductPage();
		mpp.clickNew();
		String actualresult = mpp.dropdownValueOfType(1);
		String expectedresult = "g";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}

	@Test
	public void verifyRadioButtonInProductTypeInTheNewOption() throws IOException {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		mpp.enterManageProductPage();
		mpp.clickNew();
		mpp.clickProductTypeRadioButton();
		boolean actualresult = mpp.productTypeRadioButtonValue();
		boolean expectedresult = true;
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}

	@Test
	public void verifyRadioButtonInPriceTypeInTheNewOption() throws IOException {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		mpp.enterManageProductPage();
		mpp.clickNew();
		mpp.clickPriceTypeRadioButton();
		boolean actualresult = mpp.priceTypeRadioButtonValue();
		boolean expectedresult = true;
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}

	@Test
	public void verifyifunlimitedStockCheckBoxIsSelectedInNewOption() throws IOException {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		mpp.enterManageProductPage();
		mpp.clickNew();
		Boolean actualresult = mpp.ifunlimitedStockCheckBoxIsSelected();
		Boolean expectedresult = true;
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}

	@Test
	public void verifyDropdownValueOfGroupInNewOption() throws IOException {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		mpp.enterManageProductPage();
		mpp.clickNew();
		String actualresult = mpp.dropdownvalueofGroup(1);
		String expectedresult = "discount";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);
	}

	@Test
	public void verifyIfAlertMessageIsShownAfterEnteringInvalidProductCodeIsSearched() throws IOException {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		mpp.enterManageProductPage();
		mpp.clickSearchButton();
		mpp.enterProductCode("1");
		mpp.clickSearchCodeButton();
		String actualresult = mpp.alertMessageAfterInvalidProductCodeIsEntered();
		String expectedresult = ".........RESULT NOT FOUND.......";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}
}
