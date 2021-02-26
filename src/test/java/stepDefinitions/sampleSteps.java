package stepDefinitions;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.GoogleSearchPage;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

public class sampleSteps {
	
	private WebDriver driver;
	GoogleSearchPage googleSearch;

	public static Logger logger;

	@Before
	public void setup() {
 		logger=Logger.getLogger(this.getClass());
		BasicConfigurator.configure();
 		logger.setLevel(Level.INFO);		
		logger.info("********* starting Chrome *************");
	
 		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
// 		options.addArguments("headless");
// 		options.addArguments("disable-gpu");
// 		options.addArguments("no-sandbox");
// 		options.addArguments("allow-running-insecure-content");
// 		options.addArguments("ignore-certificate-errors");
// 		options.addArguments("window-size=1920,1080");
// 		options.addArguments("disable-dev-shm-usage"); 
// 		options.addArguments("disable-browser-side-navigation");
// 		options.addArguments("allow-file-access-from-files");
// 		options.addArguments("--disable-plugins");
// 		options.addArguments("--disable-extensions");


		chromeOptions.addArguments("disable-gpu");
		chromeOptions.addArguments("no-sandbox");
		chromeOptions.addArguments("allow-running-insecure-content");
		chromeOptions.addArguments("ignore-certificate-errors");
		chromeOptions.addArguments("window-size=1920,1080");
		chromeOptions.addArguments("disable-dev-shm-usage"); 
		chromeOptions.addArguments("disable-browser-side-navigation");
		chromeOptions.addArguments("allow-file-access-from-files");
		chromeOptions.addArguments("--disable-plugins");
		chromeOptions.addArguments("--disable-extensions");	
		
    chromeOptions.addArguments("headless");
    chromeOptions.addArguments("allow-file-access");
    chromeOptions.addArguments("allow-file-access-from-files");
    chromeOptions.addArguments("disable-background-networking");
    chromeOptions.addArguments("disable-background-timer-throttling");
    chromeOptions.addArguments("disable-breakpad");
    chromeOptions.addArguments("disable-child-account-detection");
    chromeOptions.addArguments("disable-clear-browsing-data-counters");
    chromeOptions.addArguments("disable-client-side-phishing-detection");
    chromeOptions.addArguments("disable-cloud-import");
    chromeOptions.addArguments("disable-component-cloud-policy");
    chromeOptions.addArguments("disable-component-update");
    chromeOptions.addArguments("disable-default-apps");
    chromeOptions.addArguments("disable-download-notification");
    chromeOptions.addArguments("disable-extensions");
    chromeOptions.addArguments("disable-extensions-file-access-check");
    chromeOptions.addArguments("disable-extensions-http-throttling");
    chromeOptions.addArguments("disable-hang-monitor");
    chromeOptions.addArguments("disable-infobars");
    chromeOptions.addArguments("disable-popup-blocking");
    chromeOptions.addArguments("disable-print-preview");
    chromeOptions.addArguments("disable-prompt-on-repost");
    chromeOptions.addArguments("disable-sync");
    chromeOptions.addArguments("disable-translate");
    chromeOptions.addArguments("disable-web-resources");
    chromeOptions.addArguments("disable-web-security");
    chromeOptions.addArguments("dns-prefetch-disable");
    chromeOptions.addArguments("download-whole-document");
    chromeOptions.addArguments("enable-logging");
    chromeOptions.addArguments("enable-screenshot-testing-with-mode");
    chromeOptions.addArguments("ignore-certificate-errors");
    chromeOptions.addArguments("log-level=0");
    chromeOptions.addArguments("metrics-recording-only");
    chromeOptions.addArguments("mute-audio");
    chromeOptions.addArguments("no-default-browser-check");
    chromeOptions.addArguments("no-displaying-insecure-content");
    chromeOptions.addArguments("no-experiments");
    chromeOptions.addArguments("no-first-run");
    chromeOptions.addArguments("no-sandbox");
    chromeOptions.addArguments("no-service-autorun");
    chromeOptions.addArguments("noerrdialogs");
    chromeOptions.addArguments("password-store=basic");
    chromeOptions.addArguments("reduce-security-for-testing");
    chromeOptions.addArguments("safebrowsing-disable-auto-update");
    chromeOptions.addArguments("safebrowsing-disable-download-protection");
    chromeOptions.addArguments("safebrowsing-disable-extension-blacklist");
    chromeOptions.addArguments("start-maximized");
    chromeOptions.addArguments("test-type=webdriver");
    chromeOptions.addArguments("use-mock-keychain");	
		
		
		
		
		        
//        try {
//          driver = new RemoteWebDriver( new URL("http://selenium__standalone-chrome:4444/wd/hub"), options);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

		
 		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("User  launch google browser")
	public void user_launch_google_browser() {
		googleSearch = new GoogleSearchPage(driver);
		googleSearch.openGooglesPage();
		logger.info("********* Open Google *************");
		
		
		String title = driver.getTitle();
		System.out.println(title);
		logger.info("Title is   "+ title );

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
