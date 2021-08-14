package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage login;
	HomePage homePage;

	public HomePageTest() {
		super();
	}
	@BeforeMethod
	
	public void setUp() {
		TestBase.intialization();
		 login = new LoginPage();
		homePage = login.signIn(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void verifyuserDisplay() {
	//	HomePage homePage = new HomePage();

		AssertJUnit.assertTrue(homePage.verifyuserDisplay());
	}

	@Test
	public void verifytitle() {
		//HomePage homePage = new HomePage();
		String title = homePage.homePageTitle();
		AssertJUnit.assertEquals("Cogmento CRM", title);

	}

	@Test
	public void contactClick() {
	//	HomePage homePage = new HomePage();
		homePage.goToContacts();
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}
}
