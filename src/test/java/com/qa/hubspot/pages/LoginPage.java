package com.qa.hubspot.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.constants.Constants;

public class LoginPage extends BasePage{
	
	//1.a.find page objects using page factory pattern
	
	@FindBy(id="username")
	WebElement emailId;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement loginBtn;
	
	@FindBy(linkText="Sign up")
	WebElement SignUpLink;
	
	//1.b.Constructor of page class and initialize elements with driver
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//2.methods-Actions
	
	public String getLoginPageTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.titleIs(Constants.LOGIN_PAGE_TITLE));
		return driver.getTitle();
	}
	
	public boolean verifySignUpLink() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return SignUpLink.isDisplayed();
	}
	
	public HomePage login(String Uname, String Pwd) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.elementToBeClickable(emailId));
		emailId.sendKeys(Uname);
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(Pwd);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
		return new HomePage(driver);
	}

}
