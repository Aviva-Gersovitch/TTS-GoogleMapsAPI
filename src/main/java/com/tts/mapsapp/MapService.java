package com.tts.mapsapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MapService {
	@Value("${api_key}")
	private String apiKey;
	
	public void addCoordinates(Location location) {
		//API call to take the city and state stored in the location object and use the Google geocoding API to get lat and long and store also in 'location'
	
		String url = "https://maps.googleapis.com/maps/api/geocode/json?";
		url += "address=" + location.getCity() + "," + location.getState();
		url += "&key=" + apiKey;
		
		
		//To make HTTP requests inside Spring boot java, create instance of class called RestTemplate
		
		RestTemplate restTemplate = new RestTemplate();
		
		GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
		
		Location coordinates = response.getResults().get(0).getGeometry().getLocation();
		location.setLat(coordinates.getLat());
		location.setLng(coordinates.getLng());
	}
}
