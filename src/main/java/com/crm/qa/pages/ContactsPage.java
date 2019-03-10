package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
@FindBy(xpath ="//*[text()='Contact Information']")
WebElement ContactScreen;

@FindBy(xpath = "//*[@name='title']")
WebElement title;

@FindBy(xpath = "//*[@name='first_name']")
WebElement fname;

@FindBy(xpath = "//*[@name='surname']")
WebElement lname;

@FindBy(xpath = "//*[@id='contactForm']//*[@type='submit' and @value='Save']")
WebElement save;

public ContactsPage()
{
	PageFactory.initElements(driver, this);
}
public boolean ValidateContactScreen()
{
	return ContactScreen.isDisplayed();
}

public void CreateContacts(String Title,String Fname, String Lname) throws InterruptedException
{
	Select select = new Select(title);
	select.selectByVisibleText(Title);
    Thread.sleep(5000);
	fname.sendKeys(Fname);
	lname.sendKeys(Lname);
	save.click();
	
}




}
