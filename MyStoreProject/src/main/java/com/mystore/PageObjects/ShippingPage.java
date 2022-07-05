package com.mystore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {

	
	@FindBy(xpath = "//input[@id='cgv']")
	WebElement terms;
	
	@FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement prdToCheckout;
	
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void checkTheTerms() {
		Action.fluentWait(getDriver(), terms, 10);
		Action.click(getDriver(), terms);
	}
	
	public PaymentPage clickOnProceedtoCheckOut() {
		Action.click(getDriver(), prdToCheckout);
		return new PaymentPage();
	}
	
}
