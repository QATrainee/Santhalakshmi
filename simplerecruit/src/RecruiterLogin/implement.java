package RecruiterLogin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class implement extends BaseClass {

	public void DashBoard() throws Exception {
		/*
		 * @author Sakthi Praveen Kumar.k work name : DashBoard
		 */
		String mytitle="Top Jobs for Smart Talent | TechFetch.com";
		if(d.getTitle().equals(mytitle))
		{
		d.navigate().refresh();
		}
		Thread.sleep(3000);
		Properties prop;
		FileInputStream fileInput = new FileInputStream(workingDir + "\\Resources\\Dashboard.properties");
		prop = new Properties();
		prop.load(fileInput);
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
	
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe1");
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		css(prop.getProperty("Avaliableasof")).click();
		log.debug("Clicking Avaliable as of menu");

		// To display all the element from the WebPage Table WebElement table =
		xp(prop.getProperty("TableBorder"));

		// Get all rows (tr tags) List<WebElement> rows =
		/*
		 * table.findElements(By.tagName("tr"));
		 * System.out.println("No. of Rows in the WebTable: "); // Print data from each
		 * row (Data from each System.out.println(rows.size() - 1); // td tag)
		 * d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		 */

		// To Display All The Resumes according To Month Using For Loop:

		String[] months = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
				"Dec" };
		for (int i = 0; i < 12; i++) {

			/*
			 * driver.findElement( By.xpath(
			 * ".//[@id='emp-col9']/div/div[2]/div[3]/div/div/div[2]/table/thead/tr[2]/td[1]/div/input"
			 * )) .clear();
			 */

			xp(prop.getProperty("AvaliableasofFieldBox")).sendKeys(months[i]);

			d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

			WebElement table1 = xp(prop.getProperty("TableBorder"));

			List<WebElement> rows4 = table1.findElements(By.tagName("tr"));
			d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

			System.out.println("Resumes" + months[i]);
			System.out.println(rows4.size() - 1);
			xp(prop.getProperty("AvaliableasofFieldBox")).clear();

		}

		// Search by Name d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		xp(prop.getProperty("SearchByNameFieldBox")).sendKeys(prop.getProperty("SearchByNameValue"));
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		xp(prop.getProperty("SearchByNameFieldBox")).clear();
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		// Search By Work Authorization

		String[] WorkAuthorization = new String[] { "US Citizen", "Green Card", "US Security Clearance" };
		for (int i = 0; i < 3; i++) {

			xp(prop.getProperty("WorkAuthorizationFieldBox")).sendKeys(WorkAuthorization[i]);

			d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

			xp(prop.getProperty("WorkAuthorizationFieldBox")).clear();
			d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		} // Search By Location(City or State)

		xp(prop.getProperty("LocationFieldBox")).sendKeys(prop.getProperty("LocationSearchValue"));
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		xp(prop.getProperty("LocationFieldBox")).clear();

		// Search By Relocation

		String[] ReLocation = new String[] { "Yes", "No" };
		for (int i = 0; i < 2; i++) {

			xp(prop.getProperty("RelocationFieldBox")).sendKeys(ReLocation[i]);
			d.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			xp(prop.getProperty("RelocationFieldBox")).clear();

		}

		// search By Specialized Area

		xp(prop.getProperty("SpecializedAreaFieldBox")).sendKeys(prop.getProperty("SpecializedAreaSearchValue"));
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		xp(prop.getProperty("SpecializedAreaFieldBox")).clear();

		// Search By Experience
		xp(prop.getProperty("ExperienceFieldBox")).sendKeys(prop.getProperty("ExperienceSearchValue"));
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		xp(prop.getProperty("ExperienceFieldBox")).clear();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Search By Rate
		xp(prop.getProperty("RateFieldBox")).sendKeys(prop.getProperty("RateSearchValue"));

		// Profile Click

		xp(prop.getProperty("ProfileClick")).click();

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
				d.switchTo().window(x);

				// d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				Thread.sleep(2000);
				xp(prop.getProperty("Email")).click();
				d.switchTo().defaultContent();
				d.switchTo().frame("empchkResumecontentframe");
				xp(prop.getProperty("Subject")).sendKeys(prop.getProperty("SubjectValue"));
				xp(prop.getProperty("EmailSend")).click();
				xp(prop.getProperty("EmailNotificationClose")).click();
				Thread.sleep(500);
				// d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				d.switchTo().defaultContent();

				// d.close();

				d.switchTo().window(x);
				// d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				xp(prop.getProperty("ForwardProfile")).click();
				d.switchTo().defaultContent();

				d.switchTo().frame("empforwardprofilecontentframe");
				xp(prop.getProperty("ToMailID")).sendKeys(prop.getProperty("ToMailIDValue"));
				xp(prop.getProperty("ForwardButton")).click();
				xp(prop.getProperty("ForwardCloseButton")).click();

				d.switchTo().defaultContent();
				d.switchTo().window(x);
				Thread.sleep(500);
				xp(prop.getProperty("AddFeedback")).click();

				d.switchTo().defaultContent();
				d.switchTo().frame("employerfeedbackframe");

				Thread.sleep(500);

				xp(prop.getProperty("OpenToRelocate")).click();
				xp(prop.getProperty("Save&Close")).click();

				d.switchTo().defaultContent();
				d.switchTo().window(x);
				d.close();

				/*
				 * xp(prop.getProperty("AddNote")).click(); d.switchTo().defaultContent();
				 * 
				 * Thread.sleep(1000); d.switchTo().frame("addnotesframe");
				 * 
				 * xp(prop.getProperty("TextBoxField")).sendKeys(prop.getProperty("TextBoxValue"
				 * )); xp(prop.getProperty("Save&close")).click();
				 */

			}
		}
		d.switchTo().window(window1);
		Thread.sleep(1000);
	}

	public void postjob() throws Exception {

		/**
		 * @author surya Balapriya work name : postjobs
		 */
		String workingDir;

		workingDir = System.getProperty("user.dir");

		File file = new File(workingDir + "\\Resources\\postjob.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		id(prop.getProperty("postjobs")).click();

		d.switchTo().defaultContent();

		d.switchTo().frame("Iframe2");
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		id(prop.getProperty("Jobtitle")).clear();
		id(prop.getProperty("Jobtitle")).sendKeys(prop.getProperty("jobtitle"));
		id(prop.getProperty("Requiredskills")).clear();
		id(prop.getProperty("Requiredskills")).sendKeys(prop.getProperty("requiredskills"));
		id(prop.getProperty("Preferredskill")).clear();
		id(prop.getProperty("Preferredskill")).sendKeys(prop.getProperty("preferredskill"));
		id(prop.getProperty("explevel")).click();
		id(prop.getProperty("Jobdescription")).clear();
		id(prop.getProperty("Jobdescription")).sendKeys(prop.getProperty("jobdescription"));
		id(prop.getProperty("Clientname")).clear();
		id(prop.getProperty("Clientname")).sendKeys(prop.getProperty("clientname"));
		id(prop.getProperty("Buttonclick")).click();
		Thread.sleep(2000);

		id(prop.getProperty("City")).sendKeys(prop.getProperty("city"));

		Thread.sleep(3000);
		css(prop.getProperty("citylist")).click();

		Thread.sleep(3000);

		new Select(id(prop.getProperty("Jobexp"))).selectByVisibleText("1 Week");
		id(prop.getProperty("consulting")).click();

		id(prop.getProperty("workauthori")).click();
		id(prop.getProperty("preferemp")).click();
		id(prop.getProperty("Duration")).clear();
		id(prop.getProperty("Duration")).sendKeys(prop.getProperty("duration"));
		Select select = new Select(xp(prop.getProperty("splarea")));
		Select select1 = new Select(xp(prop.getProperty("splskills")));

		for (int i = 0; i <= 27; i++) {
			select.selectByIndex(i);

			d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}

		select.selectByIndex(1);
		select1.selectByIndex(1);
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		id(prop.getProperty("savebtn")).click();
		id(prop.getProperty("others")).click();
		id(prop.getProperty("domainexpo")).click();
		id(prop.getProperty("domainexpo1")).click();

		id(prop.getProperty("domainexpo2")).click();
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		id(prop.getProperty("postmyjob")).click();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		xp(prop.getProperty("closebtn")).click();
		d.switchTo().defaultContent();
	}

	public void Jobresponse() throws Exception {

		/**
		 * @author Santhalakshmi work name :Jobresponse
		 */

		File file = new File(workingDir + "\\Resources\\jobresponse.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);

		// jobresponse tab
		css(prop.getProperty("jobresponse")).click();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		d.switchTo().defaultContent();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		d.switchTo().frame("Iframe4");
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Select Select = new Select(id(prop.getProperty("resumetitle")));
		// d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		// resumelink click
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
				// switch to window
				d.switchTo().window(x);
				// d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				// forwarding

				Thread.sleep(2000);
				css(prop.getProperty("forward")).click();
				Thread.sleep(500);
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
				// downloading
				//css(prop.getProperty("download")).click();
				
				d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				// check email availability
				css(prop.getProperty("checkmail")).click();
				d.switchTo().defaultContent();
				d.switchTo().frame("empchkResumecontentframe");
				css(prop.getProperty("subject")).sendKeys(prop.getProperty("Resume"));
				css(prop.getProperty("submit")).click();
				css(prop.getProperty("close")).click();
				d.switchTo().defaultContent();
				d.switchTo().window(x);
				d.close();
			}
			d.switchTo().window(window1);
			Thread.sleep(1000);
		}

	}

	public void fetchresume() throws InterruptedException, IOException {

		/**
		 * @author Karthigavalli work name :Fetch Resume
		 */

		File file = new File(workingDir + "\\Resources\\rec.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		
		d.switchTo().defaultContent();
		
		xp(prop.getProperty("fetch")).click();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe5");
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		id(prop.getProperty("key")).sendKeys(prop.getProperty("keyword"));
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		id(prop.getProperty("all")).click();
		id(prop.getProperty("workAuthority")).click();
		id(prop.getProperty("workAuthority1")).click();
		id(prop.getProperty("workAuthority2")).click();
		id(prop.getProperty("workAuthority3")).click();
		id(prop.getProperty("preferedEmployment")).click();
		id(prop.getProperty("preferedEmployment1")).click();
		id(prop.getProperty("preferedEmployment2")).click();
		id(prop.getProperty("preferedEmployment3")).click();
		id(prop.getProperty("preferedEmployment4")).click();
		id(prop.getProperty("workAuthority")).click();
		id(prop.getProperty("workAuthority1")).click();
		id(prop.getProperty("preferedEmployment")).click();
		id(prop.getProperty("preferedEmployment1")).click();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		new Select(id(prop.getProperty("area"))).selectByVisibleText("Java, J2EE");
		new Select(id(prop.getProperty("skill"))).selectByVisibleText("Java Server Side");
		id(prop.getProperty("advancedSearch")).click();
		Thread.sleep(1000);
		xp(prop.getProperty("domain1")).click();
		xp(prop.getProperty("domain2")).click();
		id(prop.getProperty("country")).click();
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		new Select(id(prop.getProperty("degree"))).selectByVisibleText("Bachelor");
		Select select = new Select(id(prop.getProperty("state")));
		List<WebElement> l = select.getOptions();
		for (int i = 0; i < 6; i++) {
			select.selectByIndex(i);
			xp(prop.getProperty("arrow")).click();
		}
		id(prop.getProperty("Experience")).click();
		id(prop.getProperty("usExperience")).click();
		id(prop.getProperty("askill1")).sendKeys(prop.getProperty("skill1"));
		new Select(id(prop.getProperty("year1"))).selectByVisibleText("4");
		id(prop.getProperty("askill2")).sendKeys(prop.getProperty("skill1"));
		new Select(id(prop.getProperty("year2"))).selectByVisibleText("2");
		id(prop.getProperty("askill3")).sendKeys(prop.getProperty("skill1"));
		new Select(id(prop.getProperty("year3"))).selectByVisibleText("4");

		xp(prop.getProperty("save")).sendKeys(prop.getProperty("fetching"));

		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		new Select(id(prop.getProperty("days"))).selectByVisibleText("90 Days");

		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		id(prop.getProperty("fetched")).click();

		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		 d.switchTo().defaultContent();
		     Thread.sleep(4000);
		         xp(prop.getProperty("loggggggg")).click();
		         Thread.sleep(4000);
		         xp(prop.getProperty("logggggggoooo")).click();
		         
		         }
		
	public void Jobs() throws Exception {
		File file = new File(workingDir + "\\Resources\\myjob.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		d.switchTo().defaultContent();
		css(prop.getProperty("jobmenu")).click();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe7");
		xp(prop.getProperty("updateddate")).sendKeys(prop.getProperty("month"));
		xp(prop.getProperty("jobtitle")).sendKeys(prop.getProperty("lang"));
		xp(prop.getProperty("location")).sendKeys(prop.getProperty("cty4"));
		d.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

		xp(prop.getProperty("preview")).click();
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
				d.switchTo().window(x);
				d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

				xp(prop.getProperty("applynow")).click();
				d.switchTo().defaultContent();
				d.switchTo().frame("applyemailframe");
				d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				new Select(d.findElement(By.id(prop.getProperty("selectfromprofile")))).selectByVisibleText("Doles Pierre (Pierre) [Active]");
				css(prop.getProperty("optionvalue")).click();
				id(prop.getProperty("cc")).clear();
				id(prop.getProperty("cc")).sendKeys(prop.getProperty("tooo"));
				id(prop.getProperty("coveringletter")).click();
				d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				id(prop.getProperty("fileupload")).clear();
				// d.findElement(By.xpath(".//*[@id='uploaddiv']/div/div/div")).click();
				d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				id(prop.getProperty("fileupload")).clear();
				id(prop.getProperty("fileupload")).sendKeys(workingDir +"\\Resources\\ram.docx");

				// d.findElement(By.id("uploadvalue2")).sendKeys("C:\\Users\\mag8\\Desktop\\res.docx");
				id(prop.getProperty("sendemail")).click();
				d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				d.switchTo().defaultContent();
				d.switchTo().frame("applyemailframe");
				xp(prop.getProperty("btnclose")).click();

				// forward
				Thread.sleep(5000);
				d.switchTo().defaultContent();
				d.switchTo().window(x);
				xp(prop.getProperty("forwardjob")).click();

				d.switchTo().defaultContent();
				d.switchTo().frame("jsfwdjobcontentframe");
				d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				xp(prop.getProperty("toaddr")).sendKeys(prop.getProperty("tooo"));
				Thread.sleep(2000);
				xp(prop.getProperty("sendmail")).click();
				d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			d.close();
			}
		}
		
		//FORWARD
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		d.switchTo().window(window1);
		css(prop.getProperty("jobmenu")).click();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe7");

		xp(prop.getProperty("updateddate")).clear();
		xp(prop.getProperty("jobtitle")).clear();
		xp(prop.getProperty("location")).clear();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		xp(prop.getProperty("updateddate")).sendKeys(prop.getProperty("month8"));
		xp(prop.getProperty("jobtitle")).sendKeys(prop.getProperty("lang8"));
		xp(prop.getProperty("location")).sendKeys(prop.getProperty("cty8"));
		//xp(prop.getProperty("fwd")).click();
		//d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//d.switchTo().frame(d.findElement(By.xpath(prop.getProperty("forwardmain"))));
		//d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//xp(prop.getProperty("toaddr")).sendKeys(prop.getProperty("tooo"));
		//Thread.sleep(1000);
		//css(prop.getProperty("sendmail1")).click();
		//d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	

		// EDIT

		// @author surya Balapriya work name : edit
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe7");
		xp(prop.getProperty("updateddate")).clear();
		xp(prop.getProperty("jobtitle")).clear();
		xp(prop.getProperty("location")).clear();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		xp(prop.getProperty("edit")).click();
		d.switchTo().defaultContent();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.switchTo().frame("Iframe8");

		id(prop.getProperty("jobtitle5")).clear();
		id(prop.getProperty("jobtitle5")).sendKeys(prop.getProperty("Title"));
		Thread.sleep(1000);
		id(prop.getProperty("skillreq")).clear();
		id(prop.getProperty("skillreq")).sendKeys(prop.getProperty("Title"));
		id(prop.getProperty("exlevel")).click();
		id(prop.getProperty("exlevel1")).click();
		id(prop.getProperty("exlevel2")).click();
		id(prop.getProperty("exlevel3")).click();
		id(prop.getProperty("exlevel4")).click();
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		xp(prop.getProperty("permanenttype")).click();

		id(prop.getProperty("Work1")).click();
		Thread.sleep(1000);
		id(prop.getProperty("PreferredEmployment5")).click();
		Thread.sleep(1000);
		new Select(id(prop.getProperty("splarea1"))).selectByVisibleText("Java, J2EE");
		new Select(id(prop.getProperty("splskill1"))).selectByVisibleText("Java, J2EE");
		id(prop.getProperty("domainlist0")).click();
		id(prop.getProperty("domainlist2")).click();
		id(prop.getProperty("preview1")).click();
		Thread.sleep(5000);
		d.findElement(By.linkText(prop.getProperty("closebutton"))).click();
		Thread.sleep(5000);
		d.switchTo().defaultContent();
	xp(prop.getProperty("matchclose")).click();
	xp(prop.getProperty("jobclose")).click();
		//id(prop.getProperty("updatebutton")).click();
		//Thread.sleep(5000);
		//xp(".//*[@id='tabs']/ul/li[3]/span").click();
		//d.close();
	}
	
	public void myaccount() throws Exception
	{
		File file = new File(workingDir + "\\Resources\\myaccount.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		String winHandleBefore = d.getWindowHandle();
		for(String winHandle : d.getWindowHandles())
		{
		    d.switchTo().window(winHandle);
	
		xp(prop.getProperty("myaccount")).click();
		Thread.sleep(1000);
	
		d.switchTo().frame("Iframe9");
		xp(prop.getProperty("txt_mail")).clear();
		xp(prop.getProperty("txt_mailid")).sendKeys(prop.getProperty("username"));
		Thread.sleep(1000);
		xp(prop.getProperty("Firstname")).clear();
		xp(prop.getProperty("Firstname")).sendKeys("Trainee");
		Thread.sleep(1000);
		xp(prop.getProperty("Lastname")).clear();
		xp(prop.getProperty("Lastname")).sendKeys("One");
		Thread.sleep(1000);
		xp(prop.getProperty("companyname")).clear();
		xp(prop.getProperty("companyname")).sendKeys("Techpark");;
		Thread.sleep(1000);
		xp(prop.getProperty("country")).sendKeys("India");
		Thread.sleep(1000);
		xp(prop.getProperty("city")).clear();
		xp(prop.getProperty("city")).sendKeys("Mumbai, Maharashtra");
		Thread.sleep(1000);
		xp(prop.getProperty("personalid")).clear();
		xp(prop.getProperty("personalid")).sendKeys("qatraining1@tiliconveli.com");
		Thread.sleep(1000);
	
		xp(prop.getProperty("ph_area")).sendKeys("+91");
		Thread.sleep(1000);
		xp(prop.getProperty("phno")).clear();
		xp(prop.getProperty("phno")).sendKeys("9487525100");
		Thread.sleep(1000);
		xp(prop.getProperty("update")).click();
		Thread.sleep(5000);
		
		}
		String winHandleBefore1 = d.getWindowHandle();
		for(String winHandle1 : d.getWindowHandles())
		{
		    d.switchTo().window(winHandle1);
	
		
		css(prop.getProperty("passclick")).click();  
	
		d.switchTo().frame("Iframe10");
		xp(prop.getProperty("passreset")).sendKeys(prop.getProperty("password"));
		Thread.sleep(2000);
		css(prop.getProperty("passreset1")).sendKeys(prop.getProperty("password"));
		Thread.sleep(2000);
		xp(prop.getProperty("resetbutton")).click();
		Thread.sleep(5000);
	
		}
	
		
		String winHandleBefore2 = d.getWindowHandle();
		for(String winHandle2 : d.getWindowHandles())
		{
		    d.switchTo().window(winHandle2);
		
		
		css(prop.getProperty("preference")).click();
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe11");
		
		Thread.sleep(2000);
		
		css(prop.getProperty("radio2")).click();
		Thread.sleep(2000);
		css(prop.getProperty("radio1")).click();
		Thread.sleep(2000);
		css(prop.getProperty("radio4")).click();
		Thread.sleep(2000);
		css(prop.getProperty("radio3")).click();
		Thread.sleep(2000);
		css(prop.getProperty("radio6")).click();
		Thread.sleep(2000);
		css(prop.getProperty("radio5")).click();
		Thread.sleep(2000);
		css(prop.getProperty("radio_button")).click();
		Thread.sleep(2000);
		}

		String winHandleBefore3 = d.getWindowHandle();
		for(String winHandle3 : d.getWindowHandles())
		{
		    d.switchTo().window(winHandle3);
		    xp(prop.getProperty("user")).click();
		    Thread.sleep(2000);
		   
		}	   
		}
		

		
	

}