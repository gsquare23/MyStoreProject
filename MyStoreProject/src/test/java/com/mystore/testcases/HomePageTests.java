package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.PageObjects.HomePage;
import com.mystore.PageObjects.IndexPage;
import com.mystore.PageObjects.LoginPage;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.utility.Log;

public class HomePageTests extends BaseClass{
	LoginPage loginPage;
	IndexPage indexPage;
	HomePage  homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String br) {
		launchApp(br);
		
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke", dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void wishListTests(String uname, String pswd) {
		Log.startTestCase("wishListTests");
		indexPage = new IndexPage();
		
		loginPage = indexPage.signIn();
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(uname, pswd);
		boolean result = homePage.validateMywishList();
		Assert.assertTrue(result);
		Log.endTestCase("wishListTests");
	}
	
	@Test(groups = "Smoke", dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void orderHistoryTests(String uname, String pswd) {
		Log.startTestCase("orderHistoryTests");
		indexPage = new IndexPage();
		
		loginPage = indexPage.signIn();
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(uname, pswd);
		boolean result1= homePage.validateOrderHistory();
		Assert.assertTrue(result1);
		Log.endTestCase("orderHistoryTests");
	}
}
