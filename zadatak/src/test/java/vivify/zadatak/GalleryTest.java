package vivify.zadatak;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import vivify.zadatak.pages.GalleryPage;
import vivify.zadatak.pages.LoginPage;

public class GalleryTest {

	public String baseUrl = " https://gallery-app.vivifyideas.com/";
    String driverPath = "/Users/mila/Documents/selenium/chromedriver";
    public WebDriver driver = DriverConfig.getWebDriver();
    
   
    @BeforeClass
    public void login()
    {   
    	LoginPage lp = new LoginPage(driver);
    	
    	lp.LoginButton().click();
    	lp.EmailField().sendKeys("bogovac.mila24@gmail.com");
    	lp.PassField().sendKeys("20dinara");
    	lp.SubmitButton().click();
        
    	WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul:nth-child(3) > li:nth-child(3) > a")));
        WebElement logout = driver.findElement(By.cssSelector("ul:nth-child(3) > li:nth-child(3) > a"));
        String expText = "Logout";
        String actText = logout.getText();
        
        Assert.assertEquals(expText, actText);
        System.out.println(actText);
    } 
    
    
    @Test(priority = 0)
    public void createGallery() {
    	GalleryPage gp = new GalleryPage(driver);
    	
    	gp.CreateGallery().click();
    	
    	WebElement naslov = driver.findElement(By.tagName("h1"));
        String expText = "CREATE GALLERY";
        String actText = naslov.getText();
        
        Assert.assertEquals(expText, actText);
        System.out.println(actText);
        
        gp.TitleField().sendKeys("Nova galerija");
        gp.DescriptionField().sendKeys("opis nove galerije");
        gp.UrlField().sendKeys("https://m.media-amazon.com/images/I/81KoSSAwH2L._SL1500_.jpg");
        gp.SubmitButton().click();
        
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid > div:nth-child(1) > h2 > a")));
        
        WebElement titleGallery = driver.findElement(By.cssSelector(".grid > div:nth-child(1) > h2 > a"));
        String expTitle = "Nova galerija";
        String actTitle = titleGallery.getText();
        
        Assert.assertEquals(expTitle, actTitle);
        System.out.println(actTitle);
    }
    
    @Test(priority = 1)
    public void editGallery()
   {	
    	GalleryPage gp = new GalleryPage(driver);
    	gp.LastCreatedGallery().click();
    	gp.EditButton().click();
    	gp.DescriptionField().sendKeys("novi opis");
    	
    	List<WebElement> buttons = driver.findElements(By.tagName("button"));
    	buttons.get(2).click();
    	
    	gp.NewUrlField().sendKeys("https://cdn.shopify.com/s/files/1/0024/9803/5810/products/517525-Product-0-I-637756964607204864_800x800.jpg?v=1658208966");
    	gp.UpwardsArrowButton().click();
    	gp.DownwardArrowButton().click();
    	gp.TrashIcon().click();
    	gp.SubmitButton().click();
    } 
    
    @Test(priority = 2)
    public void commentGallery()
    {
    	GalleryPage gp = new GalleryPage(driver);
    	gp.CommentField().sendKeys("Komentar bla bla bla");
    	gp.SubmitButton().click();
    }
	
    @Test(priority = 3)
    public void deleteGallery()
    {
    	GalleryPage gp = new GalleryPage(driver);
    	gp.DeleteGallery().click();
    	
    	String expTitle = "Are you sure you want to delete gallery?";
        String actTitle = driver.switchTo().alert().getText();
        Assert.assertEquals(expTitle, actTitle);
        System.out.println(actTitle);
        
    	driver.switchTo().alert().accept();
    	
    	driver.quit();
    }
}
