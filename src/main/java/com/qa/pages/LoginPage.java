package com.qa.pages;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	

	@FindBy(xpath = "//input[@name='email']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public String validateLoginPageTitle() {
		return driver.getTitle();

	}
	
	public HomePage signIn(String un, String pwd) {

		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage()  ;
 
	}

	


}