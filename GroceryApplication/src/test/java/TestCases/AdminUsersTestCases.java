package TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;
import bsh.org.objectweb.asm.Constants;
import elementRepository.AdminUsersPage;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class AdminUsersTestCases extends BaseClass {
	LoginPage lp;
	AdminUsersPage aup;

	@Test(groups = { "Critical" })
	public void verifyDropdownValueOfUserTypeInSearch() throws IOException {
		lp = new LoginPage(driver);
		aup = new AdminUsersPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		aup.selectAdminUsers();
		aup.clickSearchButton();
		String actualresult = aup.dropdownValueOfType(1);
		String expectedresult = "Staff";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);
	}

	@Test
	public void verifyIfAlertMessageIsShownWhenInvalidTitleIsGiven() throws IOException {
		lp = new LoginPage(driver);
		aup = new AdminUsersPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		aup.selectAdminUsers();
		aup.clickSearchButton();
		aup.adminUserName("qwertyu");
		aup.clickSearchUsername();
		String expectedresult = aup.verifyAlertMessage();
		String actualresult = ".........RESULT NOT FOUND.......";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}

	@Test(groups = { "High" })
	public void verifyIfAlertMessageIsShownWhenNewUserIsCreated() throws IOException {
		lp = new LoginPage(driver);
		aup = new AdminUsersPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		aup.selectAdminUsers();
		aup.clickNew();
		aup.enterNewUsername("admin_01_02_03");
		aup.enterNewPassword("abc");
		aup.selectNewType(1);
		aup.clickCreateButton();
		String expectedresult = aup.newUserCreatedMessageShown();
		String actualresult = "×\n" + "Alert!\n" + "User Created Successfully";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);
	}

}
