package vivify.zadatak.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GalleryPage {
	WebDriver driver;
	
	public GalleryPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By createGallery = By.xpath("//a[@href='/create']");
	By titleField = By.id("title");
	By descriptionField = By.id("description");
	By urlField = By.xpath("//input[@type='url']");
	By submitButton = By.xpath("//button[@type='submit']");
	
	By lastCreatedGallery = By.cssSelector(".grid > div:nth-child(1) > h2 > a");
	By editButton = By.cssSelector("a.btn-custom");
	By newUrlField = By.xpath("//div[@class='container']/div/div/form/div[3]/div[2]/div/input");
	By upwardsArrowButton = By.xpath("//div[@class='container']/div/div/form/div[3]/div[2]/div/div/button[2]");
	By downwardArrowButton = By.xpath("//div[@class='container']/div/div/form/div[3]/div/div/div/button[3]");
	By trashIcon = By.xpath("//div[@class='container']/div/div/form/div[3]/div[2]/div/div/button[1]");
	
	By commentField = By.tagName("textarea");
	
	By deleteGallery = By.xpath("//div[@class='container']/div/div[2]/button");
	
	public WebElement CreateGallery() {
		return driver.findElement(createGallery);
	}
	
	public WebElement TitleField() {
		return driver.findElement(titleField);
	}
	
	public WebElement DescriptionField() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description")));
		return driver.findElement(descriptionField);
	}
	
	public WebElement UrlField() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='url']")));
		return driver.findElement(urlField);
	}
	
	public WebElement SubmitButton() {
		return driver.findElement(submitButton);
	}
	
	public WebElement LastCreatedGallery() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid > div:nth-child(1) > h2 > a")));
		return driver.findElement(lastCreatedGallery);
	}
	
	public WebElement EditButton() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.btn-custom")));
		return driver.findElement(editButton);
	}
	
	public WebElement NewUrlField() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container']/div/div/form/div[3]/div[2]/div/input")));
		return driver.findElement(newUrlField);
	}
	
	public WebElement UpwardsArrowButton() {
		return driver.findElement(upwardsArrowButton);
	}
	
	public WebElement DownwardArrowButton() {
		return driver.findElement(upwardsArrowButton);
	}
	
	public WebElement TrashIcon() {
		return driver.findElement(trashIcon);
	}
	
	public WebElement CommentField() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("textarea")));
		return driver.findElement(commentField);
	}
	
	public WebElement DeleteGallery() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container']/div/div[2]/button")));
		return driver.findElement(deleteGallery);
	}
}
