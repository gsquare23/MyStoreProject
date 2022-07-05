package com.mystore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

public class OrderSummaryPage extends BaseClass {

	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	WebElement confirmOrderBtn;
	
	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmationPage clickOnconfirmOrderBtn() {
		//Action.fluentWait(getDriver(), confirmOrderBtn, 10);
		Action.click(getDriver(), confirmOrderBtn);
		return new OrderConfirmationPage();
	}
}
