package org.memoryextension.java.samples.basicwebapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalControllerAdvice.class);
	@Value("${software.version}")
    private String softwareVersion;

	
	@ModelAttribute("username")
	public String getUsername(Authentication auth) {
		return "nobody (since auth not implemented yet)";
	}
	
	@ModelAttribute("softwareVersion")
	public String getSoftwareVersion() {
		return softwareVersion;
	}
}
