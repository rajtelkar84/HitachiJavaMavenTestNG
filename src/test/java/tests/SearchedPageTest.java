package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HitachiMainPage;
import pages.Searchedpage;
import testSetup.SeleniumSetup;

public class SearchedPageTest extends SeleniumSetup{
	
	@Test(dataProvider = "allLinksNavigation")
	 public void navigatetoEachSearchedLink(String listofword) throws InterruptedException
	 {
	  HitachiMainPage.SearchResult(driver,listofword); 
	  List<Object> afterseachedclickURL = Searchedpage.navigatetoSearchResult(driver);
	  Assert.assertTrue(afterseachedclickURL.size() > 0);
	  Assert.assertEquals(afterseachedclickURL.get(0), afterseachedclickURL.size()-1);	
	 }

}
