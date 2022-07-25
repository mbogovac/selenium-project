package vivify.zadatak;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GalleryTest {

	public String baseUrl = " https://gallery-app.vivifyideas.com/";
    String driverPath = "/Users/mila/Documents/selenium/chromedriver";
    public WebDriver driver = DriverConfig.getWebDriver();
    
   
    @Test(priority = 0)
    public void login()
    {   
        driver.findElement(By.cssSelector("ul:nth-child(3) > li:nth-child(1)")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        
        driver.findElement(By.id("email")).sendKeys("bogovac.mila24@gmail.com");
        driver.findElement(By.id("password")).sendKeys("20dinara");
        driver.findElement(By.xpath("//*[@type = 'submit']")).click();
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul:nth-child(3) > li:nth-child(3) > a")));
        WebElement logout = driver.findElement(By.cssSelector("ul:nth-child(3) > li:nth-child(3) > a"));
        String expText = "Logout";
        String actText = logout.getText();
        
        Assert.assertEquals(expText, actText);
        System.out.println(actText);
    } 
    
    @Test(priority = 1)
    public void createGallery() {
    	
    	driver.findElement(By.xpath("//a[@href='/create']")).click();
    	
    	WebElement naslov = driver.findElement(By.cssSelector("h1"));
        String expText = "CREATE GALLERY";
        String actText = naslov.getText();
        
        Assert.assertEquals(expText, actText);
        System.out.println(actText);
        
        driver.findElement(By.id("title")).sendKeys("Nova galerija");
        driver.findElement(By.id("description")).sendKeys("opis nove galerije");
        driver.findElement(By.xpath("//input[@type='url']")).sendKeys("https://m.media-amazon.com/images/I/81KoSSAwH2L._SL1500_.jpg");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid > div:nth-child(1) > h2 > a")));
        
        WebElement titleGallery = driver.findElement(By.cssSelector(".grid > div:nth-child(1) > h2 > a"));
        String expTitle = "Nova galerija";
        String actTitle = titleGallery.getText();
        
        Assert.assertEquals(expTitle, actTitle);
        System.out.println(actTitle);
    }
    
    @Test(priority = 2)
    public void editGallery()
   {	
    	driver.findElement(By.cssSelector(".grid > div:nth-child(1) > h2 > a")).click();

    	WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.btn-custom")));
    	driver.findElement(By.cssSelector("a.btn-custom")).click();
    	
    	
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description")));
    	driver.findElement(By.id("description")).sendKeys("novi opis");
    	
    	
    	List<WebElement> buttons = driver.findElements(By.tagName("button"));
    	buttons.get(2).click();
    	
    	driver.findElement(By.xpath("//div[@class='container']/div/div/form/div[3]/div[2]/div/input")).sendKeys("https://cdn.shopify.com/s/files/1/0024/9803/5810/products/517525-Product-0-I-637756964607204864_800x800.jpg?v=1658208966");
    	driver.findElement(By.xpath("//div[@class='container']/div/div/form/div[3]/div[2]/div/div/button[2]")).click();
    	driver.findElement(By.xpath("//div[@class='container']/div/div/form/div[3]/div/div/div/button[3]")).click();
    	driver.findElement(By.xpath("//div[@class='container']/div/div/form/div[3]/div[2]/div/div/button[1]")).click();
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
    } 
    
    @Test(priority = 3)
    public void commentGallery()
    {
    	WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("textarea")));
    	driver.findElement(By.tagName("textarea")).sendKeys("Komentar bla bla bla");
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
	
    @Test(priority = 4)
    public void deleteGallery()
    {
    	driver.findElement(By.xpath("//div[@class='container']/div/div[2]/button")).click();
    	
    	String expTitle = "Are you sure you want to delete gallery?";
        String actTitle = driver.switchTo().alert().getText();
        Assert.assertEquals(expTitle, actTitle);
        System.out.println(actTitle);
        
    	driver.switchTo().alert().accept();
    }
}
