package gov.research.publicaccess.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://www.osti.gov/scitech/scitechxml?searchFor=geodesy", Object[].class);
		
		System.out.println(responseEntity.toString());
	}

}
