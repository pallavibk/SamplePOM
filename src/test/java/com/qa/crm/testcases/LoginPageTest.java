package com.qa.crm.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class LoginPageTest  extends TestBase
{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
   @BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	@Test(priority=1)
	public void loginPageTitleTest(){
	String title =loginPage.validateLoginPageTitle();
	Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest(){
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='navbar navbar-default navbar-fixed-top skrollable skrollable-between']/div/div[@class='col-sm-4 col-md-4 pull-right']/form[@class='navbar-form']/div/div[@class='input-group-btn']/input")));
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
