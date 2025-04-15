package myproject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class CirrusAlpha {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.edge.driver","C:\\Users\\jchowdha\\Documents\\learningpoint\\AcetT1\\driver\\msedgedriver.exe");

	WebDriver driver=new EdgeDriver();
	try {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://cirrus-alpha.optum.com/member.uhg");
	driver.findElement(By.xpath("//*[@id=\"1\"]")).click();
	driver.manage().window().maximize();
	DataReader DR= new DataReader();
	DR.getClass();
	
	
	Thread.sleep(1000);
	
	String[] MemberID = {"110008183338"};
	int i=0;
	for (i=0; i<MemberID.length;i++)
	
	{
		driver.findElement(By.xpath("//*[@id=\"memberID\"]")).sendKeys(MemberID[i]);
		driver.findElement(By.xpath("/html/body/div[7]/form/center/input[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"main\"]/form/div[2]/p/table/tbody/tr[2]/td[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"tabDiv_0\"]/div/div/ul/li[5]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"listTable\"]/tbody/tr[2]/td[1]/a")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)","");
		driver.findElement(By.xpath("//*[@id=\"action\"]/option[3]")).click();
		driver.findElement(By.xpath("/html/body/div[7]/form/center/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"tabDiv_0\"]/div/div/ul/li[1]/a")).click();
		
		
			 
	
	}
	}
	catch (Exception e) {
		e.printStackTrace();
	
	//WebElement m =driver.findElement(By.xpath("//*[@id=\"5bc1c61fa058406481f558bea0580213-enabled\"]"));
//	m.sendKeys(Keys.ENTER);
	
	
	/*driver.findElement(By.id("username")).sendKeys("EBAgt.DCSMDGSAAgt.No.On@optum.acet.test.auto.QA");
	driver.findElement(By.id("password")).sendKeys("ACETTestUserOM6I8Bsf!");
	driver.findElement(By.id("Login")).click();
	driver.findElement(By.className("btn")).click();
	/*driver.findElement(By.className("(.//button)[4]")).click();
	driver.findElement(By.id("Search")).click();*/
	/*driver.findElement(By.xpath("//*[@name=\"thePage:myform:memberId\"]")).sendKeys("09471403100");
	driver.findElement(By.id("//*[@id=\"baseSearch\"]/div/div/fieldset/ul/li[3]/div/span/lightning-input/div/div")).click();
	driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[1]/div/div[2]/div/button[1]")).click();
	Thread.sleep(100000);
	driver.findElement(By.xpath("//*[@id=\"thePage:myform:groupId\"]")).sendKeys("09471403100");
	driver.findElement(By.xpath("driver.findElement(By.id(\"Search\")).click();")).click();*/


	}
	
	
	

	
}

}
