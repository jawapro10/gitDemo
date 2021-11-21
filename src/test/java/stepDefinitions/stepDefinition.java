package stepDefinitions;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import TestData.TestPayload;
import TestData.Utils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Configfiles.APIresources;

public class stepDefinition extends Utils{
	
	RequestSpecification res;
	Response response;
	String responseString;
	String ActualRespvalue;
	static String placeId;
	TestPayload data = new TestPayload();

	@Given("^Add place json payload is available with name\"([^\"]*)\" address \"([^\"]*)\"$")
	public void add_place_json_payload_is_available_with_name_address(String name, String address) throws Throwable{
		
		res = given().spec(reqspecification()).body(data.addplacereq(name, address));
		
	}

	@When("^post the request to \"([^\"]*)\" with HTTP \"([^\"]*)\" method$")
	public void post_the_request_to_with_HTTP_method(String APIType, String HTTPmethod) throws Throwable {
			
			APIresources resourcename = APIresources.valueOf(APIType);
			//build response with responsespecbuilder class
			if(HTTPmethod.equalsIgnoreCase("POST"))
			response = res.when().post(resourcename.returnresource())
		    		.then().spec(responsespec()).extract().response();
			
			else if (HTTPmethod.equalsIgnoreCase("GET"))
				response = res.when().get(resourcename.returnresource())
	    		.then().spec(responsespec()).extract().response();
			else response = res.when().delete(resourcename.returnresource())
		    		.then().spec(responsespec()).extract().response();
	    	
	}

	@Then("^validate the status code is (\\d+)$")
	public void validate_the_status_code_is(long expstatuscode) throws Throwable {
	    
		Assert.assertEquals(expstatuscode, response.getStatusCode());
	}

	@Then("^the \"([^\"]*)\" is \"([^\"]*)\" in generated in the response and get placeId$")
	public void the_is_in_generated_in_the_response_and_get_placeId(String Keyvalue, String expectedvalue) throws Throwable {
	    
		ActualRespvalue = getJsonPath(response,Keyvalue);
		
		Assert.assertEquals(ActualRespvalue,expectedvalue);
		
		placeId = getJsonPath(response,"place_id");
		
		System.out.println("The Place ID id "+placeId);
		
	}
	
	@Given("^GET place API with \"([^\"]*)\"$")
	public void get_place_API_with(String placeId) throws Throwable {
		placeId = this.placeId;
		res = given().spec(reqspecification()).queryParam("place_id", placeId);
	}
	
	@Given("^Delete place API is available with payload$")
	public void delete_place_API_is_available_with_payload() throws Throwable {
		
		res = given().spec(reqspecification()).body(data.deleteapireq(placeId));
	    
	}
	
}
