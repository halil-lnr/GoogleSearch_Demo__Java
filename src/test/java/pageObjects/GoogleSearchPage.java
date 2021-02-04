package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
private WebDriver driver = null;
	
	By searchBox = By.cssSelector("input.gLFyf.gsfi");
	By searchButton = By.cssSelector("div.aajZCb input.gNO89b");
       
	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void openGooglesPage() {
		driver.get("https://www.google.com/");
// 		driver.navigate().to("https://www.google.com");
	}
	public void setSearchField(String text) {
		driver.findElement(searchBox).click();
		driver.findElement(searchBox).clear();
		driver.findElement(searchBox).sendKeys(text);
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {		
		e.printStackTrace();
	}
	}
	
	public void clickSearchButton() {
		driver.findElement(searchButton).click();
	}
	
	public String  getSearchPageTitle() {
		String title = driver.getTitle();
		return title;
	}

}
