package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;
//POM Rule #1 : Seperate pages class for all pages in a package - Done
//POM Rule #2 : All pages must extend same project specific wrapper
public class LoginPage extends ProjectSpecificWrappers {
	//POM Rule #3 : Page class must have constructor where we need to verify the page landed
	public LoginPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if (!verifyTitle("Login - PHPTRAVELS")) {
			reportStep("The Page is not the LoginPage", "FAIL");
		}
	}
	//POM Rule #4 : Every action performed on the each element of the page should be created as a method in each page class
	//POM Rule #5 : Every method should return the page where it lands
	
	public LoginPage enterUserName() {
		enterByXpath("//input[@name='username']", username);
		return this;
	}
	
	public LoginPage enterPassword() {
		enterByXpath("//input[@name='password']", password);
		return this;
	}
	
	public LoginPage clickNotRobot() throws InterruptedException{
		Thread.sleep(1000);
		clickByXpath("//div[@class='g-recaptcha']");
		return this;
	}
	
	public HomePage clickLogin() throws InterruptedException {
		Thread.sleep(10000);
		clickByXpath("//button[contains(text(),'Login')]");
		return new HomePage(driver,test);
	}
}
