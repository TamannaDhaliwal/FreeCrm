package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.TestUtils;

public class ContactPageTest extends TestBase{
	LoginPage login;
	HomePage homePage;
	 ContactsPage contact	;
	 String sheetName = "Sheet1";
	 
	public ContactPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp() {
		TestBase.intialization();
		 login = new LoginPage();
		homePage = login.signIn(prop.getProperty("email"), prop.getProperty("password"));
		contact = homePage.goToContacts()	;
	}
	
	
	@Test
	public void  clickCreate() {
		// ContactsPage contact = new  ContactsPage()	;
		contact.clickCreate();
	}
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data [] [] = TestUtils.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider ="getCRMTestData")
	public void contactDetails(String firstname, String lastname) {
		contact.clickCreate();
		contact.contactDetails(firstname, lastname);
	}
	
	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}
}
