package org.hotel;
import org.helper.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class AdactinPage_1 extends BaseClass {
	@Parameters("Browser")
	@BeforeClass
	private void homePage(String browserName) {
		if (browserName.equals("1")) {
			browserLaunch(1);
		}else if (browserName.equals("2")) {
			browserLaunch(2);
		}
		else {
			browserLaunch(3);
		}		
		launchUrl("https://adactinhotelapp.com/");
		maxWin();
		waitTime();
	}
	@Test(groups = "Smile", dataProvider = "LoginData")
	private void login(String userName, String pass) {
		LoginPage l = new LoginPage();
		passValue(l.getUserName(), userName);
		passValue(l.getPass(), pass);
		clickbtn(l.getLogin());
	}
	@DataProvider(name = "LoginData")
	private String[][] getData() {
		return new String[][] {
			{ "smart", "1234" },
			{ "java", "Majfh@" }, 
			{ "selenium", "!@#fh" },
			{ "username1515", "Manivel1515" } 
		};
	}
}
