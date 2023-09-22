package com.oauth.springbootcommandlineapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.oauth2Client(Customizer.withDefaults());
    http.authorizeHttpRequests(auth-> auth.anyRequest().permitAll());
    return http.build();
  }

  @Bean
  public OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager(
          ClientRegistrationRepository clients) {

    OAuth2AuthorizedClientService service =
            new InMemoryOAuth2AuthorizedClientService(clients);
    AuthorizedClientServiceOAuth2AuthorizedClientManager manager =
            new AuthorizedClientServiceOAuth2AuthorizedClientManager(clients, service);
    OAuth2AuthorizedClientProvider provider =
            OAuth2AuthorizedClientProviderBuilder.builder()
                    .clientCredentials()
                    .build();
    manager.setAuthorizedClientProvider(provider);
    return manager;
  }

  @Bean
  public ClientRegistrationRepository clientRegistrationRepository() {
    ClientRegistration c1 = ClientRegistration.withRegistrationId("1")
        .clientId("serverapp")
        .clientSecret("secret2")
        .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
        .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
        .tokenUri("http://localhost:9000/oauth2/token")
        .scope("read").scope("access.admin")
        .build();

    return new InMemoryClientRegistrationRepository(c1);
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
