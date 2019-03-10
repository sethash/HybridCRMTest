package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class SignInPage extends TestBase{
  @FindBy(xpath = "//*[@name = 'username']")
  WebElement username;
  
  @FindBy(xpath = "//*[@name = 'password']")
  WebElement password;
  
  @FindBy(xpath = "//*[@type= 'submit']")
  WebElement login_btn;

  @FindBy(xpath = "//*[@alt= 'free crm logo']")
  WebElement logo;
  
  public SignInPage()
  {
	  PageFactory.initElements(driver, this);
  }
  
  public String ValidatePageTitle()
  {
	  return driver.getTitle();
  }
  
  public boolean ValidateCrmLogo()
  {
	  return logo.isDisplayed();
  }
  
  public HomePage Login(String un, String pas) throws InterruptedException
  {
	  
	  username.sendKeys(un);
	  password.sendKeys(pas);
	  Thread.sleep(5000);
	  login_btn.click();
	  return new HomePage();
	  
  }

}
