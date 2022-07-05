package com.mystore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath = "//span[normalize-space()='My wishlists']")
	WebElement myWishlist;

	@FindBy(xpath = "//span[normalize-space()='Order history and details']")
	WebElement orderHistory; 
	
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateMywishList() {
		return Action.isDisplayed(getDriver(), myWishlist);
	}
	
	public boolean validateOrderHistory() {
		return Action.isDisplayed(getDriver(), orderHistory);
		
	}
	
	public String getCurrentUrl() {
		String homePageUrl = getDriver().getCurrentUrl();
		return homePageUrl;
	}
}
