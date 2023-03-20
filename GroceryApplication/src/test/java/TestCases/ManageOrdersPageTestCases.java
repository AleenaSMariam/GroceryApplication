package TestCases;

import java.io.IOException;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageOrdersPage;
import utilities.ExcelRead;

public class ManageOrdersPageTestCases extends BaseClass {
	LoginPage lp;
	ManageOrdersPage mo;

	@Test
	public void verifyTheMoneyAmountOfTheUserAccordingToTheOrderID() throws IOException {
		lp = new LoginPage(driver);
		mo = new ManageOrdersPage(driver);
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		mo.selectManageOrdersPage();
		String actualresult = mo.getLocatorToFindValueOfAmount();
		String expectedresult = Constant.MONEY_AMOUNT;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);
	}

	@Test
	public void verifyColourOfResetButton() throws IOException {
		lp = new LoginPage(driver);
		mo = new ManageOrdersPage(driver);
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		mo.selectManageOrdersPage();
		String color = mo.colourOfResetButton(Constant.COLOUR);
		String actualresult = Color.fromString(color).asHex();
		String expectedresult = Constant.VALUE_OF_COLOR;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);
	}

	@Test
	public void verifyDropDownValueOfPaymentModeInSearchOption() throws IOException {
		lp = new LoginPage(driver);
		mo = new ManageOrdersPage(driver);
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		mo.selectManageOrdersPage();
		mo.clickSearchOption();
		String actualresult = mo.paymentModeDropDownValue(Constant.PAYMENT_VALUE);
		String expectedresult = Constant.PAYMENT_MODE;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);
	}

}
