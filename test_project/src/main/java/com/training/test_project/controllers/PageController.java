package com.training.test_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

  @GetMapping("/home")
  public String home() {
    return "home";
  }

  @GetMapping("/")
  public String defaultPage() {
    return "home";
  }
}
