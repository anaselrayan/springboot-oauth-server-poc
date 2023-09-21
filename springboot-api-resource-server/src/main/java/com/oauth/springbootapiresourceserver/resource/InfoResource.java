package com.oauth.springbootapiresourceserver.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoResource {

    @GetMapping("/info")
    public String getInfo() {
        return "Public Info";
    }
}
