package myproject;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MyUHC {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver","C:\\Users\\jchowdha\\Documents\\learningpoint\\AcetT1\\driver\\msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://cirrus-alpha.optum.com/member.uhg");
		String[] MemberID = { "110004396357" };
		int i = 0;
		for (i = 0; i < MemberID.length; i++)

		

		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://member.int.uhc.com/myuhc?action=logout&locale=en-US");
		  driver.manage().window().maximize();
		  driver.findElement(By.xpath("//*[@id=\"registerbutton\"]")).click();
		

		  {
			driver.findElement(By.xpath("//*[@id=\"1\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"memberID\"]")).sendKeys(MemberID[i]);
			driver.findElement(By.xpath("/html/body/div[7]/form/center/input[2]")).click();
			driver.findElement(By.xpath("//*[@id=\"nameFirst\"]")).sendKeys(Keys.chord(Keys.CONTROL, "A"));
			driver.findElement(By.xpath("//*[@id=\"nameFirst\"]")).sendKeys(Keys.chord(Keys.CONTROL, "C"));

			/*
			 * Set<String> windowhandles = driver.getWindowHandles(); Iterator<String>
			 * iterator = windowhandles.iterator(); String parantid = iterator.next();
			 * String childid = iterator.next(); driver1.switchTo().window(parantid);
			 * driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(Keys.chord(
			 * Keys.CONTROL, "V"));
			 */
			driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
			driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(Keys.chord(Keys.CONTROL, "V"));

			driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));

			driver.findElement(By.xpath("//*[@id=\"nameLast\"]")).sendKeys(Keys.chord(Keys.CONTROL, "A"));
			driver.findElement(By.xpath("//*[@id=\"nameLast\"]")).sendKeys(Keys.chord(Keys.CONTROL, "C"));

			driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
			driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(Keys.chord(Keys.CONTROL, "V"));

			driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));

			driver.findElement(By.xpath("//*[@id=\"birthDate\"]")).sendKeys(Keys.chord(Keys.CONTROL, "A"));
			driver.findElement(By.xpath("//*[@id=\"birthDate\"]")).sendKeys(Keys.chord(Keys.CONTROL, "C"));

			driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
			driver.findElement(By.xpath("//*[@id=\"dob\"]")).sendKeys(Keys.chord(Keys.CONTROL, "V"));

			driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
			driver.findElement(By.xpath("//*[@id=\"listTable\"]/tbody/tr[2]/td[1]/a")).click();
			String text = driver.findElement(By.xpath("//*[@id=\"listTable\"]/tbody/tr[2]/td[5]")).getText();

		}

	}
}
