package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginTest extends TestBase {

	LoginPage login;
	HomePage homePage;

	public LoginTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		TestBase.intialization();
	 login = new LoginPage();
	}

	@Test
	public void validateTitle() {
		//LoginPage login = new LoginPage();
		String title = login.validateLoginPageTitle();
		AssertJUnit.assertEquals("Cogmento CRM", title);
	}

	@Test
	public void signIn() {
		//LoginPage login = new LoginPage();
		homePage = login.signIn(prop.getProperty("email"), prop.getProperty("password"));
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
