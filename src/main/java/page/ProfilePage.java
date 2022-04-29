package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ProfilePage extends BasePage {
	WebDriver driver;
	
	public ProfilePage(WebDriver driver) {
		this.driver=driver;		
	}
	//WebElements
	@FindBy(how = How.XPATH, using = "//*[@id=\"application_ajaxrender\"]/table[1]/thead/tr/th")
	WebElement NEWCUSTOMER_ACCOUNTINGSUMMARY_ELEMENT;
	
	//Intractable Methods
	public void Explicitwaitforaccountingsummaryelement(int time) {
		waitForElement(driver, time, NEWCUSTOMER_ACCOUNTINGSUMMARY_ELEMENT);
	}
	public void verifyingaddedcustomerbyaccountingsummary() {
//		String text = ACCOUNTINGSUMMARY_ELEMENT.getText();
//		System.out.println(text);
		Assert.assertEquals(NEWCUSTOMER_ACCOUNTINGSUMMARY_ELEMENT.getText(), "Accounting Summary", "wrong Page");

	}

}
