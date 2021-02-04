package stepDefinitions;

import java.util.concurrent.TimeUnit;
// import org.apache.log4j.Level;
// import org.apache.log4j.Logger;
// import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.GoogleSearchPage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Level;

public class sampleSteps {
	
	private WebDriver driver;
	GoogleSearchPage googleSearch;

	public static Logger logger;

	@Before
	public void setup() {
 		logger=Logger.getLogger("CucumberJava_Demo");
 		PropertyConfigurator.configure("Log4j.properties");
 		logger.setLevel(Level.INFO);
		
		logger.info("********* starting Chrome *************");
	
 		WebDriverManager.chromedriver().setup();	
		ChromeOptions opt = new ChromeOptions();
		opt.setHeadless(true);	
        
//        try {
//          driver = new RemoteWebDriver( new URL("http://selenium__standalone-chrome:4444/wd/hub"), opt);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

		
 		driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("User  launch google browser")
	public void user_launch_google_browser() {
		googleSearch = new GoogleSearchPage(driver);
		googleSearch.openGooglesPage();
		logger.info("********* Open Google *************");

	}

	@When("User  enters {string} in searchbox")
	public void user_enters_in_searchbox(String string) {	
		googleSearch.setSearchField("Laptop");
		logger.info("********* Enter The Item to Search  *************");

	}

	@And("User  clicks on SearchButton")
	public void user_clicks_on_search_button() {
		googleSearch.clickSearchButton();
		logger.info("********* Click Search Button *************");

	}

	@Then("Search results page Title should contain {string}")
	public void search_results_page_title_should_contain(String string) {
		String actualTitle = googleSearch.getSearchPageTitle();
		logger.info("********* Get Search Results Page Title *************");

		Assert.assertTrue(actualTitle.contains("Google Search"));
	}

	@After
	public void close_the_browser() {
		logger.info("********* Close Chrome *************");

		driver.quit();
	}

	

}