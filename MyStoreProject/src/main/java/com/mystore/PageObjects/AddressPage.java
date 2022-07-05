package com.mystore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass{

	@FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckout;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage clickOnCheckOut() {
		Action.click(getDriver(), proceedToCheckout);
		return new ShippingPage();
	}
}
