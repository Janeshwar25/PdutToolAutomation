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

public class MgUpdate {

	/*
	 * public static void switchToPopupWindow(WebDriver driver) { String
	 * subWindowHandler = null; Set<String> handles = driver.getWindowHandles(); //
	 * get all window handles for (String handle : handles) { subWindowHandler =
	 * handle; } driver.switchTo().window(subWindowHandler); // switch to popup
	 * window }
	 */

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\jchowdha\\Documents\\learningpoint\\AcetT1\\driver\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://cirrus-master.optum.com/");
			driver.findElement(By.xpath("//*[@id=\"levelOneMembership\"]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"levelOneMembership\"]/ul/li[5]/a")).click();
			driver.manage().window().maximize();
			DataProvider DP = new DataProvider();

			Thread.sleep(1000);

			// ArrayList<String> list = new ArrayList<String>();
			// list.add(0, null);

			String[] MemberID = {
				
					"3453977",
					"3453974",
					"3453979",
					"3456495",
					"3456496",
					"3460342",
					"3456499",
					"3457458"







					
					
			};
			int i = 0;
			for (i = 0; i < MemberID.length; i++)

			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"memGroupID\"]")).sendKeys(MemberID[i]);
				driver.findElement(By.xpath("/html/body/div[7]/form/center/input[2]")).click();
				driver.findElement(By.xpath("//*[@id=\"memGroupName\"]")).sendKeys(".");
				driver.findElement(By.xpath("//*[@id=\"UPDATE\"]")).click();
				driver.findElement(By.xpath("/html/body/div[7]/form/center/input[2]")).click();
				
				driver.findElement(By.xpath("//*[@id=\"memGroupName\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"memGroupName\"]")).sendKeys(Keys.chord(Keys.ARROW_DOWN));
				 
				driver.findElement(By.xpath("//*[@id=\"memGroupName\"]")).sendKeys(Keys.chord(Keys.BACK_SPACE));
				driver.findElement(By.xpath("//*[@id=\"UPDATE\"]")).click();
				driver.findElement(By.xpath("/html/body/div[7]/form/center/input[2]")).click();
				/*
				 * driver.findElement(By.xpath("//*[@id=\"nameLast\"]")).sendKeys(Keys.chord(
				 * Keys.ARROW_UP));
				 * driver.findElement(By.xpath("//*[@id=\"nameLast\"]")).sendKeys("LN");
				 * driver.findElement(By.xpath("//*[@id=\"UPDATE\"]")).click();
				 * driver.findElement(By.xpath("/html/body/div[7]/form/center/input[2]")).click(
				 * );
				 */
				
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
