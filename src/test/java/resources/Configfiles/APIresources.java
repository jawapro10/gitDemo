package resources.Configfiles;

public enum APIresources {
	
	addplaceAPI("/maps/api/place/add/json"),
	getplaceAPI("/maps/api/place/get/json"),
	deleteplaceAPI("/maps/api/place/delete/json");
	private String ApiRes;

	APIresources (String ApiRes){
		this.ApiRes = ApiRes;
	}
	
	public String returnresource() {
		return ApiRes;
		
	}

}
