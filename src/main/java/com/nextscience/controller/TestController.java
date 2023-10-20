package com.nextscience.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextscience.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

/**
 * Processes an {@link TestController } .controller
 * @author Raghu
 *
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class TestController {
    private final AuthenticationService authenticationService;
    
    /**Create a Newuser in userinfo.*/
    @GetMapping("test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Working as Expected");
    }

}
