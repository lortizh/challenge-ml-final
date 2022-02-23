package com.chalenge.ml.payload.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
	public static ResponseEntity<Object> generateResponse(String message, int code, String errors, HttpStatus status) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status:", message);
		map.put("errors:", errors);
		map.put("Code:", code);
		return new ResponseEntity<Object>(map, status);
	}
}
