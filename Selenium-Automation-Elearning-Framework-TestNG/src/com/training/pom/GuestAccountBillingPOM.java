package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GuestAccountBillingPOM {
	@SuppressWarnings("unused")
	private WebDriver driver;

	public GuestAccountBillingPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='input-payment-firstname']")
	private WebElement billingFirstName;

	@FindBy(xpath = "//input[@id='input-payment-lastname']")
	private WebElement billingLastName;

	@FindBy(xpath = "//input[@id='input-payment-email']")
	private WebElement billingEmail;

	@FindBy(xpath = "//input[@id='input-payment-telephone']")
	private WebElement billingfon;

	@FindBy(xpath = "//input[@id='input-payment-address-1']")
	private WebElement billingAddress;

	@FindBy(xpath = "//input[@id='input-payment-city']")
	private WebElement billingCity;

	@FindBy(xpath = "//input[@id='input-payment-postcode']")
	private WebElement billingPostCode;

	@FindBy(xpath = "//input[@id='button-guest']")
	private WebElement billingContinue;

	@FindBy(xpath = "//input[@name='shipping_address']")
	private WebElement deliveryAddress;

	@FindBy(xpath = "//textarea[@name='comment']")
	private WebElement shippingComments;

	@FindBy(xpath = "//input[@id='button-shipping-method']")
	private WebElement commentsContinue;
		
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement deliveryInformationCheckbox;
	
	@FindBy(xpath = "//input[@id='button-payment-method']")
	private WebElement deliveryContinue;
	
	@FindBy(xpath = "//input[@id='button-confirm']")
	private WebElement confirmOrder;

	@FindBy(xpath = "//h1[contains(text(),'Your order has been placed!')]")
	private WebElement orderPlacedMsg;

	public void billingFirstName() {
		this.billingFirstName.sendKeys("Yashu");
	}

	public void billingLastName() {
		this.billingLastName.sendKeys("verma");
	}

	public void billingEmail() {
		this.billingEmail.sendKeys("yash0002@gmail.com");
	}

	public void billingfon() {
		this.billingfon.sendKeys("223223");
	}

	public void billingAddress() {
		this.billingAddress.sendKeys("street2");
	}

	public void billingCity() {
		this.billingCity.sendKeys("hyderabad");
	}

	public void billingPostCode() {
		this.billingPostCode.sendKeys("20453");
	}

	public void deliveryAddress() {
		this.deliveryAddress.click();
	}

	public void billingContinue() {
		this.billingContinue.click();
	}

	public void shippingComments() {
		this.shippingComments.sendKeys("This is my first product");
	}

	public void commentsContinue() {
		this.commentsContinue.click();
	}
	
	public void deliveryInformationCheckbox() {
		this.deliveryInformationCheckbox.click();
	}
	
	public void deliveryContinue() {
		this.deliveryContinue.click();
	}

	public void confirmOrder() {
		this.confirmOrder.click();
	}

	public void orderPlacedMsg() {
		this.orderPlacedMsg.click();
	}

}
