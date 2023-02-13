package tests;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testData.DataProviders;

public class APITests extends DataProviders{
	
	@Test(dataProvider = "keywordsearch")
	public void GetDetails(String searchKeyWord)
	{
		
		RestAssured.baseURI = "https://global.hitachi-solutions.com/?s="+ searchKeyWord +"&post_type=page";
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.get("");
		 
		 int statusCode = response.getStatusCode();
		 System.out.println("status code is :-"+ statusCode);
		 Assert.assertEquals(statusCode, 200);
	}

}
