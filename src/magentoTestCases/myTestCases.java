package magentoTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases extends parameters {
	@BeforeTest 
	public void myBeforTest () {
		driver.get(TheWebSite);
		
	}
	
	@Test (priority = 1) 
	public void TheTest() throws InterruptedException {
		driver.get(SingUp);
		WebElement firstNameInput =driver.findElement(By.id("firstname"));
		WebElement lastNameInput =driver.findElement(By.id("lastname"));
		WebElement emileInput =driver.findElement(By.id("email_address"));
		WebElement passwordInput =driver.findElement(By.id("password"));
		WebElement confirmPasswordInput =driver.findElement(By.id("password-confirmation"));
	WebElement singUpInput =driver.findElement(By.xpath(Email));
		
		firstNameInput .sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		emileInput.sendKeys(Email);
		passwordInput.sendKeys(password);
		confirmPasswordInput.sendKeys(password);
		singUpInput.click();
		Thread.sleep(2000);
		 String WelcomeMsg =driver.findElement(By.xpath("//div[@class='panel header']")).getText();
		softassert.assertEquals(WelcomeMsg.contains("Welcome"), false,"Validation the signup process");
		softassert.assertAll();
	}
	@Test (priority = 2)
	public void logOut() throws InterruptedException {
		driver.get(logOut);
		Thread.sleep(7000);
		softassert.assertEquals(driver.getCurrentUrl(), TheWebSite,"validation of the website url after the logout");
        softassert.assertAll();

		
	
	}
	@Test (priority = 3)
	public void logIn() {
		driver.get(logIn);
		WebElement emailInput =driver.findElement(By.id("email"));
		WebElement passwordInput =driver.findElement(By.id("pass"));
		WebElement logInButton=driver.findElement(By.id("send2"));


		emailInput.sendKeys(Email);
		passwordInput.sendKeys(password);
		logInButton.click();
	}
	
	@AfterTest
	public void after() {}


	

}
