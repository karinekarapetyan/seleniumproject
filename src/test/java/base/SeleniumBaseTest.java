package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.lang.reflect.*;


public class SeleniumBaseTest {
	private WebDriver webDriver;
	private PageFactory pageFactory;
	private Wait wait;
	private Actions actions;
	private final String url = "https://stage1-vote.pollstream.com/8610";

	@BeforeMethod(alwaysRun = true)
	public void setUpSelenium(Method method) {
		System.setProperty("webdriver.chrome.driver",
			"src/main/resources/drivers/chromedriver-mac-64bit");
		webDriver = new ChromeDriver();
		//webDriver = new FirefoxDriver();
		pageFactory = new PageFactory();
		//wait = new Wait(webDriver);
		actions = new Actions(webDriver);

		//webDriver.navigate().to(url);
		webDriver.get(url);
	}

	@AfterMethod(alwaysRun = true)
	public final void tearDownSelenium() {
		webDriver.quit();
	}


	public WebDriver getWebDriver() {
		return webDriver;
	}

	public PageFactory getPageFactory() {
		return pageFactory;
	}

	public Wait getWait() {
		return wait;
	}

	public Actions getActions() {
		return actions;
	}


}

