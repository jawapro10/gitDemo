package TestData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	static RequestSpecification Req;
	static ResponseSpecification Resp;
	static String responseString;
	static String Jsonpathvalue;
	
	public RequestSpecification reqspecification() throws IOException{
		if(Req==null){
			PrintStream logs = new PrintStream(new FileOutputStream("logs.txt"));
		//build request with Request spec builder class
		Req = new RequestSpecBuilder().addFilter(RequestLoggingFilter.logRequestTo(logs)).addFilter(ResponseLoggingFilter.logResponseTo(logs)).setContentType(ContentType.JSON).setBaseUri(returnconfigvalues("baseURI")).addQueryParam("key", "qaclick123").build();
		return Req;
		}
		return Req;
	
	}
	
	public ResponseSpecification responsespec() {
		
		Resp = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		return Resp;
	}
	
	public static String returnconfigvalues(String key) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("src\\test\\java\\resources\\Configfiles\\config.properties");
		prop.load(file);
		return prop.getProperty(key);
	}
	
	public String getJsonPath(Response response, String Keyvalue){
		
		responseString = response.asString();
		JsonPath js= new JsonPath(responseString);
		Jsonpathvalue = js.get(Keyvalue);
		return Jsonpathvalue;
		
	}

}
