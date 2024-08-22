package com.example.rsocket.verification.client.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.messaging.rsocket.service.RSocketServiceProxyFactory;

/**
 * @author Olga Maciaszek-Sharma
 */
@Configuration
public class ClientConfig {

//	@Bean
//	@Qualifier("rsocket-verification")
//	public RSocketServiceProxyFactory rSocketServiceProxyFactory() {
//		RSocketStrategies strategies = RSocketStrategies.builder()
//				.encoders(encoders -> encoders.add(new Jackson2JsonEncoder()))
//				.decoders(decoders -> decoders.add(new Jackson2JsonDecoder()))
//				.build();
//		RSocketRequester requester = RSocketRequester.builder()
//				.rsocketStrategies(strategies)
//				.tcp("localhost", 7000);
//		return RSocketServiceProxyFactory
//				.builder(requester)
//				.build();
//	}

	@Bean
	@Qualifier("rsocket-verification")
	public RSocketRequester rSocketRequester() {
		RSocketStrategies strategies = RSocketStrategies.builder()
				.encoders(encoders -> encoders.add(new Jackson2JsonEncoder()))
				.decoders(decoders -> decoders.add(new Jackson2JsonDecoder()))
				.build();
		return RSocketRequester.builder()
				.rsocketStrategies(strategies)
				.tcp("localhost", 7000);
	}

}
