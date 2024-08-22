package com.example.http.verification.client;

import com.example.http.verification.client.clients.VerificationService;
import reactor.core.publisher.Mono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class HttpVerificationClientApplication {

	private final VerificationService verificationService;

	private final ApplicationContext applicationContext;

	public HttpVerificationClientApplication(VerificationService verificationService,
			ApplicationContext applicationContext) {
		this.verificationService = verificationService;
		this.applicationContext = applicationContext;
	}

	public static void main(String[] args) {
		SpringApplication.run(HttpVerificationClientApplication.class, args);
	}

//	@GetMapping
//	public String test() {
//		return verificationService.test();
//	}

	@GetMapping
	public Mono<String> test() {
		return verificationService.monoTest();
	}

}
