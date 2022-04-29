package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashBoardPage;
import page.ListCustomerPage;
import page.LoginPage;
import page.ProfilePage;
import util.BrowserFactory;
import util.ExcelReader;

public class ListCustomerTest {
	 WebDriver driver;
	 

	@Test
	public void ValidUserShouldAbleToAddContact() throws InterruptedException {
		BrowserFactory bf = PageFactory.initElements(driver, BrowserFactory.class);
		driver = bf.init();

		ExcelReader excelreader = new ExcelReader("TestData\\TF_TestData.xlsx");
		String UserName = excelreader.getCellData("LoginInfo", "UserName", 2);
		String Password = excelreader.getCellData("LoginInfo", "Password", 2);
		String FullName = excelreader.getCellData("AddContactInfo", "FullName", 2);
		String CompanyName = excelreader.getCellData("AddContactInfo", "CompanyName", 2);
		String Email = excelreader.getCellData("AddContactInfo", "Email", 2);
		String Phone = excelreader.getCellData("AddContactInfo", "Phone", 2);
		String Address = excelreader.getCellData("AddContactInfo", "Address", 2);
		String City = excelreader.getCellData("AddContactInfo", "City", 2);
		String State = excelreader.getCellData("AddContactInfo", "State", 2);
		String Zip = excelreader.getCellData("AddContactInfo", "Zip", 2);
		String Country = excelreader.getCellData("AddContactInfo", "Country", 2);
		
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertusername(UserName);
		loginpage.insertpassword(Password);
		loginpage.clicksigninbutton();

		DashBoardPage dashboard = PageFactory.initElements(driver, DashBoardPage.class);
		dashboard.verifydashboardpage();
		dashboard.clickcustomermenu();
		dashboard.clickaddcustomer();

		AddContactPage addcontactpage = PageFactory.initElements(driver, AddContactPage.class);
		addcontactpage.Explicitwaitforaddcontactpage(10);
		addcontactpage.verifyaddcontactpage();
		String generatedName1 = addcontactpage.insertfullname(FullName);
		addcontactpage.selectcompanydropdown(CompanyName);
		addcontactpage.insertemail(Email);
		addcontactpage.insertphonenumber(Phone);
		addcontactpage.insertaddress(Address);
		addcontactpage.insertcity(City);
		addcontactpage.insertstate(State);
		addcontactpage.insertzip(Zip);
		addcontactpage.selectcountrydropdown(Country);
		addcontactpage.selectcurrencydropdown("USD");
		addcontactpage.insertpassword("123456");
		addcontactpage.inserconfirmtpassword("123456");
		addcontactpage.clicksubmit();

		ProfilePage profilepage = PageFactory.initElements(driver, ProfilePage.class);	
		profilepage.Explicitwaitforaccountingsummaryelement(10);
		profilepage.verifyingaddedcustomerbyaccountingsummary();
		
		ListCustomerPage listcustomerpage = PageFactory.initElements(driver, ListCustomerPage.class);
		listcustomerpage.clicklistcustomermenu();
		listcustomerpage.Explicitwaitforcontactpage(10);
		listcustomerpage.verifycustomerpage();
		listcustomerpage.validUserCanGetAddedCustomerNameAndDeleteIt(generatedName1);
		listcustomerpage.explicitWaitForAlertPage(10);
		listcustomerpage.verifyalertpopup();
		listcustomerpage.clickalertpopup();
	}

}
