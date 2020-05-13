package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GuestPlaceOrderPOM {
	@SuppressWarnings("unused")
	private WebDriver driver; 	
	
	
	public GuestPlaceOrderPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[3]//div[1]//div[1]//div[1]//a[1]//img[1]")
	private WebElement maroonTshirt;
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement addCart;
	
	@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	private WebElement CartBtn;
	
	@FindBy(xpath="//strong[contains(text(),'View Cart')]")
	private WebElement viewCart;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement checkOut;
	
	@FindBy(xpath="//div[@id='collapse-checkout-option']//div[2]//label[1]//input[1]")
	private WebElement guestRadio;
	
	@FindBy(xpath="//input[@id='button-account']")
	private WebElement guestContinue;
	
	
	
	public void maroonTshirt() {
		this.maroonTshirt.click();
	}
	
	public void addCart() {
		this.addCart.click();
	}
	
	public void CartBtn() {
		this.CartBtn.click();
	}
	
	public void viewCart() {
		this.viewCart.click();
	}
	
	public void checkOut() {
		this.checkOut.click();
	}
	
	public void guestRadio() {
		this.guestRadio.click();
	}
	
	public void guestContinue() {
		this.guestContinue.click();
	}
	
}
