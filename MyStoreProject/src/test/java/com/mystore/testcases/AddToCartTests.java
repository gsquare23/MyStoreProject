package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.PageObjects.AddtoCartPage;
import com.mystore.PageObjects.HomePage;
import com.mystore.PageObjects.IndexPage;
import com.mystore.PageObjects.LoginPage;
import com.mystore.PageObjects.SearchResultPage;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.utility.Log;

public class AddToCartTests extends BaseClass {
	LoginPage loginPage;
	IndexPage indexPage;
	HomePage  homePage;
	SearchResultPage searchResultPage;
	AddtoCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String br) {
		launchApp(br);
		
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Regression", "Sanity"}, dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void clickOnProduct(String prd, String qty, String size) {
		Log.startTestCase("clickOnProduct");
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(prd);
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		boolean result =addToCartPage.validateAddToCartMsg();
		Assert.assertTrue(result);
		Log.endTestCase("clickOnProduct");
	}
}
