package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminaddProductPOM {
	@SuppressWarnings("unused")
	private WebDriver driver; 	
	
	
	public AdminaddProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-tags fa-fw']")
	private WebElement catalogIcon;
	
	@FindBy(xpath="//li[@id='catalog']//ul//li//a[contains(text(),'Products')]")
	private WebElement productIcon;
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addNewIcon;
	
	@FindBy(xpath="//input[@id='input-name1']")
	private WebElement productName;
	
	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement metaTag;
	
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement dataTab;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement model;
	
	@FindBy(xpath="//input[@id='input-price']")
	private WebElement priceTag;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement productQuantity;
	
	@FindBy(xpath="//a[contains(text(),'Links')]")
	private WebElement links;
	
	@FindBy(xpath="//input[@id='input-category']")
	private WebElement categoriesList;
	
	@FindBy(xpath="//a[contains(text(),'Discount')]")
	private WebElement discountTab;
	
	@FindBy(xpath="//table[@id='discount']//button[@class='btn btn-primary']")
	private WebElement addDiscount;
	
	@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Quantity']")
	private WebElement discountQuantity;
	
	@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Price']")
	private WebElement discountPrice;
	
	@FindBy(xpath="//td[5]//div[1]//span[1]//button[1]")
	private WebElement calenderStart;		
	
	@FindBy(xpath="//td[6]//div[1]//span[1]//button[1]")
	private WebElement calenderEnd;
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']//a[contains(text(),'Reward Points')]")
	private WebElement rewardPointsTab;
	
	@FindBy(xpath="//input[@id='input-points']")
	private WebElement points;
	
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement saveProduct;
	
	
	
	
	public void catalogIcon() {
		this.catalogIcon.click();
	}
	
	public void productIcon() {
		this.productIcon.click();
	}
	
	public void addNewIcon() {
		this.addNewIcon.click();
	}
	
	public void productName() {
		this.productName.sendKeys("Blazer Girls(7-8)");
	}
	
	public void metaTag() {
		this.metaTag.sendKeys("Blazer for Girls");
	}
	
	public void dataTab() {
		this.dataTab.click();
	}
	
	public void model() {
		this.model.sendKeys("BLG-112");
	}
	
	public void priceTag() {
		this.priceTag.sendKeys("3000");
	}
	
	public void productQuantity() {
		this.productQuantity.sendKeys("100");
	}
	
	public void links() {
		this.links.click();
	}
		
	public void discountTab() {
		this.discountTab.click();
	}
	
	public void addDiscount() {
		this.addDiscount.click();
	}
	
	public void discountQuantity() {
		this.discountQuantity.sendKeys("5");
	}
	
	public void discountPrice() {
		this.discountPrice.sendKeys("200");
	}
	
	public void calenderStart() {
		this.calenderStart.click();;   
	}
	
	public void calenderEnd() {
		this.calenderEnd.click();   
	}
	
	public void rewardPointsTab() {
		this.rewardPointsTab.click();
	}
	
	public void point() {
		this.points.sendKeys("20");
	}
	
	public void saveProduct() {
		this.saveProduct.click();;
	}
	
}
