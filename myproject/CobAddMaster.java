package myproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CobAddMaster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\jchowdha\\Documents\\learningpoint\\AcetT1\\driver\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://cirrus-master.optum.com/");
			driver.findElement(By.xpath("//*[@id=\"levelOneMembership\"]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"levelOneMembership\"]/ul/li[2]/a")).click();
			driver.manage().window().maximize();
			DataProvider DP = new DataProvider();

			Thread.sleep(1000);

			// ArrayList<String> list = new ArrayList<String>();
			// list.add(0, null);

			String[] MemberID = {
				
					
					
					"330001117119",
					"330001117120",
					"330001117121",
					"330001117122",
					"330001117123",
					"330001117129",
					"330001117128",
					"330001117131",
					"330001117127",
					"330001117130",
					"330001127197",
					"330001127198",
					"330001127202",
					"330001127203",
					"330001127199",
					"330001127214",
					"330001127215",
					"330001127216",
					"330001127217",
					"330001127219",
					"330001127218",
					"330001076523",
					"330001076521",
					"330001076524",
					"330001076525",
					"330001086624",
					"330001086623",
					"330001117148",
					"330001117147",
					"330001117145",
					"330001117146",
					"330001117149",
					"330001117150",
					"330001127220",
					"330001127221",
					"330001127222",
					"330001127223",
					"330001127226",
					"330001127224",
					"330001127225",
					"330001086639",
					"330001086637",
					"330001086640",
					"330001086638",
					"330001086641",
					"330001106961",
					"330001106962",
					"330001117136",
					"330001117135",
					"330001117137",
					"330001117152",
					"330001117153",
					"330001117154"







					
					
			};
			int i = 0;
			for (i = 0; i < MemberID.length; i++)

			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"memberID\"]")).sendKeys(MemberID[i]);
				
				driver.findElement(By.xpath("/html/body/div[7]/form/center/input[2]")).click();
				driver.findElement(By.xpath("//*[@id=\"levelOneMoreMenu\"]/a")).click();
				driver.findElement(By.xpath("//*[@id=\"levelOneMoreMenu\"]/ul/li[15]/a")).click();
				
				driver.findElement(By.xpath("//*[@id=\"effectiveDate\"]")).sendKeys("10012023");
				
				driver.findElement(By.xpath("//*[@id=\"payerResponsibilitySeqCode\"]/option[2]")).click();
				driver.findElement(By.xpath("//*[@id=\"cobEntityIdentifierCode\"]/option[4]")).click();
				 
				driver.findElement(By.xpath("//*[@id=\"cobCoverageType\"]/option[3]")).click();
				driver.findElement(By.xpath("//*[@id=\"govtBenefitType\"]/option[6]")).click();
				driver.findElement(By.xpath("//*[@id=\"benefitType\"]/option[2]")).click();
				driver.findElement(By.xpath("//*[@id=\"carrierID\"]")).sendKeys("1108926");
				driver.findElement(By.xpath("//*[@id=\"action\"]/option[1]")).click();
				driver.findElement(By.xpath("/html/body/div[8]/form/div[1]/input[2]")).click();
				
				driver.findElement(By.xpath("//*[@id=\"tabDiv_0\"]/div/div/ul/li[1]/a/span")).click();
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


