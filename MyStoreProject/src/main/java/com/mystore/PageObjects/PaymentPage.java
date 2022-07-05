package com.mystore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass{

	
	@FindBy(xpath= "//a[contains(text(),'Pay by bank wire')]")
	WebElement bankWireMethod;
	
	@FindBy(xpath= "///a[@title='Pay by check.']")
	WebElement checkMethod;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummaryPage clickOnPaymentMethod() {
		//Action.fluentWait(getDriver(), bankWireMethod, 10);
		Action.click(getDriver(), bankWireMethod);
		return new OrderSummaryPage();
	}
}
