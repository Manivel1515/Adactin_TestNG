package org.helper;

import java.io.File;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static Alert al;

	public static void browserLaunch(int a) {
		if (a == 1) {
			driver = new ChromeDriver();
		} else if (a == 2) {
			driver = new FirefoxDriver();
		} else if (a == 3) {
			driver = new EdgeDriver();
		}

	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void maxWin() {
		driver.manage().window().maximize();
	}

	public static void newWindow(WindowType WindowType) {

		driver.switchTo().newWindow(WindowType);
	}

	public static void prtUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void prtTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void passValue(WebElement webEleRef, String value) {
		webEleRef.sendKeys(value);
	}

	public static void jsPassValue(WebElement webEleRef, String value) {
		js.executeScript("arguments[0].setAttribute('value','" + value + "')", webEleRef);
	}

	public static void clickbtn(WebElement webEleRef) {
		webEleRef.click();
	}

	public static void jsclick(WebElement webEleRef) {
		js.executeScript("arguments[0].click();", webEleRef);
	}

	public static void moveToElement(WebElement target) {
		a = new Actions(driver);
		a.moveToElement(target).perform();
	}

	public void frameSelect(int index) {
		driver.switchTo().frame(index);
	}

	public void frameSelect(String name) {
		driver.switchTo().frame(name);
	}

	public void frameSelect(WebElement webRef) {
		driver.switchTo().frame(webRef);
	}

	public static void dragDrop(WebElement source, WebElement target) {
		a.dragAndDrop(source, target).perform();
	}

	public static void doubleClick(WebElement target) {
		a.doubleClick(target).perform();
	}

	public static void rightClick(WebElement target) {
		a.contextClick(target).perform();
	}

	public static void keyPress(int keycode) throws AWTException {
		r = new Robot();
		r.keyPress(keycode);
	}

	public static void keyRelease(int keycode) throws AWTException {
		r.keyRelease(keycode);
	}

	public static void keyPrint(int keycode) throws AWTException {
		r.keyPress(keycode);
		r.keyRelease(keycode);
	}

	public static void waitTime() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void snap(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\CHITHAMBARAM\\Eclipse\\Adactin\\ScreenShots\\" + fileName + ".png");
		FileUtils.copyFile(src, des);
	}

	public static void Alert(boolean a, String alert) {
		al = driver.switchTo().alert();
		if (a == true && alert.isEmpty()) {
			al.accept();
		} else if (a == false && alert.isEmpty()) {
			al.dismiss();
		} else {
			if (a == true) {
				al.sendKeys(alert);
				al.accept();
			} else if (a == false) {
				al.sendKeys(alert);
				al.dismiss();
			}
		}
	}

	public static JavascriptExecutor js;

	public static void pageScroll(boolean z, WebElement webRefName) {
		js = (JavascriptExecutor) driver;
		if (z) {
			js.executeScript("arguments[0].scrollIntoView(true)", webRefName);
		} else {
			js.executeScript("arguments[0].scrollIntoView(false)", webRefName);
		}

	}

	public static void switchWindow(int indexno) {
		Set<String> all = driver.getWindowHandles();
		List<String> list = new LinkedList<String>();
		list.addAll(all);
		String w = list.get(indexno);
		driver.switchTo().window(w);
	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static Select s;

	public static void dropDown(WebElement webEleRef, int index) {
		s = new Select(webEleRef);
		s.selectByIndex(index);
	}

	public static void dropDown(WebElement webEleRef, String value) {
		s = new Select(webEleRef);
		s.selectByValue(value);
	}

	public static void dropDown(String text, WebElement webEleRef) {
		s = new Select(webEleRef);
		s.selectByVisibleText(text);
	}

	public static List<WebElement> table(WebElement webEleRef) {
		List<WebElement> lis = new ArrayList<WebElement>();
		List<WebElement> rows = webEleRef.findElements(By.tagName("tr"));
		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);
			List<WebElement> datas = row.findElements(By.tagName("td"));
			for (int j = 0; j < datas.size(); j++) {
				WebElement data = datas.get(j);
				lis.add(data);
			}
		}

		return lis;
	}

	public static int tableRowSize(WebElement webEleRef) {
		List<WebElement> rows = webEleRef.findElements(By.tagName("tr"));
		return rows.size();
	}

	public static String readFile(String fileName, String sheetName, int rowNum, int cellNum, String format)
			throws IOException {
		File f = new File("C:\\Users\\CHITHAMBARAM\\Eclipse\\Adactin\\Excel\\" + fileName + ".xlsx");
		FileInputStream fileIn = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fileIn);
		Sheet sh = book.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value;
		int type = cell.getCellType();
		if (type == 1) {
			value = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();
			SimpleDateFormat fr = new SimpleDateFormat(format);
			value = fr.format(date);
		} else {
			double doble = cell.getNumericCellValue();
			long l = (long) doble;
			value = String.valueOf(l);
		}
		return value;
	}

	public static List<String> readFiles(String fileName, String sheetName, String format) throws IOException {
		File f = new File("C:\\Users\\CHITHAMBARAM\\Eclipse\\Adactin\\Excel\\" + fileName + ".xlsx");
		FileInputStream fileIn = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fileIn);
		Sheet sh = book.getSheet(sheetName);
		String value;
		List<String> li = new ArrayList<String>();
		for (int i = 0; i < sh.getPhysicalNumberOfRows(); i++) {
			Row row = sh.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				int typ = cell.getCellType();
				if (typ == 1) {
					value = cell.getStringCellValue();
				} else if (DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					SimpleDateFormat fr = new SimpleDateFormat(format);
					value = fr.format(date);
				} else {
					double doble = cell.getNumericCellValue();
					long l = (long) doble;
					value = String.valueOf(l);
				}
				li.add(value);
			}
		}
		return li;
	}

	public static List<String> singleRow(String fileName, String sheetName, String format, int rowNum)
			throws IOException {
		File f = new File("C:\\Users\\CHITHAMBARAM\\Eclipse\\Adactin\\Excel\\" + fileName + ".xlsx");
		FileInputStream fileIn = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fileIn);
		Sheet sh = book.getSheet(sheetName);
		String value;
		List<String> li = new ArrayList<String>();

		Row row = sh.getRow(rowNum);
		for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
			Cell cell = row.getCell(j);
			int typ = cell.getCellType();
			if (typ == 1) {
				value = cell.getStringCellValue();
			} else if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat fr = new SimpleDateFormat(format);
				value = fr.format(date);
			} else {
				double doble = cell.getNumericCellValue();
				long l = (long) doble;
				value = String.valueOf(l);
			}
			li.add(value);
		}

		return li;
	}

	public static List<String> singleColumn(String fileName, String sheetName, String format, int columnNum)
			throws IOException {
		File f = new File("C:\\Users\\CHITHAMBARAM\\Eclipse\\Adactin\\Excel\\" + fileName + ".xlsx");
		FileInputStream fileIn = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fileIn);
		Sheet sh = book.getSheet(sheetName);
		String value;
		List<String> li = new ArrayList<String>();
		for (int i = 0; i < sh.getPhysicalNumberOfRows(); i++) {
			Row row = sh.getRow(i);
			Cell cell = row.getCell(columnNum);
			int typ = cell.getCellType();
			if (typ == 1) {
				value = cell.getStringCellValue();
			} else if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat fr = new SimpleDateFormat(format);
				value = fr.format(date);
			} else {
				double doble = cell.getNumericCellValue();
				long l = (long) doble;
				value = String.valueOf(l);
			}
			li.add(value);
		}
		return li;
	}

	public static int numOfRows(String fileName, String sheetName) throws IOException {
		File f = new File("C:\\Users\\CHITHAMBARAM\\Eclipse\\Adactin\\Excel\\" + fileName + ".xlsx");
		FileInputStream fileIn = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fileIn);
		Sheet sh = book.getSheet(sheetName);
		int n = sh.getPhysicalNumberOfRows();
		return n;

	}

	public static int numOfCells(String fileName, String sheetName) throws IOException {
		File f = new File("C:\\Users\\CHITHAMBARAM\\Eclipse\\Adactin\\Excel\\" + fileName + ".xlsx");
		FileInputStream fileIn = new FileInputStream(f);
		int c = 0;
		Workbook book = new XSSFWorkbook(fileIn);
		Sheet sh = book.getSheet(sheetName);
		int n = sh.getPhysicalNumberOfRows();
		for (int i = 0; i < n; i++) {
			Row row = sh.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				cell.getCellType();
				c++;
			}
		}

		return c;
	}

	public static void writeData(String fileName, String sheetName, int rowNum, List<String> list) throws IOException {
		File file = new File("C:\\Users\\CHITHAMBARAM\\Eclipse\\Adactin\\Excel\\" + fileName + ".xlsx");
		FileInputStream in = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(in);
		Sheet sh = book.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		if (row == null) {
			row = sh.createRow(rowNum);
		}
		int size = list.size();
		for (int i = 0; i < size; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(list.get(i));
		}
		FileOutputStream fos = new FileOutputStream(file);
		book.write(fos);
	}

}
