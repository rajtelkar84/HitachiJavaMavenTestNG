package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Searchedpage {
	
	private static WebElement element = null;
	
	//region--- pageobjects
	
	public static WebElement SearchResultText(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//h4[@class='results']"));
		// no result -- Sorry, your search didn't return any results.
		// Search result -- Search results for: abc
		return element;
	}
	
	public static List<WebElement> searchedResultLinklist(WebDriver driver)
	{
		return driver.findElements(By.xpath("//div[@class='search-result']/p/a"));
	}
	
	// endrigion
	
	//region--- pageActions
	public static List<Object> navigatetoSearchResult(WebDriver driver) throws InterruptedException
	{
		String searchedresulttext = SearchResultText(driver).getText();
		String afternavigationurl = " " ;
		
		List<Object> al = new ArrayList<Object>();
		
		if(searchedresulttext.contains("Search results for"))
		{
			int searchedResultLinklistcount = searchedResultLinklist(driver).size();
			al.add(searchedResultLinklistcount);
			System.out.println(searchedResultLinklistcount);
			
			for(int j=0;j<searchedResultLinklistcount; j++)
			{
				try {
					
				     searchedResultLinklist(driver).get(j).click();
				    }
				catch(Exception e)
				   {
					((JavascriptExecutor) driver).executeScript(("scroll(0, 200);"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchedResultLinklist(driver).get(j));
					Thread.sleep(5000);
					searchedResultLinklist(driver).get(j).click();
				   }
				
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.invisibilityOfAllElements(searchedResultLinklist(driver)));
				
				 afternavigationurl =  driver.getCurrentUrl();
				al.add(afternavigationurl);
				driver.navigate().back();
				
				Thread.sleep(10000);
				
				
			}
		}
		else
		{
			System.out.println("No result with Given kewyword");
			
		}
		System.out.println(al);
		return al;
	}
	
	// endrigion

}
