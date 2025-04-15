package myproject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestMyUHC {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver","C:\\Users\\jchowdha\\Documents\\learningpoint\\AcetT1\\driver\\msedgedriver.exe");

		
		WebDriver driver=new EdgeDriver();
		//WebDriverWait wait = new WebDriverWait(driver);
		try {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://member.int.uhc.com/myuhc?action=logout");
		driver.findElement(By.xpath("/html/body/main/div[3]/div/section/div[2]/div/div/div[2]/div[1]/div/button")).click();
		driver.manage().window().maximize();
		DataProvider DP= new DataProvider();
	
		
		Thread.sleep(1000);
		
			
		
		 //ArrayList<String> list = new ArrayList<String>(); 
		 //list.add(0, null);
		
		
		
		 String[] MemberID = { 
				 
				 "FNDanyetteSubsLNAcedo",
				 "FNAgusteSubsLNAlbinson",
				 "FNAlphonseSubsLNAdolthine",
				 "FNElizSubsLNBaiyle",
				 "FNFredaSubsLNBamber",
				 "FNDanyetteSubsLNAcedo",
				 "FNBendickSubsLNAdriaens",
				 "FNCullSubsLNBenjamin",
				 "FNCassaundraSubsLNAtheru",
				 "FNClaudieSubsLNBerney"












	}; 
		 int i=0;
		 for (i=0;i<MemberID.length ;i++)
		  
		 {
			 Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(MemberID[i]);
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Test2daytest");
			driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
			driver.findElement(By.xpath("/html/body/div[1]/div/main/div[3]/div/div[2]/form/div/div[4]/div/button")).click();
			driver.findElement(By.xpath("//*[@id=\"confirmationCode\"]")).sendKeys("987654");
			driver.findElement(By.xpath("/html/body/div[1]/div/main/div[3]/div/div[2]/form/div/div[4]/div/button")).click();
			
			
			
			 Thread.sleep(3000);
				/*
				 * Set<String> windowhandles = driver.getWindowHandles();
				 * System.out.println(windowhandles);
				 * 
				 * Iterator<String> iterator = windowhandles.iterator(); String parantwindow =
				 * iterator.next(); String childwindow = iterator.next();
				 */
				
				/*
				 * driver.switchTo().window(childwindow);
				 * 
				 * Set<String> handles = driver.getWindowHandles(); // get all window handles
				 * for (String handle : handles) { childwindow = handle;
				 * 
				 * } driver.switchTo().window(childwindow);
				 */
			    
			
			 /*driver.findElement(By.xpath("//*[@id=\"global-header\"]/div//div/header/div[1]/div/div/nav/div/ul/li[1]/a")).sendKeys(Keys.chord(Keys.ALT, "D" ));
	        
	        
	        driver.findElement(By.xpath("//*[@id=\"global-header\"]/div//div/header/div[1]/div/div/nav/div/ul/li[1]/a")).sendKeys(Keys.chord(Keys.ENTER ));*/

			// wait.until(ExpectedConditions.alertIsPresent());
			 Alert alert = driver.switchTo().alert();
			 alert.dismiss();
			 
			 
		    driver.findElement(By.xpath("/html/body/div[8]/div[3]/div/img")).click();
			driver.findElement(By.xpath("//*[@id=\"global-header\"]/div//div/header/div[1]/div/div/nav/div/ul/button[3]")).click();
			driver.findElement(By.xpath("//*[@id=\"global-header\"]/div//div/header/div[1]/div/div/nav/div/ul/div/div/ul/li[1]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[3]/div[5]/div/div/div[2]/div/a")).click();
			
			
			File File = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			
		 }
		}
		catch (Exception e) {
			e.printStackTrace();

		}


	}
	

}
