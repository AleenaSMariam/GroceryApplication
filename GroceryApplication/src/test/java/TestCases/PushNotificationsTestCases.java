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
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		pnp.enterPushNotificationsPage();
		pnp.typeTitleInPushNotifications("ABC");
		pnp.typeDescriptionInPushNotifications("This is a sample description");
		pnp.clickSendButton();
		String actualresult = pnp.getAlertMeassageAfterSendingPushNotifications();
		String expectedresult = "×\n" + "Alert!\n" + "Message send successfully";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}
}
