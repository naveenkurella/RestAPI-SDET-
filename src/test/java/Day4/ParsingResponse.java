package Day4;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingResponse {
	
	@Test(priority = 1)
	void responseValidations() {
		
		
		Response res=
				given()
				.contentType(ContentType.JSON)
				.when()
			.get("http://localhost:3000/store");
		
		Assert.assertEquals(res.statusCode(), 200);  //validation 1
		Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
		String phoneNum=res.jsonPath().get("users[4].phoneNumber").toString();
		Assert.assertEquals(phoneNum, "111111111");
		
		
	}
	
	
	@Test(priority = 2)
	void testJSONData() {
		
		
		Response res=
				given()
				.contentType(ContentType.JSON)
				.when()
			.get("http://localhost:3000/store");
		
		/*
		 * Assert.assertEquals(res.statusCode(), 200); //validation 1
		 * Assert.assertEquals(res.getHeader("Content-Type"),
		 * "application/json; charset=utf-8"); String
		 * phoneNum=res.jsonPath().get("users[4].phoneNumber").toString();
		 * Assert.assertEquals(phoneNum, "111111111");
		 */
		
		
		JSONObject jo=new JSONObject(res.asString());
		
		for(int i=0;i<jo.getJSONArray("users").length();i++) {
			
			String email=jo.getJSONArray("users").getJSONObject(i).get("emailAddress").toString();
			System.out.println(email);
		}
		double totalPrice = 0;
		for (int i = 0; i < jo.getJSONArray("users").length(); i++) {

			String price = jo.getJSONArray("users").getJSONObject(i).get("price").toString();
			totalPrice = totalPrice + Double.parseDouble(price);

		}
		System.out.println(totalPrice);
		Assert.assertEquals(totalPrice, 125);
	}

}
