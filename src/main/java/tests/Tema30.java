package tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import page.objects.BlogPage;
import page.objects.MenuPage;

import selenium.utils.BaseTest;

public class Tema30 extends BaseTest {

	@Test
	public void verifyBlog() throws InterruptedException {
		MenuPage menu =  new MenuPage(driver);
					
		menu.click(menu.blogPageLink);
		
		List<WebElement> blogListItems = driver.findElements(By.cssSelector("article[id]"));		
		assertEquals(blogListItems.size(),4);
		 for (int i = 0; i < blogListItems.size(); i++) {			 
			 
			 WebElement titleSection = blogListItems.get(i).findElement(By.cssSelector("h2[class='entry-title'] a"));
			 titleSection.click();
			 Thread.sleep(2000);
			 
			 BlogPage bpage = new BlogPage(driver);
			 bpage.commentSection.sendKeys("hey");
	
			 
			 
			 
		 }
	
	  
	}
	
}
