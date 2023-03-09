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

	@Test
	public void verifyIfTheDropDownValueOfStatusCanBeSelectedFromSearchOption() throws IOException {
		lp = new LoginPage(driver);
		mu = new ManageUsersPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		mu.enterManageUsers();
		mu.selectSearchButton();
		String actualresult = mu.selectStatusValueFromDropDown(1);
		String expectedresult = "Active";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);
	}

	@Test
	public void verifyIfAlertMessageIsShownWhenInvalidNameIsGiven() throws IOException {
		lp = new LoginPage(driver);
		mu = new ManageUsersPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		mu.enterManageUsers();
		mu.selectSearchButton();
		mu.selectNameOption("aleena123");
		mu.selectSearchAfterEnterButton();
		String actualresult = mu.alertMessageAfterInvalidNameEnter();
		String expectedresult = ".........RESULT NOT FOUND.......";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);
	}

}
