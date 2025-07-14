package Ekart.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ekart.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//a[normalize-space()='Log in'])[1]")
	WebElement loginlink;
	@FindBy(xpath="//input[@id='loginusername']")
	WebElement usernameinputfield;
	@FindBy(xpath="//input[@id='loginpassword']")
	WebElement passwordinputfield;
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement loginbutton;
	
	public void LandingUrl() throws InterruptedException
	{
		driver.get("https://www.demoblaze.com/");
		Thread.sleep(2000);
	}
	public void landingPage(String username ,String password) throws InterruptedException
	{
		loginlink.click();
		Thread.sleep(2000);
		usernameinputfield.sendKeys(username);
		Thread.sleep(2000);
		passwordinputfield.sendKeys(password);
		Thread.sleep(2000);
		loginbutton.click();
	}
	
	

}
