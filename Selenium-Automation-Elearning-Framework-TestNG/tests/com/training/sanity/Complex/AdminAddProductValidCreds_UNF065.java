package com.training.sanity.Complex;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminaddProductMandatoryPOM;
import com.training.pom.UniformStoreLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import junit.framework.Assert;

public class AdminAddProductValidCreds_UNF065 {
	private WebDriver driver;
	private String baseUrl;
	private UniformStoreLoginPOM storeLogin;
	private AdminaddProductMandatoryPOM adminAddProductMandatory;
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
		adminAddProductMandatory = new AdminaddProductMandatoryPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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

	}

	@Test(priority = 2, dataProvider = "input2", dataProviderClass = LoginDataProviders.class)

	public void addProductValid(String productName, String metaTag, String model, String price, String qtty,
			String category) throws InterruptedException {

		// clicking on product icon.
		act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//i[@class='fa fa-tags fa-fw']"))).perform();
		adminAddProductMandatory.productIcon();
		adminAddProductMandatory.addNewIcon();
		adminAddProductMandatory.productName(productName);
		adminAddProductMandatory.metaTag(metaTag);

		// clicking on data tab.
		adminAddProductMandatory.dataTab();
		adminAddProductMandatory.model(model);
		adminAddProductMandatory.priceTag(price);
		adminAddProductMandatory.productQuantity(qtty);

		// clicking on link tab.
		adminAddProductMandatory.links();
		adminAddProductMandatory.categoriesList(category);
		driver.findElement(By.xpath("//div[@id='tab-links']//li[1]")).click();
		adminAddProductMandatory.saveProduct();

		// Asserting final message.
		String finalMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertTrue(finalMessage.contains("Success"));
		screenShot.captureScreenShot("UNF065");

	}

}