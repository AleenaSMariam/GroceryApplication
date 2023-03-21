package TestCases;

import org.testng.annotations.Test;

import Constant.Constant;
import elementRepository.LoginPage;
import utilities.DataProviderUtility;
import utilities.ExcelRead;
import utilities.GeneralUtilities;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTestCases extends BaseClass {

	LoginPage lp;

	@Test(groups = "Smoke Testing")
	public void verifyTextOfTheSignInButton() {
		lp = new LoginPage(driver);
		String actualresult = lp.verifySignIn();
		String expectedresult = Constant.SIGNIN_BUTTON_TEXT;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);
	}

	@Test(groups = "Smoke Testing")
	public void verifyIfRememberMeCheckboxIsSelected() {
		lp = new LoginPage(driver);
		Boolean actualresult = lp.checkRememberMe();
		Boolean expectedresult = false;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);
	}

	@Test(dataProvider = "dataProvider", dataProviderClass = DataProviderUtility.class, groups = "Regression Testing")
	public void verifySignInWithInvalidCredentials(String user, String pwd) throws IOException {
		testBasic();
		lp = new LoginPage(driver);
		lp.enterUsername(user);
		lp.enterPassword(pwd);
		lp.clickSignIn();
		String actualresult = lp.alertMessageForInvalidUsernamAndPassword();
		String expectedresult = Constant.ALERT_MESSAGE_INVALID_CREDENTIALS;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);
	}

	@Test(groups = "Smoke Testing")
	public void verifyBackgroundColourOfSignInButton() {
		lp = new LoginPage(driver);
		String color = lp.backgroundColourOfSignInButton(Constant.BACKGROUND_COLOUR);
		String actualresult = Color.fromString(color).asHex();
		String expectedresult = Constant.BACKGROUND_COLOUR_VALUE;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);
	}

	@Test(groups = "Sanity Testing")
	public void verifyValidCredentials() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUsername(
				ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(
				ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		String actualresult = lp.adminOptionInHomePage();
		String expectedresult = Constant.HOMEPAGE_TEXT;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);

	}

}
