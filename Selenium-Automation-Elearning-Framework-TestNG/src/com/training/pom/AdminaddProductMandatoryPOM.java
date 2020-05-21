package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminaddProductMandatoryPOM {
	@SuppressWarnings("unused")
	private WebDriver driver; 	
	
	
	public AdminaddProductMandatoryPOM(WebDriver driver) {
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
	
	public void productName(String productName) {
		this.productName.clear();
		this.productName.sendKeys(productName);
	}
	
	public void metaTag(String metaTag) {
		this.metaTag.clear();
		this.metaTag.sendKeys(metaTag);
	}
	
	public void dataTab() {
		this.dataTab.click();
	}
	
	public void model(String model) {
		this.model.clear();
		this.model.sendKeys(model);
	}
	
	public void priceTag(String price) {
		this.priceTag.clear();
		this.priceTag.sendKeys(price);
	}
	
	public void productQuantity(String qtty) {
		this.productQuantity.clear();
		this.productQuantity.sendKeys(qtty);
	}
	
	public void links() {
		this.links.click();
	}
	
	public void categoriesList(String category) {
		this.categoriesList.clear();
		this.categoriesList.sendKeys(category);
	}
	
		
	public void saveProduct() {
		this.saveProduct.click();;
	}
	
}
