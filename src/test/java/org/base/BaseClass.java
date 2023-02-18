package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Ramesh Riyo
 * @Date 18-01-2023
 * @see to maintain all reusable methods
 *
 */
public class BaseClass {

	// private static final WebElement WebElement = null;
	/**
	 * @see maintains to launch browsers
	 */
	public static WebDriver driver;

	public static void getDriver(String browserType) {
		switch (browserType) {

		case "chrome":

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "ie":

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			break;
		default:
			break;
		}

	}

	/**
	 * @see maintain to enter url in a browser
	 * 
	 * @param url
	 */
	public static void enterAppUrl(String url) {
		driver.get(url);
	}

	/**
	 * @see maintain to maximize window
	 */
	public static void maximizeWindow() {
		driver.manage().window().maximize();

	}

	/**
	 * @see maintain to perform tab by using Robot class
	 * @throws AWTException
	 */
	public void robotTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	/**
	 * @see maintain to perform enter by using Robot class
	 * @throws AWTException
	 */
	public void robotEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * @see maintains to send values to elements
	 * @param element
	 * @param text
	 */
	public static void elementSendKeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	/**
	 * see maintains to send values to elements by using JvavScriptExecutor
	 * 
	 * @param element
	 * @param text
	 */
	public void elementSendKeysJs(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arugument[0].setattribute('value','" + text + "')", element);

	}

	/**
	 * @see maintains to perform click by using JavaScriptExecutor
	 */
	public void clickByJs() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[o].click(), element");

	}

	/**
	 * @ see maintains to perform click elements
	 * 
	 * @param element
	 */
	public void elementClick(WebElement element) {
		element.click();
	}

	/**
	 * @see maintains to clear textbox
	 * @param element
	 */
	public void elementClear(WebElement element) {
		element.clear();
		;
	}

	/**
	 * @see maintain to get application title
	 * @return String
	 */
	public static String getAppTittle() {
		String title = driver.getTitle();
		return title;

	}

	/**
	 * @see maintains to close particular window
	 */
	public void closeWindow() {
		driver.close();
	}

	/**
	 * @see maintains to close all windows
	 */
	public static void quitWindow() {
		driver.quit();
	}

	/**
	 * @see maintains to get text from elements
	 * @param element
	 * @return String
	 */
	public String elementGetText(WebElement element) {
		String text = element.getText();
		return text;
	}

	// 99% value
	/**
	 * @see maintains to get values from elements
	 * @param element
	 * @return
	 */
	public static String elementGetAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	// remaining 1%
	/**
	 * @see maintains to get values from elements
	 * @param element
	 * @param attributeName
	 * @return
	 */
	public String elementGetAttribute(WebElement element, String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

	/**
	 * 
	 * @param attributevalue
	 * @return WebElement
	 * @see maintains to get webelement locators by id
	 */
	public WebElement findelementById(String attributevalue) {
		WebElement element = driver.findElement(By.id(attributevalue));
		return element;
	}

	/**
	 * 
	 * @param attributevalue
	 * @return WebElement
	 * @see maintains to get webelement locators by name
	 * 
	 */
	public WebElement findelementByName(String attributevalue) {
		WebElement element = driver.findElement(By.name(attributevalue));
		return element;
	}

	/**
	 * 
	 * @param attributevalue
	 * @return WebElement
	 * @see maintains to get webelement locators by classname
	 */
	public WebElement findelementByClassName(String attributevalue) {
		WebElement element = driver.findElement(By.className(attributevalue));
		return element;
	}

	/**
	 * 
	 * @param attributevalue
	 * @return WebElement
	 * @see maintains to get webelement locators by xpath
	 */
	public WebElement findelementByXpath(String attributevalue) {
		WebElement element = driver.findElement(By.xpath(attributevalue));
		return element;
	}

	/**
	 * @see maintains to rightclick by using action class
	 */
	public void rightClick() {
		Actions action = new Actions(driver);
		action.contextClick().perform();
	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @see maintain to select options by visible text
	 */
	public void selectOptionByText(WebElement element, String text) {
		Select Select = new Select(element);
		Select.selectByVisibleText(text);
	}

	/**
	 * 
	 * @param element
	 * @param valve
	 * @see maintain to select options by value
	 */
	public void SelectoptionByValue(WebElement element, String valve) {
		Select Select = new Select(element);
		Select.selectByValue(valve);
	}

	/**
	 * 
	 * @param element
	 * @param index
	 * @see maintain to select options by index
	 */
	public void selectOptionByIndex(WebElement element, int index) {
		Select Select = new Select(element);
		Select.selectByIndex(index);
	}

	/**
	 * 
	 * @return Alert maintains to accept alert by alert class
	 */
	public Alert alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return alert;
	}

	/**
	 * 
	 * @return Alert
	 * @see maintain to cancel alert by using alert class
	 */
	public Alert alertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		return alert;
	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @see maintains to send datas to text box
	 */
	public void alertSendKeys(WebElement element, String text) {
		Alert al = driver.switchTo().alert();
		al.sendKeys("value");
	}

	/**
	 * 
	 * @return String
	 * @see maintains to get or print current url
	 */
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	/**
	 * @see maintains to refresh the window
	 */
	public void refreshPage() {
		driver.navigate().refresh();
	}

	/**
	 * @see maintains to move to previous page
	 */
	public void back() {
		driver.navigate().back();
	}

	/**
	 * @see maintains to move to next page
	 */
	public void forward() {
		driver.navigate().forward();
	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @see maintains to deselect drop down option by visible text
	 */
	public void deSelectoptionByText(WebElement element, String text) {
		Select Select = new Select(element);
		Select.deselectByVisibleText(text);
	}

	/**
	 * 
	 * @param element
	 * @param valve
	 * @see maintains to deselect drop down option by attributr value
	 */
	public void deSelectoptionByAttribute(WebElement element, String valve) {
		Select Select = new Select(element);
		Select.deselectByValue(valve);
	}

	/**
	 * 
	 * @param element
	 * @param index
	 * @see maintains to deselect drop down option by index value
	 */
	public void deSelectoptionByIndex(WebElement element, int index) {
		Select Select = new Select(element);
		Select.deselectByIndex(index);
	}

	/**
	 * 
	 * @param element
	 * @see maintains to deselect all drop down options
	 */
	public void deSelectAll(WebElement element) {
		Select Select = new Select(element);
		Select.deselectAll();
	}

	/**
	 * 
	 * @param element
	 * @return boolean
	 * @see maintains to display webelement is present or not
	 */
	public boolean isDisplayed(WebElement element) {
		boolean c = element.isDisplayed();
		return c;
	}

	/**
	 * 
	 * @param element
	 * @return boolean
	 * @see maintains to check webelement is clickable or not
	 */
	public boolean isEnabled(WebElement element) {
		boolean c = element.isEnabled();
		return c;

	}

	/**
	 * 
	 * @param element
	 * @return boolean
	 * @see to check radio button or checkbox is selected or not
	 */
	public boolean isSelected(WebElement element) {
		boolean c = element.isSelected();
		return c;

	}

	/**
	 * @see maintains to wait 20sec to find the locator
	 */
	public void implicityWait() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	/**
	 * @see maintains to wait 10sec to find locator
	 */
	@SuppressWarnings("unused")
	public void explicitWait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	/**
	 * @see maintains to wait in interval of 10/2 will check the locator is found or
	 *      not
	 */
	@SuppressWarnings("unused")
	public void fluentwait() {
		Wait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(Throwable.class);

	}

	/**
	 * @see maintain to write in a excel sheet
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public void writeCellData(String sheetName, int rownum, int cellnum, String data) throws IOException {
		File file = new File("C:\\Users\\Ramesh Riyo\\eclipse-workspace\\FrameWork1\\excelSheet\\Book1.xlsx");
		FileInputStream fileinputstream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileinputstream);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream fileoutputstream = new FileOutputStream(file);
		workbook.write(fileoutputstream);

	}

	/**
	 * @see maintains to update cell value in excel sheet
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @param oldData
	 * @param newData
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public void updateCellData(String sheetName, int rownum, int cellnum, String oldData, String newData)
			throws IOException {

		File file = new File("C:\\Users\\Ramesh Riyo\\eclipse-workspace\\FrameWork1\\excelSheet\\Book1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);

		String value = cell.getStringCellValue();
		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}

	/**
	 * @see maintains to read or get cell value from excel sheet
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public String getCellValue(String sheetName, int rownum, int cellnum) throws IOException {

		String res = " ";
		File file = new File("C:\\Users\\Ramesh Riyo\\eclipse-workspace\\FrameWork1\\excelSheet\\Book1.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();

		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				res = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long check = Math.round(numericCellValue);
				if (check == numericCellValue) {
					res = String.valueOf(numericCellValue);
				} else {
					res = String.valueOf(check);
				}
				break;
			}
		default:
			break;
		}
		return res;
	}

	// get path of project
	/**
	 * 
	 * @return String
	 * @see maintains to get project path
	 */
	public String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	// to read values in properties file
	/**
	 * 
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @see maintains to get or read propert file values
	 */
	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\Config\\config.properties"));
		Object object = properties.get(key);
		String string = (String) object;
		return string;

	}

	/**
	 * 
	 * @return byte
	 * @see maintains to take screenshot
	 */
	public byte[] screenShot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] file = ts.getScreenshotAs(OutputType.BYTES);
		return file;

	}

}