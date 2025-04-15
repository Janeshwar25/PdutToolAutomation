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

		public class DateCirrus {
			

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
							
							"110041180698",
							"110041241644",
							"110041241645",
							"110041261937",
							"110041261938",
							"110041261939",
							"110041261940",
							"110041261941",
							"110041261942",
							"110041261943",
							"110041251777",
							"110041251778",
							"110041251779",
							"110041241652",
							"110041241653"

							

	



							
							
					};
					int i = 0;
					for (i = 0; i < MemberID.length; i++)

					{
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@id=\"memberID\"]")).sendKeys(MemberID[i]);
						driver.findElement(By.xpath("/html/body/div[7]/form/center/input[2]")).click();
				        driver.findElement(By.xpath("//*[@id=\"main\"]/form/div[2]/p/table/tbody/tr[2]/td[1]/a")).click();
				        driver.findElement(By.xpath("//*[@id=\"tabDiv_0\"]/div/div/ul/li[5]/a/span")).click();
				        driver.findElement(By.xpath("//*[@id=\"listTable\"]/tbody/tr[2]/td[1]/a")).click();
				        
				        driver.findElement(By.xpath("//*[@id=\"benPlanEffDate\"]")).sendKeys("03012024");
				        driver.findElement(By.xpath("//*[@id=\"UPDATE\"]")).click();
				        driver.findElement(By.xpath("//*[@id=\"8b420a821b8f4fd0bb0993d5880835a6-enabled\"]")).click();
				        //driver.findElement(By.xpath("/html/body/div[7]/form/div[2]/input[2]")).click();
				        driver.findElement(By.xpath("//*[@id=\"tabDiv_0\"]/div/div/ul/li[1]/a/span")).click();
					}
				} catch (Exception e) {
					e.printStackTrace();

				}

			}
		}

