package com.cg.app.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cg.app.base.TestBase;
import com.cg.app.pages.HomePage;
import com.cg.app.util.TestUtil;

public class HomePageTest extends TestBase {

	HomePage homePage;
	TestUtil testUtil;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homePage = new HomePage();
		testUtil = new TestUtil();
	}

	@DataProvider
	public Object[][] TestData() throws Exception {

		Object[][] testArray = testUtil.getTestData("Sheet1");

		return testArray;

	}

	@Test(dataProvider = "TestData", priority = 2)
	public void verifyVaccineSlots(String state, String district, String price, String vaccine)
			throws InterruptedException, IOException {

		homePage.verifyVaccineSlots(state, district, price, vaccine);
		TestUtil.takeScreenshotAtEndOfTest(district);

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CoWIN", "Home page title not matched");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
