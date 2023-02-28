package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManagePagesPage;
import elementRepository.PushNotificationsPage;

public class PushNotificationsTestCases extends BaseClass {

	LoginPage lp;
	PushNotificationsPage pnp;

	@Test
	public void verifyIfAlertMessagesAreShownWhenPushNotificationsAreSent() {
		lp = new LoginPage(driver);
		pnp = new PushNotificationsPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
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
