package basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Timeouts;

public class Baseclass {

	public static Properties prop=new Properties();
	public static WebDriver driver;
	
	//step1
	
	public Baseclass() {
		
		try {
		FileInputStream file=new FileInputStream("C:\\Users\\vedan\\Desktop\\Roician\\Eclips\\HR\\src\\test\\java\\variable\\Config.properties");
		prop.load(file);		
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();	
		}
			catch(IOException a) {
				a.printStackTrace();
				
			}
	}
	//step 2
		
		public static void initiation() {
			
			String browsername = prop.getProperty("browser");
		
			if(browsername.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver","geckodriver.exe");
				driver = new FirefoxDriver ();
			}
				
				else if (browsername.equals("chrome")) {
					System.setProperty("webdriver.chrome.driver","chrome.exe");	
					driver = new ChromeDriver();
				}
					
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Timeouts.timepage));
			driver.get(prop.getProperty("url"));
			//driver.findElement(By.className(browsername))
				}
				
		public static void screenshot(String filename) {
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("C:\\Users\\vedan\\Desktop\\Roician\\Eclips\\HR\\src\\test\\java\\screenshot\\Screenshot" + filename+ ".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		}
		
		
