package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HitachiMainPage {
	
private static WebElement element = null;

//region--- pageobjects
	
	public static List<WebElement> GlobalSearchLink(WebDriver driver)
	{
		return driver.findElements(By.xpath("//a[@id='open-global-search']"));
	}
	
	public static List<WebElement> SearchInputBox(WebDriver driver)
	{

		return driver.findElements(By.xpath("//input[@id='site-search-keyword']"));
	}
//endrigion	
	
//	region--- pageActions
	
	public static String SearchResult(WebDriver driver ,String SearchKeyword)
	{
		int globalsearchlinkcount = GlobalSearchLink(driver).size();
		
		if(globalsearchlinkcount > 0)
		{
			GlobalSearchLink(driver).get(0).click();
		}
		
		int SearchInputBoxcount = SearchInputBox(driver).size();
		
		try
		{
			if(SearchInputBoxcount > 0)
			{
				SearchInputBox(driver).get(0).clear();
				SearchInputBox(driver).get(0).click();
				SearchInputBox(driver).get(0).sendKeys(SearchKeyword);
			}
			else
			{
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfAllElements(SearchInputBox(driver)));
			}
		}
		catch(Exception e)
		{
			SearchInputBox(driver).get(0).clear();
			SearchInputBox(driver).get(0).click();
			SearchInputBox(driver).get(0).sendKeys(SearchKeyword);
		}
		
		SearchInputBox(driver).get(0).sendKeys(Keys.ENTER);
		
		String currentURL = driver.getCurrentUrl();
		
		return currentURL;
	}
	//endrigion	
	

}
