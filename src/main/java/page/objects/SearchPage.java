package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.utils.SeleniumWrappers;

public class SearchPage extends SeleniumWrappers{

	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="dgwt-wcas-search-input-1")
	public WebElement searchField;
	
	@FindBy(css="div [class*='single_add_to_cart_button']")
	public WebElement addToCart;
	
	@FindBy(css="div [class='woocommerce-message']")
	public WebElement succesMsg;
	
	
	@FindBy(xpath="(//a[@class='button wc-forward'])[2]")
	public WebElement viewBTN;
	//class='quantity-button plus'
	
	@FindBy(css="[class='quantity-button plus']")
	public WebElement plusBtn;
	
	@FindBy(xpath="(//span[@class='woocommerce-Price-amount amount'])[5]")
	public WebElement pricePerItem;
	
	@FindBy(xpath="(//span[@class='woocommerce-Price-amount amount'])[7]")
	public WebElement totalPrice;
	
}