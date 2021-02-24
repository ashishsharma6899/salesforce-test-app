package com.salesforce.demo.util;

import java.io.FileWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utility {

	private static final Logger LOG = LoggerFactory.getLogger(Utility.class);

	public static void writeInFile(String content, String filePath) {
		LOG.info("filePath " + filePath);
		try {
			FileWriter fw = new FileWriter(filePath);
			fw.write(content);
			fw.close();
		} catch (Exception e) {
			LOG.error("Error while writting data in file", e);
		}

	}

}
