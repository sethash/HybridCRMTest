package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.SignInPage;

public class SignInPageTest extends TestBase {

	SignInPage signin;
	HomePage homepage;

	public SignInPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp1() {
		initialisation();
		signin = new SignInPage();
	}

	@Test(priority = 1)
	public void ValidatePageTitle() {
		String title = signin.ValidatePageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}

	@Test(priority = 2)
	public void CrmLogo() {
		Boolean flag = signin.ValidateCrmLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void Signin() throws InterruptedException {
		homepage = signin.Login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void quit1() {
		driver.quit();
	}

}
