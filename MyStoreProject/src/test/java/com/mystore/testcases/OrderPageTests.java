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
import com.mystore.PageObjects.OrderPage;
import com.mystore.PageObjects.SearchResultPage;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.utility.Log;

public class OrderPageTests extends BaseClass{
	LoginPage loginPage;
	IndexPage indexPage;
	HomePage  homePage;
	SearchResultPage searchResultPage;
	AddtoCartPage addToCartPage;
	OrderPage orderPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String br) {
		launchApp(br);
		
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void teardown() {
		getDriver().quit();
	} 
	
	@Test(groups = "Regression", dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void verifyTotalPrice(String prd, String qty, String size) {
		Log.startTestCase("verifyTotalPrice");
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(prd);
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnProeedTocheckOut();
		Double unitPrice= orderPage.getUnitPrice();
		Double totalPrice = orderPage.getTotalPrice();
		Double totalExpectedPrice = (unitPrice*2)+2;
		Assert.assertEquals(totalPrice,totalExpectedPrice);
		Log.endTestCase("verifyTotalPrice");
		
	}
}
