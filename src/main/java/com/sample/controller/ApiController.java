package com.sample.controller;

import com.sample.service.ApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/call")
    public String makeApiCall() {
        String apiUrl = "https://www.boredapi.com/api/activity";

        try {
            return apiService.makeApiCall(apiUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error making API call";
        }
    }
}