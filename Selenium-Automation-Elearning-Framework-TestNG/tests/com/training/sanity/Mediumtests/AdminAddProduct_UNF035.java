package com.training.sanity.Mediumtests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	private WebElement element;
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

	@Test(priority=1)
	public void uniformLogin() {
		storeLogin.adminUserName("admin");
		storeLogin.adminPassword("admin@123");
		storeLogin.adminSubmit();
		System.out.println("<--- admin Login Successfull --->");
	}
	
	@Test(priority=2)
	public void catalogPage() throws InterruptedException {
		
		act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//i[@class='fa fa-tags fa-fw']"))).perform();
		adminaddProduct.productIcon();
		adminaddProduct.addNewIcon();
		adminaddProduct.productName();
		adminaddProduct.metaTag();
		adminaddProduct.dataTab();
		adminaddProduct.model();
		adminaddProduct.priceTag();
		adminaddProduct.productQuantity();
		adminaddProduct.links();
		
		
		driver.findElement(By.xpath("//input[@id='input-category']")).sendKeys("s");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='input-category']//following-sibling::ul//li[1]")).click();
		System.out.println("cateogry selected from the dropdown");			
		adminaddProduct.discountTab();
		adminaddProduct.addDiscount();
		adminaddProduct.discountQuantity();
		adminaddProduct.discountPrice();
		adminaddProduct.calenderStart();
		System.out.println("Calender1 opened");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tr//td[@class='day active today']")).click();
		
		
		//driver.findElement(By.xpath("//tr//td[@class='day active today']")).click();			
		System.out.println("Discount start date selected");
		adminaddProduct.calenderEnd();
		driver.findElement(By.xpath("//div[@class='bootstrap-datetimepicker-widget dropdown-menu top pull-right picker-open']//td[@class='day active today']//following-sibling::td[1]")).click();		
		System.out.println("Discount end date selected");
		adminaddProduct.rewardPointsTab();
		adminaddProduct.point();
		adminaddProduct.saveProduct();
		String expected="Success: You have modified products!";
		String actual= driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertEquals(expected, actual);
		System.out.println("TC complete");
		
		
	}

	
}
