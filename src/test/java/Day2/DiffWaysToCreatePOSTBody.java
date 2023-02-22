package Day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/*How many ways we can create body
-------------------------------------------------
1.Using Hashmap
2.org.json library
3.POJO clas( Plain Old Java Object)
4.Using any external josn file*/

public class DiffWaysToCreatePOSTBody {
	
	// 1.Using Hashmap

	int id;

	//@Test(priority = 1)
	void testMethod() {
		HashMap d = new HashMap();
		d.put("email", "nk2777@gmail.com");
		d.put("first_name", "nk2@gmail.com");
		d.put("last_name", "nk2@gmail.com");

	id=	given().contentType("application/json")
		.body(d)
		.when()
		.post("http://localhost:3000/data")
		.jsonPath()
		 .getInt("id");
		/*
		 * .then() .statusCode(201) .body("email",equalTo("nk2@gmail.com"))
		 * .header("Content-Type",equalTo("application/json; charset=utf-8"))
		 * 
		 * .log().all();
		 */
	System.out.println(id);
	}

//	2.org.json library
	
	//@Test(priority = 1)
	void uingJSOnLibrary() {
		JSONObject d=new JSONObject();

		d.put("email", "nk2777@gmail.com");
		d.put("first_name", "nk2@gmail.com");
		d.put("last_name", "nk2@gmail.com");

	id=	given()
			.contentType("application/json")
			.body(d.toString())
		.when()
			.post("http://localhost:3000/data")
			.jsonPath()
			.getInt("id");
		/*
		 * .then() .statusCode(201) .body("email",equalTo("nk2@gmail.com"))
		 * .header("Content-Type",equalTo("application/json; charset=utf-8"))
		 * 
		 * .log().all();
		 */
	System.out.println(id);
	}
	
	//3.POJO clas( Plain Old Java Object)
	
	//@Test(priority = 1)
	void uingPOJO() {
		
		Pojo_PostRequest data=new Pojo_PostRequest();
		
		
		data.setEmail("nk2777@gmail.com");
		data.setFirst_name("nk2777@gmail.com");
		data.setSecond_name("nk2777@gmail.com");
		
	id=	given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/data")
			.jsonPath()
			.getInt("id");
		/*
		 * .then() .statusCode(201) .body("email",equalTo("nk2@gmail.com"))
		 * .header("Content-Type",equalTo("application/json; charset=utf-8"))
		 * 
		 * .log().all();
		 */
		System.out.println(id);
	}

// 	4.Using any external josn file*/
	@Test(priority = 1)
	void UsingJSONFile() throws IOException {
	  
		File f=new File(".\\body.json");	
	    FileReader fr = new FileReader(f);
	    JSONTokener tr=new JSONTokener(fr);
	    JSONObject jo= new JSONObject(tr);
	
	  id=	given()
			.contentType("application/json")
			.body(jo)
		.when()
			.post("http://localhost:3000/data")
			.jsonPath()
			.getInt("id");
		/*
		 * .then() .statusCode(201) .body("email",equalTo("nk2@gmail.com"))
		 * .header("Content-Type",equalTo("application/json; charset=utf-8"))
		 * 
		 * .log().all();
		 */
		System.out.println(id);
	}
	@Test(priority = 2, enabled = true)
	void deleteUser() {
		System.out.println(id);
		when().delete("http://localhost:3000/data/" + id).then().statusCode(200);

	}
}
