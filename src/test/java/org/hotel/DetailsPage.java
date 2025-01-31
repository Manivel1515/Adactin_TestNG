package org.hotel;
import org.helper.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DetailsPage extends BaseClass {
	public DetailsPage() {
		PageFactory.initElements(driver, this);
	}
	public @FindBy(id = "first_name") WebElement firstName;
	public @FindBy(id = "last_name") WebElement lastName;
	public @FindBy(id = "address") WebElement address;
	public @FindBy(id = "cc_num") WebElement ccNum;
	public @FindBy(id = "cc_type") WebElement ccType;
	public @FindBy(id = "cc_exp_month") WebElement expMonth;
	public @FindBy(id = "cc_exp_year") WebElement expYear;
	public @FindBy(id = "cc_cvv") WebElement cvv;
	public @FindBy(id = "book_now") WebElement book;
	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCcNum() {
		return ccNum;
	}

	public WebElement getCcType() {
		return ccType;
	}

	public WebElement getExpMonth() {
		return expMonth;
	}

	public WebElement getExpYear() {
		return expYear;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getBook() {
		return book;
	}
}
