package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
//import test.*;

import util.ExcelReader;

public class ListCustomerPage extends BasePage {
	WebDriver driver;

	public ListCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a")
	WebElement LIST_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
	WebElement CUSTOMER_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"foo_filter\"]")
	WebElement ADDED_CUSTOMER_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]")
	WebElement VERIFY_ADDEDCUSTOMER_SUMMARY_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div")
	WebElement ALERT_POPUP_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[2]/button[2]")
	WebElement ALERT_POPUP_ACCEPT_ELEMENT;

	
	public void clicklistcustomermenu() {
		LIST_CUSTOMER_ELEMENT.click();
	}

	public void Explicitwaitforcontactpage(int time) {
		waitForElement(driver, time, CUSTOMER_HEADER_ELEMENT);
	}

	public void verifycustomerpage() {
		Assert.assertEquals(CUSTOMER_HEADER_ELEMENT.getText(), "Contacts", "Wrong Page!!");
	}

//	ExcelReader exlread = new ExcelReader("TestData\\TF_TestData.xlsx");
//	String fullName = exlread.getCellData("AddContactInfo", "FullName", 2);

	String before_path = "//tbody/tr[";
	String after_path = "]/td[3]";

	public void validUserCanGetAddedCustomerNameAndDeleteIt(String generatedName) {
		 
//		ListCustomerTest lt =PageFactory.initElements(driver, ListCustomerTest.class);
//		addcontactpage.insertfullname(fullName);		
//		AddContactPage addcontactpage=PageFactory.initElements(driver, AddContactPage.class);
//		String generatedName=addcontactpage.generatedName;
			
		for (int i = 1; i <= 5; i++) {
			String CUSTOMER_NAME = driver.findElement(By.xpath(before_path + i + after_path)).getText();
			System.out.println(CUSTOMER_NAME);
			System.out.println(generatedName);
			if (CUSTOMER_NAME.contains(generatedName)) {
				driver.findElement(By.xpath("//tbody/tr[" + i + " ]/td[3]/following-sibling::td[4]/a[2]")).click();
			}
		}
	}
	public void explicitWaitForAlertPage(int timeInSec) {
		waitForElement(driver,timeInSec,ALERT_POPUP_ELEMENT);
	}
	public void verifyalertpopup() {
		Assert.assertEquals(ALERT_POPUP_ELEMENT.getText(), "Are You Sure?", "Wrong Page!!");
	}

	public void clickalertpopup() throws InterruptedException {
		Thread.sleep(3000);
//		driver.switchTo().alert();
//		Actions action = new Actions(driver);
//		action.sendKeys(Keys.TAB).build().perform();
//		driver.switchTo().alert().accept();
		ALERT_POPUP_ACCEPT_ELEMENT.click();
	}
}
