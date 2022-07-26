package vivify.zadatak;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import vivify.zadatak.pages.LoginPage;

public class GalleryAppLoginTest {


    public String baseUrl = " https://gallery-app.vivifyideas.com/";
    String driverPath = "/Users/mila/Documents/selenium/chromedriver";
    public WebDriver driver = DriverConfig.getWebDriver();

    
    @Test
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
        
        driver.quit();
    }
	
}
