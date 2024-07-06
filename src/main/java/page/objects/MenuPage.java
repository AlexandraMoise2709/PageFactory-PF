package page.objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

		
	//<a href="https://keyfood.ro/wishlist/">Wishlist</a>
	
	public By pickCategory(String foodCategory) {
		
		 return By.xpath("(//a[@href='https://keyfood.ro/product-category/"+ foodCategory + "/'])[2]");		
		 				  //(//a[@href='https://keyfood.ro/product-category/fruits-vegetables/'])[2]
	}
	
	public By pickProduct(String productType) {
		
		 return By.xpath("(//a[@href='https://keyfood.ro/product/"+ productType + "/'])[2]");		
		 				  //(//a[@href='https://keyfood.ro/product-category/fruits-vegetables/'])[2]
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