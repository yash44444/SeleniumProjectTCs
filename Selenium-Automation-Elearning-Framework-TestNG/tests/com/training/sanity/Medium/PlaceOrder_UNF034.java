package com.training.sanity.Medium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void homePage() throws InterruptedException {

		// Entering application as guest user.
		guestPlaceOrder.maroonTshirt();
		System.out.println("clicked on tshirt");

		Select sel = new Select(driver.findElement(By.id("input-option386")));
		sel.selectByIndex(1);
		guestPlaceOrder.addCart();

		// Asserting message when product added to cart.
		String actualMessage = "Success: You have added Regular T-Shirt (Maroon) to your shopping cart!";
		String retrievedMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertTrue(retrievedMessage.contains(actualMessage));
		System.out.println(retrievedMessage);
		screenShot.captureScreenShot("UNF034_ProductAddedtoCart");

		guestPlaceOrder.CartBtn();
		guestPlaceOrder.viewCart();
		guestPlaceOrder.checkOut();
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
		Select region = new Select(driver.findElement(By.xpath("//select[@id='input-payment-zone']")));
		region.selectByVisibleText("Goa");
		System.out.println("billing address entered");

		guestAccountBilling.billingContinue();
		guestAccountBilling.shippingComments();
		guestAccountBilling.commentsContinue();
		guestAccountBilling.deliveryInformationCheckbox();
		guestAccountBilling.deliveryContinue();
		guestAccountBilling.confirmOrder();
		guestAccountBilling.orderPlacedMsg();
		System.out.println("Order placed, TC complete");
		screenShot.captureScreenShot("UNF034");

	}

}
