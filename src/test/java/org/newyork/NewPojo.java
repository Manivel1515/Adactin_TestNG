package org.newyork;

import org.helper.BaseNewYork;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPojo extends BaseNewYork {

	public NewPojo() {
		PageFactory.initElements(driver, this);
	}

	public @FindBy(xpath = "//input[@type='search']") WebElement search;
	public @FindBy(tagName = "tbody") WebElement table;

	public WebElement getSearch() {
		return search;
	}

	public WebElement getTable() {
		return table;
	}
}
