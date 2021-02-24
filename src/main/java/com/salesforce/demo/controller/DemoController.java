package com.salesforce.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesforce.demo.service.DemoService;

@RestController
@RequestMapping("/salesforce")
public class DemoController {

	@Autowired
	private DemoService demoService;

	@GetMapping("/health")
	public ResponseEntity<String> health() {
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@GetMapping("/getToolingApiObjects")
	public ResponseEntity<String> getToolingApiObjects() {
		return new ResponseEntity<>(demoService.getToolingApiObjectsList(), HttpStatus.OK);
	}

	@GetMapping("/getMetadata/{sObjectName}")
	public ResponseEntity<String> getMetadata(@PathVariable("sObjectName") String sObjectName) {
		return new ResponseEntity<>(demoService.getMetadata(sObjectName), HttpStatus.OK);
	}

	@GetMapping("/getMetadataDescription/{sObjectName}")
	public ResponseEntity<String> getMetadataDescription(@PathVariable("sObjectName") String sObjectName) {
		return new ResponseEntity<>(demoService.getMetadataDescription(sObjectName), HttpStatus.OK);
	}

	@GetMapping("/getQueryData/{query}")
	public ResponseEntity<String> getQueryData(@PathVariable("query") String query) {
		return new ResponseEntity<>(demoService.getQueryData(query), HttpStatus.OK);
	}

}
