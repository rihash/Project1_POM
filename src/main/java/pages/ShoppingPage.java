package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import wrappers.ProjectSpecificWrappers;
//POM Rule #1 : Seperate pages class for all pages in a package - Done
//POM Rule #2 : All pages must extend same project specific wrapper
public class ShoppingPage extends ProjectSpecificWrappers{
	//POM Rule #3 : Page class must have constructor where we need to verify the page landed
	public ShoppingPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if (!verifyTitle("Shopping Cart - PHPTRAVELS")) {
			reportStep("The PAge is not ShoppingPage", "FAIL");
		}
	}
	//POM Rule #4 : Every action performed on the each element of the page should be created as a method in each page class
	//POM Rule #5 : Every method should return the page where it lands
	//public ShoppingPage clickOrderNewService() {
	//	clickByXpath("//a[contains(text(),'Order New Services')]");
	//	return this;
	//}
	
	public ShoppingPage clickOnMobileTab() {
		clickByXpath("//a[contains(text(),'Mobile')]");
		return this;
	}
	public ConfigurePage chooseMobileApp() {
		clickByXpath("//a[@id='product1-order-button']");
		return new ConfigurePage(driver,test);
	}
}
