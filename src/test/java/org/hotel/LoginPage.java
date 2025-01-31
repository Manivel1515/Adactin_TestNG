package org.hotel;
//PojoClass
import org.helper.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public @FindBy(id = "username") WebElement userName;
	public @FindBy(id = "password") WebElement pass;
	public @FindBy(id = "login") WebElement login;
	public @FindBy(xpath = "//strong[text()='Go to Build 2 ']") WebElement build;

	public WebElement getBuild() {
		return build;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getLogin() {
		return login;
	}

}
