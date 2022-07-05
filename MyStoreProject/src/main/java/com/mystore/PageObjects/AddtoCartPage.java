package com.mystore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

public class AddtoCartPage extends BaseClass{
	
	@FindBy(id ="quantity_wanted")
	WebElement quantity;
	
	@FindBy(id="group_1")
	WebElement size;
	
	@FindBy(xpath = "//span[normalize-space()='Add to cart']" )
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
	WebElement addToCartMessage;
	
	@FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
	WebElement proceedToCheckOutBtn;
	
	public AddtoCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String quantity1) {
		Action.type(quantity, quantity1);
	}
	
	public void selectSize(String size1) {
		Action.selectByVisibleText(size1,size);
	}
	
	public void clickOnAddToCart() {
		Action.click(getDriver(), addToCartBtn);
		
	}
	
	public boolean validateAddToCartMsg() {
		Action.fluentWait(getDriver(), addToCartMessage, 10);
		return Action.isDisplayed(getDriver(), addToCartMessage);
	}
	
	public OrderPage clickOnProeedTocheckOut() {
		Action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
		Action.JSClick(getDriver(), proceedToCheckOutBtn);
		
		return new OrderPage();
	}
}
