package com.oauth.springbootcommandlineapp.config;

import com.oauth.springbootcommandlineapp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartUp implements CommandLineRunner {
    @Autowired
    private TestService testService;

    @Override
    public void run(String... args) throws Exception {
        String url = "http://localhost:8080/hello-admin";
        String msg;
        try {
            msg = testService.callRemoteResource(url);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        System.out.println(msg);
    }
}
