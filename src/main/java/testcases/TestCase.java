package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.ProjectSpecificWrappers;

public class TestCase extends ProjectSpecificWrappers{
	@BeforeClass
	public void setData() {
		testCaseName="TestCase1";
		testDescription="Shopping Mobile Application";
		browserName="chrome";
		//dataSheetName="";
		category="Sanity";
		authors="Rizwan";
	}
	@Test()
	public void testCase() throws InterruptedException {
		new LoginPage(driver,test)
		.enterUserName()
		.enterPassword()
		.clickNotRobot()
		.clickLogin()
		.clickOnServiceTab()
		.clickOrderNewService()
		.clickOnMobileTab()
		.chooseMobileApp()
		.addToCartContinue()
		.validateProductAdded()
		.clickCheckout()
		.clickCompleteOrder();
		
		
		
	}
}
