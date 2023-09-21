package com.oauth.springbootcommandlineapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class TestService {
    @Autowired
    private OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager;
    @Autowired
    private RestTemplate restTemplate;

    public String callRemoteResource(String url) {
        OAuth2AuthorizeRequest request = OAuth2AuthorizeRequest
                .withClientRegistrationId("1")
                .principal("serverapp")
                .build();

        OAuth2AuthorizedClient client =
                oAuth2AuthorizedClientManager.authorize(request);
        String token = client.getAccessToken().getTokenValue();
        return sendRequest(url, token);
    }

    private String sendRequest(String url, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        headers.setAccept(Collections.singletonList(MediaType.TEXT_PLAIN));
        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);
        var res = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        return res.getBody();
    }
}
