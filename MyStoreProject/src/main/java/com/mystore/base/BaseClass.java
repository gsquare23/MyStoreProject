package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.mystore.actiondrivers.Action;
import com.mystore.utility.ExtentManager;
import com.mystore.utility.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	//public static WebDriver driver;
	// Declare ThreadLocal Driver
		public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
		
		
		@BeforeSuite(groups = {"Smoke", "Sanity", "Regression"})
		public void loadConfig() throws IOException {
			DOMConfigurator.configure("log4j.xml");
			Log.info("This is BeforeSuite Method");
			ExtentManager.setExtent();
			try { 
				prop = new Properties();
			
			System.out.println("Super Constructor invoked ");
			String filePath = "C:\\Users\\garvit.c.gupta\\eclipse-Selenium\\MyStoreProject\\Configuration\\config.properties";
			FileInputStream ip = new FileInputStream(filePath);
			prop.load(ip);
			
			//System.out.println("driver:  "+ driver );
			
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		
		}
			

	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}
	

	public void launchApp(String br)  {
		//String br = prop.getProperty("browser");
		System.out.println(br);
		if(br.equals("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver()); 
		}
		if(br.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver()); 
		}
		if(br.equals("MicrosoftEdge")) {
			WebDriverManager.edgedriver().setup(); 
			driver.set(new EdgeDriver());
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		
		//Implicit TimeOuts
		Action.implicitWait(getDriver(), Integer.parseInt(prop.getProperty("implicitWait")));
				//getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
		//PageLoad TimeOuts
		Action.pageLoadTimeOut(getDriver(), (Integer.parseInt(prop.getProperty("pageLoadTimeout"))));
		//getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(prop.getProperty("pageLoadTimeout"))));
		//Launching the URL
				getDriver().get(prop.getProperty("url"));
		
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport(); 
	}


}
