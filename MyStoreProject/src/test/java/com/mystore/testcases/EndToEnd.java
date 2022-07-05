package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.PageObjects.AddressPage;
import com.mystore.PageObjects.AddtoCartPage;
import com.mystore.PageObjects.HomePage;
import com.mystore.PageObjects.IndexPage;
import com.mystore.PageObjects.LoginPage;
import com.mystore.PageObjects.OrderConfirmationPage;
import com.mystore.PageObjects.OrderPage;
import com.mystore.PageObjects.OrderSummaryPage;
import com.mystore.PageObjects.PaymentPage;
import com.mystore.PageObjects.SearchResultPage;
import com.mystore.PageObjects.ShippingPage;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.utility.Log;

public class EndToEnd extends BaseClass {
	LoginPage loginPage;
	IndexPage indexPage;
	HomePage  homePage;
	SearchResultPage searchResultPage;
	AddtoCartPage addToCartPage;
	OrderPage orderPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String br) {
		launchApp(br);
		
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void teardown() {
		getDriver().quit();
	}
	@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	
	public void endToEndTest(String prd, String qty, String size) {
		Log.startTestCase("endToEndTest");
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(prd);
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnProeedTocheckOut();
		
		loginPage = orderPage.clickOnCheckOut();
		addressPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage = addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage= shippingPage.clickOnProceedtoCheckOut();
		orderSummaryPage =paymentPage.clickOnPaymentMethod();
		orderConfirmationPage = orderSummaryPage.clickOnconfirmOrderBtn();
		String actualMsg = orderConfirmationPage.validateConfirmMessage();
		String expectedMsg = "Your order on My Store is complete.";
		Assert.assertEquals(actualMsg, expectedMsg);
		Log.endTestCase("endToEndTest");
	}
}
