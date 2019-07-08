package selenium;

import base.*;
import org.testng.*;
import org.testng.annotations.*;
import pages.*;

public class PollTest extends SeleniumBaseTest {

	@Test
	public void pollTest() {
		PollForm form = new PollForm(getWebDriver());
		form.clickSubmitButton();

		// poll page
		form = new PollForm(getWebDriver());
		form.selectAnswerForQuestion1And4ByIndex(2);
		form.selectAnswerForQuestion2(3);
		form.selectAnswerForQuestion3and5();
		// click submit button
		form.clickSubmitButton();

		// result page
		form = new PollForm(getWebDriver());
		form.clickContinueButton();

		// next poll
		form = new PollForm(getWebDriver());
		form.selectAnswerForQuestion1And4ByIndex(2);
		form.selectAnswerForQuestion1And4ByIndex(1);
		form.selectAnswerForQuestion3and5();
		form.selectAnswerForQuestion3and5();
		form.clickSubmitButton();

		// result page
		form = new PollForm(getWebDriver());
		form.clickContinueButton();

		// next poll
		form = new PollForm(getWebDriver());
		for (int i = 0; i < 4; i++){
			form.selectAnswerForQuestion6("" + i, i+1);
			form.selectAnswerForQuestion7("" + i, i+2);
		}
		for (int i = 0; i < 4; i++) {
			form.selectAnswerForQuestion8(i, "3");
			form.selectAnswerForQuestion9(i, "1");
		}
		form.clickSubmitButton();

		// result page
		form = new PollForm(getWebDriver());
		form.clickContinueButton();

		// next poll
		form = new PollForm(getWebDriver());
		form.selectAnswerForQuestion10();
		form.clickSubmitButton();

		// result page
		form = new PollForm(getWebDriver());
		form.clickContinueButton();

		// next poll
		form = new PollForm(getWebDriver());
		form.selectAnswerForQuestion11();
		form.setAnswerForQusetion12("lalala");
		form.clickSubmitButton();

		// result page
		form = new PollForm(getWebDriver());
		form.clickContinueButton();

		form = new PollForm(getWebDriver());
		String actualMessage = form.getMessage();
		String expectedMessage = "a really short message -thanks";

		Assert.assertEquals(actualMessage,expectedMessage);
	}


}

