package org.helper;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseNewYork {

	public static WebDriver driver;

	public static void browserLaunch() {
		driver = new ChromeDriver();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void maxWin() {
		driver.manage().window().maximize();
	}

	public static void waitTime() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void passValue(WebElement webEleRef, String value) {
		webEleRef.sendKeys(value);
	}

	public static void clickbtn(WebElement webEleRef) {
		webEleRef.click();
	}

	public static int tableRowSize(WebElement webEleRef) {
		List<WebElement> rows = webEleRef.findElements(By.tagName("tr"));
		return rows.size();
	}
}
