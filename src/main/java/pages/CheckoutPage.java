package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import wrappers.ProjectSpecificWrappers;
//POM Rule #1 : Seperate pages class for all pages in a package - Done
//POM Rule #2 : All pages must extend same project specific wrapper
public class CheckoutPage extends ProjectSpecificWrappers{
	//POM Rule #3 : Page class must have constructor where we need to verify the page landed
	public CheckoutPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if (!verifyTitle("Shopping Cart - PHPTRAVELS")) {
			reportStep("The Page is not CheckoutPage", "FAIL");
		}
	}
//POM Rule #4 : Every action performed on the each element of the page should be created as a method in each page class
//POM Rule #5 : Every method should return the page where it lands
	public CheckoutPage clickCheckout() {
		clickByXpath("//a[contains(text(),'Checkout')]");
		return this;
	}
	public CheckoutPage clickCompleteOrder() throws InterruptedException {
		WebElement element = getElementByXpath("//button[@id='btnCompleteOrder']");
		scrollToElement(element);
		Thread.sleep(2000);
		clickByXpath("//button[@id='btnCompleteOrder']");
		Thread.sleep(2000);
		//clickById("btnCompleteOrder");
		return this;
	}
}
