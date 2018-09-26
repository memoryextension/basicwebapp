package org.memoryextension.java.samples.basicwebapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class MyConfiguration {

    @Bean
    LayoutDialect layoutDialect() {
    	  return new LayoutDialect();
    }
}
