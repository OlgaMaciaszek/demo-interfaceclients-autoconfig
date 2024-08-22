package com.example.http.verification.client.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Olga Maciaszek-Sharma
 */
@Configuration
public class HttpInterfaceClientConfig {

//	@Qualifier("http-verification")
//	@Bean
//	RestClient qRestClient(RestClient.Builder builder) {
//		return builder.baseUrl("http://localhost:8081")
//				.build();
//	}

//	@Qualifier("http-verification")
//	@Bean
//	RestTemplate qRestTemplate(RestTemplateBuilder builder) {
//		return builder.rootUri("http://localhost:8081")
//				.build();
//	}

//	@Qualifier("http-verification")
//	@Bean
//	WebClient webClient(WebClient.Builder builder) {
//		return builder.baseUrl("http://localhost:8081")
//				.build();
//	}


	@Qualifier("http-verification")
	@LoadBalanced
	@Bean
	WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}

//	@Qualifier("http-verification")
//	@Bean
//	@LoadBalanced
//	RestTemplate qRestTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}


//	@Qualifier("http-verification")
//	@Bean
//	HttpServiceProxyFactory httpServiceProxyFactory(@Qualifier("qRestClient") RestClient restClient) {
//		return HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
//				.build();
//	}


//	@Qualifier("http-verification")
//	@LoadBalanced
//	@Bean
//	RestClient.Builder lbRestClientBuilder() {
//		return RestClient.builder();
//	}

}
