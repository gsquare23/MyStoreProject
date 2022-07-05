package com.mystore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass{

	
	@FindBy(xpath ="//img[@title='Faded Short Sleeve T-shirts']")
	WebElement prodcutResult;
	
	/*
	 * @FindBy(xpath ="//button[@name='submit_search']") WebElement clickProduct;
	 */
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() {
		return Action.isDisplayed(getDriver(), prodcutResult);
	}
	
	public AddtoCartPage clickOnProduct() {
		//Action.implicitWait(getDriver(), 5);
		Action.click(getDriver(), prodcutResult);
		//Action.pageLoadTimeOut(getDriver(), (Integer.parseInt(prop.getProperty("pageLoadTimeout"))));
		return new AddtoCartPage();
	}
	
}
