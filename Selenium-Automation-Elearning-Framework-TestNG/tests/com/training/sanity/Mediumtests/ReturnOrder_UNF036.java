package com.training.sanity.Mediumtests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.OrderConfirmationPOM;
import com.training.pom.OrderHistoryPOM;
import com.training.pom.ReturnPagePOM;
import com.training.pom.UniformStoreLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ReturnOrder_UNF036 {

	private WebDriver driver;
	private String baseUrl;
	private UniformStoreLoginPOM storeLogin;
	private OrderHistoryPOM order_History;
	private OrderConfirmationPOM orderConfirmation;
	private ReturnPagePOM returnPage;
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
		storeLogin = new UniformStoreLoginPOM(driver);
		order_History = new OrderHistoryPOM(driver);
		orderConfirmation = new OrderConfirmationPOM(driver);
		returnPage = new ReturnPagePOM(driver);
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

		storeLogin.accountLogin();
		storeLogin.sendUserName("yash0002@gmail.com");
		storeLogin.sendUserPassword("welcome1231");
		storeLogin.submit();
		System.out.println("<--- Login Successfull --->");

	}

	@Test(priority = 2)
	public void viewOrderHistory() {
		order_History.orderHistory();
		System.out.println("<--- Clicked on Order History --->");
		order_History.viewButton();
		System.out.println("<--- Clicked on view button --->");

		orderConfirmation.returnLink();
		returnPage.orderError();
		returnPage.prodOpen();
		returnPage.faultyComments();
		returnPage.returnPolicyCheckbox();
		returnPage.returnSubmit();

		String ReturnMessage = driver
				.findElement(By.xpath("//p[contains(text(),'Thank you for submitting your return request. Your')]"))
				.getText();

		Assert.assertTrue(ReturnMessage.contains("Thank you"));
		screenShot.captureScreenShot("UNF036");
	}

}
