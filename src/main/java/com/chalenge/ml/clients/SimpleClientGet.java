package com.chalenge.ml.clients;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import com.chalenge.ml.enums.EnumResponseCodes;
import com.chalenge.ml.models.Book;

public class SimpleClientGet {
	private static final Logger logger = LogManager.getLogger(SimpleClientGet.class);
	private EnumResponseCodes enumRespCodes;
	private String q; 
	
	private final String URL_ = enumRespCodes.URL_CLIENT.getDescripcion();
	private final String ACCESS_KEY = enumRespCodes.APIKEY.getDescripcion();
	
	public SimpleClientGet(String q) {
		this.q=q;
	}

	public Root ConsumeService() {
		RestTemplate restTemplate = new RestTemplate();
		logger.info(":::: CLIENT SERVICE REST ::::");
		Root root = restTemplate.getForObject(URL_.concat(this.q), Root.class, q, ACCESS_KEY);
		return root;
	}
}
