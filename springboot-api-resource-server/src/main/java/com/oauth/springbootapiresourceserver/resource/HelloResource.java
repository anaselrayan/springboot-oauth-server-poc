package com.oauth.springbootapiresourceserver.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    @GetMapping("/hello")
    public String helloUser() {
        return "Hello User";
    }

    @GetMapping("/hello-admin")
    public String helloAdmin() {
        return "Hello Admin";
    }
}
