package junitTests;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;


@RunWith(SerenityRunner.class)


public class TestSample {
	
	
	@Test
	public void Test()
	{
		RestAssured.baseURI ="https://reqres.in";
		Response resp=RestAssured.given().when().get("/api/users?page=2").then().assertThat().statusCode(200).extract().response();
		String ab = resp.asString();
		System.out.println(ab);
		
		List<Map<String,String>> comp = resp.jsonPath().getList("data");
		for(int i=0;i<comp.size();i++)
		{
			System.out.println(comp.get(i).get("first_name"));
		}		
	}
}
