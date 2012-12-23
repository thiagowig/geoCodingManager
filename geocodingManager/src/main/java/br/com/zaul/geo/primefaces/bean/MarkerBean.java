package br.com.zaul.geo.primefaces.bean;

import java.io.Serializable;

/**
 * 
 * @author thiago
 *
 */
public class MarkerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8242519839759097512L;

	private String address;
	
	private String image;
	
	private String link;
	
	private String serviceName;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	
}
