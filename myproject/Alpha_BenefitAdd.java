package myproject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class Alpha_BenefitAdd {
	/*
	 * public static void switchToPopupWindow(WebDriver driver) { String
	 * subWindowHandler = null; Set<String> handles = driver.getWindowHandles(); //
	 * get all window handles for (String handle : handles) { subWindowHandler =
	 * handle; } driver.switchTo().window(subWindowHandler); // switch to popup
	 * window }
	 */
	
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.edge.driver","C:\\Users\\jchowdha\\Documents\\learningpoint\\AcetT1\\driver\\msedgedriver.exe");

		
	WebDriver driver=new EdgeDriver();
	try {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://cirrus-alpha.optum.com/member.uhg");
	driver.findElement(By.xpath("//*[@id=\"1\"]")).click();
	driver.manage().window().maximize();
	DataProvider DP= new DataProvider();
	
	Thread.sleep(1000);
	
		
	
	 //ArrayList<String> list = new ArrayList<String>(); 
	 //list.add(0, null);
	
	
	
	 String[] MemberID = { 
			 
			 
			 
			 "111002143285",
			 "111002143286",
			 "111002143289",
			 "111002153438",
			 "111002153440",
			 "111002153441",
			 "111002153442",































}; 
	 int i=0;
	 for (i=0;i<MemberID.length ;i++)
	  
	 {
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"memberID\"]")).sendKeys(MemberID[i]);
		driver.findElement(By.xpath("/html/body/div[7]/form/center/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/form/div[2]/p/table/tbody/tr[2]/td[1]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"tabDiv_0\"]/div/div/ul/li[5]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"listTable\"]/tbody/tr[2]/td[1]/a")).click();
		//*[@id="listTable"]/tbody/tr[2]/td[1]/a
		//driver.findElement(By.xpath("//*[@id=\"listTable\"]/tbody/tr[2]/td[1]/a")).click();
		//driver.findElement(By.xpath("//*[@id=\"qualifyingEvent\"]/option[3]")).click();
		//driver.findElement(By.xpath("//*[@id=\"qualifyingEvent\"]/option[3]")).sendKeys(Keys.chord(Keys.CONTROL, "A"));
		
		/*driver.findElement(By.xpath("/html/body/div[7]/form/table[2]/tbody/tr[7]/td[4]/input")).sendKeys("01012022");
		driver.findElement(By.xpath("//*[@id=\"benPlanExpDate\"]")).sendKeys("12312022");
		driver.findElement(By.xpath("//*[@id=\"main\"]/form/table[2]/tbody/tr[11]/td[2]/a/span")).click();
		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);
		
		Iterator<String> iterator = windowhandles.iterator();
		String parantwindow = iterator.next();
		String childwindow = iterator.next();
        driver.switchTo().window(childwindow);*/
		
	    //driver.findElement(By.xpath("//*[@id=\"SetResultLength\"]")).click();
	    //driver.findElement(By.xpath("//*[@id=\\\"filterButton\\\"]")).sendKeys(Keys.chord(Keys.ENTER));
	    //driver.findElement(By.xpath("//*[@id=\"listTable\"]/tbody/tr[2]/td[1]/a")).click();
	
		/*
		 * driver.findElement(By.xpath("//*[@id=\"eventDate\"]")).sendKeys("01012019");
		 * driver.findElement(By.xpath("//*[@id=\"qualifyingEvent\"]/option[8]")).click(
		 * ); driver.findElement(By.xpath("//*[@id=\"benPlanEffDate\"]")).click();
		 * 
		 * driver.findElement(By.xpath("//*[@id=\"benPlanEffDate\"]")).sendKeys(
		 * "01012019");
		 * driver.findElement(By.xpath("//*[@id=\"benPlanExpDate\"]")).click();
		 */
		/*
		 * driver.findElement(By.xpath("//*[@id=\"benPlanExpDate\"]")).sendKeys(Keys.
		 * chord(Keys.CONTROL, "A"));
		 * driver.findElement(By.xpath("//*[@id=\"benPlanExpDate\"]")).sendKeys(
		 * "01012019"); Thread.sleep(1000); driver.findElement(By.xpath(
		 * "//*[@id=\"main\"]/form/table[2]/tbody/tr[11]/td[2]/a/span")).click();
		 */
		
		
		driver.findElement(By.xpath("//*[@id=\"benPlanEffDate\"]")).sendKeys(Keys.chord(Keys.CONTROL, "A"));
	    //driver.switchTo().window(parantwindow);
		driver.findElement(By.xpath("//*[@id=\"benPlanEffDate\"]")).sendKeys("01012023");
		
		
		 driver.findElement(By.xpath("//*[@id=\"benPlanExpDate\"]")).sendKeys(Keys.chord(Keys.CONTROL, "A"));
		 driver.findElement(By.xpath("//*[@id=\"benPlanExpDate\"]")).sendKeys("12312023");
		 
		 //driver.findElement(By.xpath("//*[@id=\"benefitStatusCode\"]/option[2]")).click();
		 
		
		driver.findElement(By.xpath("//*[@id=\"main\"]/form/table[2]/tbody/tr[11]/td[2]/a/span")).click();
		
		
		
		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);
		
		Iterator<String> iterator = windowhandles.iterator();
		String parantwindow = iterator.next();
		String childwindow = iterator.next();
		
		driver.switchTo().window(childwindow);
		
		Set<String> handles = driver.getWindowHandles(); // get all window handles
	    for (String handle : handles) {
	        childwindow = handle;
	        
	    }
	    driver.switchTo().window(childwindow);
		
	    driver.findElement(By.xpath("//*[@id=\"SetResultLength\"]")).click();
	    //driver.findElement(By.xpath("//*[@id=\\\"filterButton\\\"]")).sendKeys(Keys.chord(Keys.ENTER));
	    driver.findElement(By.xpath("//*[@id=\"listTable\"]/tbody/tr[3]/td[1]/a")).click();
	    
	 
	    //driver.findElement(By.xpath("//*[@id=\"listTable\"]/tbody/tr[3]/td[1]")).click();
	    
	    driver.switchTo().window(parantwindow);
		//driver.findElement(By.xpath("//*[@id=\\\"filterButton\\\"]")).sendKeys(Keys.chord(Keys.ENTER));
		/*
		 * driver.findElement(By.xpath("//*[@id=\"listTable\"]/tbody/tr[3]/td[1]/a")).
		 * click(); Thread.sleep(2000);
		 */
		///driver.findElement(By.xpath("//*[@id=\"listTable\"]/tbody/tr[2]/td[1]/a")).click();
		/*
		 * driver.findElement(By.xpath("//*[@id=\"filterButton\"]")).click();
		 * driver.findElement(By.xpath("//*[@id=\\\"filterButton\\\"]")).sendKeys(Keys.
		 * chord(Keys.ENTER)); Thread.sleep(1000);
		 */
		
		
		//driver.findElement(By.xpath("//*[@id=\"listTable\"]/tbody/tr[3]/td[1]/a")).click();
		
		//driver.switchTo().window(parantwindow);
		
		
		//driver.findElement(By.xpath("//*[@id=\"benefitStatusCode\"]/option[2]")).click();
		//driver.findElement(By.xpath("//*[@id=\"termMethod\"]/option[3]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"overrideEnrollmentRuleInd\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"overrideReasonType\"]/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/form/table[4]/tbody/tr[7]/td[2]/span/textarea")).sendKeys("test");
		driver.findElement(By.xpath("//*[@id=\"action\"]/option[1]")).click();
		driver.findElement(By.xpath("/html/body/div[7]/form/div[3]/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"tabDiv_0\"]/div/div/ul/li[1]/a/span")).click();
		
		//driver.findElement(By.xpath("//*[@id=\"main\"]/form/table[4]/tbody/tr[3]/td[4]/a/span")).click();
		/*
		 * Thread.sleep(1000);
		 * driver.findElement(By.xpath("//*[@id=\"termMemberBenefitReason\"]")).sendKeys
		 * (Keys.chord(Keys.CONTROL, "A"));
		 * driver.findElement(By.xpath("//*[@id=\"termMemberBenefitReason\"]")).sendKeys
		 * ("01"); Thread.sleep(1000);
		 * driver.findElement(By.xpath("//*[@id=\"overrideEnrollmentRuleInd\"]")).click(
		 * ); driver.findElement(By.xpath("//*[@id=\"overrideReasonType\"]/option[2]")).
		 * click(); Thread.sleep(1000); driver.findElement(By.xpath(
		 * "//*[@id=\"main\"]/form/table[4]/tbody/tr[7]/td[2]/span/textarea")).sendKeys(
		 * "test"); Thread.sleep(1000);
		 * driver.findElement(By.xpath("//*[@id=\"action\"]/option[1]")).click();
		 * Thread.sleep(1000);
		 * driver.findElement(By.xpath("/html/body/div[7]/form/center/input[2]")).click(
		 * ); Thread.sleep(2000);
		 * driver.findElement(By.xpath("//*[@id=\"tabDiv_0\"]/div/div/ul/li[1]/a/span"))
		 * .click();
		 */
	 }
	}
	catch (Exception e) {
		e.printStackTrace();

	}


}
}