package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import selenium.utils.SeleniumWrappers;

public class BlogPage extends SeleniumWrappers {

	public BlogPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(css="[class='comment-form-comment']")
	public WebElement commentSection;
	
	@FindBy(id="author")
	public WebElement authorSection;
	
	
	@FindBy(id ="email")
	public WebElement emailSection;
	
	@FindBy(id ="wp-comment-cookies-consent")
	public WebElement consentCheckBox;
	
	@FindBy(id ="submit")
	public WebElement submitComment;

	
	public void sendMessage(String name, String author, String email) {
		
		sendKeys(commentSection, name);
		sendKeys(authorSection, author );
		sendKeys(emailSection, email);
		click(consentCheckBox);
		click(submitComment);
		
		
	}
	


}
