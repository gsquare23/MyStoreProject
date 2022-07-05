package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.PageObjects.AccountCreationPage;
import com.mystore.PageObjects.IndexPage;
import com.mystore.PageObjects.LoginPage;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.utility.Log;

public class AccountCreationTests extends BaseClass{
	LoginPage loginPage;
	IndexPage indexPage;
	AccountCreationPage  accountPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String br) {
		launchApp(br);
		
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(groups = "Sanity", dataProvider = "email", dataProviderClass = DataProviders.class)
	public void validateCreateText(String email) {
		Log.startTestCase("validateCreateText");
		
		indexPage= new IndexPage();
		
		loginPage = indexPage.signIn();
		accountPage = loginPage.createNewAccount(email);
		boolean result = accountPage.createText();
		Assert.assertTrue(result);
		Log.endTestCase("validateCreateText");
	}
}
