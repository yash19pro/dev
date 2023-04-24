package com.spring_cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class Controller {
	
	@Value("${properties: This is client default}")
	private String contentString;
	
	@GetMapping("foobar")
	public String properties() {
		return "properties: " + contentString;
 	}
}

// I order to refresh the bean, need to do a POST request to `${BASE_URL}/actuator/refresh`