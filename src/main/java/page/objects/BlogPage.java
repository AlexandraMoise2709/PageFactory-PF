package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.utils.SeleniumWrappers;

public class BlogPage extends SeleniumWrappers {

	public BlogPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	 @FindBy(css="[class='comment-form-comment']>textarea")
     public WebElement commentSection;
	
	@FindBy(id="author")
	public WebElement authorSection;
	
	
	@FindBy(id ="email")
	public WebElement emailSection;
	
	@FindBy(css = "[class='comment-form-cookies-consent']>label")
	public WebElement consentCheckBox;
	
	
	
	@FindBy(css = "[class='form-submit']>input")
	public WebElement submitComment;

	
	@FindBy(xpath = "//a[contains(text(),'Alexandra')]")
	public WebElement commentPosted;
	

	
	public void addComment(String comment, String author, String email) {
		
		sendKeys(commentSection, comment);
		sendKeys(authorSection, author);
		sendKeys(emailSection, email);
		click(consentCheckBox);
		click(submitComment);
		
	}


}
