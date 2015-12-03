package step_definitions;

import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.net.MalformedURLException;
import java.net.URL;


public class Hooks{
    public static WebDriver driver;

    String browser = "firefox";
    String os = "WINDOWS";
    String version="36.0";
    
    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
  /*  public void openBrowser() throws MalformedURLException {
    	System.out.println("Called openBrowser");
    	driver = new FirefoxDriver();
    	driver.manage().deleteAllCookies();
    }*/

    public void setup() throws MalformedURLException,     InterruptedException {
    	DesiredCapabilities capability=null;
    	capability = gridStting(browser, version, os);
    	
    	//Give Node_IP:Node 
    	driver = new RemoteWebDriver(new URL("http://192.168.8.69:5566/wd/hub"), capability);
    	
    	}
 
    
    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {
       
        if(scenario.isFailed()) {
        try {
        	 scenario.write("Current Page URL is " + driver.getCurrentUrl());
//            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        
        }
        driver.quit();
        
    }
    
    
    
    public DesiredCapabilities gridStting(String browser, String version, String os){
    	DesiredCapabilities capability=null;
    	if(browser.equals("firefox")){
    	System.out.println("Test scripts running on firefox");
    	capability= DesiredCapabilities.firefox();
    	capability.setBrowserName("firefox");
    	capability.setVersion(version);
    	
    	}
    	if(browser.equals("iexplore")){
    	System.out.println("Test scripts running on iexplore");
    	capability= DesiredCapabilities.internetExplorer();
    	capability.setBrowserName("iexplore");
    	System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
    	capability.setVersion(version);
    	}
    	if(os.equals("WINDOWS")){
    	capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
    	}
    	else if(os.equals("XP")){
    	capability.setPlatform(org.openqa.selenium.Platform.XP);
    	}
    	else if(os.equals("Linux")){
    	capability.setPlatform(org.openqa.selenium.Platform.LINUX);
    	}
    	else{
    	capability.setPlatform(org.openqa.selenium.Platform.ANY);
    	}
    	return capability;
    	}
    	      }

