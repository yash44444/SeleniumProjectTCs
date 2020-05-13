package com.training.sanity.Mediumtests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.GuestAccountBillingPOM;
import com.training.pom.GuestPlaceOrderPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class PlaceOrder_UNF034 {

	private WebDriver driver;
	private String baseUrl;
	private GuestPlaceOrderPOM guestPlaceOrder;
	private GuestAccountBillingPOM guestAccountBilling;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

	}

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("BaseURL");
		guestPlaceOrder = new GuestPlaceOrderPOM(driver);
		guestAccountBilling = new GuestAccountBillingPOM(driver);
		screenShot = new ScreenShot(driver);
		driver.get(baseUrl);
		Thread.sleep(2000);

	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void homePage() throws InterruptedException {

		guestPlaceOrder.maroonTshirt();
		System.out.println("clicked on tshirt");

		Select sel = new Select(driver.findElement(By.id("input-option386")));
		sel.selectByIndex(1);
		guestPlaceOrder.addCart();

		String successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();

		if (successMessage.contains("Success")) {
			System.out.println("Product added successfully to the cart");
		} else {
			System.out.println("Product was not added");
		}

		screenShot.captureScreenShot("UNF034_ProductAddedtoCart");

		guestPlaceOrder.CartBtn();
		guestPlaceOrder.viewCart();
		guestPlaceOrder.checkOut();
		System.out.println("checked out of cart");
		guestPlaceOrder.guestRadio();
		guestPlaceOrder.guestContinue();

		guestAccountBilling.billingFirstName();
		guestAccountBilling.billingLastName();
		guestAccountBilling.billingEmail();
		guestAccountBilling.billingfon();
		guestAccountBilling.billingAddress();
		guestAccountBilling.billingCity();
		guestAccountBilling.billingPostCode();

		Select country = new Select(driver.findElement(By.xpath("//select[@id='input-payment-country']")));
		country.selectByVisibleText("India");
		Thread.sleep(2000);
		Select region = new Select(driver.findElement(By.xpath("//select[@id='input-payment-zone']")));
		region.selectByVisibleText("Goa");
		Thread.sleep(2000);
		System.out.println("billing address entered");

		guestAccountBilling.billingContinue();
		guestAccountBilling.shippingComments();
		System.out.println("comments added for free shipping");
		guestAccountBilling.commentsContinue();		
		Thread.sleep(2000);
		guestAccountBilling.deliveryInformationCheckbox();
		guestAccountBilling.deliveryContinue();
		guestAccountBilling.confirmOrder();
		guestAccountBilling.orderPlacedMsg();
		System.out.println("Order placed, TC complete");
		screenShot.captureScreenShot("UNF034_finalPage");

	}

}
