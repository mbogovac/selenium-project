package vivify.zadatak;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import vivify.zadatak.pages.LoginPage;

public class LogoutUITest {

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
    } 
    
    @Test(priority = 0)
    public void logoutGetText()
    {
    	LoginPage lp = new LoginPage(driver);
    	
        String expText = "Logout";
        String actText = lp.LogoutButton().getText();
        
        Assert.assertEquals(expText, actText);
        System.out.println(actText);
    }
    
    @Test(priority = 1)
    public void logoutIsCentered()
    {
    	LoginPage lp = new LoginPage(driver);
    	
        String rightAlignment = lp.LogoutButton().getCssValue("padding-right");
        String leftAlignment = lp.LogoutButton().getCssValue("padding-left");
        
        Assert.assertEquals(rightAlignment, leftAlignment);
        
        driver.quit();
    }
}
