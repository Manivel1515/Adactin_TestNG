package org.newyork;

import org.helper.BaseNewYork;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewYork extends BaseNewYork {

	@BeforeClass
	private void home() {
		browserLaunch();
		launchUrl("https://www.lambdatest.com/selenium-playground/table-sort-search-demo");
		maxWin();
		waitTime();
	}

	@Test
	private void Page_1() {

		NewPojo n = new NewPojo();
		WebElement search = n.getSearch();
		passValue(search, "new york");
		String att = search.getAttribute("value");
		Assert.assertTrue(att.equalsIgnoreCase("New York"));
		int t = tableRowSize(n.getTable());
		System.out.println(t);
		Assert.assertTrue(t == 5);
	}
}
