package com.mystore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{

	
	@FindBy(xpath = "//a[normalize-space()='Sign in']")
	WebElement signInBtn;
	
	@FindBy(xpath = "//img[@alt='My Store']")
	WebElement myStoreLogo;
	
	@FindBy(id = "search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name = "submit_search")
	WebElement searchButton;
	
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage signIn() {
		Action.fluentWait(getDriver(), signInBtn, 10);
		Action.click(getDriver(),signInBtn );
		return new LoginPage();
		
	}
	public boolean validateLogo() {
		return Action.isDisplayed(getDriver(),myStoreLogo);
	}
	
	public String myStoreTitile() {
		String myStoreTitle = getDriver().getTitle();
		return  myStoreTitle;
	}
	
	public SearchResultPage  searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		
		Action.click(getDriver(), searchButton);
		//Action.implicitWait(getDriver(), 10);
		return new SearchResultPage();
		
	}

}
