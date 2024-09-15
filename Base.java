package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class Base {
	public static WebDriver driver ;
	
	public WebDriver connect()
	{
		try {
			
			FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\projectguru99\\src\\test\\resources\\data.properties");
			Properties prop = new Properties();
			prop.load(fis);
			
			String browser = prop.getProperty("browser");
			String url = prop.getProperty("url");
			if(browser.equals("chrome"))
			{
				System.setProperty("webdriver.driver.chrome", "C:\\Users\\Admin\\Downloads\\chromedriver-win64\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browser.equals("ff"))
			{
				driver = new FirefoxDriver();
			}
			
			driver.get(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return driver;
	}

	
	public void screenshot(String name)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("C:\\Users\\Admin\\OneDrive\\Desktop\\ScreenShot\\image\\"+name+".png");
		
		try {
			Files.copy(source, dest);
			System.out.println("screenshot taken");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	
}
