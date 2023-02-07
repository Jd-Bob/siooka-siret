package com.siooka.siret;

import com.siooka.siret.common.config.RestTemplateInterceptor;
import com.siooka.siret.common.handler.RestTemplateResponseErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.util.Collections;

@SpringBootApplication
@ConfigurationPropertiesScan("com.siooka.siret.common.config")
@EnableDiscoveryClient
public class SiretApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiretApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateInterceptor restTemplateInterceptor, RestTemplateBuilder restTemplateBuilder) {
		RestTemplate restTemplate = restTemplateBuilder
				.errorHandler(new RestTemplateResponseErrorHandler())
				.build();
		restTemplate.setInterceptors(Collections.singletonList(restTemplateInterceptor));
		return restTemplate;
	}

}
