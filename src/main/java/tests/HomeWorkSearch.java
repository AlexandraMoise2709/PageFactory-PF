package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import framework.utils.PropertiesFileProcessor;
import page.objects.MenuPage;
import page.objects.MyAccountPage;
import page.objects.SearchPage;
import selenium.utils.BaseTest;


public class HomeWorkSearch extends BaseTest {
	
	
	String USER = PropertiesFileProcessor.readPropertiesFile("user", "credentials.properties");
	String PASS = PropertiesFileProcessor.readPropertiesFile("pass", "credentials.properties");

	@Test(priority=1)
	public void searchWhileLogged() {		
		MenuPage menu =  new MenuPage(driver);
		MyAccountPage myAccount =  new MyAccountPage(driver);
		SearchPage search =  new SearchPage(driver);
		Actions action = new Actions(driver);
				
		menu.click(menu.myAccountLink);
		myAccount.loginInApp(USER, PASS);			
				
		search.click(search.searchField);
		search.sendKeys(search.searchField, "Pretzels");
		action.sendKeys(Keys.ENTER).perform();
		search.click(search.addToCart);
		
		String expectedMessage = "View cart\n" +
                "\"Rold Gold Tiny Twists Pretzels\" has been added to your cart.";
                	
		//assertEquals(search.getElementText(search.succesMsg),expectedMessage);
		
		search.click(search.viewBTN);
		search.click(search.plusBtn);
		
		assertNotEquals(search.pricePerItem,search.totalPrice);
	
}
	
	
}