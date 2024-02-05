package com.qa.luma.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.luma.base.BaseTest;
import com.qa.luma.constants.AppConstants;

public class HomePageTest extends BaseTest {

	@Test
	public void homePageTitleTest() {
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
	}

	@Test
	public void homePageURLTest() {
		String actualURL = homePage.getHomePageURL();
		Assert.assertEquals(actualURL, prop.getProperty("url"));
	}

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
				{ "Marco Lightweight Active Hoodie" }, 
				{ "Fusion Backpack" }, 
				{ "Dash Digital Watch" }
		};
	}

	@Test(dataProvider = "getProductData")
	public void searchTest(String productName) throws InterruptedException {
		Thread.sleep(5000);
		String actualSearchHeader = homePage.doSearch(productName);
		String itemsPresent = "Items";
		Assert.assertTrue(actualSearchHeader.contains(itemsPresent));
	}

}
