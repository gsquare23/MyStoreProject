package com.mystore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {

	
	@FindBy(xpath= "//p/strong[contains(text(),'Your order on My Store is complete.')]")
	WebElement confirmMessage;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateConfirmMessage() {
	String confirmTxt =	confirmMessage.getText();
	return confirmTxt;
	}
}
