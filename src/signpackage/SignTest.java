package signpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignTest {

    WebDriver driver;	
	@BeforeClass
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./exe files/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://bg-dev.eweblife.com/prm/bgbtw/rsvp-signup/apply?record=826");
	}
	 @Test(priority=1)
	  public void case1() {
		  System.out.println("Submit without entering deatils");
		  String jsCode1 = "window.scrollBy(0, document.body.scrollHeight)";
          
          JavascriptExecutor je = (JavascriptExecutor)driver;
          je.executeScript(jsCode1);
          
          driver.findElement(By.xpath("//input[@value='Submit']")).click();
          driver.findElement(By.xpath("(//p[@class='error'])[1]")).getText();
         String text = driver.findElement(By.xpath("(//div[text()='Required field'])[1]")).getText();
         System.out.println("First Name :"+text);
         String text1 = driver.findElement(By.xpath("(//div[text()='Required field'])[2]")).getText();
         System.out.println("Last Name :"+text1);
         String text2 = driver.findElement(By.xpath("(//div[text()='Required field'])[3]")).getText();
         System.out.println("Email :"+text2);
         String text3 = driver.findElement(By.xpath("(//div[text()='Required field'])[4]")).getText();
         System.out.println("Phone No :"+text3);
         String text4 = driver.findElement(By.xpath("(//div[text()='Required field'])[5]")).getText();
         System.out.println("Radio Group :"+text4);
         String text5 = driver.findElement(By.xpath("(//div[text()='Required field'])[6]")).getText();
         System.out.println("Profile :"+text5);
		 
	  }
	 
	 
	 @Test(priority=2)
	 public void case2() {
		 driver.findElement(By.id("field_12052")).sendKeys("Suman");
		 driver.findElement(By.id("field_12053")).sendKeys("Kumari");
		 driver.findElement(By.name("field[12054][value]")).sendKeys("suman@gmail.com");
		 
		 Actions act = new Actions(driver);
		 WebElement ac = driver.findElement(By.id("phone_flag_field_12055_6884"));
		 act.doubleClick(ac).perform();

		 try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 WebElement acc = driver.findElement(By.id("field-12056-field_value_id-3627"));
		 act.doubleClick(acc).perform();
		 try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement ad = driver.findElement(By.id("field-12056-sub_field_ids-20-field_value_id-2"));
		act.doubleClick(ad).perform();
		driver.findElement(By.id("field_12056_sub_field_ids_2")).sendKeys("K");
		WebElement drpDwn = driver.findElement(By.name("field[12058][field_value_id]"));
        Select sel = new Select (drpDwn);
         sel.selectByIndex(2);
         
         WebElement drpDwn1  =driver.findElement(By.id("section_674_745"));
         Select sel1 = new Select (drpDwn1);
         sel1.selectByIndex(2);
         driver.findElement(By.xpath("//input[@value='Submit']")).click();
		 
	 }
	 @Test(priority=3)
	 public void case3() {
		 
		 String jsCode1 = "arguments[0].scrollIntoView(true)";
         String path ="//a[text()='Upload new Photo']" ;
         
         JavascriptExecutor je = (JavascriptExecutor) driver;
          je.executeScript(jsCode1, driver.findElement(By.xpath(path)));
          
          try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          String jsCode2 = "arguments[0].click()";
          je.executeScript(jsCode2, driver.findElement(By.xpath(path)));
          
         WebElement cl = driver.findElement(By.xpath("//h3[text()='Drag OR Click to start cropping image']"));
         

	 }
}
