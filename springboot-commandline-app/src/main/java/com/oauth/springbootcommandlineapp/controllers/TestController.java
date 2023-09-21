package com.oauth.springbootcommandlineapp.controllers;

import com.oauth.springbootcommandlineapp.service.TestService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  @Autowired
  private TestService testService;

  @GetMapping("/test")
  public String test(HttpServletResponse response) {
    String url = "http://localhost:8080/hello-admin";
    String msg;
    try {
      msg = testService.callRemoteResource(url);
    } catch (Exception e) {
      msg = e.getMessage();
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }
    System.out.println(msg);
    return msg;
  }
}
