package Automate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Hotel {

	
	public static void main(String args[]) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\javas\\chromedriver.exe" );
		
		 WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize();  
		driver.get("http://www.phptravels.net/");
		Thread.sleep(10000);
		
		driver.findElement(By.cssSelector(".select2-chosen")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector(".select2-input.select2-focused")).sendKeys("oas");
		Thread.sleep(7000);
		driver.findElement(By.xpath(".//*[@id='select2-drop']/ul/li[1]/ul/li/div")).click();
		Thread.sleep(10000);
		
		driver.findElement(By.xpath(".//*[@id='dpd1']/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/div[13]/div[1]/table/tbody/tr[3]/td[5]")).click();
		Thread.sleep(1000);
	//	driver.findElement(By.xpath(".//*[@id='dpd2']/div/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/div[14]/div[1]/table/tbody/tr[4]/td[3]")).click();
		Thread.sleep(1000);
		 Select oSelect = new Select(driver.findElement(By.id("adults")));
		 oSelect.selectByIndex(1);
	//	driver.findElement(By.xpath(".//*[@id='child']")).click();
		//Thread.sleep(1000);
		//Select s = new Select(driver.findElement(By.id("child"))).selectByVisibleText("1");
		 Select oSelect1 = new Select(driver.findElement(By.id("child")));
		 oSelect1.selectByIndex(1);
		 driver.findElement(By.xpath(".//*[@id='HOTELS']/div/form/div[6]/div/button")).click();
		 Thread.sleep(1000);
		 for(int i=0;i<5;i++)
		 {
		
		 driver.findElement(By.xpath(".//*[@id='OVERVIEW']/div/div[2]/div[1]/div[3]/div[2]/div/div[1]/div[3]")).click();
		 Thread.sleep(1000);
	
		}
		
	}

		}
		