package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInButton;

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signIn;

	@FindBy(name = "remember_me")
	WebElement checkBox;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement invalidCredentials;

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signinButton;

	@FindBy(xpath = "//a[contains(text(),'Admin')]")
	WebElement adminButton;

	public void enterUsername(String usrname) {
		username.sendKeys(usrname);
	}

	public void enterPassword(String pswd) {
		password.sendKeys(pswd);
	}

	public void clickSignIn() {
		signIn.click();
	}

	public String verifySignIn() {
		return gu.getElementText(signInButton);
	}

	public Boolean checkRememberMe() {
		return gu.isCheckboxSelected(checkBox);
	}

	public String alertMessageForInvalidUsernamAndPassword() {
		return gu.getElementText(invalidCredentials);

	}

	public String backgroundColourOfSignInButton(String value) {
		return gu.getColor(signInButton, value);
	}

	public String adminOptionInHomePage() {
		return gu.getElementText(adminButton);
	}
}
