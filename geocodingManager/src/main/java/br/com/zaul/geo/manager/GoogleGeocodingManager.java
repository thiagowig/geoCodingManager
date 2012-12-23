package br.com.zaul.geo.manager;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;

import br.com.zaul.geo.bean.GeoStatus;
import br.com.zaul.geo.bean.Location;

/**
 * 
 * @author thiago
 *
 */
public class GoogleGeocodingManager {
	
	/** . */
	private final String BASE_URL = "http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=";

	/** . */
	private final String PROPERTIE_STATUS = "status";
	/** . */
	private final String PROPERTIE_RESULTS = "results";
	/** . */
	private final String PROPERTIE_GEOMETRY = "geometry";
	/** . */
	private final String PROPERTIE_LOCATION = "location";
	/** . */
	private final String PROPERTIE_LATITUDE = "lat";
	/** . */
	private final String PROPERTIE_LONGITUDE = "lng";
	/** . */
	private final String PROPERTIE_FORMATTED_ADDRESS = "formatted_address";

	/** . */
	private String address;
	/** . */
	private JSONObject jsonCall;
	/** . */
	private List<Location> locations;
	
	/**
	 * 
	 * @param address
	 */
	private GoogleGeocodingManager(String address) {
		this.address = this.removeSpaces(address);
		this.locations = new ArrayList<Location>();
	}
	
	/**
	 * 
	 * @param address
	 * @return
	 */
	private String removeSpaces(String address) {
		address = address.replace(" ", "+");
		
		return address;
	}
	
	/**
	 * 
	 * @param address
	 * @return
	 * @throws Exception 
	 */
	public static List<Location> getLocation(String address) throws Exception {
		GoogleGeocodingManager geocodingManager = new GoogleGeocodingManager(address);

		return geocodingManager.getLocation();
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	private List<Location> getLocation() throws Exception {
		this.executeGoogleCall();
		
		if (GeoStatus.OK.name().equals(this.jsonCall.get(this.PROPERTIE_STATUS))) {
			this.generateListOfLocations();
		}
		
		return this.locations;
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	private void executeGoogleCall() throws Exception {
		URL url = new URL(this.BASE_URL + this.address);
	    ByteArrayOutputStream output = new ByteArrayOutputStream(1024);
	    IOUtils.copy(url.openStream(), output);
	    output.close();

	    this.jsonCall = (JSONObject) JSONSerializer.toJSON(output.toString());
	}
	
	/**
	 * 
	 * @param location
	 */
	private void generateListOfLocations() {
		JSONArray resultArray = JSONArray.fromObject(this.jsonCall.get(this.PROPERTIE_RESULTS));
		
		for (Object callArray : resultArray) {
			JSONObject resultJson = (JSONObject) callArray;
			JSONObject geometryJson = (JSONObject) resultJson.get(this.PROPERTIE_GEOMETRY);
			JSONObject locationJson = (JSONObject) geometryJson.get(this.PROPERTIE_LOCATION);
			
			Location location = new Location();
			
			location.setAddress(resultJson.get(this.PROPERTIE_FORMATTED_ADDRESS).toString());
			location.setLatitude(Double.valueOf(locationJson.get(this.PROPERTIE_LATITUDE).toString()));
			location.setLongitude(Double.valueOf(locationJson.get(this.PROPERTIE_LONGITUDE).toString()));
			
			this.locations.add(location);
		}
	}
	
}
