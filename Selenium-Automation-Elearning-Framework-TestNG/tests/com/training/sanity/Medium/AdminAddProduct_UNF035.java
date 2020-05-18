package com.training.sanity.Medium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.AdminaddProductPOM;
import com.training.pom.UniformStoreLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import junit.framework.Assert;

public class AdminAddProduct_UNF035 {

	private WebDriver driver;
	private String baseUrl;
	private UniformStoreLoginPOM storeLogin;
	private AdminaddProductPOM adminaddProduct;
	private static Properties properties;
	private ScreenShot screenShot;
	private Actions act;
	private WebDriverWait wait, wait2;

	@BeforeTest
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

	}

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		storeLogin = new UniformStoreLoginPOM(driver);
		adminaddProduct = new AdminaddProductPOM(driver);
		screenShot = new ScreenShot(driver);
		driver.get(baseUrl);
		Thread.sleep(2000);

	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(priority = 1)
	public void uniformLogin() {
		storeLogin.adminUserName("admin");
		storeLogin.adminPassword("admin@123");
		storeLogin.adminSubmit();
		System.out.println("<--- admin Login Successfull --->");
	}

	@Test(priority = 2)
	public void catalogPage() throws InterruptedException {

		act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//i[@class='fa fa-tags fa-fw']"))).perform();
		adminaddProduct.productIcon();

		adminaddProduct.addNewIcon();
		System.out.println("On Genral Tab");
		adminaddProduct.productName();
		adminaddProduct.metaTag();

		adminaddProduct.dataTab();
		System.out.println("switched to Data Tab");
		adminaddProduct.model();
		adminaddProduct.priceTag();
		adminaddProduct.productQuantity();

		adminaddProduct.links();
		System.out.println("switched to Links Tab");
		driver.findElement(By.xpath("//input[@id='input-category']")).sendKeys("s");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='input-category']//following-sibling::ul//li[1]")).click();
		System.out.println("cateogry selected from the dropdown");

		adminaddProduct.discountTab();
		System.out.println("switched to Discount Tab!");
		adminaddProduct.addDiscount();
		adminaddProduct.discountQuantity();
		adminaddProduct.discountPrice();
		adminaddProduct.calenderStart();
		System.out.println("Calender1 opened");
		wait = new WebDriverWait(driver, 3);
		WebElement start_dt = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='bootstrap-datetimepicker-widget dropdown-menu picker-open bottom']"
						+ "//td[@class='day active today']")));
		start_dt.click();
		System.out.println("Discount start date selected");

		adminaddProduct.calenderEnd();
		System.out.println("Calender2 opened");
		wait2 = new WebDriverWait(driver, 3);
		WebElement end_dt = wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='bootstrap-datetimepicker-widget dropdown-menu picker-open bottom pull-right']"
						+ "//td[@class='day active today']/following-sibling::td[1]")));
		end_dt.click();
		System.out.println("Discount end date selected");

		adminaddProduct.rewardPointsTab();
		System.out.println("switched to Reward Points Tab");
		adminaddProduct.point();
		adminaddProduct.saveProduct();

		String finalMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertTrue(finalMessage.contains("Success"));
		screenShot.captureScreenShot("UNF035");

	}

}
