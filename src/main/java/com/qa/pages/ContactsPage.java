package com.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase{


	@FindBy(xpath = "//button[contains(text(),'Create')]")
//	@CacheLookup speedof scriipts increases as it interacts with the cache memory and not from the page.
	WebElement create;

	@FindBy(name = "first_name")
	WebElement firstName;
	
	@FindBy(xpath = "last_name")
	WebElement lastName;

	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement save;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void  clickCreate() {
		create.click();
	}
	
	public void contactDetails(String fn, String ln) {
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		save.click();
	
	}
}
