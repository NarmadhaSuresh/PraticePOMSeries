package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.constants.Constants;

public class HomePage extends BasePage {
	
	//1.declare webElements
	
	@FindBy(id="nav-primary-contacts-branch")
	WebElement contactsMain;
	
	@FindBy(id="nav-secondary-contacts")
	WebElement ContactsBranch;
	
	@FindBy(className="private-page__title")
	WebElement homepageTitle;
	
	
	//2.Initialize web elements by calling constructor using page factory initelements method
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//3.Actions or methods
	
	public ContactsPage navigateToContactsPages() {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(contactsMain));
		contactsMain.click();
		wait.until(ExpectedConditions.visibilityOf(ContactsBranch));
		ContactsBranch.click();
		return new ContactsPage(driver);
	}
	
	public String verifyTitle() {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(Constants.HOME_PAGE_TITLE));
		return driver.getTitle();
	}
	
	public boolean verifyHomePageHeader() {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(homepageTitle));
		return homepageTitle.isDisplayed();
	}
	
	public String getHomePageHeader() {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(homepageTitle));
		return homepageTitle.getText();
	}
	
	

}
