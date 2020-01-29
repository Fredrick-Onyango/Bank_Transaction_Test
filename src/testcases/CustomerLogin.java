/**
 * 
 */
package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author fredrickonyango
 *
 */
public class CustomerLogin {
    //set Driver & open url
	WebDriver driver;
	@Test(priority = 1)
	public void OpenBrowser() throws InterruptedException {
				try {
		     System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//lib//chromedriver");
		     driver = new ChromeDriver();
		     driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
		     driver.manage().window().maximize();
		     Thread.sleep(2000);
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		    }
		    finally {
		        tearDown();
		    }
			}
			private void tearDown() {
				// TODO Auto-generated method stub
				
			}
    //Click Customer
	@Test(priority = 2)
	public void VerifyClickCustomer() {
				new WebDriverWait(driver, 100).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/div[1]/button"))).click();
			}
	//Select Customer from Drop-down
    @Test(priority = 3)
    public void VerifySelectCustomer() {
			new WebDriverWait(driver, 100).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"userSelect\"]")));
			Select customer = new Select(driver.findElement(By.id("userSelect")));
			customer.selectByVisibleText("Hermoine Granger");
			customer.selectByIndex(1);
			}
	//Verify Login		
	@Test(priority = 4)
	public void VerifyLogin() {
				new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[2]/div/form/button"))).click();
			}
	/*
	//Assert Customer details		
	@Test(priority = 5)
	public void VerifyCustomerView() {
			//Assert Customer name
			//WebElement name = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/strong/span")));
			WebElement name =driver.findElement(By.cssSelector("body > div > div > div.ng-scope > div > div:nth-child(1) > strong > span"));
			String text1=name.getText();
			System.out.println("Text obtained is "+text1);
			if(text1.contains("Expected text"))
					{
			System.out.println("Expected text is obtained");
			}else{
			System.out.println("Expected text is not obtained");
			}
			//Assert Account
			WebElement account=driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/strong[1]"));
			String text2=account.getText();
			System.out.println("Text obtained is "+text2);
			if(text2.contains("Expected text"))
					{
			System.out.println("Expected text is obtained");
			}else{
			System.out.println("Expected text is not obtained");
			}
			//Assert Balance
			WebElement balance=driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/strong[2]"));
			String text3=balance.getText();
			System.out.println("Text obtained is "+text3);
			if(text3.contains("Expected text"))
					{
			System.out.println("Expected text is obtained");
			}else{
			System.out.println("Expected text is not obtained");
			}
			//Assert Currency
			WebElement currency=driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/strong[3]"));
			String text4=currency.getText();
			System.out.println("Text obtained is "+text4);
			if(text4.contains("Expected text"))
					{
			System.out.println("Expected text is obtained");
			}else{
			System.out.println("Expected text is not obtained");
			}
	        }
	      */  
	  //Successful Withdrawal transaction
	  @Test(priority = 6)
	  public void VerifySuccessfulWithdraw() {
			//Click withdraw button
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[2]/div/div[3]/button[3]"))).click();
			//Withdraw 1000
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/form/div/input"))).sendKeys("1000");
			//Click submit withdrawal button
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/form/button"))).click();
			String bodyText = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/span")).getText();
			CharSequence text = "Transaction successful";
			Assert.assertTrue(bodyText.contains(text));
			System.out.println("Test Passed");
			WebElement element=driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/span"));
				
			//To store the text of a WebElement in a string
			String text1=element.getText();
			//For printing the text in console output
			System.out.println("Text obtained is "+text1);
			if(text1.contains("Expected text"))
						{
			System.out.println("Expected text is obtained");
			}else{
			System.out.println("Expected text is not obtained");
			}
			driver.navigate().refresh();
			}	
	//Failed Withdrawal Transaction
	@Test(priority = 7)
	public void VerifyFailedWithdraw() {
			//Click withdraw button
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[2]/div/div[3]/button[3]"))).click();
			//Withdraw 1000
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/form/div/input"))).sendKeys("10000");
			//Click submit withdrawal button
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/form/button"))).click();
			String bodyText = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/span")).getText();
			CharSequence text = "Transaction Failed. You can not withdraw amount more than the balance.";
			Assert.assertTrue(bodyText.contains(text));
			System.out.println("Test Passed");
					
				
			WebElement element=driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[4]/div/span"));
			//To store the text of a WebElement in a string
			String text1=element.getText();
			//For printing the text in console output
			System.out.println("Text obtained is "+text1);
			if(text1.contains("Expected text"))
					{
			System.out.println("Expected text is obtained");
			}else{
			System.out.println("Expected text is not obtained");
			}
			driver.navigate().refresh();
			}
	//Close Browser
    @Test(priority = 8)
    public void CloseBrowser() {
		    driver.close();
		    }
				
}
	


