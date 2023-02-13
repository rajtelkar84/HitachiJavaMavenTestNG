package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HitachiMainPage;
import testSetup.SeleniumSetup;
import org.testng.Assert;

public class HitachiMainPageTests extends SeleniumSetup
{

	
 @Test(dataProvider = "keywordsearch")
 public void searchResult(String word)
 {
	 String aftersearhURL = HitachiMainPage.SearchResult(driver,word);
	 boolean result =aftersearhURL.contains(word);
	 Assert.assertTrue(result);	 
 }
}
