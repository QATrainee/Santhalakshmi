package phptravels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Hotels {

	static WebDriver driver;

	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\javas\\chromedriver.exe" );
		driver = new ChromeDriver();

		driver.get("http://www.phptravels.net/");

		Thread.sleep(10000);

		driver.findElement(By.cssSelector(".select2-chosen")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector(".select2-input.select2-focused"))
				.sendKeys("sin");
		Thread.sleep(2000);

		// Actions action = new Actions(driver);

		WebElement e = driver.findElement(By
				.xpath(".//*[@id='select2-drop']/ul"));
		e.click();
		// action.build().perform();

		Thread.sleep(7000);

		driver.findElement(By.xpath(".//*[@id='dpd1']/div/input")).click();

		driver.findElement(
				By.xpath("html/body/div[13]/div[1]/table/thead/tr[1]/th[3]"))
				.click();

		driver.findElement(
				By.xpath("html/body/div[13]/div[1]/table/tbody/tr[4]/td[6]"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.xpath("html/body/div[14]/div[1]/table/tbody/tr[5]/td[3]"))
				.click();
		Thread.sleep(4000);
		List<WebElement> list1 = driver.findElements(By
				.xpath(".//*[@id='adults']"));
		list1.size();
		for (int i = 0; i < list1.size(); i++) {
			new Select(driver.findElement(By.xpath(".//*[@id='adults']")))
					.selectByIndex(i);
		}
		new Select(driver.findElement(By.xpath(".//*[@id='adults']")))
				.selectByVisibleText("3");

		Thread.sleep(4000);
		List<WebElement> list2 = driver.findElements(By
				.xpath(".//*[@id='child']"));
		list2.size();
		for (int i = 0; i < list2.size(); i++) {
			new Select(driver.findElement(By.xpath(".//*[@id='child']")))
					.selectByIndex(i);
		}

		new Select(driver.findElement(By.xpath(".//*[@id='child']")))
				.selectByVisibleText("2");
		Thread.sleep(4000);

		driver.findElement(
				By.xpath(".//*[@id='HOTELS']/div/form/div[6]/div/button"))
				.click();
		Thread.sleep(4000);
		driver.findElement(
				By.xpath("html/body/div[5]/div[3]/div/table/tbody/tr[1]/td/div/div[2]/div/div[1]/a/button"))
				.click();
		Thread.sleep(4000);

		for (int x = 0; x < 7; x++) {
			driver.findElement(
					By.xpath(".//*[@id='OVERVIEW']/div/div[2]/div[1]/div[3]/div[2]/div/div[1]/div[3]"))
					.click();
			Thread.sleep(4000);
		}
	}

}
