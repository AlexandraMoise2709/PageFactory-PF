package tests;

import static org.testng.Assert.assertEquals;


import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.utils.PropertiesFileProcessor;
import page.objects.MenuPage;
import page.objects.MyAccountPage;
import selenium.utils.BaseTest;


public class Tema29 extends BaseTest {
	

	String USER = PropertiesFileProcessor.readPropertiesFile("user", "credentials.properties");
	String PASS = PropertiesFileProcessor.readPropertiesFile("pass", "credentials.properties");
	  private MenuPage menu;
	  private MyAccountPage myAccount;
	
	 @BeforeClass
	    public void setUp() {
				
		 	menu = new MenuPage(driver);
	        myAccount = new MyAccountPage(driver);	
			menu.click(menu.myAccountLink);
			myAccount.loginInApp(USER, PASS);
	 }
	 
		@DataProvider(name = "createSearchCat")
		public Object[][] createSearchCat(){
			
		  Object[][] data = new Object[4][2];

	         data[0][0] = "fruits-vegetables";

	         data[0][1] = "fresh-produce-melons-each";
	         
	         data[1][0] = "beverages";

	         data[1][1] = "zevia-kidz-strawberry-lemonade-zero-calorie-soda";
	         
	         data[2][0] = "breakfast-dairy";

	         data[2][1] = "vital-farms-pasture-raised-egg-bites-bacon-cheddar";
	         
	         data[3][0] = "biscuits-snacks";

	         data[3][1] = "shimmer-pastel-almond-blend";
		

	         return data;
		
}
		@Test(dataProvider =  "createSearchCat", priority=1)
		public void addProducts(String categ, String product) throws InterruptedException {
			
			menu.click(menu.categories);
		try {	
			menu.clickBy(menu.pickCategory(categ));
			menu.clickBy(menu.pickProduct(product));
			
			
			menu.click(menu.addToWisList);
			
			Thread.sleep(3000);
			driver.navigate().back();
	        menu.click(menu.categories);
		} catch(NoSuchElementException e) {
			
			driver.navigate().back();
	        menu.click(menu.categories);
		}
		
		
			
		}
		
		
		@Test(priority=2)
		public void checkElementsInList() {
			menu.click(menu.checkWishlist);
			List<WebElement> wishlistItems = driver.findElements(By.cssSelector("[class=wishlist_item]"));
	                
	                String[] expectedProductNames = {
	                        "Shimmer Pastel Almond Blend",
	                        "Vital Farms Pasture-Raised Egg Bites Bacon & Cheddar",
	                        "Fresh Produce Melons Each",
	                        "Zevia Kidz Strawberry Lemonade Zero Calorie Soda"
	                    };
	                
	                for (int i = 0; i < wishlistItems.size(); i++) {
	                    WebElement item = wishlistItems.get(i);
	                    
	                    WebElement productNameElement = item.findElement(By.cssSelector("[class='product-name'] a"));
		                String productName = productNameElement.getText();
		                
		                WebElement productActionElement = item.findElement(By.cssSelector("[class='product-action'] button"));
		                String buttonName = productActionElement.getText();
		                
		                String expectedAction = "Add to Cart";
		
		                
		                Assert.assertEquals(productName, expectedProductNames[i]);
		                
		                Assert.assertEquals(buttonName,expectedAction); 
		            
	                }
			}

		
		@Test(priority=3)
		public void checkWishlist() throws InterruptedException {
			
			
		      menu.click(menu.checkItems);
		      Actions action = new Actions(driver);
				action.moveToElement(menu.dropDown)
				.click()
				.keyDown(Keys.ARROW_DOWN)
				.keyDown(Keys.ENTER)
				.perform();
				action.moveToElement(menu.applyAction)
				.click()			
				.perform();			
				
				
			assertEquals(menu.errorMsg.getText(),
			"Product “Zevia Kidz Strawberry Lemonade Zero Calorie Soda” could not be added to cart because some requirements are not met.");

		}
			
		
}