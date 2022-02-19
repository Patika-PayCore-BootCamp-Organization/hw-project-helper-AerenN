package com.helperproject.interestservice.controller;

import com.helperproject.interestservice.service.UserInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/interest")
public class UserInterestController {
    @Autowired
    UserInterestService userInterestService;

    @GetMapping(path = "/getUserInterest")
    public String getUserInterest(@RequestParam String username){
        return userInterestService.getUserInterests(username);
    }
}
