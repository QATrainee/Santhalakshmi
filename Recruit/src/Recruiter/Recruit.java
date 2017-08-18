package Recruiter;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Recruit {

	static WebDriver d;

	public String workingDir = System.getProperty("user.dir");

	protected static WebElement xp(String xpath) {

		return d.findElement(By.xpath(xpath));
	}

	protected static WebElement id(String id) {

		return d.findElement(By.id(id));
	}

	protected static WebElement css(String cssSelector) {

		return d.findElement(By.cssSelector(cssSelector));
	}

	void browserOpen() throws InterruptedException {
		// workingDir = System.getProperty("user.dir");
		// BasicConfigurator.configure();
		System.setProperty("webdriver.chrome.driver", workingDir + "\\Resources\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

	void logIn() throws Exception {
		File file = new File(workingDir + "\\Resources\\Base.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		d.get(prop.getProperty("URL"));

		d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		xp(prop.getProperty("recruiterlogin")).click();

		d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		xp(prop.getProperty("loginbutton")).click();

		d.switchTo().defaultContent();
		d.switchTo().frame("empcontentframe");

		xp(prop.getProperty("mailid")).sendKeys(prop.getProperty("username"));

		xp(prop.getProperty("password1")).sendKeys(prop.getProperty("password"));

		xp(prop.getProperty("submitbutton")).click();

		d.switchTo().defaultContent();
		d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	void jobResponse() throws Exception {
		
				/**
				 * @author santhanalakshmi work name : job response
				 */

		File file = new File(workingDir + "\\Resources\\jobresponse.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
        //jobresponse tab
		css(prop.getProperty("jobresponse")).click();
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe2");
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Select Select = new Select(id(prop.getProperty("resumetitle")));
		// d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		//resumelink click
		css(prop.getProperty("resumelink")).click();
         
		String window1 = d.getWindowHandle();
		System.out.println(window1);

		Set<String> windows = d.getWindowHandles();
		Iterator iterator = windows.iterator();
		String x;
		while (iterator.hasNext()) {
			x = iterator.next().toString();

			System.out.println(x);

			// for(String x:windows){
			if (x.equals(window1) == false) {
				//switch to window
				d.switchTo().window(x);
				d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				//forwarding
				css(prop.getProperty("forward")).click();
				d.switchTo().defaultContent();
				d.switchTo().frame("empforwardprofilecontentframe");
				d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				css(prop.getProperty("toaddress")).sendKeys(prop.getProperty("tomailid"));
				css(prop.getProperty("send")).click();
				d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				css(prop.getProperty("close")).click();
				d.switchTo().defaultContent();
				d.switchTo().window(x);
				Thread.sleep(2000);
				// d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//downloading
				css(prop.getProperty("download")).click();
				d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				//check email availability
				css(prop.getProperty("checkmail")).click();
				d.switchTo().defaultContent();
				d.switchTo().frame("empchkResumecontentframe");
				css(prop.getProperty("subject")).sendKeys(prop.getProperty("Resume"));
				css(prop.getProperty("submit")).click();
				css(prop.getProperty("close")).click();

			}
		}
	}

	public static void main(String[] args) throws Exception {

		Recruit r = new Recruit();
		r.browserOpen();
		r.logIn();
		r.jobResponse();

	}
}
