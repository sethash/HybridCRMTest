package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.SignInPage;

public class HomePageTest extends TestBase {
	HomePage homepage;
	ContactsPage contactpage;
	SignInPage signin;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp2() throws InterruptedException {
		initialisation();
		contactpage = new ContactsPage();
		signin = new SignInPage();
		homepage = signin.Login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void ValiadteUser() {
		Boolean flag = homepage.ValidateUsername();
		Assert.assertTrue(flag);
	}

	@Test
	public void newContactLink() {
		contactpage = homepage.newContact();
	}

	@AfterMethod
	public void Quit2() {
		driver.quit();

	}

}
