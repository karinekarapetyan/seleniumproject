package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.util.*;
import java.util.concurrent.*;


public class PollForm {
	private WebDriver webDriver;

	public PollForm(WebDriver driver) {
		PageFactory.initElements(driver, this);
		webDriver = driver;
	}

	public void selectAnswerForQuestion1And4ByIndex(int index) {
		List<WebElement> radioList = webDriver.findElements(By.cssSelector(".pst-answer-row-table-tr"));
		radioList.get(index).click();
	}

	public void selectAnswerForQuestion2(int index) {
		WebElement webElement = webDriver.findElement(By.cssSelector("select[id='answer_id']"));
		webElement.click();
		By selector = By.cssSelector("#answer_id > option:nth-child(" + index + ")");
		waitForElementToBeVisible(selector);
		WebElement option = webDriver.findElement(selector);

		option.click();
	}

	public void selectAnswerForQuestion3and5() {
		List<WebElement> elements = webDriver.findElements(By.cssSelector("span .question-image"));
		elements.get(elements.size() - 1).click();
	}

	public void selectAnswerForQuestion6(String rowIndex, int radioIndex) {
		String selector = String.format("#question-79368 [data-pst-answer-index = '%s'] > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(2) input", rowIndex);
		webDriver.findElements(By.cssSelector(selector)).get(radioIndex).click();
	}

	public void selectAnswerForQuestion7(String rowIndex, int radioIndex) {
		String selector = String.format("#question-79371 [data-pst-answer-index = '%s'] > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(2) input", rowIndex);
		webDriver.findElements(By.cssSelector(selector)).get(radioIndex).click();
	}

	public void selectAnswerForQuestion8(int rowIndex, String option) {
		WebElement element = webDriver.findElements(By.cssSelector("#question-79370 > div .ps-answer select")).get(rowIndex);

		Select select = new Select(element);
		select.selectByVisibleText(option);
	}

	public void selectAnswerForQuestion9(int rowIndex, String option) {
		WebElement element = webDriver.findElements(By.cssSelector("#question-79369 > div .ps-answer select")).get(rowIndex);

		Select select = new Select(element);
		select.selectByVisibleText(option);
	}

	public void selectAnswerForQuestion10() {
		WebElement from = webDriver.findElement(By.id("ans_:268870-1"));
		WebElement to = webDriver.findElement(By.id("ans_:268869-1"));
		dragAndDrop(from, to);

	}
	public void selectAnswerForQuestion11() {
		WebElement from = webDriver.findElement(By.id("ans_:268874-1"));
		WebElement to = webDriver.findElement(By.id("ans_:268875-1"));
		dragAndDrop(from, to);
	}

	public String getMessage() {
		WebElement element = webDriver.findElement(By.cssSelector(".ps-acknowledgement"));
		return element.getText();
	}

	public void setAnswerForQusetion12(String text) {
		WebElement textarea = webDriver.findElement(By.id("ps_answer_PSPoll_268868"));
		textarea.sendKeys(text);
	}

	public void clickSubmitButton() {
		WebElement button = webDriver.findElement(By.cssSelector(".ps-vote-button"));
		//scrollToElement(button);
		button.click();
		waitForPollNextForm();

	}

	public void clickContinueButton() {
		By by = By.cssSelector("div.ps-result-continue > input");

		//scrollToElement(button);
		waitForElementToBeVisible(by);
		WebElement button = webDriver.findElement(by);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table")));
		button.click();
		waitForPollNextForm();
	}

	private void waitForPollNextForm() {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	private void waitForElementToBeVisible(By location) {
		new WebDriverWait(webDriver, 10)
			.until(ExpectedConditions.visibilityOfElementLocated(location));
	}

	private void waitForElementToBeVisible(WebElement element) {
		new WebDriverWait(webDriver, 10)
			.until(ExpectedConditions.visibilityOf(element));
	}

	private void scrollToElement(WebElement element) {
		((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	private void dragAndDrop(WebElement from, WebElement to) {
		Actions action = new Actions(webDriver);
		action.dragAndDrop(from, to).perform();
	}
}


