package com.crm.qa.base;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\ashish\\eclipse-workspace\\HybridCrmtest\\src\\main\\java\\com\\crm\\qa\\config\\Config.properties");
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		
	}

	}
	
public void initialisation()
{
	String browser = prop.getProperty("browser");
	if(browser.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","E:\\MyData\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver","E:\\MyData\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));

	
	
}
}
