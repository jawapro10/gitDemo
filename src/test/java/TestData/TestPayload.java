package TestData;

import java.util.ArrayList;
import java.util.List;

import POJO.addplacereq;
import POJO.deleteplacereq;
import POJO.location1;

public class TestPayload {
	
	
	public addplacereq addplacereq(String name, String address) {
		
		addplacereq addreq = new addplacereq();
		addreq.setAddress(address);
		addreq.setLanguage("French-IN");
		addreq.setName(name);
		addreq.setPhone_number("(+91) 983 893 3937");
		addreq.setWebsite("http://google.com");
		addreq.setAccuracy(50);
		
		List<String> typelist = new ArrayList <String>();
		typelist.add("shoe park");
		typelist.add("shop");
		addreq.setTypes(typelist);
		
		location1 loc = new location1();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		addreq.setLocation(loc);
		
		return addreq;
	}
	
	public deleteplacereq deleteapireq(String placeid) {
		
		deleteplacereq delreq = new deleteplacereq();
		delreq.setPlace_id(placeid);
		return delreq;	
	}
}
