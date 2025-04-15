package myproject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class obm_Automation {

	
		public static void main(String[] args) throws InterruptedException {
			
			System.setProperty("webdriver.edge.driver","C:\\Users\\jchowdha\\Documents\\learningpoint\\AcetT1\\driver\\msedgedriver.exe");

		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://cirrus-master.optum.com/provider.uhg");
		driver.manage().window().maximize();
		
		
		
		{
			driver.findElement(By.xpath("//*[@id=\"levelOneMembership\"]")).click();
			driver.findElement(By.xpath("/html/body/div[4]/ul/li[4]/ul/li[5]/a")).click();
			driver.findElement(By.xpath("/html/body/div[7]/form/div[1]/table/tbody/tr[2]/td[2]/input")).sendKeys("Test1234");
			driver.findElement(By.xpath("//*[@id=\"memGroupType\"]/option[3]")).click();
			driver.findElement(By.xpath("//*[@id=\"organizationType\"]/option[7]")).click();
			driver.findElement(By.xpath("//*[@id=\"industryClassCode\"]")).sendKeys("7372");
			driver.findElement(By.xpath("//*[@id=\"action\"]/option[1]")).click();
			driver.findElement(By.xpath("/html/body/div[7]/form/center/input[2]")).click();
			driver.findElement(By.xpath("//*[@id=\"memGroupTypeAction\"]/option[3]")).click();
			driver.findElement(By.xpath("//*[@id=\"onshoreServiceLevelCode\"]/option[2]")).click();
			driver.findElement(By.xpath("//*[@id=\"employeeCount\"]")).sendKeys("101");
			driver.findElement(By.xpath("//*[@id=\"carrierID1\"]")).sendKeys("36");
			driver.findElement(By.xpath("//*[@id=\"action\"]/option[2]")).click();
			driver.findElement(By.xpath("/html/body/div[7]/form/center/input[2]")).click();
			driver.findElement(By.xpath("/html/body/div[2]/button[1]")).click();
			driver.findElement(By.xpath("/html/body/div[7]/form/div[1]/table/tbody/tr[1]/td[2]/input")).sendKeys(Keys.chord(Keys.CONTROL, "C"));
			
			WebDriver driver1=new EdgeDriver();
			driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver1.get("https://imdesktop-pp.uhc.com/customerProfile/customerDemographics");
			driver1.manage().window().maximize();
			//driver1.findElement(By.xpath("//*[@id=\"sideMenu\"]/div/ul/li[2]")).click();
			driver1.findElement(By.xpath("//*[@id=\"app\"]/section/section/main/div[2]/div/div[1]/div/div/button")).click();
			driver1.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Test123");
			driver1.findElement(By.xpath("//*[@id=\"platform\"]/label[1]/span[1]/input")).click();
			driver1.findElement(By.xpath("//*[@id=\"customerNumber\"]")).sendKeys(Keys.chord(Keys.CONTROL, "V"));
			driver1.findElement(By.xpath("//*[@id=\"platform\"]/label[1]/span[1]/input")).click();
			driver1.findElement(By.xpath("//*[@id=\"originalEffectiveDate\"]/div/input")).click();
			driver1.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[1]/div/input")).sendKeys("07/01/2023");
			driver1.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td[7]/div")).click();
			//driver1.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td[1]/div")).click();
			driver1.findElement(By.xpath("//*[@id=\"comments\"]")).sendKeys("Test");
			//Thread.sleep(1000);
			driver1.findElement(By.xpath("//*[@id=\"timelineDate\"]/div/input")).click();
			//Thread.sleep(1000);
			driver1.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div[1]/div/input")).sendKeys("07/01/2023");
			driver1.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td[7]/div")).click();
			driver1.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[7]/div/div/div[2]/div/span/div")).click();
			
			//Thread.sleep(1000);
			//Select qualifyingEventType = new Select(driver.findElement(By.className("ant-select-selection__rendered")));
			//qualifyingEventType.selectByValue("New Business");
			
			//driver1.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[7]/div/div/div[2]")).click();
			//Thread.sleep(1000);
			//driver1.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[7]/div/div/div[2]/div")).sendKeys(Keys.TAB);
			driver1.findElement(By.className("ant-select-selection__rendered")).click();
			driver1.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[7]/div/div/div[2]/div")).sendKeys(Keys.DOWN);
			driver1.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[7]/div/div/div[2]")).sendKeys(Keys.DOWN);
			driver1.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[7]/div/div/div[2]")).sendKeys(Keys.DOWN,Keys.ENTER);
			//Select qualifyingEventType = new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[7]/div/div/div[2]")));
			//qualifyingEventType.selectByVisibleText("New Business");
			driver1.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td[7]/div")).sendKeys(Keys.TAB);
			driver1.findElement(By.xpath("//*[@id=\"timelineDate\"]/div/input")).click();
			driver1.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td[7]/div")).sendKeys("07/01/2023");
			driver1.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td[7]/div")).click();
			
			
			
			driver1.findElement(By.xpath("//*[@id=\"transactionType\"]/div")).click();
			driver1.findElement(By.xpath("//*[@id=\"transactionType\"]/div/div/div")).click();
			driver1.findElement(By.xpath("//*[@id=\"effectiveDate\"]/div/input")).click();
			driver1.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[1]/div/input")).sendKeys("07/01/2023");
			Thread.sleep(1000);
			
			driver1.findElement(By.xpath("//*[@id=\"transactionType\"]/div/span/i/svg")).click();
			driver1.findElement(By.xpath("//*[@id=\"transactionType\"]/div/span")).click();
			driver1.findElement(By.xpath("//*[@id=\"transactionType\"]/div/div")).click();
			/*List<WebElement> allOptions = driver.findElements(By.xpath("//*[@id=\"transactionType\"]/div/div/div"));

			String option = "Highest to lowest";

			

			for (int i = 0; i < allOptions.size(); i++) {

			if (allOptions.get(i).getText().contains("New Business")) {

			 allOptions.get(i).click();

			System.out.println("clicked");
*/
			
			}
			}
		
//			driver1.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td[7]/div")).click();
			/*
			 * Select action = new
			 * Select(driver1.findElement(By.xpath("//*[@id=\"transactionType\"]/div/div")))
			 * ; action.selectByVisibleText("New Business");
			 */
			//*[@id="transactionType"]/div/div
			//driver.findElement(By.xpath("//*[@id=\"memGroupID\"]")).click();
			//driver.findElement(By.xpath("//*[@id=\"memGroupID\"]")).click();
			
//			Thread.sleep(1000);
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("window.scrollBy(0,1000)","");
//			Select drpDown = new Select(driver.findElement(By.xpath("//*[@id=\"transactionType\"]/div/div")));
//			drpDown.selectByVisibleText("New Business");
//			driver.findElement(By.xpath("//*[@id=\"transactionType\"]/div/div/div")).click();
//			driver.findElement(By.xpath("/html/body/div[7]/form/center/input[2]")).click();
//			driver.findElement(By.xpath("//*[@id=\"tabDiv_0\"]/div/div/ul/li[1]/a")).click();
//			driver1.findElement(By.xpath("//*[@id=\"transactionType\"]/div/div/div")).click();
//			driver1.findElement(By.xpath("//*[@id=\"effectiveDate\"]/div/input")).click();
//			driver1.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[1]/div/input")).sendKeys("07/01/2023");		
		}
		
		
				



		

