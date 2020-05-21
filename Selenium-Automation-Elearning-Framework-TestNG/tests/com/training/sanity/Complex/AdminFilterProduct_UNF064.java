package com.training.sanity.Complex;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminFilterProductPOM;
import com.training.pom.AdminaddProductPOM;
import com.training.pom.UniformStoreLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminFilterProduct_UNF064 {
	private WebDriver driver;
	private String baseUrl;
	private UniformStoreLoginPOM storeLogin;
	private AdminFilterProductPOM adminFilterProduct;
	private AdminaddProductPOM adminaddProduct;
	private static Properties properties;
	private ScreenShot screenShot;
	private Actions act;

	@BeforeTest
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		storeLogin = new UniformStoreLoginPOM(driver);
		adminaddProduct = new AdminaddProductPOM(driver);
		adminFilterProduct = new AdminFilterProductPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(priority = 1)
	public void uniformLogin() throws InterruptedException {
		
		// Logging as admin.
		storeLogin.adminUserName("admin");
		storeLogin.adminPassword("admin@123");
		storeLogin.adminSubmit();
		System.out.println("<--- admin Login Successfull --->");
		screenShot.captureScreenShot("admin_login");
		act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//i[@class='fa fa-tags fa-fw']"))).perform();
		adminaddProduct.productIcon();

	}

	@Test(priority = 2, dataProvider = "input1", dataProviderClass = LoginDataProviders.class)

	public void filterProduct(String prodName, String prodPrice, String prodStatus, String prodModel, String prodQtty)
			throws InterruptedException {

		adminFilterProduct.enterProductName(prodName);

		adminFilterProduct.enterProductPrice(prodPrice);

		Select status = new Select(driver.findElement(By.xpath("//select[@id='input-status']")));

		status.selectByVisibleText("Enabled");

		adminFilterProduct.enterProductModel(prodModel);

		driver.findElement(By.xpath("//div[@class='well']//div[2]//ul[1]//li[1]")).click();

		adminFilterProduct.enterProductQtty(prodQtty);

		// Clicking on filter button.
		adminFilterProduct.clickProductFilter();
		screenShot.captureScreenShot("UNF064");

	}

}