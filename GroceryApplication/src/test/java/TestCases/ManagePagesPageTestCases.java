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
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		mppg.enterManagePages();
		mppg.clickNewButton();
		String actualresult = mppg.toolTipValueOfStyleInDescription(Constant.ATTRIBUTE_VALUE);
		String expectedresult = Constant.TOOLTIP_VALUE1;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);

	}

	@Test
	public void verifyToolTipValueOfVideoOptionInDescriptonOfNewOption() throws IOException {
		lp = new LoginPage(driver);
		mppg = new ManagePagesPage(driver);
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		mppg.enterManagePages();
		mppg.clickNewButton();
		String actualresult = mppg.toolTipValueOfVideoInDescription(Constant.ATTRIBUTE_VALUE);
		String expectedresult = Constant.TOOLTIP_VALUE2;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);

	}
	
	@Test
	public void verifyTheValueOfPagesAccordingToTheTitle() throws IOException {
		lp = new LoginPage(driver);
		mppg = new ManagePagesPage(driver);
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		mppg.enterManagePages();
		String actualresult = mppg.getLocatorToFindValueOfPage();
		String expectedresult = Constant.VALUE_OF_PAGE;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);

	}
}
