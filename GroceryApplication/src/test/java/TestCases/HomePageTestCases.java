package TestCases;

import java.io.IOException;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class HomePageTestCases extends BaseClass {
	LoginPage lp;
	HomePage hp;;

	@Test
	public void verifyLogOutButtonInAdminOption() throws IOException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		hp.clickAdminButton();
		hp.clickLogoutButton();
		String actualresult = hp.signInPageTextAfterLogOut();
		String expectedresult = "Sign in to start your session";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}

	@Test
	public void verifyTheBackgroundColourOfNewButton() throws IOException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		hp.clickManageExpenseDropDown();
		hp.clickExpenseCategory();
		String color = hp.bordercolourOfNewButton("border-color");
		String actualresult = Color.fromString(color).asHex();
		String expectedresult = "#dc3545";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}

}
