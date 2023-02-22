package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class CookiesDemo {
	
	@Test
	void testCookies() {
		
		when()
			.get("https://google.com/")
		
		.then()
			.cookie("AEC","ARSKqsJ_NXezyDu1mBJG65sqZP_Z2TVxJHrcxh8pYJVJ3VjIo7GnzTLaZRs")
			.log().all();
		
	}
	
	@Test
	void getCookiesInfo() {
		
		Response res=when()
			.get("https://google.com/");
		
	Map<String,String> allCookies=	res.getCookies();
	
	System.out.println(allCookies.keySet());
	
	for(String k:allCookies.keySet()) {
		
		String  value=res.getCookie(k);
		
		System.out.println("key ="+k +"  ,  " + "Value="+value);
	}
			
		
		
	}

}
