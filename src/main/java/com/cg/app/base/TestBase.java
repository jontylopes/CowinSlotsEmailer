package com.cg.app.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static JavascriptExecutor js;

	
	
	public void initialization() throws InterruptedException{
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        
        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}



	 	
	
}
