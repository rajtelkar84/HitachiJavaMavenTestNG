package testData;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider (name = "keywordsearch")
	public static Object[][] searchkeyworddata(){
		return new Object[][] {{"Hitachi"}, {"abc"},{"xyz"},{"asbnkasndsdl"}};
	}
	
	@DataProvider (name = "allLinksNavigation")
	public static Object[][] navigatetoallLinks(){
		return new Object[][] {{"xyz"}, {"abcasasasas"}};
	}

}
