package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import wrappers.ProjectSpecificWrappers;
//POM Rule #1 : Seperate pages class for all pages in a package - Done
//POM Rule #2 : All pages must extend same project specific wrapper
public class HomePage extends ProjectSpecificWrappers {
	//POM Rule #3 : Page class must have constructor where we need to verify the page landed
	public HomePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if (!verifyTitle("Client Area - PHPTRAVELS")) {
			reportStep("The page is not HomePage", "FAIL");
		}
	}
	//POM Rule #4 : Every action performed on the each element of the page should be created as a method in each page class
	//POM Rule #5 : Every method should return the page where it lands
	public HomePage clickOnServiceTab() throws InterruptedException {
		Thread.sleep(1000);
		clickByXpath("(//a[@data-toggle='dropdown'])[1]");
		return this;
	}
	public ShoppingPage clickOrderNewService() throws InterruptedException {
		Thread.sleep(1000);
		clickByXpath("//a[contains(text(),'Order New Services')]");
		return new ShoppingPage(driver,test);
		
	}
}
