package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageSliderPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider'][normalize-space()='More info']")
	WebElement manageSliderPagesButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(id = "main_img")
	WebElement uploadImageOption;

	@FindBy(id = "link")
	WebElement enterLinkOption;
	
	@FindBy(xpath = "//button[@name='create']")
	WebElement enterSaveButton;
	

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement uploadSuccesfullMessage;

	public void enterMobileSlide() {
		manageSliderPagesButton.click();
	}

	public void selectNewButton() {
		newButton.click();
	}

	public void uploadImageOption() throws AWTException {
		gu.uploadFiles(driver, uploadImageOption, System.getProperty("user.dir")+"//src//main//resources//ManagePageImage.png");
	}

	public void enterLink(String lnk) {
		enterLinkOption.sendKeys(lnk);
	}
	public void selectSaveButton() {
		enterSaveButton.click();
	}

	public String alertSuccesfullMessage() {
		return gu.getElementText(uploadSuccesfullMessage);
	}

}
