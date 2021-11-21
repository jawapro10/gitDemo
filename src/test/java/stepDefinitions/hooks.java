package stepDefinitions;

import cucumber.api.java.Before;

public class hooks{
	
	@Before("@deleteplace")
	public void BeforeScenario() throws Throwable {
		
		if(stepDefinition.placeId==null) {
		stepDefinition m = new stepDefinition();
		m.add_place_json_payload_is_available_with_name_address("jawa", "2901 WW 204");
		m.post_the_request_to_with_HTTP_method("addplaceAPI", "POST");
		m.the_is_in_generated_in_the_response_and_get_placeId("status", "OK");
		}
		
	}

}
