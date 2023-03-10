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
	public void verifyToolTipValueOfVideoOptionInDescriptonOfNewOption() throws IOException {
		lp = new LoginPage(driver);
		mppg = new ManagePagesPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		mppg.enterManagePages();
		mppg.clickNewButton();
		String actualresult = mppg.toolTipValueOfVideoInDescription("aria-label");
		String expectedresult = "Video";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}
	
	@Test
	public void verifyTheValueOfPagesAccordingToTheTitle() throws IOException {
		lp = new LoginPage(driver);
		mppg = new ManagePagesPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		mppg.enterManagePages();
		String actualresult = mppg.getLocatorToFindValueOfPage();
		String expectedresult = "Page New";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}
}
