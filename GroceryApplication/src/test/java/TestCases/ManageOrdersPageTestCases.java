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
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		mo.selectManageOrdersPage();
		String actualresult = mo.getLocatorToFindValueOfAmount();
		String expectedresult = "£ 280";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);
	}

	@Test
	public void verifyColourOfResetButton() throws IOException {
		lp = new LoginPage(driver);
		mo = new ManageOrdersPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		mo.selectManageOrdersPage();
		String color = mo.colourOfResetButton("color");
		String actualresult = Color.fromString(color).asHex();
		String expectedresult = "#1f2d3d";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);
	}

	@Test
	public void verifyDropDownValueOfPaymentModeInSearchOption() throws IOException {
		lp = new LoginPage(driver);
		mo = new ManageOrdersPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		mo.selectManageOrdersPage();
		mo.clickSearchOption();
		String actualresult = mo.paymentModeDropDownValue(2);
		String expectedresult = "Bank";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);
	}

}
