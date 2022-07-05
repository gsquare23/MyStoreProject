package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.PageObjects.HomePage;
import com.mystore.PageObjects.IndexPage;
import com.mystore.PageObjects.LoginPage;
import com.mystore.PageObjects.SearchResultPage;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.utility.Log;

public class SearchResultTests extends BaseClass{
	LoginPage loginPage;
	IndexPage indexPage;
	HomePage  homePage;
	SearchResultPage searchResultPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String br) {
		launchApp(br);
		
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke", dataProvider = "searchProduct", dataProviderClass= DataProviders.class)
	public void validateProductAvaility(String productname) {
		Log.startTestCase("validateProductAvaility");
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(productname);
		boolean result = searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		Log.endTestCase("validateProductAvaility");
	}
	
	 
	
}
