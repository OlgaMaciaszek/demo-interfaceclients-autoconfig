package com.example.rsocket.verification.client.controllers;

import java.util.Optional;

import com.example.rsocket.verification.client.clients.VerificationService;
import com.example.rsocket.verification.client.dto.VerificationResult;
import reactor.core.publisher.Mono;

import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Olga Maciaszek-Sharma
 */
@RestController
@RequestMapping
public class VerificationController {

	private final VerificationService verificationService;

	public VerificationController(VerificationService verificationService) {
		this.verificationService = verificationService;
	}


	@PostMapping("/verify")
	Mono<VerificationResult> verify() {
		return verificationService.verify(Mono.just(Optional.empty()));
	}

	@GetMapping("/test")
	Mono<String> test() {
		return verificationService.test("Mark");
	}

	@GetMapping("/testMetadata")
	Mono<String> testMetadata() {
		return verificationService.test("Mark", "testHeaderValue", MimeType.valueOf("application/json"));
	}

	@GetMapping("/count")
	Mono<Integer> count() {
		return verificationService.count();
	}

}
