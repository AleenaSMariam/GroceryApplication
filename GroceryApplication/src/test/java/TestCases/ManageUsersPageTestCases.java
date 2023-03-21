package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageUsersPage;
import utilities.ExcelRead;

public class ManageUsersPageTestCases extends BaseClass {
	LoginPage lp;
	ManageUsersPage mu;

	@Test(groups = "Regression Testing")
	public void verifyIfTheDropDownValueOfStatusCanBeSelectedFromSearchOption() throws IOException {
		lp = new LoginPage(driver);
		mu = new ManageUsersPage(driver);
		lp.enterUsername(
				ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(
				ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		mu.enterManageUsers();
		mu.selectSearchButton();
		String actualresult = mu.selectStatusValueFromDropDown(Constant.STATUS_VALUE);
		String expectedresult = Constant.STATUS_OF_USER;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);
	}

	@Test(groups = "Smoke Testing")
	public void verifyIfAlertMessageIsShownWhenInvalidNameIsGiven() throws IOException {
		lp = new LoginPage(driver);
		mu = new ManageUsersPage(driver);
		lp.enterUsername(
				ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(
				ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		mu.enterManageUsers();
		mu.selectSearchButton();
		mu.selectNameOption(Constant.SAMPLE_USERNAME);
		mu.selectSearchAfterEnterButton();
		String actualresult = mu.alertMessageAfterInvalidNameEnter();
		String expectedresult = Constant.ALERTMESSAGEFORINVALID;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);
	}

}
