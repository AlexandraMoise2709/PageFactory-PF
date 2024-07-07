package page.objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.utils.SeleniumWrappers;

public class MenuPage extends SeleniumWrappers{

	public MenuPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//public By myAccountLink = By.linkText("My account");
	//WebElement myAccountLink = driver.findElement(myAccountLink);
	
	@FindBy(linkText = "My account")
	public WebElement myAccountLink;
	
	@FindBy(linkText = "CONTACT")
	 public WebElement contactPageLink;
	
	////span[@class='text' and text()='ALL CATEGORIES']
	
	@FindBy(xpath = "//span[@class='text' and text()='ALL CATEGORIES']")
	 public WebElement categories;
	
		
	@FindBy(xpath = "(//span[@class='tinvwl_add_to_wishlist-text'])[2]")
	 public WebElement addToWisList;
	
	@FindBy(css = "a[href='https://keyfood.ro/wishlist/']")
	 public WebElement checkWishlist;
	
    public WebElement productName(String product) {
        return driver.findElement(By.xpath("//a[contains(@href, '" + product + "')]"));
    }
	
	@FindBy(name = "tinvwl-add-to-cart")
	 public WebElement addToCart;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	public WebElement checkItems;
	
	@FindBy(id ="tinvwl_product_actions")
	public WebElement dropDown;

	@FindBy(xpath = "(//button[@type='submit'])[5]")
	public WebElement applyAction;
	
	//class="woocommerce-error"
	
	@FindBy(className = "woocommerce-error")
	public WebElement errorMsg;
	
	public By pickCategory(String foodCategory) {
		

		return By.xpath("(//a[@href='https://keyfood.ro/product-category/"+ foodCategory + "/'])[2]");		
		 				  //(//a[@href='https://keyfood.ro/product-category/fruits-vegetables/'])[2]
	}
	
	public By pickProduct(String productType) {
		if(productType=="fresh-produce-melons-each" || productType=="shimmer-pastel-almond-blend" )
		{ return By.xpath("(//a[@href='https://keyfood.ro/product/"+ productType + "/'])[3]");		
			}
		else if(productType=="vital-farms-pasture-raised-egg-bites-bacon-cheddar") {
				return By.xpath("(//a[@href='https://keyfood.ro/product/"+ productType + "/'])[4]");
		}	else {
			return By.xpath("//a[@href='https://keyfood.ro/product/"+ productType + "/']");
		}			  
	} 
	
	public By composeProductName(String product) {
		
		 return By.xpath("(//a[contains(@href, '"+product+"')]");		
		 				  //(//a[@href='https://keyfood.ro/product-category/fruits-vegetables/'])[2]
	}
	
	
	public void clickBy(By locator) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			WebElement element  =  driver.findElement(locator);
			element.click();	
			
		}catch(NoSuchElementException e) {
			
		}		

	
		}
}