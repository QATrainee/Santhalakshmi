package Automate;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class Calendar {
 
	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\javas\\chromedriver.exe" );
	    WebDriver	driver = new ChromeDriver();
	    driver.manage().window().maximize();
 
		driver.get("http://www.phptravels.net");
		
		driver.findElement(By.name("checkin")).click();
					
		List<WebElement> allDates=driver.findElements(By.xpath("html/body/div[14]"));
		System.out.println(allDates);
		
		
		for(WebElement ele:allDates)
		{
			
			String date=ele.getText();
			System.out.println(date);
			
			if(date.equalsIgnoreCase("28"))
			{
				ele.click();
				break;
			}
			
		}
		
		
	}
 
}