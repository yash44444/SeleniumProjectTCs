package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public  class OrderConfirmationPOM {
	@SuppressWarnings("unused")
	private WebDriver driver; 
	
	public OrderConfirmationPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h2[contains(text(),'Order Information')]")
	private WebElement confirmation;
	
	@FindBy(xpath="//td//a[2][contains(@href,'return')]/i[@class='fa fa-reply']")
	private WebElement returnLink;
		
	public String confirmationPage() {
		String expected=this.confirmation.getText(); 
		return expected;
	}
	
	public void returnLink() {
		this.returnLink.click();
		
	}
	
	
}
