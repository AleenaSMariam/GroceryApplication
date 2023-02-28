package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class PushNotificationsPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public PushNotificationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']//li[7]//a[1]")
	WebElement clickPushNotifications;

	@FindBy(id = "title")
	WebElement enterTitle;

	@FindBy(id = "description")
	WebElement enterDescription;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement sendButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessageAfterSending;

	public void enterPushNotificationsPage() {
		clickPushNotifications.click();
	}

	public void typeTitleInPushNotifications(String title) {
		enterTitle.sendKeys(title);
	}

	public void typeDescriptionInPushNotifications(String des) {
		enterDescription.sendKeys(des);
	}

	public void clickSendButton() {
		sendButton.click();
	}

	public String getAlertMeassageAfterSendingPushNotifications() {
		return gu.getElementText(alertMessageAfterSending);
	}

}
