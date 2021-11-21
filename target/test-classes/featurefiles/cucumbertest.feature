@Test
Feature: validating place API in Map UI

@Addplace
Scenario Outline: Add a place in the google map API
Given Add place json payload is available with name"<name>" address "<address>"
When post the request to "addplaceAPI" with HTTP "POST" method
Then validate the status code is 200
And the "<attribute>" is "<expvalue>" in generated in the response and get placeId

Examples:
|name | address 	 | attribute  | expvalue |
|jawa | 2901 WW 204  | status  	  | OK       |



@deleteplace
Scenario Outline: Get a place in the google map API
Given GET place API with "placeId"
When post the request to "getplaceAPI" with HTTP "GET" method
Then validate the status code is 200
Given Delete place API is available with payload
When post the request to "deleteplaceAPI" with HTTP "DELETE" method
Then validate the status code is 200
And the "<attribute>" is "<expvalue>" in generated in the response and get placeId

Examples:
| attribute  | expvalue |
| status  	 | OK       |


