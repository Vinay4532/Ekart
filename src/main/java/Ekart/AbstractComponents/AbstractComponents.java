package Ekart.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	public WebDriver driver;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	////Genereic method for waits
	public void waitforElement(By FindBy)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	////Generic Mehtods for scorll up and down
	public void ScrollUp(WebDriver wait)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.ScrollBy(0,500)");
	}
	public void ScrollDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.ScrollBy(0,-500)");
	}

}
