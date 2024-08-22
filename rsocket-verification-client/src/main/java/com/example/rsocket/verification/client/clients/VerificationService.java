package com.example.rsocket.verification.client.clients;

import java.util.Optional;

import com.example.rsocket.verification.client.dto.VerificationRequest;
import com.example.rsocket.verification.client.dto.VerificationResult;
import reactor.core.publisher.Mono;

import org.springframework.boot.autoconfigure.interfaceclients.rsocket.RSocketClient;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.rsocket.service.RSocketExchange;
import org.springframework.util.MimeType;

/**
 * @author Olga Maciaszek-Sharma
 */
@RSocketClient("rsocket-verification")
public interface VerificationService {

	@RSocketExchange("count")
	Mono<Integer> count();

	@RSocketExchange("verify")
	Mono<VerificationResult> verify(@Payload Mono<Optional<VerificationRequest>> request);

	@RSocketExchange("verify")
	VerificationResult verifyBlocking(@Payload VerificationRequest request);

	@RSocketExchange("/test/{name}")
	Mono<String> test(@DestinationVariable("name") String name);

	@RSocketExchange("/testMetadata/{name}")
	Mono<String> test(@DestinationVariable("name") String name,
			String metadataEntry, MimeType mimeType);
}
