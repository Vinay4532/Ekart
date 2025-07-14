package Ekart.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Ekart.PageObjects.LandingPage;
import Ekart.TestComponents.BaseTest;

public class SubmitOrder extends BaseTest{
	
	@Test
	public void SubmitOrder() throws IOException, InterruptedException {
		
		launchApplication();
		Thread.sleep(2000);
		LandingPage l1	=	new LandingPage(driver);
		l1.landingPage("pavanol", "test@123");
		//output is obtained
		
		
	}

}
