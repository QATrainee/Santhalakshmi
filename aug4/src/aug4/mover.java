package aug4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mover {
	static WebDriver driver;
public static void main(String[] args) throws InterruptedException{

	 System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Javas\\chromedriver.exe");
		driver = new ChromeDriver();
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   driver.get("http://www.google.com");
   Thread.sleep(10000);
   WebElement ele = driver.findElement((By.xpath(".//*[@id='tsf']/div[2]/div[3]/center/input[1]")));
   Actions action = new Actions(driver);
   action.moveToElement(ele).click().perform();


}

}