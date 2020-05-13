package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReturnPagePOM {
	@SuppressWarnings("unused")
	private WebDriver driver; 	
	
	
	public ReturnPagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[3]//label[1]//input[1]")
	private WebElement orderError;
	
	@FindBy(xpath="//label[@class='radio-inline']//input[@type='radio' and @value=1]")
	private WebElement prodOpen;
	
	@FindBy(xpath="//textarea[@id='input-comment']")
	private WebElement faultyComments;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement returnPolicyCheckbox;
	
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement returnSubmit;
	
	
	public void orderError() {
		this.orderError.click();
	}
	
	public void prodOpen() {
		this.prodOpen.click();
	}
	
	public void faultyComments() {
		this.faultyComments.sendKeys("not fit");
	}
	
	public void returnPolicyCheckbox() {
		this.returnPolicyCheckbox.click();
	}
	
	public void returnSubmit() {
		this.returnSubmit.click();
	}
	
}	
