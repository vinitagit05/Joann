package com.joann.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.joann.base.BaseClass;

public class LoginPage extends BaseClass {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver)

	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	// LOCATORS
	@FindBy(xpath = "//input[@placeholder='Username']")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(id = "createAllocationButton")
	@CacheLookup
	WebElement textName;

	// ACTIONS

	public void setUserName(String uname) {
		txtUserName.clear();
		txtUserName.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public boolean checkText() {
		boolean status = textName.isDisplayed();
		return status;
	}

}
