package com.mystore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass {

	
	@FindBy(xpath = "//h1[normalize-space()='Create an account']")
	WebElement createAccount;
	
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean createText() {
		return Action.isDisplayed(getDriver(), createAccount);
	}
}
