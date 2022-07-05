package com.mystore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

public class OrderPage  extends BaseClass{
	@FindBy(xpath = "//td[@class='cart_unit']/span/span")
	WebElement unitPrice;
	
	@FindBy(id = "total_price")
	WebElement totalPrice;
	
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOut;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice() {
		//Action.fluentWait(getDriver(), unitPrice, 10);
		String unitPrice1 = unitPrice.getText();
		String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUntprice = Double.parseDouble(unit);
		return finalUntprice/100;
	}
	
	public double getTotalPrice() {
		String totalPrice1 = totalPrice.getText();
		String total = totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice = Double.parseDouble(total);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckOut() {
		Action.click(getDriver(), proceedToCheckOut);
		return new LoginPage();
	}

}
