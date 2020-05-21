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
import com.training.pom.AdminaddProductInvalidPOM;
import com.training.pom.UniformStoreLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import junit.framework.Assert;

public class AdminAddProductInvalidCreds {
	private WebDriver driver;
	private String baseUrl;
	private UniformStoreLoginPOM storeLogin;
	private AdminaddProductInvalidPOM adminaddProductInvalid;
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
		adminaddProductInvalid = new AdminaddProductInvalidPOM(driver);
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
		storeLogin.adminUserName("admin");
		storeLogin.adminPassword("admin@123");
		storeLogin.adminSubmit();
		System.out.println("<--- admin Login Successfull --->");
		screenShot.captureScreenShot("admin_login");
		

	}

	@Test(priority = 2, dataProvider = "input3", dataProviderClass = LoginDataProviders.class)

	public void addProductInvalid(String productName, String metaTag, String model, String price, String qtty, String category)
			throws InterruptedException {

		act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//i[@class='fa fa-tags fa-fw']"))).perform();
		adminaddProductInvalid.productIcon();
		adminaddProductInvalid.addNewIcon();
		adminaddProductInvalid.productName(productName);
		adminaddProductInvalid.metaTag(metaTag);
		adminaddProductInvalid.dataTab();
		adminaddProductInvalid.model(model);
		adminaddProductInvalid.priceTag(price);
		adminaddProductInvalid.productQuantity(qtty);
		adminaddProductInvalid.links();
		adminaddProductInvalid.categoriesList(category);
		driver.findElement(By.xpath("//div[@id='tab-links']//li[1]")).click();
		adminaddProductInvalid.saveProduct();
		Thread.sleep(2000);
		
		String finalMessage = driver.findElement(By.xpath("//*[contains(text(),'Warning')]")).getText();
		Assert.assertTrue(finalMessage.contains("Warning"));
		screenShot.captureScreenShot("UNF066");
	}

}