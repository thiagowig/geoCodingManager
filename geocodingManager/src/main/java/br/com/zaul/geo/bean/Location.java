package br.com.zaul.geo.bean;

/**
 * 
 * @author thiago
 *
 */
public class Location {
	
	/** */
	private String address;
	/** */
	private Double latitude;
	/** */
	private Double Longitude;
	
	/**
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 
	 * @return
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * 
	 * @param address
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * 
	 * @return
	 */
	public Double getLongitude() {
		return Longitude;
	}

	/**
	 * 
	 * @param address
	 */
	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}	
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return this.address;
	}
}
