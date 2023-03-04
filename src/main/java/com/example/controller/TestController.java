package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.response.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/")
    public String hello() {
        return "Success";
    }

    @GetMapping(value = "/hello")
    public ResponseEntity<Object> hello(HttpServletRequest request) {
        return new ResponseEntity<>("Hi Your Public IP is : " + request.getRemoteAddr(), HttpStatus.OK);
    }

    @GetMapping(value = "/test")
    public ResponseEntity<Object> world(HttpServletRequest request) {
        return new ResponseEntity<>(new Person("Shahzad", "Hussain", 26), HttpStatus.OK);
    }

    @GetMapping(value = "/address")
    public ResponseEntity<Object> getRemoteAddress(HttpServletRequest request) {
        log.info(request.getHeader("x-forwarded-for"));
        return new ResponseEntity<>("Hi Your Public IP is : \t " + request.getHeader("X-FORWARDED-FOR"), HttpStatus.OK);
    }
}
