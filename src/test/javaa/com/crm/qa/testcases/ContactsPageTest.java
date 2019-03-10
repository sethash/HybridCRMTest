package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.SignInPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	SignInPage signin;
	HomePage homepage;
	ContactsPage contactspage;
	String sheetName="contacts";
	
	public ContactsPageTest()
	{
		super();
	}
@BeforeMethod
public void setup3() throws InterruptedException
{
	initialisation();
	signin = new SignInPage();
	contactspage = new ContactsPage();
	homepage = new HomePage();
	homepage = signin.Login(prop.getProperty("username"), prop.getProperty("password"));
	contactspage = homepage.newContact();
	
	
}

@Test(priority=1)
public void VerifyContactsScreen()
{
	Assert.assertTrue(contactspage.ValidateContactScreen());
}

@DataProvider
public Object[][] getCrmTestData()
{
	
	Object data[][] =TestUtil.getTestData(sheetName);
	return data;
}

@Test(priority=2,dataProvider="getCrmTestData")
public void CreateContact(String titl, String fnam, String lnam) throws InterruptedException
{
	contactspage.CreateContacts(titl, fnam, lnam);
}

@AfterMethod
public void quit3()
{
	driver.quit();
}

}
