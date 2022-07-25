package vivify.zadatak;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverConfig {


    public static String baseUrl = " https://gallery-app.vivifyideas.com/";
    public static String driverPath = "/Users/mila/Documents/selenium/chromedriver";
    public static WebDriver driver;
    
	public static WebDriver getWebDriver() {
		
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        
        return driver;

	}
}
