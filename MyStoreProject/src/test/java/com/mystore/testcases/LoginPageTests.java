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

public class LoginPageTests extends BaseClass {
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
	
	@Test(groups = {"Sanity","Smoke"}, dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginTests(String uname, String pswd) {
		Log.startTestCase("loginTests");
		indexPage = new IndexPage();
		Log.info("user is going to click on SignIn");
		loginPage = indexPage.signIn();
		Log.info("User is going to enter username and password");
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(uname, pswd);
		String actualUrl = homePage.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
		Log.info("User is trying to verifying is able to login or not");
		Assert.assertEquals(actualUrl, expectedUrl);
		Log.info("User is able to login Successfully");
		Log.endTestCase("loginTests");		
	}
}
