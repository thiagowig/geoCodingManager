package br.com.zaul.geo;

import java.util.List;

import org.junit.Test;

import br.com.zaul.geo.bean.Location;
import br.com.zaul.geo.manager.GoogleGeocodingManager;

public class GoogleGeocodingManagerTest {

	@Test
	public void testGeocoding() throws Exception {
		List<Location> locations = GoogleGeocodingManager.getLocation("av. engenheiros, 301. castelo. belo horizonte");
	}
}
