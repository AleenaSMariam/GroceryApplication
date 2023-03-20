package TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;
import elementRepository.LoginPage;
import elementRepository.PushNotificationsPage;
import utilities.ExcelRead;

public class PushNotificationsTestCases extends BaseClass {

	LoginPage lp;
	PushNotificationsPage pnp;

	@Test
	public void verifyIfAlertMessagesAreShownWhenPushNotificationsAreSent() throws IOException {
		lp = new LoginPage(driver);
		pnp = new PushNotificationsPage(driver);
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		pnp.enterPushNotificationsPage();
		pnp.typeTitleInPushNotifications(Constant.PUSH_NOTIFICATION_TITLE);
		pnp.typeDescriptionInPushNotifications(Constant.PUSH_NOTIFICATION_DESCRIPTION);
		pnp.clickSendButton();
		String actualresult = pnp.getAlertMeassageAfterSendingPushNotifications();
		String expectedresult = Constant.ALERT_MESSAGE_FOR_PUSH_NOTIFICATION;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);

	}
}
