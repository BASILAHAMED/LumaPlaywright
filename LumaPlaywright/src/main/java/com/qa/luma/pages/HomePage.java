package com.qa.luma.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;

	// 1. String Locators 
	private String search = "input[id='search']";
	private String searchIcon = "button[type='submit']";
	private String searchPageHeader = "//*[@id=\"toolbar-amount\"]";
//	private String loginLink = "a:text('Login')";
	private String myAccountLink = "//li[contains(@class, 'authorization-link')]//a[contains(@href, 'customer/account/login')]";
	

	// 2. page constructor:
	public HomePage(Page page) {
		this.page = page;
	}

	// 3. page actions/methods:
	public String getHomePageTitle() {
		String title =  page.title();
		System.out.println("page title: " + title);
		return title;
	}

	public String getHomePageURL() {
		String url =  page.url();
		System.out.println("page url : " + url);
		return url;
	}

	public String doSearch(String productName) throws InterruptedException {
		page.fill(search, productName);
		page.click(searchIcon);
		Thread.sleep(4000);
		String header =  page.textContent(searchPageHeader);
		System.out.println("search header: " + header);
		page.goBack();
		return header;
	}
	
	public LoginPage navigateToLoginPage() throws InterruptedException {
		page.click(myAccountLink);
		Thread.sleep(4000);
		return new LoginPage(page);
	}

}
