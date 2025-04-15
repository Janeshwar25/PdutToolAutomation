package myproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class CopyWebelement {

	public static void main(String[] args) {

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\jchowdha\\Documents\\learningpoint\\AcetT1\\driver\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://cirrus-alpha.optum.com/member.uhg");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"memberID\"]")).sendKeys("110004396357");
		driver.findElement(By.xpath("/html/body/div[7]/form/center/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/form/div[2]/p/table/tbody/tr[2]/td[1]/a")).click();
		//String text = driver.findElement(By.xpath("/html/body/div[7]/form/table[16]/tbody/tr[2]/td[5]")).getText();
		WebElement doubleClickLink = driver.findElement(By.xpath("(/html/body/div[7]/form/table[4]/tbody/tr[4]/td/table/tbody/tr[2]/td[3]"));
		Actions actions = new Actions(driver);
		actions.doubleClick(doubleClickLink).build().perform();
		driver.findElement(By.xpath("/html/body/div[7]/form/table[4]/tbody/tr[4]/td/table/tbody/tr[2]/td[3]")).sendKeys(Keys.chord(Keys.CONTROL, "C"));
		driver.findElement(By.xpath("//*[@id=\"tabDiv_0\"]/div/div/ul/li[1]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"memberID\"]")).sendKeys(Keys.chord(Keys.CONTROL, "V"));
		
		/*
		 * Actions action = new Actions(driver);
		 * action.doubleClick(indicatorCode).perform(); switchToPopupWindow(driver);
		 * driver.findElement(By.name("FILTERreferenceCode")).sendKeys(code);
		 * driver.findElement(By.id("filterButton")).click();
		 * driver.findElement(By.xpath("//*[@id='listTable']/tbody/tr[2]/td[1]/a")).
		 * click(); driver.switchTo().window(parentWindowHandler);
		 */
		/*
		 * driver.findElement(By.xpath(
		 * "/html/body/div[7]/form/table[16]/tbody/tr[2]/td[5]")).getText();
		 * 
		 * driver.findElement(By.xpath("//*[@id=\"memberID\"]")).click();
		 * driver.findElement(By.xpath("//*[@id=\"memberID\"]")).sendKeys(Keys.chord(
		 * Keys.CONTROL, "A"));
		 * driver.findElement(By.xpath("//*[@id=\"memberID\"]")).sendKeys(Keys.chord(
		 * Keys.CONTROL, "V"));
		 */

		/*
		 * driver.findElement(By.xpath("//*[@id=\"listTable\"]/tbody/tr[2]/td[5]")).
		 * sendKeys(Keys.chord(Keys.CONTROL, "A"));
		 * driver.findElement(By.xpath("//*[@id=\"listTable\"]/tbody/tr[2]/td[5]")).
		 * sendKeys(Keys.chord(Keys.CONTROL, "C"));
		 * driver.findElement(By.xpath("//*[@id=\"tabDiv_0\"]/div/div/ul/li[1]/a/span"))
		 * .click(); driver.findElement(By.xpath("//*[@id=\"memberID\"]")).click();
		 * driver.findElement(By.xpath("//*[@id=\"memberID\"]")).sendKeys(Keys.chord(
		 * Keys.CONTROL, "A"));
		 * driver.findElement(By.xpath("//*[@id=\"memberID\"]")).sendKeys(Keys.chord(
		 * Keys.CONTROL, "V"));
		 */

	}

}
