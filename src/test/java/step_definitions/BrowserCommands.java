package step_definitions;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
public class BrowserCommands{
    public WebDriver driver;
    public BrowserCommands()
    {
    	driver = Hooks.driver;
    }
    @Given("^open reddit website$")
    public void i_open_reddit_website() throws Throwable {
        driver.get("https://www.reddit.com");
        driver.manage().window().maximize();
    }
    @And("^he navigate to new link$")
    public void he_navigate_to_new_link() throws Throwable {
     //   WebDriverWait wait = new WebDriverWait(driver,10);
       // wait.ignoring(WebDriverException.class);
        //wait.ignoring(StaleElementReferenceException.class);
    //    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='header-bottom-left']/ul/li[2]/a")));
        driver.findElement(By.xpath(".//*[@id='header-bottom-left']/ul/li[2]/a")).click();
    }
    @Then("^he can nevigate new post$")
    public void he_can_nevigate_new_post() throws Throwable {
       System.out.println("Browser title-"+driver.getTitle());
    }
    @Then("^I perform selenium browser commands$")
    public void i_perform_selenium_browser_commands() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.reddit.com");
        System.out.println("Printing website title...");
        System.out.println(driver.getTitle());
        System.out.println("Printing current title...");
        System.out.println(driver.getCurrentUrl());
        System.out.println("Printing page source.....");
        System.out.println(driver.getPageSource());
        System.out.println("Clicking New link...");
        driver.findElement(By.xpath(".//*[@id='header-bottom-left']/ul/li[2]/a")).click();
        driver.navigate().back();
        driver.navigate().forward();
        System.out.println("Printing title again...");
        System.out.println(driver.getTitle());
        System.out.println("Refreshing the browser");
        driver.navigate().refresh();
        System.out.println("Exiting the browser now");
    }
}