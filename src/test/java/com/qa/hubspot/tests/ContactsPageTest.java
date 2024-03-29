package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.TestUtil;
import com.qa.hubspot.pages.ContactsPage;


public class ContactsPageTest {
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;
	
	@BeforeMethod //this method will be executed before every @test method
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.initialize_Properties();
		driver = basePage.initialize_driver();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homePage.navigateToContactsPages();		
	}
	
	@DataProvider(name="getContactsData")
	public Object[][]  getContactsData() {
		Object[][] data=TestUtil.getData(Constants.CONTACTS);
		return data;
	}
	
	@Test(dataProvider="getContactsData")
	public void createNewContactTest(String email, String firstName,String lastName, String jobTitle) {
		contactsPage.createNewContact(email,firstName,lastName,jobTitle);
	}
	
	@AfterMethod //this method will be executed before every @test method
	public void tearDown(){
		driver.quit();
	}


}
