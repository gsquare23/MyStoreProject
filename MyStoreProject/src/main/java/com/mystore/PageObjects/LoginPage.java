package com.mystore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass{

	@FindBy(id= "email")
	WebElement userName;
	
	@FindBy(name= "passwd")
	WebElement password;
	
	@FindBy(id= "SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(id= "email_create")
	WebElement emailforNewAccount;
	
	@FindBy(id= "SubmitCreate")
	WebElement createNewAccountbtn;
	
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uname, String passd) {
	
		Action.type(userName, uname);
		Action.type(password, passd);
		Action.click(getDriver(), signInBtn);
		return new HomePage();
	}
	
	public AddressPage login1(String uname, String passd) {
		Action.type(userName, uname);
		Action.type(password, passd);
		Action.click(getDriver(), signInBtn);
		return new AddressPage();
	} 
	
	public AccountCreationPage createNewAccount(String newEmail) {
		Action.type(emailforNewAccount, newEmail);
		Action.click(getDriver(), createNewAccountbtn);
		return new AccountCreationPage();
	}
}
