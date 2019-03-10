package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//td[contains(text(),'User: ashish sethi')]")
	WebElement user;
	
	@FindBy(xpath = "//*[@title= 'Contacts']")
	WebElement contacts;
	
	@FindBy(xpath = "//*[@title= 'New Contact']")
	WebElement newcontact;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean ValidateUsername()
	{
		TestUtil.SwitchToFrame();
		return user.isDisplayed();
		
		
	}
	
	public ContactsPage newContact()
	{
		TestUtil.SwitchToFrame();
		Actions action = new Actions(driver);
		action.moveToElement(contacts).build().perform();
		newcontact.click();
		return new ContactsPage();
		
		
	}
	

}
