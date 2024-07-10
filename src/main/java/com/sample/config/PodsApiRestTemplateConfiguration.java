package com.sample.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Configuration
@EnableOAuth2Client
@AllArgsConstructor
public class PodsApiRestTemplateConfiguration {

    private final ApiKey apiKey;

    @Qualifier("getClientCredentialsResourceDetails")
    private final ClientCredentialsResourceDetails clientCredentialsResourceDetails;

    public RestTemplate podsApiRestTemplate() {
        OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(clientCredentialsResourceDetails,
                new DefaultOAuth2ClientContext());
        oAuth2RestTemplate.getInterceptors().add(new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
                httpRequest.getHeaders().add("api-key", apiKey.getApiKey());
                return clientHttpRequestExecution.execute(httpRequest, bytes);
            }
        });

        return oAuth2RestTemplate;
    }


}
