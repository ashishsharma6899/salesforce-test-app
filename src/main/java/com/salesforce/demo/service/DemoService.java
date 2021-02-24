package com.salesforce.demo.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.salesforce.demo.util.Utility;

@Service
public class DemoService {

	private static final Logger LOG = LoggerFactory.getLogger(DemoService.class);

	@Value("${bearerToken}")
	private String accessToken;

	@Value("${salesforceEnvironmentUrl}")
	private String salesforceUrl;

	@Value("${filePath}")
	private String filePath;

	@Autowired
	RestTemplate restTemplate;

	public String getToolingApiObjectsList() {
		String response = "";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setBearerAuth(accessToken);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		try {
			response = restTemplate.exchange(salesforceUrl + "/services/data/v50.0/tooling/sobjects", HttpMethod.GET,
					entity, String.class).getBody();
			Utility.writeInFile(response, filePath);
		} catch (Exception e) {
			LOG.error("Error while connecting to salesforce app ", e);
			response = e.getMessage();
		}

		LOG.info("getToolingApiObjectsList() response " + response);
		return response;
	}

	public String getMetadata(String sObjectName) {
		String response = "";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setBearerAuth(accessToken);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		try {
			response = restTemplate.exchange(salesforceUrl + "/services/data/v50.0/tooling/sobjects/" + sObjectName,
					HttpMethod.GET, entity, String.class).getBody();
			Utility.writeInFile(response, filePath);
		} catch (Exception e) {
			LOG.error("Error while connecting to salesforce app ", e);
			response = e.getMessage();
		}
		LOG.info("getMetadata() response " + response);
		return response;
	}

	public String getMetadataDescription(String sObjectName) {
		String response = "";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setBearerAuth(accessToken);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		try {
			response = restTemplate
					.exchange(salesforceUrl + "/services/data/v50.0/tooling/sobjects/" + sObjectName + "/describe",
							HttpMethod.GET, entity, String.class)
					.getBody();
			Utility.writeInFile(response, filePath);
		} catch (Exception e) {
			LOG.error("Error while connecting to salesforce app ", e);
			response = e.getMessage();
		}

		LOG.info("getMetadataDescription() response " + response);
		return response;
	}

	public String getQueryData(String query) {
		String response = "";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setBearerAuth(accessToken);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		try {
			response = restTemplate.exchange(salesforceUrl + "/services/data/v50.0/query/?q=" + query, HttpMethod.GET,
					entity, String.class).getBody();
			Utility.writeInFile(response, filePath);
		} catch (Exception e) {
			LOG.error("Error while connecting to salesforce app ", e);
			response = e.getMessage();
		}

		LOG.info("getQueryData() response " + response);
		return response;
	}

}
