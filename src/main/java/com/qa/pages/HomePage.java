package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {
	

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contacts;

	@FindBy(linkText = "/deals")
	WebElement deals;

	@FindBy(xpath = "//span[@class='user-display']")
	WebElement userDisplay;

	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public ContactsPage goToContacts() {
		contacts.click();
		return new ContactsPage();
	}

	public DealsPage goToDeals() {
		deals.click();
		return new DealsPage();
	}

	public boolean verifyuserDisplay() {
		return userDisplay.isDisplayed();

	}
	
	public String  homePageTitle() {
		return driver.getTitle();
	}
}
