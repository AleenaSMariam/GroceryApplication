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

	@Test(groups = "Smoke Testing")
	public void verifyDropDownValueOfWeightUnitInTheNewOption() throws IOException {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUsername(
				ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(
				ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		mpp.enterManageProductPage();
		mpp.clickNew();
		String actualresult = mpp.dropdownValueOfType(Constant.WEIGHT_VALUE);
		String expectedresult = Constant.WEIGHT_TYPE;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);

	}

	@Test(groups = "Regression Testing")
	public void verifyRadioButtonInProductTypeInTheNewOption() throws IOException {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUsername(
				ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(
				ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		mpp.enterManageProductPage();
		mpp.clickNew();
		mpp.clickProductTypeRadioButton();
		boolean actualresult = mpp.productTypeRadioButtonValue();
		boolean expectedresult = true;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);

	}

	@Test(groups = "Smoke Testing")
	public void verifyRadioButtonInPriceTypeInTheNewOption() throws IOException {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUsername(
				ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(
				ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		mpp.enterManageProductPage();
		mpp.clickNew();
		mpp.clickPriceTypeRadioButton();
		boolean actualresult = mpp.priceTypeRadioButtonValue();
		boolean expectedresult = true;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);

	}

	@Test(groups = "Smoke Testing")
	public void verifyifunlimitedStockCheckBoxIsSelectedInNewOption() throws IOException {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUsername(
				ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(
				ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		mpp.enterManageProductPage();
		mpp.clickNew();
		Boolean actualresult = mpp.ifunlimitedStockCheckBoxIsSelected();
		Boolean expectedresult = true;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);

	}

	@Test(groups = "Sanity Testing")
	public void verifyDropdownValueOfGroupInNewOption() throws IOException {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUsername(
				ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(
				ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		mpp.enterManageProductPage();
		mpp.clickNew();
		String actualresult = mpp.dropdownvalueofGroup(Constant.GROUP_VALUE);
		String expectedresult = Constant.DROPDOWN_VALUE_GROUP;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);
	}

	@Test(groups = "Regression Testing")
	public void verifyIfAlertMessageIsShownAfterEnteringInvalidProductCodeIsSearched() throws IOException {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.enterUsername(
				ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(
				ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		mpp.enterManageProductPage();
		mpp.clickSearchButton();
		mpp.enterProductCode(Constant.PAGE_CODE);
		mpp.clickSearchCodeButton();
		String actualresult = mpp.alertMessageAfterInvalidProductCodeIsEntered();
		String expectedresult = Constant.ALERTMESSAGEFORINVALID;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);

	}
}
