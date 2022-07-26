package vivify.zadatak.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	
	By loginButton = By.cssSelector("ul:nth-child(3) > li:nth-child(1)");
	By emailField = By.id("email");
	By passwordField = By.id("password");
	By submitButton = By.xpath("//*[@type = 'submit']");
	
	public WebElement LoginButton() {
		return driver.findElement(loginButton);
	}
	
	public WebElement EmailField() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		return driver.findElement(emailField);
	}
	
	public WebElement PassField() {
		return driver.findElement(passwordField);
	}
	
	public WebElement SubmitButton() {
		return driver.findElement(submitButton);
	}
	
}
