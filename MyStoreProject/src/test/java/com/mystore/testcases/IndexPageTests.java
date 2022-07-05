package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.PageObjects.IndexPage;
import com.mystore.base.BaseClass;
import com.mystore.utility.Log;

public class IndexPageTests extends BaseClass{

	IndexPage indexpage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String br) {
		launchApp(br);
		
	}
	
	@Test(groups= "Smoke")
	public void VerifyLogo() {
		Log.startTestCase("VerifyLogo");
		indexpage = new IndexPage();
		boolean result = indexpage.validateLogo();
		
		Assert.assertTrue(result);
		Log.endTestCase("VerifyLogo");
	}
	
	@Test(groups= "Smoke")
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		String title = indexpage.myStoreTitile();
		Assert.assertEquals(title, "My Store");
		Log.endTestCase("verifyTitle");
		
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void teardown() {
		getDriver().quit();
	}
}
