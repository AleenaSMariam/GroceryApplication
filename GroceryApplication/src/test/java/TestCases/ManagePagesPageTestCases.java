package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManagePagesPage;
import utilities.ExcelRead;

public class ManagePagesPageTestCases extends BaseClass {
	LoginPage lp;
	ManagePagesPage mppg;

	@Test
	public void verifyToolTipValueOfStyleOptionInDescriptonOfNewOption() throws IOException {
		lp = new LoginPage(driver);
		mppg = new ManagePagesPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		mppg.enterManagePages();
		mppg.clickNewButton();
		String actualresult = mppg.toolTipValueOfStyleInDescription("aria-label");
		String expectedresult = "Style";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}

	@Test
	public void verifyIfAlertMMessageIsShownWhenDeleteMessageIsClicked() throws IOException {
		lp = new LoginPage(driver);
		mppg = new ManagePagesPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		mppg.enterManagePages();
		mppg.getLocator();
		mppg.clickDelete();
		String actualresult = mppg.alertMeassgeForDelete();
		String expectedresult = "Do you want to delete this Page?";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}
}
