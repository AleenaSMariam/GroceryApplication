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

	@Test(groups = "Regression Testing" )
	public void verifyDropdownValueOfUserTypeInSearch() throws IOException {
		lp = new LoginPage(driver);
		aup = new AdminUsersPage(driver);
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		aup.selectAdminUsers();
		aup.clickSearchButton();
		String actualresult = aup.dropdownValueOfType(Constant.USERTYPEVALUE);
		String expectedresult = Constant.USERTYPESELECTED;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);
	}

	@Test(groups = "Smoke Testing")
	public void verifyIfAlertMessageIsShownWhenInvalidTitleIsGiven() throws IOException {
		lp = new LoginPage(driver);
		aup = new AdminUsersPage(driver);
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		aup.selectAdminUsers();
		aup.clickSearchButton();
		aup.adminUserName(Constant.INVALIDUSERNAME);
		aup.clickSearchUsername();
		String expectedresult = aup.verifyAlertMessage();
		String actualresult = Constant.ALERTMESSAGEFORINVALID;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);

	}

	@Test(groups = "Regression Testing" )
	public void verifyIfAlertMessageIsShownWhenNewUserIsCreated() throws IOException { 
		lp = new LoginPage(driver);
		aup = new AdminUsersPage(driver);
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		aup.selectAdminUsers();
		aup.clickNew();
		aup.enterNewUsername(Constant.SAMPLE_USERNAME);
		aup.enterNewPassword(Constant.SAMPLE_PASSWORD);
		aup.selectNewType(Constant.USERTYPEVALUE);
		aup.clickCreateButton();
		String expectedresult = aup.newUserCreatedMessageShown();
		String actualresult = Constant.ALERTMESSAGEFORCREATINGUSER;
		System.out.println(expectedresult);
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);
	}

}
