package elementRepository;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;


public class ManagePagesPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManagePagesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page'][normalize-space()='More info']")
	WebElement managePagesButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(xpath = "//button[@aria-label='Style']")
	WebElement styleToolTipInDescription;

	@FindBy(id = "main_img")
	WebElement uploadImageInNewOption; 

	@FindBy(id = "title")
	WebElement enterTitle;

	@FindBy(xpath= "//div[@class='note-editable card-block']")
	WebElement enterDescription;

	@FindBy(id = "page")
	WebElement enterPage;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> delete;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/pages/delete?del=581&page_ad=1']")
	WebElement deleteButton;

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton2;

	public void enterManagePages() {
		managePagesButton.click();
	}

	public void clickNewButton() {
		newButton.click();
	}

	public void clickTitleOption(String title) {
		enterTitle.sendKeys(title);
	}

	public void clickDescriptionOption(String descp) {
		enterDescription.sendKeys(descp);
	}

	public void clickPageOption(String pg) {
		enterPage.sendKeys(pg);
	}

	public void uploadImage() throws AWTException {
		gu.uploadFiles(driver, uploadImageInNewOption, System.getenv("user.dir")+"/GroceryApplication/src/main/resources/ExcelRead/GroceryApp Credentials.xlsx"); 
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public String toolTipValueOfStyleInDescription(String attvalue) {
		return gu.getToolTipValue(styleToolTipInDescription, attvalue);
	}

	public void getLocator() {
		int index = gu.getLocatorValueFromTable(delete, "manage_sample");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (index + 1)
				+ "]//td[5]";
		driver.findElement(By.xpath(locator));
	}

	public void clickDelete() {
		deleteButton.click();
	}

	public String alertMeassgeForDelete() {
		return gu.alertMessage(driver);
	}

}
