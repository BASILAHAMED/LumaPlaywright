package com.qa.luma.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;

	// 1. String Locators - OR
	private String emailId = "//input[@id='email']";
	private String password = "//input[@id='pass']";
	private String loginBtn = "//button[@id='send2']";
	private String forgotPwdLink = "//*[@id=\"login-form\"]/fieldset/div[4]/div[2]/a/span";
	private String greetMsg = "//html/body/div[2]/header/div[1]/div/ul/li[1]/span[@class=\"logged-in\"]";

	// 2. page constructor:
	public LoginPage(Page page) {
		this.page = page;
	}
	
	// 3. page actions/methods:
	public String getLoginPageTitle() {
		return page.title();
	}
	
	public boolean isForgotPwdLinkExist() {
		return page.isVisible(forgotPwdLink);
	}
	
	public boolean doLogin(String appUserName, String appPassword) {
		System.out.println("App creds: " + appUserName + ":" + appPassword);
		page.fill(emailId, appUserName);
		page.fill(password, appPassword);
		page.click(loginBtn);
		page.locator(greetMsg).waitFor();
		if(page.locator(greetMsg).isVisible()) {
			System.out.println("user is logged in successfully....");
			return true;
		}else {
			System.out.println("user is not logged in successfully....");
			return false;
		}
	}
}
