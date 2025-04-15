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

public class FnLN {
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
			driver.get("https://cirrus-alpha.optum.com/member.uhg");
			driver.findElement(By.xpath("//*[@id=\"1\"]")).click();
			driver.manage().window().maximize();
			DataProvider DP = new DataProvider();

			Thread.sleep(1000);

			// ArrayList<String> list = new ArrayList<String>();
			// list.add(0, null);

			String[] MemberID = {
					"110013026351",
					"110013026354",
					"110013026355",
					"110013026372",
					"110013026373",
					"110013026374",
					"110013026375",
					"110013026376",
					"110013026377",
					"110013036496",
					"110013036497",
					"110013036507",
					"110013036511",
					"110013036515",
					"110013036516",
					"110013036521",
					"110013046653",
					"110013046654",
					"110013046655",
					"110013046656",
					"110013046658",
					"110013046659",
					"110013046660",
					"110013046661",
					"110013046662",
					"110013046663",
					"110013046664",
					"110013046665",
					"110013066949",
					"110013066950",
					"110013066951",
					"110013066952",
					"110013066953",
					"110013066954",
					"110013066955",
					"110013066956",
					"110013066957",
					"110013066958",
					"110013066959",
					"110013066960",
					"110013066961",
					"110013066962",
					"110013066963",
					"110013087268",
					"110013087269",
					"110013087270",
					"110013087271",
					"110013087273",
					"110013087274",
					"110013087275",
					"110013087276",
					"110013097418",
					"110013097419",
					"110013097420",
					"110013097421",
					"110013097423",
					"110013097424",
					"110013097425",
					"110013097426",
					"110013117709",
					"110013117710",
					"110013117711",
					"110013117725",
					"110013117726",
					"110013117727",
					"110013117728",
					"110013117729",
					"110013117730",
					"110013117731",
					"110013117732"



					
					
			};
			int i = 0;
			for (i = 0; i < MemberID.length; i++)

			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"memberID\"]")).sendKeys(MemberID[i]);
				driver.findElement(By.xpath("/html/body/div[7]/form/center/input[2]")).click();
				driver.findElement(By.xpath("//*[@id=\"nameFirst\"]")).sendKeys(Keys.chord(Keys.ARROW_UP));
				driver.findElement(By.xpath("//*[@id=\"nameFirst\"]")).sendKeys("FN");
				driver.findElement(By.xpath("//*[@id=\"nameLast\"]")).sendKeys(Keys.chord(Keys.ARROW_UP));
				driver.findElement(By.xpath("//*[@id=\"nameLast\"]")).sendKeys("LN");
				driver.findElement(By.xpath("//*[@id=\"UPDATE\"]")).click();
				driver.findElement(By.xpath("/html/body/div[7]/form/center/input[2]")).click();
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}