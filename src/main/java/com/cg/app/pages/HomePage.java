package com.cg.app.pages;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cg.app.base.TestBase;

public class HomePage extends TestBase {
	
	

	public void verifyVaccineSlots(String statep,String districtp,String costp,String vaccinep) throws InterruptedException 
	{
		//String statep = prop.getProperty("state");
		//String districtp = prop.getProperty("district");
		//String costp = prop.getProperty("cost");
		//String vaccinep = prop.getProperty("vaccine");
		
		WebElement search = driver.findElement(By.xpath("//div[@class = 'mat-tab-label-content' ] [text()= 'Search by District']"));
        
        js.executeScript("arguments[0].click();", search);
        //js.executeScript("arguments[0].scrollIntoView();", search);
        
        WebElement state = driver.findElement(By.id("mat-select-value-1"));
        js.executeScript("arguments[0].click();", state);
        
        WebElement stateselect = driver.findElement(By.xpath("//span[contains(text(),'"+statep+"')]"));
        js.executeScript("arguments[0].click();", stateselect);
        
        Thread.sleep(600);
        
        WebElement district = driver.findElement(By.id("mat-select-value-3"));
        js.executeScript("arguments[0].click();", district);
        
        WebElement districtselect = driver.findElement(By.xpath("//span[contains(text(),'"+districtp+"')]"));
        js.executeScript("arguments[0].click();", districtselect);
        
        WebElement searchbox = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
        js.executeScript("arguments[0].click();", searchbox);
        
        Thread.sleep(600);
        
        WebElement cost = driver.findElement(By.xpath("//label[contains(text(),'"+costp+"')]"));
        js.executeScript("arguments[0].click();", cost);
        
        WebElement vaccine = driver.findElement(By.xpath("//label[contains(text(),'"+vaccinep+"')]"));
        js.executeScript("arguments[0].click();", vaccine);
        
        
        
        //Get Vaccination Centres
        List<WebElement> centres = driver.findElements(By.xpath("//div[@class='center-name-box']/h5[@class='center-name-title']"));
        
        
        //Get Dose1 availability
        
        List<WebElement> dose1 = driver.findElements(By.xpath("//div[@class='dose1-block']/span[2]"));
        
        
        //Get Dose2 availability
        
        List<WebElement> dose2 = driver.findElements(By.xpath("//div[@class='dose2-block']/span[2]"));
        
       
        System.out.println("Centres| Dose 1 | Dose 2 |");
        for(int i=0;i<centres.size();i++)
        {
        	
        	System.out.print(centres.get(i).getAttribute("innerText")+" |");
        	if(dose1.get(i).getCssValue("color").equals("rgba(255, 0, 0, 1)"))
        	{
        		System.out.print("0 slot |");
        	}
        	else
        	System.out.print(dose1.get(i).getAttribute("innerText")+" |");
        	
        	if(dose2.get(i).getCssValue("color").equals("rgba(255, 0, 0, 1)"))
        	{
        		System.out.println("0 slot |");
        	}
        	else
        	System.out.println(dose2.get(i).getAttribute("innerText")+" |");
        }
		
	}

	public String verifyHomePageTitle() {
		
		return driver.getTitle();
	}







	
	

}
