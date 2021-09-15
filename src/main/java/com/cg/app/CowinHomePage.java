package com.cg.app;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CowinHomePage {

	static WebDriver driver;
	
	
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jonlopes\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        
        driver.get("https://www.cowin.gov.in/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
        WebElement search = driver.findElement(By.xpath("//div[@class = 'mat-tab-label-content' ] [text()= 'Search by District']"));
        
        js.executeScript("arguments[0].click();", search);
        //js.executeScript("arguments[0].scrollIntoView();", search);
        
        WebElement state = driver.findElement(By.id("mat-select-value-1"));
        js.executeScript("arguments[0].click();", state);
        
        WebElement stateselect = driver.findElement(By.xpath("//span[contains(text(),'Maharashtra')]"));
        js.executeScript("arguments[0].click();", stateselect);
        
        Thread.sleep(500);
        
        WebElement district = driver.findElement(By.id("mat-select-value-3"));
        js.executeScript("arguments[0].click();", district);
        
        WebElement districtselect = driver.findElement(By.xpath("//span[contains(text(),'Palghar')]"));
        js.executeScript("arguments[0].click();", districtselect);
        
        WebElement searchbox = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
        js.executeScript("arguments[0].click();", searchbox);
        
        WebElement free = driver.findElement(By.xpath("//label[contains(text(),'Paid')]"));
        js.executeScript("arguments[0].click();", free);
        
        WebElement vaccine = driver.findElement(By.xpath("//label[contains(text(),'Covishield')]"));
        js.executeScript("arguments[0].click();", vaccine);
        
        //Get Vaccination Centres
        List<WebElement> centres = driver.findElements(By.xpath("//div[@class='row-disp']/h5[@class='center-name-title']"));
        Iterator<WebElement> itr = centres.iterator();
        System.out.println(centres.size()+" Vaccine Centres Found:");
        while(itr.hasNext()) {
        
        	System.out.println(itr.next().getText());
        	
        }
        
        //Get Dose1 availability
        
        List<WebElement> dose1 = driver.findElements(By.xpath("//div[@class='dose1-block']/span[@class='available-slot ng-star-inserted' or @class='booked-slot ng-star-inserted']"));
        Iterator<WebElement> itr1 = dose1.iterator();
        System.out.println("Dose 1 slots:");
        while(itr1.hasNext()) {
            
        	System.out.println(itr1.next().getAttribute("innerText"));
        	
        }
        
        //Get Dose2 availability
        
        List<WebElement> dose2 = driver.findElements(By.xpath("//div[@class='dose2-block']/span[@class='available-slot ng-star-inserted' or @class='booked-slot ng-star-inserted']"));
        Iterator<WebElement> itr2 = dose2.iterator();
        System.out.println("Dose 2 slots:");
        while(itr2.hasNext()) {
            
        	System.out.println(itr2.next().getAttribute("textContent"));
        	
        }
        
        //driver.quit();

	}
}
