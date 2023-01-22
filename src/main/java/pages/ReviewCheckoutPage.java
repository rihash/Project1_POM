package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import wrappers.ProjectSpecificWrappers;
//POM Rule #1 : Seperate pages class for all pages in a package - Done
//POM Rule #2 : All pages must extend same project specific wrapper
public class ReviewCheckoutPage extends ProjectSpecificWrappers {
	//POM Rule #3 : Page class must have constructor where we need to verify the page landed
	public ReviewCheckoutPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if (!verifyTitle("Shopping Cart - PHPTRAVELS")) {
			reportStep("The Page is not ReviewAndCheckoutPage", "FAIL");
		}
	}
	//POM Rule #4 : Every action performed on the each element of the page should be created as a method in each page class
	//POM Rule #5 : Every method should return the page where it lands

	public CheckoutPage validateProductAdded() {
		getTextByXpath("//span[@class='item-title']");
		verifyTextByXpath("//span[@class='item-title']", "Mobile Applications");
		return new CheckoutPage(driver,test);
	}
}
