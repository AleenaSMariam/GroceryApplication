package TestCases;

import java.io.IOException;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelRead;
import utilities.RetryUtility;

public class HomePageTestCases extends BaseClass {
	LoginPage lp;
	HomePage hp;;

	@Test(retryAnalyzer = RetryUtility.class, groups = "Smoke Testing")
	public void verifyLogOutButtonInAdminOption() throws IOException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		hp.clickAdminButton();
		hp.clickLogoutButton();
		String actualresult = hp.signInPageTextAfterLogOut();
		String expectedresult = Constant.SIGNIN_PAGE_TEXT;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);

	}

	@Test(groups = "Sanity Testing")
	public void verifyTheBackgroundColourOfNewButton() throws IOException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		hp.clickManageExpenseDropDown();
		hp.clickExpenseCategory();
		String color = hp.bordercolourOfNewButton(Constant.BORDER_COLOUR);
		String actualresult = Color.fromString(color).asHex();
		String expectedresult =Constant.COLOUR_VALUE;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);

	}

}
