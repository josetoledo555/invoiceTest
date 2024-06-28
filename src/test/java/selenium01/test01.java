package selenium01;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test01 {


WebDriver driver;
@BeforeMethod
public void initDriver() {
	driver = new ChromeDriver ();
	driver.get("https://mystore-abc123.000webhostapp.com/");
}

@Test
public void testSuccessInvoice() throws IOException {
	System.out.println("testSuccessInvoice");
	WebElement invoice= driver.findElement(By.id("invoice"));
	WebElement date = driver.findElement(By.id("date"));
	WebElement product = driver.findElement(By.id("product"));
	WebElement quantity = driver.findElement(By.id("quantity"));
	WebElement amount = driver.findElement(By.id("amount"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

	invoice.sendKeys("abc123");
	date.sendKeys("06/29/2024");
	product.sendKeys("iPhone");
	quantity.sendKeys("1");
	amount.sendKeys("$1000.00");
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	submitBtn.click();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	
		
	TakesScreenshot scrSht = (TakesScreenshot)driver;
	File srcFile = scrSht.getScreenshotAs(OutputType.FILE);
	
	File DestFile = new File("C:/tmp/testSuccessInvoice.png");
	FileUtils.copyFile(srcFile, DestFile);

	WebElement message = driver.findElement(By.id("message"));
	
	String invoiceText=invoice.getText();
	Assert.assertEquals(invoiceText,"");
	
	String messageText= message.getText();
	Assert.assertEquals(messageText, "SUCCESS MESSAGE, invoice abc123 has been created");
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));	
}

@Test
public void testInvoiceMandatoryField() throws IOException {
	System.out.println("testMandatoryField");
	WebElement invoice= driver.findElement(By.id("invoice"));
	WebElement date = driver.findElement(By.id("date"));
	WebElement product = driver.findElement(By.id("product"));
	WebElement quantity = driver.findElement(By.id("quantity"));
	WebElement amount = driver.findElement(By.id("amount"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

	date.sendKeys("06/29/2024");
	product.sendKeys("iPhone");
	quantity.sendKeys("1");
	amount.sendKeys("$1000.00");

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	submitBtn.click();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	
	TakesScreenshot scrSht = (TakesScreenshot)driver;
	File srcFile = scrSht.getScreenshotAs(OutputType.FILE);
	
	File DestFile = new File("C:/tmp/testInvoiceMandatoryField.png");
	FileUtils.copyFile(srcFile, DestFile);

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));	
	
	WebElement message = driver.findElement(By.id("message"));
	
	String invoiceText=invoice.getText();
	Assert.assertEquals(invoiceText,"");
	
	String messageText= message.getText();
	Assert.assertEquals(messageText, "ERROR: Missing invoice, mandatory field");
	
	
}


@Test
public void testDateMandatoryField() throws IOException {
	System.out.println("testMandatoryField");
	WebElement invoice= driver.findElement(By.id("invoice"));
	WebElement product = driver.findElement(By.id("product"));
	WebElement quantity = driver.findElement(By.id("quantity"));
	WebElement amount = driver.findElement(By.id("amount"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

	invoice.sendKeys("abc123");
	product.sendKeys("iPhone");
	quantity.sendKeys("1");
	amount.sendKeys("$1000.00");

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	submitBtn.click();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	
	TakesScreenshot scrSht = (TakesScreenshot)driver;
	File srcFile = scrSht.getScreenshotAs(OutputType.FILE);
	
	File DestFile = new File("C:/tmp/testDateMandatoryField.png");
	FileUtils.copyFile(srcFile, DestFile);

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));	
	
	WebElement message = driver.findElement(By.id("message"));
	
	String invoiceText=invoice.getText();
	Assert.assertEquals(invoiceText,"");
	
	String messageText= message.getText();
	Assert.assertEquals(messageText, "ERROR: Missing date, mandatory field");
	
	
}


@Test
public void testProductMandatoryField() throws IOException {
	System.out.println("testMandatoryField");
	WebElement invoice= driver.findElement(By.id("invoice"));
	WebElement date = driver.findElement(By.id("date"));
	WebElement quantity = driver.findElement(By.id("quantity"));
	WebElement amount = driver.findElement(By.id("amount"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

	date.sendKeys("06/29/2024");
	invoice.sendKeys("abc123");
	quantity.sendKeys("1");
	amount.sendKeys("$1000.00");

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	submitBtn.click();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	
	TakesScreenshot scrSht = (TakesScreenshot)driver;
	File srcFile = scrSht.getScreenshotAs(OutputType.FILE);
	
	File DestFile = new File("C:/tmp/testProductMandatoryField.png");
	FileUtils.copyFile(srcFile, DestFile);

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));	
	
	WebElement message = driver.findElement(By.id("message"));
	
	String invoiceText=invoice.getText();
	Assert.assertEquals(invoiceText,"");
	
	String messageText= message.getText();
	Assert.assertEquals(messageText, "ERROR: Missing Product, mandatory field");
	
	
}


@Test
public void testAmountMandatoryField() throws IOException {
	System.out.println("testMandatoryField");
	WebElement invoice= driver.findElement(By.id("invoice"));
	WebElement date = driver.findElement(By.id("date"));
	WebElement product = driver.findElement(By.id("product"));
	WebElement quantity = driver.findElement(By.id("quantity"));
	WebElement amount = driver.findElement(By.id("amount"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

	date.sendKeys("06/29/2024");
	product.sendKeys("iPhone");
	quantity.sendKeys("1");
	invoice.sendKeys("abc123");

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	submitBtn.click();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	
	TakesScreenshot scrSht = (TakesScreenshot)driver;
	File srcFile = scrSht.getScreenshotAs(OutputType.FILE);
	
	File DestFile = new File("C:/tmp/testAmountMandatoryField.png");
	FileUtils.copyFile(srcFile, DestFile);

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));	
	
	WebElement message = driver.findElement(By.id("message"));
	
	String invoiceText=invoice.getText();
	Assert.assertEquals(invoiceText,"");
	
	String messageText= message.getText();
	Assert.assertEquals(messageText, "ERROR: Missing Amount, mandatory field");
	
	
}

@Test
public void testQuantity() throws IOException {
	System.out.println("testQuantity");
	WebElement invoice= driver.findElement(By.id("invoice"));
	WebElement date = driver.findElement(By.id("date"));
	WebElement product = driver.findElement(By.id("product"));
	WebElement quantity = driver.findElement(By.id("quantity"));
	WebElement amount = driver.findElement(By.id("amount"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

	invoice.sendKeys("abc123");
	date.sendKeys("06/29/2024");
	product.sendKeys("iPhone");
	quantity.sendKeys("0");
	amount.sendKeys("0");

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	submitBtn.click();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	
	TakesScreenshot scrSht = (TakesScreenshot)driver;
	File srcFile = scrSht.getScreenshotAs(OutputType.FILE);
	
	File DestFile = new File("C:/tmp/testQuantity.png");
	FileUtils.copyFile(srcFile, DestFile);

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));		
	
	WebElement message = driver.findElement(By.id("message"));	
	Assert.assertEquals(message, "ERROR: Quantity cannot be zero or empty value.");

}

@Test
public void testQuantityDefaultValue() throws IOException {
	System.out.println("testQuantityDefaultValue");
	WebElement invoice= driver.findElement(By.id("invoice"));
	WebElement date = driver.findElement(By.id("date"));
	WebElement product = driver.findElement(By.id("product"));
	WebElement quantity = driver.findElement(By.id("quantity"));
	WebElement amount = driver.findElement(By.id("amount"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

	invoice.sendKeys("abc123");
	date.sendKeys("06/29/2024");
	product.sendKeys("iPhone");
	amount.sendKeys("0");
	new Actions(driver).moveToElement(quantity).click().perform();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
	TakesScreenshot scrSht = (TakesScreenshot)driver;
	File srcFile = scrSht.getScreenshotAs(OutputType.FILE);
	
	File DestFile = new File("C:/tmp/testQuantityFocus.png");
	FileUtils.copyFile(srcFile, DestFile);

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));		

	String amountText = amount.getText();
	Assert.assertEquals(amountText, "1");
	

}


@AfterMethod
public void closeWindow() {
	System.out.println("closeWindow");
	driver.close();
}

@AfterTest
public void quitWindow() {
	System.out.println("quitWindow");
	driver.quit();
}

}



