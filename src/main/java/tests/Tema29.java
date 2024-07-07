package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
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
			driver.navigate().back();
	        menu.click(menu.categories);
		} catch(NoSuchElementException e) {
			
			driver.navigate().back();
	        menu.click(menu.categories);
		}
		
			
		}
		
		@Test(priority=2)
		public void checkWishlist() throws InterruptedException {
			
			menu.click(menu.checkWishlist);

			String[] products = {"fresh-produce-melons-each", "zevia-kidz-strawberry-lemonade-zero-calorie-soda", "vital-farms-pasture-raised-egg-bites-bacon-cheddar", "shimmer-pastel-almond-blend"}; 		
			
		      for(String product : products) { 
		    	  
		    	WebElement produs =  menu.productName(product);
		    	WebElement addToCart =  menu.addToCart;
		    	System.out.println(menu.productName(product));
		    	  Assert.assertTrue(produs.isDisplayed());
		    	  Assert.assertTrue(addToCart.isDisplayed());


		          }
		      
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
				
				Thread.sleep(10000);
				
				//assertEquals("","BLABA");

			
		}
			
		
}