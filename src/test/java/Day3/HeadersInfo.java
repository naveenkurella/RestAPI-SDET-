package Day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersInfo {
	
	@Test(priority = 1)
	void testHeader() {
		
		when()
			.get("https://google.com/")
		
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Server", "gws")
			.header("Content-Encoding", "gzip")
			//.log().body()
			//.log().headers()
			//.log().cookies()
			.log().all();
		
	}
	
	//@Test(priority=2)
	void getCookiesInfo() {
		
	Response res=	when()
		.get("https://google.com/");
	
	Headers hds=res.headers();
	
	System.out.println("--------------------------------------");
	for(Header hd:hds) {
		
		System.out.println(hd.getName() +"  "+hd.getValue());
	}
		
		
	}

}
