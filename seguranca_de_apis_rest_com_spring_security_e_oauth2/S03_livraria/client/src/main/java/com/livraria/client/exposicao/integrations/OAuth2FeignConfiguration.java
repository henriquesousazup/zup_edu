package com.livraria.client.exposicao.integrations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@Configuration
public class OAuth2FeignConfiguration {

    @Value("${integrations.registrationId}")
    private String clientRegistrationId;

    @Bean
    public OAuth2FeignRequestInterceptor oAuth2FeignRequestInterceptor(OAuth2AuthorizedClientManager clientManager) {
        return new OAuth2FeignRequestInterceptor(clientManager, clientRegistrationId);
    }

    @Bean
    public OAuth2AuthorizedClientManager authorizedClientManager(ClientRegistrationRepository clientRegistrationRepository,
                                                                 OAuth2AuthorizedClientService clientService) {

        OAuth2AuthorizedClientProvider provider
                = OAuth2AuthorizedClientProviderBuilder.builder()
                .clientCredentials()
                .build();

        AuthorizedClientServiceOAuth2AuthorizedClientManager manager
                = new AuthorizedClientServiceOAuth2AuthorizedClientManager(clientRegistrationRepository, clientService);
        manager.setAuthorizedClientProvider(provider);

        return manager;
    }
}
