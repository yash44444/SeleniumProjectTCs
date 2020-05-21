package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminFilterProductPOM {
	@SuppressWarnings("unused")
	private WebDriver driver; 	
	
	
	public AdminFilterProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-name']")
	private WebElement prodName;
	
	@FindBy(xpath="//input[@id='input-price']")
	private WebElement prodPrice;
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement prodFilter;
	
	@FindBy(xpath="//select[@id='input-status']")
	private WebElement prodStatus;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement prodModel;
		
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement prodQtty;
	

	
	public void enterProductName(String prodName) {
		this.prodName.clear();
		this.prodName.sendKeys(prodName);
	}
	
	public void enterProductPrice(String prodPrice) {
		this.prodPrice.clear();
		this.prodPrice.sendKeys(prodPrice);
	}
		
	public void clickProductFilter() {
		this.prodFilter.click();
	}
	
	public String enterProductStatus(String prodStatus) {
		this.prodStatus.clear();
		this.prodStatus.sendKeys(prodStatus);
		return prodStatus;
	}
	
	public void enterProductModel(String prodModel) {
		this.prodModel.clear();
		this.prodModel.sendKeys(prodModel);
	}
	
	public void enterProductQtty(String prodQtty) {
		this.prodQtty.clear();
		this.prodQtty.sendKeys(prodQtty);
	}
	
}
