package myproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ACET_Regression {


		public static void main(String[] args) {
			
			System.setProperty("webdriver.edge.driver","C:\\Users\\jchowdha\\Documents\\learningpoint\\AcetT1\\driver\\msedgedriver.exe");
		
		try {
			WebDriver driver=new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://test.salesforce.com/");
			driver.manage().window().maximize();
			Thread.sleep(1000);
			driver.findElement(By.id("username")).sendKeys("EBAgt.DCSMDGSAAgt.No.On@optum.acet.test.auto.QA");
			driver.findElement(By.id("password")).sendKeys("ACETTestUserOM6I8Bsf!");
			driver.findElement(By.id("Login")).click();
			driver.findElement(By.className("btn")).click();
			/*driver.findElement(By.className("(.//button)[4]")).click();
			driver.findElement(By.id("Search")).click();*/
			/*driver.findElement(By.xpath("//*[@name=\"thePage:myform:memberId\"]")).sendKeys("09471403100");
			driver.findElement(By.id("//*[@id=\"baseSearch\"]/div/div/fieldset/ul/li[3]/div/span/lightning-input/div/div")).click();
			driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[1]/div/div[2]/div/button[1]")).click();*/
			Thread.sleep(100000);
			driver.findElement(By.xpath("//*[@id=\"thePage:myform:groupId\"]")).sendKeys("09471403100");
			driver.findElement(By.xpath("driver.findElement(By.id(\"Search\")).click();")).click();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}
		
		
	            
		}
		
		}
